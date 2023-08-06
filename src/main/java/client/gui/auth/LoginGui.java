package client.gui.auth;

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
                if(e.getKeyCode() == 10) loginButtonClicked();;
            }
        });
    }

    private void loginButtonClicked() {
        //TODO login code here
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        System.out.println(email);
        System.out.println(password);
    }
}
