package GUI.Panels;
import EmployeeManager.Login;
import java.awt.*;
import javax.swing.*;


public class LoginPanel extends JPanel {

    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;
    private Login login;
    
    public LoginPanel() {

        login = new Login();

        // Panel settings
        setLayout(new GridLayout(3, 2, 10, 15));
        setBorder(
                BorderFactory.createEmptyBorder(40, 30, 40, 30)
        );

        // Labels
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        // Input Fields
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        // Buttons
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");

        // Add components
        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(loginButton);
        add(exitButton);

        // Login Action
        loginButton.addActionListener(e -> authenticateUser());

        // Exit Action
        exitButton.addActionListener(e -> {
            Window window = SwingUtilities.getWindowAncestor(this);

            if (window != null) {
                window.dispose();
            }
        });
    }

    private void authenticateUser() {

        String username = usernameField.getText();

        String password =
                new String(passwordField.getPassword());

        if (login.authenticate(username, password)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Open Dashboard later.

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Incorrect Username or Password!",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE
            );

            passwordField.setText("");
        }
    }
}