package client.gui;

import javax.swing.*;

public class MainGui extends JFrame {

    private JPanel mainPane;
    private JPanel contentPane;
    private JButton authRegisterButton;
    private JButton bookingRequestButton;
    private JButton authLogoutButton;
    private JButton bookingUpdateButton;
    private JButton bookingCancelButton;
    private JButton prescruptionCreateButton;
    private JButton prescriptionsDisplayAllButton;
    private JButton prescriptionsDisplayButton;
    private JButton dashboardButton;

    public MainGui() {
        setTitle("Health First | Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 720);
        setContentPane(this.mainPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
