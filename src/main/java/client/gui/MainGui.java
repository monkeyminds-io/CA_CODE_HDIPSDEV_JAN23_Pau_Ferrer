package client.gui;

import client.controllers.Appointment;
import client.controllers.Prescription;
import client.services.BookingService;
import client.services.PrescriptionsService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class MainGui extends JFrame {

    private JPanel mainPane;
    private JPanel contentPane;
    private JButton authLogoutButton;
    private JTabbedPane tabbedPane1;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox roleComboBox;
    private JButton registerButton;
    private JTextPane registerOutputPane;
    private JTabbedPane tabbedPane2;
    private JButton createBookingButton;
    private JComboBox patientCreateBookingComboBox;
    private JComboBox doctorCreateBookingComboBox;
    private JComboBox dayCreateBookingComboBox;
    private JComboBox monthCreateBookingComboBox;
    private JComboBox yearCreateBookingComboBox;
    private JComboBox slotCreateBookingComboBox;
    private JTextPane createBookingOutputPane;
    private JButton updateBookingButton;
    private JComboBox idUpdateBookingComboBox;
    private JComboBox patientUpdateBookingComboBox;
    private JComboBox doctorUpdateBookingComboBox;
    private JComboBox dayUpdateBookingComboBox;
    private JComboBox monthUpdateBookingComboBox;
    private JComboBox yearUpdateBookingComboBox;
    private JComboBox slotUpdateBookingComboBox;
    private JTextPane updateBookingOutputPane;
    private JComboBox idCancelBookingComboBox;
    private JTextPane cancelBookingOutputPane;
    private JButton cancelBookingButton;
    private JTextField dayCancelBookingTextField;
    private JTextField monthCancelBookingTextField;
    private JTextField yearCancelBookingTextField;
    private JTextField slotCancelBookingTextField;
    private JTextField patientCancelBookingTextField;
    private JTextField doctorCancelBookingTextField;
    private JTextPane shiftListBookingOutputPane;
    private JCheckBox doctor1ShiftListBookingCheckBox;
    private JCheckBox doctor2ShiftListBookingCheckBox;
    private JCheckBox doctor3ShiftListBookingCheckBox;
    private JCheckBox doctor4ShiftListBookingCheckBox;
    private JButton shiftListButton;
    private JTabbedPane tabbedPane3;
    private JTextPane createPrescriptionOutputPane;
    private JTextPane viewAllPrescriptionsOutputPane;
    private JButton viewAllPrescriptionsButton;
    private JComboBox patientCreatePrescriptionComboBox;
    private JComboBox doctorCreatePrescriptionComboBox;
    private JComboBox expiryCreatePrescriptionComboBox;
    private JTextField drugNameCreatePrescriptionField;
    private JSpinner dosesCreatePrescriptionSpinner;
    private JTextArea commentCreatePrescriptionTextArea;
    private JButton addDrugToPrescriptionButton;
    private JButton createPrescriptionButton;
    private JButton getDataBookingButton;

    public MainGui() {
        setTitle("Health First | Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 720);
        setContentPane(this.mainPane);
        setLocationRelativeTo(null);
        setVisible(true);

        this.initAuthTab();
        this.initBookingsTab();
        this.initPrescriptionsTab();
    }

    private void initAuthTab() {
        // Add roles to comboBox
        roleComboBox.addItem("Select from list...");
        roleComboBox.addItem("Patient");
        roleComboBox.addItem("Doctor");
        roleComboBox.addItem("Nurse");
    }

    private void initBookingsTab() {
        // Local variables
        String[] idsList = {"Select from list...", "1", "2", "3"};
        String[] patientIdList = {"Select from list...", "5"};
        String[] doctorsIdList = {"Select from list...", "1"};
        String[] daysList = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31"};
        String[] monthsList = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        String[] yearsList = {"2023", "2024"};
        String[] slotsList = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
                "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", };

        // Services Instances
        BookingService bookingService = new BookingService();

        // Combo Boxes settings
        // TODO use proper data
        addItemsToComboBox(patientCreateBookingComboBox, patientIdList);
        addItemsToComboBox(doctorCreateBookingComboBox, doctorsIdList);
        addItemsToComboBox(dayCreateBookingComboBox, daysList);
        addItemsToComboBox(monthCreateBookingComboBox, monthsList);
        addItemsToComboBox(yearCreateBookingComboBox, yearsList);
        addItemsToComboBox(slotCreateBookingComboBox, slotsList);

        addItemsToComboBox(idUpdateBookingComboBox, idsList);
        addItemsToComboBox(patientUpdateBookingComboBox, patientIdList);
        addItemsToComboBox(doctorUpdateBookingComboBox, doctorsIdList);
        addItemsToComboBox(dayUpdateBookingComboBox, daysList);
        addItemsToComboBox(monthUpdateBookingComboBox, monthsList);
        addItemsToComboBox(yearUpdateBookingComboBox, yearsList);
        addItemsToComboBox(slotUpdateBookingComboBox, slotsList);

        // Create Booking event
        createBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from fields
                int patientId = Integer.parseInt(Objects.requireNonNull(patientCreateBookingComboBox.getSelectedItem()).toString());
                int doctorId = Integer.parseInt(Objects.requireNonNull(doctorCreateBookingComboBox.getSelectedItem()).toString());
                String dateTime = dayCreateBookingComboBox.getSelectedItem().toString() + "-" +
                        monthCreateBookingComboBox.getSelectedItem().toString() + "-" +
                        yearCreateBookingComboBox.getSelectedItem().toString() + " @ " +
                        slotCreateBookingComboBox.getSelectedItem().toString();
                // Update Output text
                updateOutputPane(createBookingOutputPane, "Creating appointment with:" +
                        "\nPatient id: " + patientId +
                        "\nDoctor id: " + doctorId +
                        "\nSlot: " + dateTime +
                        "\nPlease wait...");
                try {
                    // Call Booking create() method
                    bookingService.create(patientId, doctorId, dateTime);
                    Thread.sleep(2000);
                    // Update Output text
                    updateOutputPane(createBookingOutputPane, "Appointment created successfully! 🥳");
                    // Reset fields
                    patientCreateBookingComboBox.setSelectedItem("Select from list...");
                    doctorCreateBookingComboBox.setSelectedItem("Select from list...");
                    dayCreateBookingComboBox.setSelectedItem("01");
                    monthCreateBookingComboBox.setSelectedItem("JAN");
                    yearCreateBookingComboBox.setSelectedItem("2023");
                    slotCreateBookingComboBox.setSelectedItem("8:00");
                } catch(InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(createBookingOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
            }
        });

        // Get Appointment data event
        getDataBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from fields
                int id = Integer.parseInt(Objects.requireNonNull(idUpdateBookingComboBox.getSelectedItem()).toString());
                // Update Output text
                updateOutputPane(updateBookingOutputPane, "Getting appointment data...");
                try {
                    // Call Booking get() method
//                    Appointment appointment = bookingService.get(id);
                    Appointment appointment = new Appointment(1, 5, 1, "08-AUG-2023 @ 13:30");
                    Thread.sleep(2000L);
                    // Populate fields
                    patientUpdateBookingComboBox.setSelectedItem(String.valueOf(appointment.getPatientId()));
                    doctorUpdateBookingComboBox.setSelectedItem(String.valueOf(appointment.getDoctorId()));
                    dayUpdateBookingComboBox.setSelectedItem(appointment.getDateTime().substring(0, 2));
                    monthUpdateBookingComboBox.setSelectedItem(appointment.getDateTime().substring(3, 6));
                    yearUpdateBookingComboBox.setSelectedItem(appointment.getDateTime().substring(7, 11));
                    slotUpdateBookingComboBox.setSelectedItem(appointment.getDateTime().substring(14, 19));
                } catch(InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(createBookingOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
            }
        });

        // Update Appointment event
        updateBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from fields
                int id = Integer.parseInt(Objects.requireNonNull(idUpdateBookingComboBox.getSelectedItem()).toString());
                String patientId = Objects.requireNonNull(patientUpdateBookingComboBox.getSelectedItem()).toString();
                String doctorId = Objects.requireNonNull(doctorUpdateBookingComboBox.getSelectedItem()).toString();
                String dateTime = dayUpdateBookingComboBox.getSelectedItem().toString() + "-" +
                        monthUpdateBookingComboBox.getSelectedItem().toString() + "-" +
                        yearUpdateBookingComboBox.getSelectedItem().toString() + " @ " +
                        slotUpdateBookingComboBox.getSelectedItem().toString();
                // Update Output text
                updateOutputPane(updateBookingOutputPane, "Updating appointment " + id + "...");
                try {
                    // Call Booking update() method
                    bookingService.update(id, new String[]{patientId, doctorId, dateTime});
                    Thread.sleep(2000L);
                    // Reset fields
                    idUpdateBookingComboBox.setSelectedItem("Select from list...");
                    patientUpdateBookingComboBox.setSelectedItem("Select from list...");
                    doctorUpdateBookingComboBox.setSelectedItem("Select from list...");
                    dayUpdateBookingComboBox.setSelectedItem("01");
                    monthUpdateBookingComboBox.setSelectedItem("JAN");
                    yearUpdateBookingComboBox.setSelectedItem("2023");
                    slotUpdateBookingComboBox.setSelectedItem("8:00");
                    // Update Output text
                    updateOutputPane(updateBookingOutputPane, "Appointment updated successfully! 🥳");
                } catch(InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(updateBookingOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
            }
        });

        // Cancel Appointment event
        cancelBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
    }

    private void initPrescriptionsTab() {
        // Local variables
        ArrayList<String[]> drugs = new ArrayList<>();

        // Services Instances
        PrescriptionsService prescriptionsService = new PrescriptionsService();

        // Combo Boxes settings
        // TODO use proper data
        patientCreatePrescriptionComboBox.addItem("Select from list...");
        patientCreatePrescriptionComboBox.addItem("5");

        // TODO use proper data
        doctorCreatePrescriptionComboBox.addItem("Select from list...");
        doctorCreatePrescriptionComboBox.addItem("1");

        expiryCreatePrescriptionComboBox.addItem("Select from list...");
        expiryCreatePrescriptionComboBox.addItem("60");
        expiryCreatePrescriptionComboBox.addItem("120");
        expiryCreatePrescriptionComboBox.addItem("180");

        // Add Drug button event
        addDrugToPrescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capture data from fields
                String[] drugRecord = new String[3];
                drugRecord[0] = drugNameCreatePrescriptionField.getText();
                drugRecord[1] = String.valueOf(dosesCreatePrescriptionSpinner.getValue());
                drugRecord[2] = commentCreatePrescriptionTextArea.getText();
                // Add data to Streaming array
                drugs.add(drugRecord);
                // Update Output text
                updateOutputPane(createPrescriptionOutputPane,
                        "Drug: " + drugRecord[0] +
                        "\nDoses: " + drugRecord[1] +
                        "\nComments: " + drugRecord[2] +
                        "\nAdded to the drugs list.");
                // Reset fields
                drugNameCreatePrescriptionField.setText("");
                dosesCreatePrescriptionSpinner.setValue(0);
                commentCreatePrescriptionTextArea.setText("");
            }
        });

        // Create Prescription event
        createPrescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capture data from fields
                int patientId = Integer.parseInt(Objects.requireNonNull(patientCreatePrescriptionComboBox.getSelectedItem()).toString());
                int doctorId = Integer.parseInt(Objects.requireNonNull(doctorCreatePrescriptionComboBox.getSelectedItem()).toString());
                int expiry = Integer.parseInt(Objects.requireNonNull(expiryCreatePrescriptionComboBox.getSelectedItem()).toString());
                // Update Output text
                updateOutputPane(createPrescriptionOutputPane, "Creating prescription." + "\nPlease, wait...");
                // Call Prescriptions service create() method
                try {
                    prescriptionsService.create(patientId, doctorId, expiry, drugs);
                    Thread.sleep(2000);
                    // Update Output text
                    updateOutputPane(createPrescriptionOutputPane, "Prescription created successfully! 🥳");
                    // Reset fields
                    patientCreatePrescriptionComboBox.setSelectedItem("Select from list...");
                    doctorCreatePrescriptionComboBox.setSelectedItem("Select from list...");
                    expiryCreatePrescriptionComboBox.setSelectedItem("Select from list...");
                } catch (InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(createPrescriptionOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
            }
        });

        // View all Prescriptions event
        viewAllPrescriptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update Output text
                updateOutputPane(viewAllPrescriptionsOutputPane, "Getting all prescriptions...");
                try {
                    // Call Prescriptions getAll() method
                    ArrayList<Prescription> prescriptions = prescriptionsService.getAll();
                    Thread.sleep(2000L);
                    // Update Output text
                    updateOutputPane(viewAllPrescriptionsOutputPane, "ID | PATIENT_ID | DOCTOR_ID | EXPIRY");
                    for (Prescription p : prescriptions) {
                        updateOutputPane(viewAllPrescriptionsOutputPane, p.toString());
                    }
                } catch (InterruptedException ex) {
                    updateOutputPane(viewAllPrescriptionsOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
            }
        });
    }

    private void addItemsToComboBox(JComboBox comboBox, String[] items) {
        for (String item : items) comboBox.addItem(item);
    }

    private void updateOutputPane(JTextPane outputPane, String newText) {
        String currentText = outputPane.getText();
        outputPane.setText(currentText + "\n" + newText);
    }
}
