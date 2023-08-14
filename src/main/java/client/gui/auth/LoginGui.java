package client.gui.auth;

import client.controllers.User;
import client.gui.MainGui;
import client.services.AuthService;
import com.google.protobuf.ServiceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginGui extends JFrame {

    private JPanel mainPane;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginGui() {
        setTitle("Health First | Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 320);
        setContentPane(this.mainPane);
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loginButtonClicked();
                } catch (ServiceException | InterruptedException ex) {
                    JOptionPane.showMessageDialog(LoginGui.super.rootPane,
                            "The credentials are not correct.\nPlease, try again with correct credentials.",
                            "Wrong credentials",
                            JOptionPane.WARNING_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        });
        loginButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    try {
                        loginButtonClicked();
                    } catch (ServiceException | InterruptedException ex) {
                        JOptionPane.showMessageDialog(LoginGui.super.rootPane,
                                "The credentials are not correct.\nPlease, try again with correct credentials.",
                                "Wrong credentials",
                                JOptionPane.WARNING_MESSAGE);
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    private void loginButtonClicked() throws ServiceException, InterruptedException {
        // Get data from fields
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        // Check empty fields
        if(email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Sorry, all fields are required.\nPlease, fill with your credentials.",
                    "Empty credentials",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            // Call Auth login() method
            AuthService authService = new AuthService();
            User user = authService.login(email, password);
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                // Close login window
                this.dispose();
                // Open dashboard window
                new MainGui();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "The credentials are not correct.\nPlease, try again with correct credentials.",
                        "Wrong credentials",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
