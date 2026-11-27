
package gui.Panels;

import javax.swing.*;

import gui.Panels.*;
import EmployeeManager.*;

public class SearchEmployeePanelTest {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Create EmployeeManager
            EmployeeManager manager = new EmployeeManager();

            // Create main frame
            JFrame frame = new JFrame("Employee Management System");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);

            // Create Panels
            ViewEmployeePanel viewPanel =
                new ViewEmployeePanel(manager);

            SearchEmployeePanel searchPanel =
                new SearchEmployeePanel(manager);

            DepartmentPanel depPanel = 
                new DepartmentPanel();

            // Tabs
            JTabbedPane tabs = new JTabbedPane();

            tabs.addTab("View Employees", viewPanel);
            tabs.addTab("Search Employees", searchPanel);
            tabs.addTab("Manage Departments", depPanel);

            frame.add(tabs);

            frame.setVisible(true);
        });
    }
}
