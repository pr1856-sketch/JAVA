import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {

    JTextField nameField, regField;
    JRadioButton male, female;
    JComboBox<String> department;

    StudentRegistration() {

        setTitle("Student Registration");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Student Name
        add(new JLabel("Student Name:"));
        nameField = new JTextField(20);
        add(nameField);

        // Register Number
        add(new JLabel("Register Number:"));
        regField = new JTextField(20);
        add(regField);

        // Gender
        add(new JLabel("Gender:"));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        add(male);
        add(female);

        // Department
        add(new JLabel("Department:"));

        String[] departments = {
            "CSE",
            "ECE",
            "EEE",
            "MECH",
            "CIVIL"
        };

        department = new JComboBox<>(departments);
        add(department);

        // Register Button
        JButton registerButton = new JButton("Register");
        add(registerButton);

        // Button Action
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String reg = regField.getText();

                String gender;

                if (male.isSelected())
                    gender = "Male";
                else if (female.isSelected())
                    gender = "Female";
                else
                    gender = "Not Selected";

                String dept = (String) department.getSelectedItem();

                JOptionPane.showMessageDialog(
                    StudentRegistration.this,
                    "Student Name: " + name +
                    "\nRegister Number: " + reg +
                    "\nGender: " + gender +
                    "\nDepartment: " + dept
                );
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}