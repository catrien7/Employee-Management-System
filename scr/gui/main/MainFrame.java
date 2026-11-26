package gui.main;
import Employee.*;
import EmployeeManager.*;
import gui.Panels.*;
import javax.swing.JFrame;


public class MainFrame extends JFrame {

    private EmployeeManager employeeManager;

    public MainFrame(EmployeeManager employeeManager) {

        this.employeeManager = employeeManager;

        setTitle("Employee Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ViewEmployeePanel viewPanel =
            new ViewEmployeePanel(employeeManager);

        add(viewPanel);

        setVisible(true);
    }
}
