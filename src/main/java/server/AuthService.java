package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import server.jmDNS.ServiceRegistration;
import server.services.authService.AuthGrpc;
import server.services.authService.LoginRequest;
import server.services.authService.RegisterRequest;
import server.services.authService.User;

import java.io.*;
import java.util.ArrayList;

public class AuthService extends AuthGrpc.AuthImplBase {
    // Properties
    final static int SERVICE_PORT = 50056;
    final static String SERVICE_TYPE = "_auth._tcp.local.";
    final static String SERVICE_NAME = "authService";
    final static String SERVICE_DESCRIPTION = "Authorisation service for registering and granting access to users.";

    private String usersFile = new File("src/main/resources/data/users.csv").getAbsolutePath();
    private ArrayList<String[]> users;
    private int lastIndex;

    // Constructors
    public AuthService() {
        // Get data from DB
        this.users = getDataFromCsv(this.usersFile);
        this.lastIndex = this.users.size();
    }

    // Methods
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        try{
            // Register service
            ServiceRegistration serviceRegistration = new ServiceRegistration();
            serviceRegistration.register(SERVICE_PORT, SERVICE_TYPE, SERVICE_NAME, SERVICE_DESCRIPTION);
            //set the port and add the services implemented
            Server server = ServerBuilder.forPort(SERVICE_PORT)
                    .addService(authService)
                    .build();
            server.start();
            System.out.println("\nAuth server started on port " + SERVICE_PORT);
            server.awaitTermination();
        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String[]> getDataFromCsv(String filePath) {
        ArrayList<String[]> data = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headers = br.readLine();
            String record;
            while((record = br.readLine()) != null) {
                data.add(record.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    // Overrides
    @Override
    public void register(RegisterRequest request, StreamObserver<User> responseObserver) {
        // Create the new user String array object
        String[] newUser = new String[6];
        newUser[0] = String.valueOf(this.lastIndex + 1);
        newUser[1] = request.getFirstName();
        newUser[2] = request.getLastName();
        newUser[3] = request.getEmail();
        newUser[4] = request.getPassword();
        newUser[5] = request.getRole();
        // Add user record to ArrayList
        this.users.add(newUser);
        this.lastIndex++;
        // Persist new user in csv file
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : newUser) stringBuilder.append(s).append(",");
        String record = stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersFile, true))) {
            bufferedWriter.append("\n").append(record);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // Build and return response
        User user = User.newBuilder()
                .setId(newUser[0])
                .setFirstName(newUser[1])
                .setLastName(newUser[2])
                .setEmail(newUser[3])
                .setPassword(newUser[4])
                .setRole(newUser[5])
                .build();
        responseObserver.onNext(user);
        responseObserver.onCompleted();
    }

    @Override
    public void login(LoginRequest request, StreamObserver<User> responseObserver) {
        String[] target = new String[6];
        int count = 0;
        for(String[] current : this.users) {
            if(current[3].equals(request.getEmail()) && current[4].equals(request.getPassword())) target = current;
            count++;
        }
        try {
            if(count > this.users.size()) throw new Exception();
            User user = User.newBuilder()
                    .setId(target[0])
                    .setFirstName(target[1])
                    .setLastName(target[2])
                    .setEmail(target[3])
                    .setPassword(target[4])
                    .setRole(target[5])
                    .build();
            responseObserver.onNext(user);
            responseObserver.onCompleted();
        } catch(Exception ex) {
            responseObserver.onError(ex);
        }
    }
}
