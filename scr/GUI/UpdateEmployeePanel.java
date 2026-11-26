
package GUI;

import Employee.Employee;
import Employee.Position;
import Department.Department;
import Manager.DepartmentManager;
import HashMap.EmpHashMap;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class UpdateEmployeePanel extends JPanel {
    private JTable employeeTable;
    private DefaultTableModel employeeTableModel;

    // Backend connection
    private DepartmentManager departmentManager =
            new DepartmentManager();

    // GUI components
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;

    private JComboBox<String> departmentBox;
    private JComboBox<Position> positionBox;

    private JLabel typeLabel;

    // The employee currently being edited
    private Employee selectedEmployee;

    // Constructor
    public UpdateEmployeePanel() {

        setLayout(new BorderLayout(10, 10));
        // Create employee table
        String[] columns = {
                "ID",
                "Name",
                "Age",
                "Department",
                "Position",
                "Type"
        };

        employeeTableModel = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        employeeTable = new JTable(employeeTableModel);

        employeeTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane tableScrollPane = new JScrollPane(employeeTable);

        tableScrollPane.setPreferredSize(new Dimension(450, 300));

        add(tableScrollPane, BorderLayout.WEST);

        // Main form
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Employee ID
        idField = new JTextField();

        JButton loadButton = new JButton("Load Employee");

        // Employee information fields
        nameField = new JTextField();

        ageField = new JTextField();

        departmentBox = new JComboBox<>();

        positionBox = new JComboBox<>(Position.values());

        typeLabel = new JLabel("Not loaded");

        // Add components to the form
        formPanel.add(new JLabel("Employee ID:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Age:"));
        formPanel.add(ageField);

        formPanel.add(new JLabel("Department:"));
        formPanel.add(departmentBox);

        formPanel.add(new JLabel("Position:"));
        formPanel.add(positionBox);

        formPanel.add(new JLabel("Employee Type:"));
        formPanel.add(typeLabel);

        // Buttons
        JButton updateButton = new JButton("Update Employee");

        JButton deleteButton = new JButton("Delete Employee");

        // Button panel
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(loadButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Add panels
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        loadButton.addActionListener(e -> loadEmployee());

        updateButton.addActionListener(e -> updateEmployee());

        deleteButton.addActionListener(e -> deleteEmployee());

        // Load available departments
        loadDepartments();

        // Disable editing until an employee is loaded
        setFieldsEnabled(false);
    }

    // Load departments into the combo box
    private void loadDepartments() {

        departmentBox.removeAllItems();

        for (Department department :
                departmentManager.getAllDepartments()) {

            departmentBox.addItem(department.getName());
        }
    }

    // Load an employee using their ID
    private void loadEmployee() {

        try {

            int id = Integer.parseInt(idField.getText().trim());

            selectedEmployee = EmpHashMap.IDsearch(id);

            if (selectedEmployee == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee not found."
                );

                setFieldsEnabled(false);

                return;
            }

            // Display employee information
            nameField.setText(selectedEmployee.getName());

            ageField.setText(
                    String.valueOf(selectedEmployee.getAge())
            );

            departmentBox.setSelectedItem(
                    selectedEmployee.getDep() == null ? null : selectedEmployee.getDep().getName()
            );

            positionBox.setSelectedItem(
                    selectedEmployee.getPo()
            );

            typeLabel.setText(
                    selectedEmployee.getType().toString()
            );

            setFieldsEnabled(true);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid employee ID."
            );
        }
    }

    // Update employee information
    private void updateEmployee() {

        if (selectedEmployee == null) {
            return;
        }

        String name = nameField.getText().trim();

        String department =
                (String) departmentBox.getSelectedItem();

        try {

            int age = Integer.parseInt(ageField.getText().trim());

            if (age <= 0 || name.isEmpty() || department == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid employee information."
                );

                return;
            }

            // Validate the name before changing anything
            if (!selectedEmployee.setName(name)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid employee name."
                );

                return;
            }

            // Update department
            if (selectedEmployee.setDep(department) == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid department."
                );

                return;
            }

            // Update age and position
            selectedEmployee.setAge(age);

            selectedEmployee.setPo(
                    (Position) positionBox.getSelectedItem()
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Employee updated successfully!"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Age must be a valid number."
            );
        }
    }

    // Delete employee
    private void deleteEmployee() {

        if (selectedEmployee == null) {
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete employee "
                        + selectedEmployee.getName() + "?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            EmpHashMap.delEmp(selectedEmployee.getID());

            JOptionPane.showMessageDialog(
                    this,
                    "Employee deleted successfully!"
            );

            selectedEmployee = null;

            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            typeLabel.setText("Not loaded");

            setFieldsEnabled(false);
        }
    }

    // Enable or disable employee information fields
    private void setFieldsEnabled(boolean enabled) {

        nameField.setEnabled(enabled);

        ageField.setEnabled(enabled);

        departmentBox.setEnabled(enabled);

        positionBox.setEnabled(enabled);

    }
    // Refresh employee table
    private void refreshEmployeeTable() {

        employeeTableModel.setRowCount(0);

        ArrayList<Employee> employees =
                EmpHashMap.getAllEmployees();

        for (Employee employee : employees) {

            Object[] row = {
                    employee.getID(),
                    employee.getName(),
                    employee.getAge(),
                    employee.getDep(),
                    employee.getPo(),
                    employee.getType()
            };

            employeeTableModel.addRow(row);
        }
    }
}
