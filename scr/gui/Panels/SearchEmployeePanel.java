package gui.Panels;

import java.awt.*;
import java.util.Collection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Employee.*;
import EmployeeManager.*;

import HashMap.*;
import search.*;

public class SearchEmployeePanel extends JPanel {

    private EmployeeManager employeeManager;

    private JComboBox<String> searchType;
    private JTextField searchField;
    private JButton searchButton;

    private JTable resultTable;
    private DefaultTableModel tableModel;

    public SearchEmployeePanel(EmployeeManager employeeManager) {

        this.employeeManager = employeeManager;

        setLayout(new BorderLayout(10, 10));

        // Search controls
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

        // Table
        String[] columns = {
            "ID", "Name", "Department",
            "Position", "Type", "Salary"
        };

        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        resultTable = new JTable(tableModel);

        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        // Search action
        searchButton.addActionListener(e -> search());

        searchField.addActionListener(e -> search());
    }

    private void search() {

        // Clear previous results
        tableModel.setRowCount(0);

        String value = searchField.getText().trim();

        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a search value"
            );
            return;
        }

        String type = (String) searchType.getSelectedItem();  //getSelectedItem() returns object

        if (type.equals("ID")) {

            try {

                int id = Integer.parseInt(value);

                Employee emp = SearchByID.search(id);

                if (emp != null) {
                    addEmployeeRow(emp);
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "ID must be a valid number"
                );
                return;
            }

        } else {

            Collection<Employee> employees =
                SearchByDep.depEmployees(value);

            for (Employee emp : employees) {
                addEmployeeRow(emp);
            }
        }

        if (tableModel.getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                this,
                "No employees found"
            );
        }
    }

    private void addEmployeeRow(Employee emp) {

        tableModel.addRow(new Object[]{

            emp.getID(),
            emp.getName(),

            emp.getDep() == null
                ? ""
                : emp.getDep().getName(),

            emp.getPo(),
            emp.getType(),
            emp.calcSalary()

        });
    }

    public JTable getResultTable() {
        return resultTable;
    }
}
