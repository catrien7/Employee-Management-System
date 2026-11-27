
package gui.Panels;

import java.awt.*;
import java.util.Collection;
import javax.swing.*;

import Employee.*;
import EmployeeManager.*;
import HashMap.*;
import search.*;
import gui.Components.EmployeeTable;

public class SearchEmployeePanel extends JPanel {

    private EmployeeManager employeeManager;

    private JComboBox<String> searchType;
    private JTextField searchField;
    private JButton searchButton;

    private EmployeeTable employeeTable;

    public SearchEmployeePanel(EmployeeManager employeeManager) {

        this.employeeManager = employeeManager;

        setLayout(new BorderLayout(10, 10));

        JPanel searchPanel = new JPanel(new FlowLayout());

        searchType = new JComboBox<>(
            new String[]{"ID", "Department"}
        );

        searchField = new JTextField(15);
        searchButton = new JButton("Search");

        searchPanel.add(new JLabel("Search By:"));
        searchPanel.add(searchType);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);

        employeeTable = new EmployeeTable();

        add(employeeTable, BorderLayout.CENTER);

        searchButton.addActionListener(e -> search());
        searchField.addActionListener(e -> search());
    }

    private void search() {

        employeeTable.clearTable();

        String value = searchField.getText().trim();

        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please enter a search value"
            );
            return;
        }

        String type = (String) searchType.getSelectedItem();

        if (type.equals("ID")) {

            try {

                int id = Integer.parseInt(value);

                Employee emp = SearchByID.search(id);

                if (emp != null) {
                    employeeTable.addEmployee(emp);
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this, "ID must be a valid number"
                );
                return;
            }

        } else {

            Collection<Employee> employees =
                SearchByDep.depEmployees(value); //set implements collection

            employeeTable.addEmployees(employees);
        }

        if (employeeTable.getModel().getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                this, "No employees found"
            );
        }
    }
}
