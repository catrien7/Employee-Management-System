
package gui.Panels;

import Department.Department;
import Manager.DepartmentManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DepartmentPanel extends JPanel {

    // Connect the GUI to our backend
    private DepartmentManager departmentManager =
            new DepartmentManager();

    // GUI components
    private JTextField departmentNameField;
    private JTable departmentTable;
    private DefaultTableModel tableModel;

    // Constructor
    public DepartmentPanel() {

        // Set the main layout
        setLayout(new BorderLayout(10, 10));

        // Create the top panel
        JPanel inputPanel = new JPanel();

        departmentNameField = new JTextField(15);

        JButton addButton = new JButton("Add Department");
        JButton deleteButton = new JButton("Delete Department");
        JButton refreshButton = new JButton("Refresh");

        inputPanel.add(new JLabel("Department Name:"));
        inputPanel.add(departmentNameField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        inputPanel.add(refreshButton);

        // Create the table
        String[] columns = {"Department ID", "Department Name", "Employees"};

        tableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        departmentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(departmentTable);

        // Add panels to the main panel
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button actions
        addButton.addActionListener(e -> addDepartment());

        deleteButton.addActionListener(e -> deleteDepartment());

        refreshButton.addActionListener(e -> loadDepartments());

        // Load departments when the panel opens
        loadDepartments();
    }

    // Add a department
    private void addDepartment() {

        String name = departmentNameField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a department name."
            );
            return;
        }

        boolean added = departmentManager.addDepartment(name);

        if (added) {

            JOptionPane.showMessageDialog(
                    this,
                    "Department added successfully!"
            );

            departmentNameField.setText("");

            loadDepartments();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid department name or department already exists."
            );
        }
    }

    // Load all departments into the table
    private void loadDepartments() {

        tableModel.setRowCount(0);

        for (Department department :
                departmentManager.getAllDepartments()) {

            Object[] row = {
                    department.getID(),
                    department.getName(),
                    department.getEmployees().size()
            };

            tableModel.addRow(row);
        }
    }

    // Delete the selected department
    private void deleteDepartment() {

        int selectedRow = departmentTable.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a department first."
            );

            return;
        }

        String departmentName =
                tableModel.getValueAt(selectedRow, 1).toString();

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete "
                        + departmentName + "?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            boolean deleted =
                    departmentManager.deleteDepartment(departmentName);

            if (deleted) {

                JOptionPane.showMessageDialog(
                        this,
                        "Department deleted successfully!"
                );

                loadDepartments();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Cannot delete this department because "
                                + "employees are assigned to it."
                );
            }
        }
    }
}
