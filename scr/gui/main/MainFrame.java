package GUI.main;
import EmployeeManager.*;
import GUI.Panels.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class MainFrame extends JFrame {

    @SuppressWarnings("FieldMayBeFinal")
    private EmployeeManager employeeManager;
    private final CardLayout cards = new CardLayout();
    private final JPanel content = new JPanel(cards);

    public MainFrame(EmployeeManager employeeManager) {

        this.employeeManager = employeeManager;

        setTitle("Employee Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//this::showDashboard
        content.add(new GUI.Panels.LoginPanel(), "login");
        content.add(createDashboard(), "dashboard");
        add(content);
        cards.show(content, "login");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createDashboard() {
        JPanel dashboard = new JPanel(new BorderLayout());
        JPanel header = new JPanel(new BorderLayout());
        header.add(new JLabel("  Welcome, Administrator"), BorderLayout.WEST);
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(event -> cards.show(content, "login"));
        header.add(logoutButton, BorderLayout.EAST);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Employees", new ViewEmployeePanel(employeeManager));
        tabs.addTab("Update / Delete Employees", new UpdateEmployeePanel());
        tabs.addTab("Departments", new DepartmentPanel());
        dashboard.add(header, BorderLayout.NORTH);
        dashboard.add(tabs, BorderLayout.CENTER);
        return dashboard;
    }

    private void showDashboard() {
        cards.show(content, "dashboard");
    }
}
