package client.services;

import client.controllers.Prescription;
import client.jmDNS.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import server.services.prescriptionsService.*;

import javax.jmdns.ServiceInfo;
import java.util.ArrayList;

public class PrescriptionsService {
    // Properties
    final String SERVICE_TYPE = "_prescription._tcp.local.";
    final String HOST = "localhost";
//    private int port = 50055;
    private int port;
    private ManagedChannel channel;
    private PrescriptionsGrpc.PrescriptionsBlockingStub blockingStub;
    private PrescriptionsGrpc.PrescriptionsStub asyncStub;

    // Constructors
    public PrescriptionsService() {
        // Discovering service
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery();
        ServiceInfo serviceInfo = serviceDiscovery.discover(this.SERVICE_TYPE);
        this.port = serviceInfo.getPort(); // Comment to use static port
        // Connecting to service
        this.setChannel(ManagedChannelBuilder.forAddress(this.HOST, this.port)
                .usePlaintext()
                .build());
        // Creating the stub
        this.setBlockingStub(PrescriptionsGrpc.newBlockingStub(this.getChannel()));
        this.setAsyncStub(PrescriptionsGrpc.newStub(this.getChannel()));
    }

    // Getters & Setters
    public int getPort() { return port; }
    public void setPort(int port) { this.port = port; }
    public ManagedChannel getChannel() { return channel; }
    public void setChannel(ManagedChannel channel) { this.channel = channel; }
    public PrescriptionsGrpc.PrescriptionsBlockingStub getBlockingStub() { return blockingStub; }
    public void setBlockingStub(PrescriptionsGrpc.PrescriptionsBlockingStub blockingStub) { this.blockingStub = blockingStub; }
    public PrescriptionsGrpc.PrescriptionsStub getAsyncStub() { return asyncStub; }
    public void setAsyncStub(PrescriptionsGrpc.PrescriptionsStub asyncStub) { this.asyncStub = asyncStub; }

    // Methods
    public void create(int patientId, int doctorId, int expiry) {
        try {
            CreateRequest request = CreateRequest.newBuilder()
                    .setPatientId(String.valueOf(patientId))
                    .setDoctorId(String.valueOf(doctorId))
                    .setExpiryDate(String.valueOf(expiry))
                    .build();
            server.services.prescriptionsService.Prescription prescription = this.getBlockingStub().create(request);
            System.out.println(prescription);
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
        }
    }

    public void addDrug(String drug, String doses, String comment) {
        try {
            AddDrugRequest request = AddDrugRequest.newBuilder()
                    .setDrug(drug)
                    .setDoses(doses)
                    .setComment(comment)
                    .build();
            Drug response = this.getBlockingStub().addDrug(request);
            System.out.println(response);
        } catch(StatusRuntimeException e) {
            System.err.println("RPC failed {0} " + e.getStatus());
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Prescription> getAll() {
        ArrayList<Prescription> response = new ArrayList<>();
        Empty request = Empty.newBuilder().build();
        StreamObserver<server.services.prescriptionsService.Prescription> responseObserver = new StreamObserver<server.services.prescriptionsService.Prescription>() {
            @Override
            public void onNext(server.services.prescriptionsService.Prescription prescription) {
                response.add(new Prescription(
                        Integer.parseInt(prescription.getId()),
                        Integer.parseInt(prescription.getPatientId()),
                        Integer.parseInt(prescription.getDoctorId()),
                        Integer.parseInt(prescription.getExpiryDate())));
            }
            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
            @Override
            public void onCompleted() {}
        };
        this.getAsyncStub().getAll(request, responseObserver);
        return response;
    }
}
