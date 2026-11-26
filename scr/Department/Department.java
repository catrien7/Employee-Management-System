package Department;

import Employee.*;
import java.io.Serializable;
import Validation.DepNameValidation;
import java.util.HashMap;

public class Department implements Serializable {
    private static int noOfDeps;
    private int ID;
    private String name;
    private HashMap<Integer, Employee> employees = new HashMap<>();

    // expects valid and new name
    public Department(String name) {
        ID = newID();
        setName(name);
    }

    public Department(String name, HashMap<Integer, Employee> employees) {
        this(name);
        setEmployees(employees);
    }

    public HashMap<Integer, Employee> getEmployees() {
        return employees;
    }

    public Boolean setEmployees(HashMap<Integer, Employee> employees) {
        if (employees == null) return false;
        this.employees = employees;
        for (Employee emp : employees.values()) {
            emp.setDep(this);
        }
        return true;
    }

    public Boolean addEmployee(Employee emp) {
        if (emp == null) return false;
        if (this.employees.putIfAbsent(emp.getID(), emp) == null) { // returns null if it doesnot exist
            emp.setDep(this);
            return true;
        }
        return false;
    }

    /*
     * public Boolean addEmployee(Employee emp) {
     * 
     * if (emp == null) return false;
     * 
     * return employees.putIfAbsent(emp.getID(), emp) == null;
     * }
     */

    private int newID() {
        return ++noOfDeps + 100;
    }

    public static int getNoOfDeps() {
        return noOfDeps;
    }

    public static void setNoOfDeps(int value) {
        noOfDeps = Math.max(0, value);
    }
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Boolean setName(String name) {
        if (DepNameValidation.isValid(name)) {
            this.name = name;
            return true;
        } else
            return false;

    }

}
