package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import server.jmDNS.ServiceRegistration;
import server.services.prescriptionsService.*;

import java.io.*;
import java.util.ArrayList;

public class PrescriptionsService extends PrescriptionsGrpc.PrescriptionsImplBase {
    // Properties
    final static int SERVICE_PORT = 50055;
    final static String SERVICE_TYPE = "_prescription._tcp.local.";
    final static String SERVICE_NAME = "prescriptionsService";
    final static String SERVICE_DESCRIPTION = "Prescription service to manage prescriptions.";

    private String prescriptionsFile = new File("src/main/resources/data/prescriptions.csv").getAbsolutePath();
    private String drugsFile = new File("src/main/resources/data/drugs.csv").getAbsolutePath();
    private ArrayList<String[]> prescriptions;
    private ArrayList<String[]> drugs;
    private int lastPrescriptionIndex;
    private int lastDrugIndex;

    // Constructors
    public PrescriptionsService() {
        // Get data from DB
        this.prescriptions = getDataFromCsv(this.prescriptionsFile);
        this.lastPrescriptionIndex = this.prescriptions.size();
        this.drugs = getDataFromCsv(this.drugsFile);
        this.lastDrugIndex = this.drugs.size();
    }

    // Methods
    public static void main(String[] args) {
        PrescriptionsService prescriptionsService = new PrescriptionsService();
        try{
            // Register service
            ServiceRegistration serviceRegistration = new ServiceRegistration();
            serviceRegistration.register(SERVICE_PORT, SERVICE_TYPE, SERVICE_NAME, SERVICE_DESCRIPTION);
            // set the port and add the services implemented
            Server server = ServerBuilder.forPort(SERVICE_PORT)
                    .addService(prescriptionsService)
                    .build();
            server.start();
            System.out.println("\nPrescriptions server started on port " + SERVICE_PORT);
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
    public void create(CreateRequest request, StreamObserver<Prescription> responseObserver) {
        // Create the new String array object
        String[] newPrescription = new String[4];
        newPrescription[0] = String.valueOf(this.lastPrescriptionIndex + 1);
        newPrescription[1] = request.getPatientId();
        newPrescription[2] = request.getDoctorId();
        newPrescription[3] = request.getExpiryDate();
        // Add record to ArrayList
        this.prescriptions.add(newPrescription);
        this.lastPrescriptionIndex++;
        // Persist new user in csv file
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : newPrescription) stringBuilder.append(s).append(",");
        String record = stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(prescriptionsFile, true))) {
            bufferedWriter.append("\n").append(record);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // Build and return response
        Prescription prescription = Prescription.newBuilder()
                .setId(newPrescription[0])
                .setPatientId(newPrescription[1])
                .setDoctorId(newPrescription[2])
                .setExpiryDate(newPrescription[3])
                .build();
        responseObserver.onNext(prescription);
        responseObserver.onCompleted();
    }

    @Override
    public void addDrug(AddDrugRequest request, StreamObserver<Drug> responseObserver) {
        // Create the new String array object
        String[] newDrug = new String[5];
        newDrug[0] = String.valueOf(this.lastDrugIndex + 1);
        newDrug[1] = String.valueOf(this.lastPrescriptionIndex);
        newDrug[2] = request.getDrug();
        newDrug[3] = request.getDoses();
        newDrug[4] = request.getComment();
        // Add record to ArrayList
        this.prescriptions.add(newDrug);
        this.lastPrescriptionIndex++;
        // Persist new user in csv file
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : newDrug) stringBuilder.append(s).append(",");
        String record = stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(drugsFile, true))) {
            bufferedWriter.append("\n").append(record);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // Build and return response
        Drug drug = Drug.newBuilder()
                .setId(newDrug[0])
                .setPrescriptionsId(newDrug[1])
                .setDrug(newDrug[2])
                .setDoses(newDrug[3])
                .setComment(newDrug[4])
                .build();
        responseObserver.onNext(drug);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(Empty request, StreamObserver<Prescription> responseObserver) {
        for(String[] prescription : prescriptions) {
            Prescription response = Prescription.newBuilder()
                    .setId(prescription[0])
                    .setPatientId(prescription[1])
                    .setDoctorId(prescription[2])
                    .setExpiryDate(prescription[3])
                    .build();
            responseObserver.onNext(response);
        }
    }
}
