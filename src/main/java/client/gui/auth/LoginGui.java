package client.gui.auth;

import client.gui.MainGui;
import client.services.AuthService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

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
                loginButtonClicked();
            }
        });
        loginButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) loginButtonClicked();
            }
        });
    }

    private void loginButtonClicked() {
        // Get data from fields
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        // Call Auth login() method
        AuthService authService = new AuthService();
        String response = authService.login(email, password);
        if(response == "true") {
            // Close login window
            this.dispose();
            // Open dashboard window
            new MainGui();
        } else {
            JOptionPane.showMessageDialog(this, response, "Wrong credentials", JOptionPane.WARNING_MESSAGE);
        }
    }
}
