package client.services;

import client.jmDNS.ServiceDiscovery;
import com.google.protobuf.ServiceException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import server.services.authService.AuthGrpc;
import server.services.authService.LoginRequest;
import server.services.authService.RegisterRequest;
import client.controllers.User;

import javax.jmdns.ServiceInfo;

public class AuthService {
    // Properties
    final String SERVICE_TYPE = "_auth._tcp.local.";
    final String HOST = "localhost";
//    private int port = 50056;
    private int port;
    private ManagedChannel channel;
    private AuthGrpc.AuthBlockingStub blockingStub;

    // Constructors
    public AuthService() {
        // Discovering service
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery();
        ServiceInfo serviceInfo = serviceDiscovery.discover(this.SERVICE_TYPE);
        this.port = serviceInfo.getPort(); // Comment to use static port
        // Connecting to service
        this.setChannel(ManagedChannelBuilder.forAddress(this.HOST, this.port)
                .usePlaintext()
                .build());
        // Creating the stub
        this.setBlockingStub(AuthGrpc.newBlockingStub(this.getChannel()));
    }

    // Setters & Getters
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public ManagedChannel getChannel() {
        return channel;
    }
    public void setChannel(ManagedChannel channel) {
        this.channel = channel;
    }
    public AuthGrpc.AuthBlockingStub getBlockingStub() {
        return blockingStub;
    }
    public void setBlockingStub(AuthGrpc.AuthBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    // Methods
    public void register(String firstName, String lastName, String email, String password, String role) {
        try {
            RegisterRequest request = RegisterRequest.newBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setPassword(password)
                    .setRole(role)
                    .build();
            server.services.authService.User user = this.getBlockingStub().register(request);
            System.out.println(user);
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
        }
    }

    public User login(String email, String password) throws ServiceException {
        User target = new client.controllers.User();
        try {
            LoginRequest request = LoginRequest.newBuilder()
                    .setEmail(email)
                    .setPassword(password)
                    .build();
            server.services.authService.User user = this.getBlockingStub().login(request);
            target.setId(Integer.parseInt(user.getId()));
            target.setFirstName(user.getFirstName());
            target.setLastName(user.getLastName());
            target.setEmail(user.getEmail());
            target.setPassword(user.getPassword());
            target.setRole(user.getRole());
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
            throw new ServiceException(e.getCause());
        }
        return target;
    }
}
