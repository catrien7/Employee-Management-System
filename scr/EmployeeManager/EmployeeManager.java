package EmployeeManager;

import java.util.Collection;

import Employee.Employee;
import HashMap.EmpHashMap;

public class EmployeeManager {
    public Collection<Employee> getAllEmployees() {
    return EmpHashMap.getEmployees().values();
}
}
