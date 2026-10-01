import javax.swing.*;
import java.awt.*;

public class UserLogin extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JCheckBox rememberMe, notifications;

    UserLogin() {

        setTitle("User Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Username
        add(new JLabel("Username:"));

        usernameField = new JTextField(20);
        add(usernameField);

        // Password
        add(new JLabel("Password:"));

        passwordField = new JPasswordField(20);
        add(passwordField);

        // Preferences
        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        add(rememberMe);
        add(notifications);

        // Login Button
        JButton loginButton = new JButton("Login");
        add(loginButton);

        // Login Action
        loginButton.addActionListener(e -> {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {

                JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!\nWelcome " + username
                );

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password"
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}