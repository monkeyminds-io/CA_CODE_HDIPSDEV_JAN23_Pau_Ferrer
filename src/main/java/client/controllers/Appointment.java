package client.controllers;

public class Appointment {

    // Properties
    private int id;
    private int patientId;
    private int doctorId;
    private String dateTime;

    // Constructors
    public Appointment() {}

    public Appointment(int id, int patientId, int doctorId, String dateTime) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    // Overrides
    @Override
    public String toString() {
        // TODO Create better format
        return "Appointment{" +
                "id=" + id +
                ", patient_id=" + patientId +
                ", doctor_id=" + doctorId +
                ", date_time='" + dateTime + '\'' +
                '}';
    }
}
