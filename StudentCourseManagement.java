import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentCourseManagement extends JFrame {

    JTextField nameField;
    JList<String> courseList;
    JTable table;
    DefaultTableModel model;

    StudentCourseManagement() {

        setTitle("Student Course Management");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Student Name
        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Student Name:"));

        nameField = new JTextField(15);
        topPanel.add(nameField);

        add(topPanel, BorderLayout.NORTH);

        // Course List
        String[] courses = {
            "Java Programming",
            "Data Structures",
            "Database Management",
            "Operating Systems",
            "Computer Networks"
        };

        courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane courseScrollPane = new JScrollPane(courseList);
        courseScrollPane.setBorder(
            BorderFactory.createTitledBorder("Available Courses")
        );

        add(courseScrollPane, BorderLayout.WEST);

        // Table
        String[] columns = {
            "Student Name",
            "Selected Course",
            "Enrollment Status"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane tableScrollPane = new JScrollPane(table);

        add(tableScrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Registration");
        JButton removeButton = new JButton("Remove Registration");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add Registration
        addButton.addActionListener(e -> {

            String name = nameField.getText();
            String course = courseList.getSelectedValue();

            if (name.isEmpty() || course == null) {
                JOptionPane.showMessageDialog(
                    this,
                    "Enter student name and select a course."
                );
            } else {

                model.addRow(new Object[]{
                    name,
                    course,
                    "Enrolled"
                });

                nameField.setText("");
                courseList.clearSelection();
            }
        });

        // Remove Registration
        removeButton.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row != -1) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Select a registration to remove."
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentCourseManagement();
    }
}