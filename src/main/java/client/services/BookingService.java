package client.services;

import client.controllers.Appointment;
import client.jmDNS.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import server.services.bookingService.*;

import javax.jmdns.ServiceInfo;
import java.util.ArrayList;

public class BookingService {
    // Properties
    final String SERVICE_TYPE = "_booking._tcp.local.";
    final String HOST = "localhost";
//    private int port = 50053;
    private int port;
    private ManagedChannel channel;
    private BookingGrpc.BookingBlockingStub blockingStub;
    private BookingGrpc.BookingStub asyncStub;

    // Constructors
    public BookingService() {
        // Discovering service
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery();
        ServiceInfo serviceInfo = serviceDiscovery.discover(this.SERVICE_TYPE);
        this.port = serviceInfo.getPort(); // Comment to use static port
        // Connecting to service
        this.setChannel(ManagedChannelBuilder.forAddress(this.HOST, this.port)
                .usePlaintext()
                .build());
        // Creating the stub
        this.setBlockingStub(BookingGrpc.newBlockingStub(this.getChannel()));
        this.setAsyncStub(BookingGrpc.newStub(this.getChannel()));
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

    public BookingGrpc.BookingStub getAsyncStub() {
        return asyncStub;
    }

    public void setAsyncStub(BookingGrpc.BookingStub asyncStub) {
        this.asyncStub = asyncStub;
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
        Appointment appointment = null;
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

    public void update(int id, String patientId, String doctorId, String dateTime) {
        try {
            UpdateRequest request = UpdateRequest.newBuilder()
                    .setId(String.valueOf(id))
                    .setPatientId(patientId)
                    .setDoctorId(doctorId)
                    .setDateTime(dateTime)
                    .build();
            server.services.bookingService.Appointment response = this.getBlockingStub().update(request);
            System.out.println(response);
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
        }
    }

    public void cancel(int id) {
        try {
            CancelRequest request = CancelRequest.newBuilder()
                    .setId(String.valueOf(id))
                    .build();
            server.services.bookingService.Appointment response = this.getBlockingStub().cancel(request);
            System.out.println(response);
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Appointment> getShiftAppointments(ArrayList<Integer> idList) {
        ArrayList<Appointment> response = new ArrayList<>();
        StreamObserver<server.services.bookingService.Appointment> responseObserver = new StreamObserver<server.services.bookingService.Appointment>() {
            @Override
            public void onNext(server.services.bookingService.Appointment appointment) {
                response.add(new Appointment(
                        Integer.parseInt(appointment.getId()),
                        Integer.parseInt(appointment.getPatientId()),
                        Integer.parseInt(appointment.getDoctorId()),
                        appointment.getDateTime()));
            }
            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
            @Override
            public void onCompleted() {}
        };
        StreamObserver<ShiftListRequest> requestObserver = this.asyncStub.shiftList(responseObserver);
        try {
            for (Integer integer : idList) {
                requestObserver.onNext(ShiftListRequest.newBuilder()
                        .setDoctorId(String.valueOf(integer))
                        .build());
            }
            requestObserver.onCompleted();
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
        }
        return response;
    }
}
