import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/* =====================================================================
 *  Employee Management Portal  (Java Swing + MVC)
 *  Compile:  javac EmployeePortal.java
 *  Run:      java EmployeePortal
 *  Login:    admin / admin123
 * ===================================================================== */
public class EmployeePortal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeModel model = new EmployeeModel();
            LoginView loginView = new LoginView();
            new AppController(model, loginView);
            loginView.setVisible(true);
        });
    }
}

/* =====================================================================
 *  MODEL
 * ===================================================================== */
class Employee {
    private final String id;
    private final String name;
    private final String department;

    Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    String getId()         { return id; }
    String getName()       { return name; }
    String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("ID: %-8s Name: %-18s Dept: %s", id, name, department);
    }
}

class EmployeeModel {
    private final String validUsername = "admin";
    private String password = "admin123";
    private final List<Employee> employees = new ArrayList<>();

    boolean validateLogin(String user, String pass) {
        return validUsername.equals(user) && password.equals(pass);
    }

    boolean isOldPasswordCorrect(String oldPass) {
        return password.equals(oldPass);
    }

    void changePassword(String newPass) {
        this.password = newPass;
    }

    boolean employeeExists(String id) {
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    void addEmployee(Employee e) {
        employees.add(e);
    }

    List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}

/* =====================================================================
 *  VIEW
 * ===================================================================== */
class LoginView extends JFrame {
    private final JTextField usernameField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);
    private final JButton loginButton = new JButton("Login");

    LoginView() {
        super("Employee Management Portal - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel form = new JPanel(new GridLayout(2, 2, 8, 8));
        form.add(new JLabel("Username:"));
        form.add(usernameField);
        form.add(new JLabel("Password:"));
        form.add(passwordField);

        JPanel south = new JPanel();
        south.add(loginButton);

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        root.add(form, BorderLayout.CENTER);
        root.add(south, BorderLayout.SOUTH);

        setContentPane(root);
        getRootPane().setDefaultButton(loginButton);
        pack();
        setLocationRelativeTo(null);
    }

    String getUsername()           { return usernameField.getText().trim(); }
    String getPassword()           { return new String(passwordField.getPassword()); }
    void addLoginListener(ActionListener l) { loginButton.addActionListener(l); }

    void showMessage(String msg, String title, int type) {
        JOptionPane.showMessageDialog(this, msg, title, type);
    }

    void clearPassword() { passwordField.setText(""); }
}

class MainView extends JFrame {
    // Menu items
    private final JMenuItem addEmployeeItem    = new JMenuItem("Add Employee");
    private final JMenuItem viewEmployeeItem   = new JMenuItem("View Employee");
    private final JMenuItem changePasswordItem = new JMenuItem("Change Password");
    private final JMenuItem logoutItem         = new JMenuItem("Logout");
    private final JMenuItem exitItem           = new JMenuItem("Exit Application");

    // Add Employee form
    private final JTextField empIdField   = new JTextField(15);
    private final JTextField empNameField = new JTextField(15);
    private final JTextField empDeptField = new JTextField(15);
    private final JButton saveButton      = new JButton("Save");

    // Change Password form
    private final JPasswordField oldPassField     = new JPasswordField(15);
    private final JPasswordField newPassField     = new JPasswordField(15);
    private final JPasswordField confirmPassField = new JPasswordField(15);
    private final JButton updatePasswordButton    = new JButton("Update Password");

    // Card layout to switch between screens
    private final CardLayout cards = new CardLayout();
    private final JPanel contentPanel = new JPanel(cards);

    MainView() {
        super("Employee Management Portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setLocationRelativeTo(null);

        buildMenuBar();

        contentPanel.add(buildHomePanel(), "home");
        contentPanel.add(buildAddEmployeePanel(), "add");
        contentPanel.add(buildChangePasswordPanel(), "password");
        setContentPane(contentPanel);
        showHome();
    }

    private void buildMenuBar() {
        JMenuBar bar = new JMenuBar();

        JMenu employeeMenu = new JMenu("Employee");
        employeeMenu.add(addEmployeeItem);
        employeeMenu.add(viewEmployeeItem);

        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.add(changePasswordItem);

        JMenu exitMenu = new JMenu("Exit");
        exitMenu.add(logoutItem);
        exitMenu.add(exitItem);

        bar.add(employeeMenu);
        bar.add(toolsMenu);
        bar.add(exitMenu);
        setJMenuBar(bar);
    }

    private JPanel buildHomePanel() {
        JPanel p = new JPanel(new GridBagLayout());
        p.add(new JLabel("Welcome to the Employee Management Portal"));
        return p;
    }

    private JPanel buildAddEmployeePanel() {
        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        form.add(new JLabel("Employee ID:"));   form.add(empIdField);
        form.add(new JLabel("Employee Name:")); form.add(empNameField);
        form.add(new JLabel("Department:"));    form.add(empDeptField);

        JPanel south = new JPanel();
        south.add(saveButton);

        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        p.add(form, BorderLayout.CENTER);
        p.add(south, BorderLayout.SOUTH);
        return p;
    }

    private JPanel buildChangePasswordPanel() {
        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        form.add(new JLabel("Old Password:"));     form.add(oldPassField);
        form.add(new JLabel("New Password:"));     form.add(newPassField);
        form.add(new JLabel("Confirm Password:")); form.add(confirmPassField);

        JPanel south = new JPanel();
        south.add(updatePasswordButton);

        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        p.add(form, BorderLayout.CENTER);
        p.add(south, BorderLayout.SOUTH);
        return p;
    }

    // ---- screen switching ----
    void showHome()           { cards.show(contentPanel, "home"); }
    void showAddEmployee()    { clearAddForm(); cards.show(contentPanel, "add"); }
    void showChangePassword() { clearPasswordForm(); cards.show(contentPanel, "password"); }

    // ---- getters for form data ----
    String getEmpId()            { return empIdField.getText().trim(); }
    String getEmpName()          { return empNameField.getText().trim(); }
    String getEmpDept()          { return empDeptField.getText().trim(); }
    String getOldPassword()      { return new String(oldPassField.getPassword()); }
    String getNewPassword()      { return new String(newPassField.getPassword()); }
    String getConfirmPassword()  { return new String(confirmPassField.getPassword()); }

    void clearAddForm() {
        empIdField.setText("");
        empNameField.setText("");
        empDeptField.setText("");
    }

    void clearPasswordForm() {
        oldPassField.setText("");
        newPassField.setText("");
        confirmPassField.setText("");
    }

    // ---- listener registration ----
    void addEmployeeMenuListener(ActionListener l)    { addEmployeeItem.addActionListener(l); }
    void viewEmployeeMenuListener(ActionListener l)   { viewEmployeeItem.addActionListener(l); }
    void changePasswordMenuListener(ActionListener l) { changePasswordItem.addActionListener(l); }
    void logoutListener(ActionListener l)             { logoutItem.addActionListener(l); }
    void exitListener(ActionListener l)               { exitItem.addActionListener(l); }
    void saveListener(ActionListener l)               { saveButton.addActionListener(l); }
    void updatePasswordListener(ActionListener l)     { updatePasswordButton.addActionListener(l); }

    void showMessage(String msg, String title, int type) {
        JOptionPane.showMessageDialog(this, msg, title, type);
    }
}

/* =====================================================================
 *  CONTROLLER
 * ===================================================================== */
class AppController {
    private final EmployeeModel model;
    private final LoginView loginView;
    private MainView mainView;

    AppController(EmployeeModel model, LoginView loginView) {
        this.model = model;
        this.loginView = loginView;
        this.loginView.addLoginListener(e -> handleLogin());
    }

    // ---------- Login ----------
    private void handleLogin() {
        String user = loginView.getUsername();
        String pass = loginView.getPassword();

        if (user.isEmpty() || pass.isEmpty()) {
            loginView.showMessage("Please enter both username and password.",
                    "Missing Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (model.validateLogin(user, pass)) {
            loginView.showMessage("Login successful! Welcome, " + user + ".",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            loginView.setVisible(false);
            openMainWindow();
        } else {
            loginView.showMessage("Invalid username or password.",
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
            loginView.clearPassword();
        }
    }

    // ---------- Main window ----------
    private void openMainWindow() {
        mainView = new MainView();

        mainView.addEmployeeMenuListener(e -> mainView.showAddEmployee());
        mainView.viewEmployeeMenuListener(e -> handleViewEmployees());
        mainView.changePasswordMenuListener(e -> mainView.showChangePassword());
        mainView.saveListener(e -> handleSaveEmployee());
        mainView.updatePasswordListener(e -> handleChangePassword());
        mainView.logoutListener(e -> handleLogout());
        mainView.exitListener(e -> handleExit());

        mainView.setVisible(true);
    }

    private void handleSaveEmployee() {
        String id = mainView.getEmpId();
        String name = mainView.getEmpName();
        String dept = mainView.getEmpDept();

        if (id.isEmpty() || name.isEmpty() || dept.isEmpty()) {
            mainView.showMessage("All fields are required.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (model.employeeExists(id)) {
            mainView.showMessage("An employee with ID '" + id + "' already exists.",
                    "Duplicate ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model.addEmployee(new Employee(id, name, dept));
        mainView.showMessage("Employee added successfully.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        mainView.clearAddForm();
    }

    private void handleViewEmployees() {
        List<Employee> list = model.getEmployees();
        if (list.isEmpty()) {
            mainView.showMessage("No employees found.",
                    "View Employee", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Employee e : list) {
            sb.append(e).append("\n");
        }
        mainView.showMessage(sb.toString(), "Employee List", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleChangePassword() {
        String oldPass = mainView.getOldPassword();
        String newPass = mainView.getNewPassword();
        String confirm = mainView.getConfirmPassword();

        if (oldPass.isEmpty() || newPass.isEmpty() || confirm.isEmpty()) {
            mainView.showMessage("All fields are required.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!model.isOldPasswordCorrect(oldPass)) {
            mainView.showMessage("Old password is incorrect.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!newPass.equals(confirm)) {
            mainView.showMessage("New password and confirm password do not match.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model.changePassword(newPass);
        mainView.showMessage("Password changed successfully.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
        mainView.clearPasswordForm();
        mainView.showHome();
    }

    private void handleLogout() {
        mainView.dispose();
        loginView.clearPassword();
        loginView.setVisible(true);
    }

    private void handleExit() {
        int choice = JOptionPane.showConfirmDialog(mainView,
                "Are you sure you want to exit?", "Exit",
                JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}