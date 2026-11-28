
package GUI.Components;

import Employee.Employee;
import java.awt.BorderLayout;
import java.util.Collection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeTable extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    public EmployeeTable() {

        setLayout(new java.awt.BorderLayout());

        String[] columns = {
            "ID", "Name", "Department",
            "Position", "Type", "Salary"
        };

        model = new DefaultTableModel(columns, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void addEmployee(Employee emp) {

        model.addRow(new Object[] {
            emp.getID(),
            emp.getName(),
            emp.getDep() == null ? "" : emp.getDep().getName(),
            emp.getPo(),
            emp.getType(),
            emp.calcSalary()
        });
    }

    public void addEmployees(Collection<Employee> employees) {

        for (Employee emp : employees) {
            addEmployee(emp);
        }
    }

    public void clearTable() {
        model.setRowCount(0);
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}

