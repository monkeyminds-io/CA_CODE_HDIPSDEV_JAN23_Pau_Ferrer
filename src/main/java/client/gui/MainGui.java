package client.gui;

import client.controllers.Appointment;
import client.controllers.Prescription;
import client.services.AuthService;
import client.services.BookingService;
import client.services.PrescriptionsService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private JButton getDataCancelBookingButton;

    public MainGui() throws InterruptedException {
        // DB Data
        ArrayList<String[]> users = getDataFromCsv(new File("src/main/resources/data/users.csv").getAbsolutePath());
        ArrayList<String[]> appointments = getDataFromCsv(new File("src/main/resources/data/appointments.csv").getAbsolutePath());
        ArrayList<String[]> prescriptions = getDataFromCsv(new File("src/main/resources/data/prescriptions.csv").getAbsolutePath());
        ArrayList<String[]> drugs = getDataFromCsv(new File("src/main/resources/data/drugs.csv").getAbsolutePath());
        // Displaying the JFrame
        setTitle("Health First | Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 720);
        setContentPane(this.mainPane);
        setLocationRelativeTo(null);
        setVisible(true);
        // Init service tabs
        this.initAuthTab();
        this.initBookingsTab(users, appointments);
        this.initPrescriptionsTab(users);
        authLogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        MainGui.super.rootPane,
                        "Are you sure you want to leave?",
                        "Logging out",
                        JOptionPane.YES_NO_OPTION);
                if(option == 0) MainGui.super.dispose();
            }
        });
    }

    private void initAuthTab() {
        // Add roles to comboBox
        roleComboBox.addItem("Select from list...");
        roleComboBox.addItem("Patient");
        roleComboBox.addItem("Doctor");
        roleComboBox.addItem("Nurse");

        // Auth service
        AuthService authService = new AuthService();

        // Register User event
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from fields
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String role = roleComboBox.getSelectedItem().toString();
                // Prevent empties
                if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            MainGui.super.rootPane,
                            "Sorry, all fields are required.\nPlease, fill form with all the data.",
                            "Empty form",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    // Update Output text
                    updateOutputPane(registerOutputPane, "Registering user with:" +
                            "\n  First Name: " + firstName +
                            "\n  Last Name: " + lastName +
                            "\n  Email: " + email +
                            "\n  Role: " + role +
                            "\nPlease wait...");
                    try {
                        // Call Auth register() method
                        authService.register(firstName, lastName, email, password, role);
                        Thread.sleep(2000);
                        // Update Output text
                        updateOutputPane(registerOutputPane, "User registered successfully! 🥳");
                        // Reset fields
                        firstNameField.setText("");
                        lastNameField.setText("");
                        emailField.setText("");
                        passwordField.setText("");
                        roleComboBox.setSelectedItem("Select from list...");
                    } catch (InterruptedException ex) {
                        // Update Output text
                        updateOutputPane(registerOutputPane, "Ups! Something went wrong... 🤯");
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void initBookingsTab(ArrayList<String[]> users, ArrayList<String[]> appointments) {
        // Local variables
        ArrayList<String> idsList = new ArrayList<>();
        idsList.add("Select from list...");
        for (int i = 0; i < appointments.size(); i++) {
            idsList.add(appointments.get(i)[0]);
        }
        ArrayList<String> patientIdList = new ArrayList<>();
        patientIdList.add("Select from list...");
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i)[5].equalsIgnoreCase("patient")) patientIdList.add(users.get(i)[0]);
        }
        ArrayList<String> doctorsIdList = new ArrayList<>();
        doctorsIdList.add("Select from list...");
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i)[5].equalsIgnoreCase("doctor")) doctorsIdList.add(users.get(i)[0]);
        }
        ArrayList<String> daysList = new ArrayList<>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31"));
        ArrayList<String> monthsList = new ArrayList<>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"));
        ArrayList<String> yearsList = new ArrayList<>(Arrays.asList("2023", "2024"));
        ArrayList<String> slotsList = new ArrayList<>(Arrays.asList("08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
                "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30"));
        ArrayList<String> doctorsNameList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i)[5].equalsIgnoreCase("doctor")) doctorsNameList.add(users.get(i)[1] + " " + users.get(i)[2]);
        }

        // Services Instances
        BookingService bookingService = new BookingService();

        // Combo Boxes settings
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

        addItemsToComboBox(idCancelBookingComboBox, idsList);

        // Update CheckBox labels
        JCheckBox[] checkBoxes = {
                doctor1ShiftListBookingCheckBox,
                doctor2ShiftListBookingCheckBox,
                doctor3ShiftListBookingCheckBox,
                doctor4ShiftListBookingCheckBox};

        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i].setText(doctorsNameList.get(i));
        }

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
                // Prevent empties
                if(patientCreateBookingComboBox.getSelectedItem().toString().isEmpty() || doctorCreateBookingComboBox.getSelectedItem().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            MainGui.super.rootPane,
                            "Sorry, all fields are required.\nPlease, fill form with all the data.",
                            "Empty form",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    // Update Output text
                    updateOutputPane(createBookingOutputPane, "Creating appointment with:" +
                            "\n  Patient id: " + patientId +
                            "\n  Doctor id: " + doctorId +
                            "\n  Slot: " + dateTime +
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
                    } catch (InterruptedException ex) {
                        // Update Output text
                        updateOutputPane(createBookingOutputPane, "Ups! Something went wrong... 🤯");
                        ex.printStackTrace();
                    }
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
                    Thread.sleep(2000L);
                    // Populate fields
                    patientUpdateBookingComboBox.setSelectedItem(String.valueOf(appointment.getPatientId()));
                    doctorUpdateBookingComboBox.setSelectedItem(String.valueOf(appointment.getDoctorId()));
                    dayUpdateBookingComboBox.setSelectedItem(appointment.getDateTime().substring(0, 2));
                    monthUpdateBookingComboBox.setSelectedItem(appointment.getDateTime().substring(3, 6));
                    yearUpdateBookingComboBox.setSelectedItem(appointment.getDateTime().substring(7, 11));
                    slotUpdateBookingComboBox.setSelectedItem(appointment.getDateTime().substring(14));
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
                    bookingService.update(id, patientId, doctorId, dateTime);
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

        // Get Appointment data for cancel event
        getDataCancelBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from fields
                int id = Integer.parseInt(Objects.requireNonNull(idCancelBookingComboBox.getSelectedItem()).toString());
                // Update Output text
                updateOutputPane(cancelBookingOutputPane, "Getting appointment data...");
                try {
                    // Call Booking get() method
                    Appointment appointment = bookingService.get(id);
                    Thread.sleep(2000L);
                    // Populate fields
                    patientCancelBookingTextField.setText(String.valueOf(appointment.getPatientId()));
                    doctorCancelBookingTextField.setText(String.valueOf(appointment.getDoctorId()));
                    dayCancelBookingTextField.setText(appointment.getDateTime().substring(0, 2));
                    monthCancelBookingTextField.setText(appointment.getDateTime().substring(3, 6));
                    yearCancelBookingTextField.setText(appointment.getDateTime().substring(7, 11));
                    slotCancelBookingTextField.setText(appointment.getDateTime().substring(14, 19));
                } catch(InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(cancelBookingOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
            }
        });

        // Cancel Appointment event
        cancelBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from fields
                int id = Integer.parseInt(Objects.requireNonNull(idCancelBookingComboBox.getSelectedItem()).toString());
                // Update Output text
                updateOutputPane(cancelBookingOutputPane, "Canceling appointment " + id + "...");
                try {
                    // Call Booking update() method
                    bookingService.cancel(id);
                    Thread.sleep(2000L);
                    // Reset fields
                    idCancelBookingComboBox.setSelectedItem("Select from list...");
                    patientCancelBookingTextField.setText("");
                    doctorCancelBookingTextField.setText("");
                    dayCancelBookingTextField.setText("");
                    monthCancelBookingTextField.setText("");
                    yearCancelBookingTextField.setText("");
                    slotCancelBookingTextField.setText("");
                    // Update Output text
                    updateOutputPane(cancelBookingOutputPane, "Appointment cancelled successfully! 🥳");
                } catch(InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(cancelBookingOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
            }
        });

        // Shift Appointments event
        shiftListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from check boxes
                ArrayList<Integer> shiftDoctorsIds = new ArrayList<>();
                for(int i = 0; i < checkBoxes.length; i++) {
                    if(checkBoxes[i].isSelected()) shiftDoctorsIds.add(Integer.parseInt(doctorsIdList.get(i + 1)));
                }
                updateOutputPane(shiftListBookingOutputPane, "Getting appointments...");
                try {
                    // Call Bookings getShiftAppointments() method
                    ArrayList<Appointment> shiftAppointments = bookingService.getShiftAppointments(shiftDoctorsIds);
                    Thread.sleep(2000L);
                    // Reset fields
                    for(JCheckBox checkBox : checkBoxes) checkBox.setSelected(false);
                    // Update Output text
                    for(Appointment appointment : shiftAppointments) updateOutputPane(shiftListBookingOutputPane, appointment.toString());
                } catch(InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(cancelBookingOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
            }
        });
    }

    private void initPrescriptionsTab(ArrayList<String[]> users) {
        // Local variables
        ArrayList<String> patientIdList = new ArrayList<>();
        patientIdList.add("Select from list...");
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i)[5].equalsIgnoreCase("patient")) patientIdList.add(users.get(i)[0]);
        }
        ArrayList<String> doctorsIdList = new ArrayList<>();
        doctorsIdList.add("Select from list...");
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i)[5].equalsIgnoreCase("doctor")) doctorsIdList.add(users.get(i)[0]);
        }

        // Services Instances
        PrescriptionsService prescriptionsService = new PrescriptionsService();

        // Combo Boxes settings
        addItemsToComboBox(patientCreatePrescriptionComboBox, patientIdList);

        addItemsToComboBox(doctorCreatePrescriptionComboBox, doctorsIdList);

        expiryCreatePrescriptionComboBox.addItem("Select from list...");
        expiryCreatePrescriptionComboBox.addItem("60");
        expiryCreatePrescriptionComboBox.addItem("120");
        expiryCreatePrescriptionComboBox.addItem("180");

        // Add Drug button event
        addDrugToPrescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capture data from fields
                String drug = drugNameCreatePrescriptionField.getText();
                String doses = String.valueOf(dosesCreatePrescriptionSpinner.getValue());
                String comment = commentCreatePrescriptionTextArea.getText();
                // Update Output text
                updateOutputPane(createPrescriptionOutputPane, "Adding drug to prescription...");
                try {
                    // Call Bookings getShiftAppointments() method
                    prescriptionsService.addDrug(drug, doses, comment);
                    Thread.sleep(2000L);
                    // Update Output text
                    updateOutputPane(createPrescriptionOutputPane,
                            " Drug: " + drug +
                                    "\n Doses: " + doses +
                                    "\n Comments: " + comment +
                                    "\nAdded to the prescription.");
                    // Reset fields
                    drugNameCreatePrescriptionField.setText("");
                    dosesCreatePrescriptionSpinner.setValue(0);
                    commentCreatePrescriptionTextArea.setText("");
                } catch(InterruptedException ex) {
                    // Update Output text
                    updateOutputPane(cancelBookingOutputPane, "Ups! Something went wrong... 🤯");
                    ex.printStackTrace();
                }
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
                try {
                    // Call Prescriptions service create() method
                    prescriptionsService.create(patientId, doctorId, expiry);
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

    // Handy methods
    private void addItemsToComboBox(JComboBox comboBox, ArrayList<String> items) {
        for (String item : items) comboBox.addItem(item);
    }

    private void updateOutputPane(JTextPane outputPane, String newText) {
        String currentText = outputPane.getText();
        outputPane.setText(currentText + "\n" + newText);
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
}
