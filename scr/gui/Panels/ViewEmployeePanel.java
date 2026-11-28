package GUI.Panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import EmployeeManager.*;
import GUI.Components.EmployeeTable;

public class ViewEmployeePanel extends JPanel {

    private EmployeeManager employeeManager;
    private EmployeeTable employeeTable;

    public ViewEmployeePanel(EmployeeManager employeeManager) {

        this.employeeManager = employeeManager;

        setLayout(new BorderLayout());

        employeeTable = new EmployeeTable();

        employeeTable.addEmployees(
            employeeManager.getAllEmployees()
        );

        add(employeeTable, BorderLayout.CENTER);
    }
}
