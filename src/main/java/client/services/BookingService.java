package client.services;

import client.controllers.Appointment;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import server.services.authService.AuthGrpc;
import server.services.bookingService.BookingGrpc;
import server.services.bookingService.CreateRequest;
import server.services.bookingService.GetRequest;

import java.util.ArrayList;

public class BookingService {
    // Properties
    final String SERVICE_TYPE = "_booking._tcp.local.";
    final String HOST = "localhost";
    private int port = 50053;
    private ManagedChannel channel;
    private BookingGrpc.BookingBlockingStub blockingStub;

    // Constructors

    public BookingService() {
        // Discovering service
//        ServiceDiscovery serviceDiscovery = new ServiceDiscovery();
//        ServiceInfo serviceInfo = serviceDiscovery.discover(this.SERVICE_TYPE);
//        this.port = serviceInfo.getPort(); // Comment to use static port
        // Connecting to service
        this.setChannel(ManagedChannelBuilder.forAddress(this.HOST, this.port)
                .usePlaintext()
                .build());
        // Creating the stub
        this.setBlockingStub(BookingGrpc.newBlockingStub(this.getChannel()));
        System.out.println("Listening to Booking Service in port " + this.port);
    }

    // Getters & Setters
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

    public BookingGrpc.BookingBlockingStub getBlockingStub() {
        return blockingStub;
    }

    public void setBlockingStub(BookingGrpc.BookingBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    // Methods
    public void create(int patientId, int doctorId, String dateTime) {
        try {
            CreateRequest request = CreateRequest.newBuilder()
                    .setPatientId(String.valueOf(patientId))
                    .setDoctorId(String.valueOf(doctorId))
                    .setDateTime(dateTime)
                    .build();
            server.services.bookingService.Appointment appointment = this.getBlockingStub().create(request);
            System.out.println(appointment);
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
        }
    }

    public Appointment get(int id) {
        Appointment appointment = new Appointment();
        try {
            GetRequest request = GetRequest.newBuilder()
                    .setId(String.valueOf(id))
                    .build();
            server.services.bookingService.Appointment response = this.getBlockingStub().get(request);
            appointment = new Appointment(
                    Integer.parseInt(response.getId()),
                    Integer.parseInt(response.getPatientId()),
                    Integer.parseInt(response.getDoctorId()),
                    response.getDateTime());
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
        }
        return appointment;
    }

    public void update(int id, String[] params) {
        // TODO
    }

    public void cancel(int id) {
        // TODO
    }

    public ArrayList<Appointment> getShiftAppointments(ArrayList<Integer> idList) {
        ArrayList<Appointment> response = new ArrayList<>();
        // TODO
        response.add(new Appointment(1, 7, 1, "08-AUG-2023 @ 13:30"));
        response.add(new Appointment(1, 8, 2, "08-AUG-2023 @ 14:00"));
        return response;
    }
}
