package gui.Panels;

import java.awt.BorderLayout;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Employee.*;
import EmployeeManager.*;

public class ViewEmployeePanel extends JPanel {

    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private EmployeeManager employeeManager;

    public ViewEmployeePanel(EmployeeManager employeeManager) {

        this.employeeManager = employeeManager;
        setLayout(new BorderLayout());

        String[] columns = { "ID", "Name", "Department", "Position", "Type", "Salary" };

        tableModel = new DefaultTableModel(columns, 0) { // Anonymous Inner Class

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        employeeTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(employeeTable);

        add(scrollPane, BorderLayout.CENTER);

        addRows(employeeManager.getAllEmployees());
    }

    public JTable getEmployeeTable() {
        return employeeTable;
    }

    public void setEmployeeTable(JTable employeeTable) {
        this.employeeTable = employeeTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    //addRows(employeeManager.getAllEmployees());

    public Boolean addRow(Employee emp) {
        this.tableModel.addRow(new Object[] {
            emp.getID(),
            emp.getName(),
            emp.getDep() == null ? "" : emp.getDepName(),
            emp.getPo(),
            emp.getType(),
            emp.calcSalary()
        });
        return true;
    }

    public Boolean addRows(Collection<Employee> employees) {
        for (Employee emp : employees) {
            addRow(emp);
        }
        return true;

    }

}
