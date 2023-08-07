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

        // Services Instances
        BookingService bookingService = new BookingService();

        // Combo Boxes settings
        // TODO use proper data
        patientCreateBookingComboBox.addItem("Select from list...");
        patientCreateBookingComboBox.addItem("5");

        // TODO use proper data
        doctorCreateBookingComboBox.addItem("Select from list...");
        doctorCreateBookingComboBox.addItem("1");

        dayCreateBookingComboBox.addItem("01");
        dayCreateBookingComboBox.addItem("02");
        dayCreateBookingComboBox.addItem("03");
        dayCreateBookingComboBox.addItem("04");
        dayCreateBookingComboBox.addItem("05");
        dayCreateBookingComboBox.addItem("06");
        dayCreateBookingComboBox.addItem("07");
        dayCreateBookingComboBox.addItem("08");
        dayCreateBookingComboBox.addItem("09");
        dayCreateBookingComboBox.addItem("10");
        dayCreateBookingComboBox.addItem("11");
        dayCreateBookingComboBox.addItem("12");
        dayCreateBookingComboBox.addItem("13");
        dayCreateBookingComboBox.addItem("14");
        dayCreateBookingComboBox.addItem("15");
        dayCreateBookingComboBox.addItem("16");
        dayCreateBookingComboBox.addItem("17");
        dayCreateBookingComboBox.addItem("18");
        dayCreateBookingComboBox.addItem("19");
        dayCreateBookingComboBox.addItem("20");
        dayCreateBookingComboBox.addItem("21");
        dayCreateBookingComboBox.addItem("22");
        dayCreateBookingComboBox.addItem("23");
        dayCreateBookingComboBox.addItem("24");
        dayCreateBookingComboBox.addItem("25");
        dayCreateBookingComboBox.addItem("26");
        dayCreateBookingComboBox.addItem("27");
        dayCreateBookingComboBox.addItem("28");
        dayCreateBookingComboBox.addItem("29");
        dayCreateBookingComboBox.addItem("30");
        dayCreateBookingComboBox.addItem("31");

        monthCreateBookingComboBox.addItem("JAN");
        monthCreateBookingComboBox.addItem("FEB");
        monthCreateBookingComboBox.addItem("MAR");
        monthCreateBookingComboBox.addItem("APR");
        monthCreateBookingComboBox.addItem("MAY");
        monthCreateBookingComboBox.addItem("JUN");
        monthCreateBookingComboBox.addItem("JUL");
        monthCreateBookingComboBox.addItem("AUG");
        monthCreateBookingComboBox.addItem("SEP");
        monthCreateBookingComboBox.addItem("OCT");
        monthCreateBookingComboBox.addItem("NOV");
        monthCreateBookingComboBox.addItem("DEC");

        yearCreateBookingComboBox.addItem("2023");
        yearCreateBookingComboBox.addItem("2024");

        slotCreateBookingComboBox.addItem("8:00");
        slotCreateBookingComboBox.addItem("8:30");
        slotCreateBookingComboBox.addItem("9:00");
        slotCreateBookingComboBox.addItem("9:30");
        slotCreateBookingComboBox.addItem("10:00");
        slotCreateBookingComboBox.addItem("10:30");
        slotCreateBookingComboBox.addItem("11:00");
        slotCreateBookingComboBox.addItem("11:30");
        slotCreateBookingComboBox.addItem("12:00");
        slotCreateBookingComboBox.addItem("12:30");
        slotCreateBookingComboBox.addItem("13:30");
        slotCreateBookingComboBox.addItem("14:00");
        slotCreateBookingComboBox.addItem("14:30");
        slotCreateBookingComboBox.addItem("15:00");
        slotCreateBookingComboBox.addItem("15:30");
        slotCreateBookingComboBox.addItem("16:00");
        slotCreateBookingComboBox.addItem("16:30");


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
                    dayCreateBookingComboBox.setSelectedItem("Select from list...");
                    monthCreateBookingComboBox.setSelectedItem("Select from list...");
                    yearCreateBookingComboBox.setSelectedItem("Select from list...");
                    slotCreateBookingComboBox.setSelectedItem("Select from list...");
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
                    Appointment appointment = bookingService.get(id);
                    Thread.sleep(2000);
                    // Populate fields
//                    patientUpdateBookingComboBox.setSelectedItem(appointment.getPatientId());
//                    doctorUpdateBookingComboBox.setSelectedItem(appointment.getDoctorId());
                    // TODO use substring to get the day, month, year and slot data from dateTime property
                    // Reset fields
                    idUpdateBookingComboBox.setSelectedItem("Select from list...");
                } catch(InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(createBookingOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
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

    private void updateOutputPane(JTextPane outputPane, String newText) {
        String currentText = outputPane.getText();
        outputPane.setText(currentText + "\n" + newText);
    }
}
