package EmployeeManager;

import Employee.Employee;
import HashMap.EmpHashMap;
import java.util.ArrayList;

public class ViewEmployee {

    // Returns all registered employees
    public static ArrayList<Employee> getAllEmployees() {
        return EmpHashMap.getAllEmployees();
    }

    // Returns an employee using ID
    public static Employee getEmployeeByID(int id) {

        return EmpHashMap.IDsearch(id);
    }
}