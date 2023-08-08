package client.services;

import client.controllers.Appointment;

import java.util.ArrayList;

public class BookingService {
    public void create(int patientId, int doctorId, String dateTime) {
        // TODO
    }

    public Appointment get(int id) {
        // TODO
        return new Appointment();
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
