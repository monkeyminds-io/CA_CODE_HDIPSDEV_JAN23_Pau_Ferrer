package server.services;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import server.jmDNS.ServiceRegistration;
import server.services.bookingService.*;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;

public class BookingService extends BookingGrpc.BookingImplBase {
    // Properties
//    private static int servicePort;
    final static int SERVICE_PORT = 8081;
    final static String SERVICE_TYPE = "_booking._tcp.local.";
    final static String SERVICE_NAME = "bookingService";
    final static String SERVICE_DESCRIPTION = "Booking service to manage appointments.";
    final String HEADERS = "id,patient_id,doctor_id,date_time";

    private String appointmentsFile = new File("src/main/resources/data/appointments.csv").getAbsolutePath();
    private ArrayList<String[]> appointments;
    private int lastIndex;

    // Constructors
    public BookingService() {
//        // Comment this try-catch block to use static port
//        try(ServerSocket socket = new ServerSocket(0)) {
//            servicePort = socket.getLocalPort();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // Get data from DB
        this.appointments = getDataFromCsv(this.appointmentsFile);
        this.lastIndex = this.appointments.size();
    }

    // Methods
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        try{
            // Register service
            ServiceRegistration serviceRegistration = new ServiceRegistration();
            serviceRegistration.register(SERVICE_PORT, SERVICE_TYPE, SERVICE_NAME, SERVICE_DESCRIPTION);
            // set the port and add the services implemented
//            Server server = ServerBuilder.forPort(servicePort)
            Server server = ServerBuilder.forPort(SERVICE_PORT)
                    .addService(bookingService)
                    .build();
            server.start();
//            System.out.println("\nBooking server started on port " + servicePort);
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

    private boolean updateCsvFileData(String headers, ArrayList<String[]> data, String filePath) {
        // Delete existing file
        boolean hasDeleted = new File(filePath).delete();
        // If deleted ok rewrite file with new data
        if(hasDeleted) {
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
                bufferedWriter.append(headers);
                for(int i = 0; i < data.size(); i++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : data.get(i)) stringBuilder.append(s).append(",");
                    String record = stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
                    bufferedWriter.append("\n").append(record);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("File not deleted correctly...");
        }
        return hasDeleted;
    }

    // Overrides
    @Override
    public void create(CreateRequest request, StreamObserver<Appointment> responseObserver) {
        // Create the new String array object
        String[] newAppointment = new String[4];
        newAppointment[0] = String.valueOf(this.lastIndex + 1);
        newAppointment[1] = request.getPatientId();
        newAppointment[2] = request.getDoctorId();
        newAppointment[3] = request.getDateTime();
        // Add record to ArrayList
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
        String[] target = new String[4];
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
        String[] updatedAppointment = new String[4];
        updatedAppointment[0] = request.getId();
        updatedAppointment[1] = request.getPatientId();
        updatedAppointment[2] = request.getDoctorId();
        updatedAppointment[3] = request.getDateTime();
        this.appointments.set(Integer.parseInt(updatedAppointment[0]) - 1, updatedAppointment);
        boolean hasUpdated = this.updateCsvFileData(this.HEADERS, this.appointments, this.appointmentsFile);
        try {
            if(!hasUpdated) throw new Exception();
            Appointment appointment = Appointment.newBuilder()
                    .setId(updatedAppointment[0])
                    .setPatientId(updatedAppointment[1])
                    .setDoctorId(updatedAppointment[2])
                    .setDateTime(updatedAppointment[3])
                    .build();
            responseObserver.onNext(appointment);
            responseObserver.onCompleted();
        } catch(Exception ex) {
            responseObserver.onError(ex);
        }
    }

    @Override
    public void cancel(CancelRequest request, StreamObserver<Appointment> responseObserver) {
        String[] deletedAppointment = this.appointments.remove(Integer.parseInt(request.getId()) - 1);
        boolean hasUpdated = this.updateCsvFileData(this.HEADERS, this.appointments, this.appointmentsFile);
        try {
            if(!hasUpdated) throw new Exception();
            Appointment appointment = Appointment.newBuilder()
                    .setId(deletedAppointment[0])
                    .setPatientId(deletedAppointment[1])
                    .setDoctorId(deletedAppointment[2])
                    .setDateTime(deletedAppointment[3])
                    .build();
            responseObserver.onNext(appointment);
            responseObserver.onCompleted();
        } catch(Exception ex) {
            responseObserver.onError(ex);
        }
    }

    @Override
    public StreamObserver<ShiftListRequest> shiftList(StreamObserver<Appointment> responseObserver) {
        return new StreamObserver<ShiftListRequest>() {

            ArrayList<String> doctors = new ArrayList<>();
            ArrayList<String[]> shiftAppointments = new ArrayList<>();
            @Override
            public void onNext(ShiftListRequest request) {
                doctors.add(request.getDoctorId());
                for (String doctor : doctors) {
                    for(String[] appointment : appointments) {
                        if(appointment[2].equalsIgnoreCase(doctor)) {
                            shiftAppointments.add(appointment);
                        }
                    }
                    for(String[] shiftAppointment : shiftAppointments) {
                        Appointment appointment = Appointment.newBuilder()
                                .setId(shiftAppointment[0])
                                .setPatientId(shiftAppointment[1])
                                .setDoctorId(shiftAppointment[2])
                                .setDateTime(shiftAppointment[3])
                                .build();
                        responseObserver.onNext(appointment);
                    }
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
