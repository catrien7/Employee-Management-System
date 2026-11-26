package gui.Panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import EmployeeManager.Login;

/** Login view; authentication remains in EmployeeManager.Login. */
public class LoginPanel extends JPanel {
    private final Login login = new Login();
    private final JTextField usernameField = new JTextField(16);
    private final JPasswordField passwordField = new JPasswordField(16);

    public LoginPanel(Runnable onAuthenticated) {
        setLayout(new BorderLayout());
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createTitledBorder("Employee Management System Login"));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0;
        form.add(new JLabel("Username:"), c);
        c.gridx = 1;
        form.add(usernameField, c);
        c.gridx = 0; c.gridy = 1;
        form.add(new JLabel("Password:"), c);
        c.gridx = 1;
        form.add(passwordField, c);

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");
        JPanel buttons = new JPanel();
        buttons.add(loginButton);
        buttons.add(exitButton);
        c.gridx = 0; c.gridy = 2; c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        form.add(buttons, c);
        add(form, BorderLayout.CENTER);

        loginButton.addActionListener(event -> attemptLogin(onAuthenticated));
        passwordField.addActionListener(event -> attemptLogin(onAuthenticated));
        exitButton.addActionListener(event -> System.exit(0));
    }

    private void attemptLogin(Runnable onAuthenticated) {
        if (login.authenticate(usernameField.getText().trim(), new String(passwordField.getPassword()))) {
            passwordField.setText("");
            onAuthenticated.run();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
