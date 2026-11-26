
package Manager;

import Department.Department;
import Employee.Employee;
import HashMap.DepHashMap;
import HashMap.EmpHashMap;
import Validation.DepNameValidation;
import FileHandeler.FileHandeler;
import java.util.ArrayList;

public class DepartmentManager {

    public DepartmentManager() {
        DepHashMap.uploadDepartments(FileHandeler.LoadDepartments());
    }

    // Add a new department
    public boolean addDepartment(String name) {

        // Check if the department name is valid
        if (!DepNameValidation.isValid(name)) {
            return false;
        }

        // Create a new Department object
        Department department = new Department(name);

        // Store the department in the HashMap
        Department existing = DepHashMap.add(name, department);

        // If existing is null, the department was added.
        if (existing == null) {
            saveDepartments();
            return true;
        }
        return false;
    }


    // Search for a department by name
    public Department findDepartment(String name) {

        return DepHashMap.search(name);
    }


    // Assign an employee to a department
    public boolean assignEmployeeToDepartment(
            int employeeID, String departmentName) {

        // Search for the department
        Department department = DepHashMap.search(departmentName);

        if (department == null) {
            return false;
        }

        // Search for the employee
        Employee employee = EmpHashMap.IDsearch(employeeID);

        if (employee == null) {
            return false;
        }

        // Update the employee's department and keep the department membership map in sync.
        if (employee.setDep(department.getName()) == null) return false;
        department.addEmployee(employee);
        saveDepartments();
        return true;
    }
    // Get all departments
    public ArrayList<Department> getAllDepartments() {
        return DepHashMap.getAllDepartments();
    }


    // Delete a department if no employees are assigned to it
    public boolean deleteDepartment(String departmentName) {

        Department department = DepHashMap.search(departmentName);

        // Check if the department exists
        if (department == null) {
            return false;
        }

        // Do not orphan employees when a department is deleted.
        if (!department.getEmployees().isEmpty()) return false;

        // Delete the department
        DepHashMap.remove(departmentName);
        saveDepartments();
        return true;
    }

    public void saveDepartments() {
        FileHandeler.SaveDepartments(DepHashMap.getDepartments());
    }
}
