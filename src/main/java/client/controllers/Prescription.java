package client.controllers;

public class Prescription {
    // Properties
    private int id;
    private int patientId;
    private int doctorId;
    private int expiryDate;

    // Constructor
    public Prescription() {}
    public Prescription(int id, int patientId, int doctorId, int expiryDate) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.expiryDate = expiryDate;
    }
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public int getExpiryDate() { return expiryDate; }
    public void setExpiryDate(int expiryDate) { this.expiryDate = expiryDate; }

    // Overrides

    @Override
    public String toString() {
        return id + " | " + patientId + " | " + doctorId + " | " + expiryDate;
    }
}
