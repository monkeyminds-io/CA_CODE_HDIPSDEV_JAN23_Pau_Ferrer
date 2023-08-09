package server.services;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import server.services.bookingService.*;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BookingService extends BookingGrpc.BookingImplBase {
    // Properties
//    private int servicePort;
    final static int SERVICE_PORT = 50053;
    final static String SERVICE_TYPE = "_booking._tcp.local.";
    final static String SERVICE_NAME = "bookingService";
    final static String SERVICE_DESCRIPTION = "Booking service to manage appointments.";

    private String appointmentsFile = new File("src/main/resources/data/appointments.csv").getAbsolutePath();
    private ArrayList<String[]> appointments;
    private int lastIndex;

    // Constructors
    public BookingService() {
        //        // Comment this try-catch block to use static port
//        try(ServerSocket socket = new ServerSocket(0)) {
//            this.servicePort = socket.getLocalPort();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // Get data from DB
        this.appointments = getDataFromCsv(this.appointmentsFile);
        this.lastIndex = this.appointments.size();
    }

    // Methods
    public static void main(String[] args) {
        try{
            // Register service
//            ServiceRegistration serviceRegistration = new ServiceRegistration();
//            serviceRegistration.register(this.SERVICE_PORT, this.SERVICE_TYPE, this.SERVICE_NAME, this.SERVICE_DESCRIPTION);
            //set the port and add the services implemented
//            Server server = ServerBuildeer.forPort(this.servicePort)
            Server server = ServerBuilder.forPort(SERVICE_PORT)
                    .addService(new BookingService())
                    .build();
            server.start();
//            System.out.println("\nAuth server started on port " + this.servicePort);
            System.out.println("\nBooking server started on port " + SERVICE_PORT);
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
    public void create(CreateRequest request, StreamObserver<Appointment> responseObserver) {
        // Create the new user String array object
        String[] newAppointment = new String[7];
        newAppointment[0] = String.valueOf(this.lastIndex + 1);
        newAppointment[1] = request.getPatientId();
        newAppointment[2] = request.getDoctorId();
        newAppointment[3] = request.getDateTime();
        newAppointment[4] = new Timestamp(System.currentTimeMillis()).toString();
        newAppointment[5] = newAppointment[4];
        newAppointment[6] = "";
        // Add user record to ArrayList
        this.appointments.add(newAppointment);
        this.lastIndex++;
        // Persist new user in csv file
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : newAppointment) stringBuilder.append(s).append(",");
        String record = stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(appointmentsFile, true))) {
            bufferedWriter.append("\n").append(record);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // Build and return response
        Appointment appointment = Appointment.newBuilder()
                .setId(newAppointment[0])
                .setPatientId(newAppointment[1])
                .setDoctorId(newAppointment[2])
                .setDateTime(newAppointment[3])
                .build();
        responseObserver.onNext(appointment);
        responseObserver.onCompleted();
    }

    @Override
    public void get(GetRequest request, StreamObserver<Appointment> responseObserver) {
        String[] target = new String[7];
        int count = 0;
        for(String[] current : this.appointments) {
            if(current[0].equals(request.getId())) target = current;
            count++;
        }
        try {
            if(count > this.appointments.size()) throw new Exception();
            Appointment appointment = Appointment.newBuilder()
                    .setId(target[0])
                    .setPatientId(target[1])
                    .setDoctorId(target[2])
                    .setDateTime(target[3])
                    .build();
            responseObserver.onNext(appointment);
            responseObserver.onCompleted();
        } catch(Exception ex) {
            responseObserver.onError(ex);
        }
    }

    @Override
    public void update(UpdateRequest request, StreamObserver<Appointment> responseObserver) {
        super.update(request, responseObserver);
    }

    @Override
    public void cancel(CancelRequest request, StreamObserver<Appointment> responseObserver) {
        super.cancel(request, responseObserver);
    }

    @Override
    public StreamObserver<ShiftListRequest> shiftList(StreamObserver<Appointment> responseObserver) {
        return super.shiftList(responseObserver);
    }
}
