package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

import Employee.*;

public abstract class EmpHashMap {
    private static final HashMap<Integer, Employee> employees = new HashMap<>();

    static public Employee IDsearch(int id) {
        Integer x = new Integer(id);
        return employees.get(x);
    }

    public static HashMap<Integer, Employee> getEmployees() {
        return employees;
    }

    static public Employee addEmp(int id, Employee emp) {
        Integer x = new Integer(id);
        return employees.putIfAbsent(x, emp);
    }

    static public Employee delEmp(int id) {
        Integer x = new Integer(id);
        return employees.remove(id);
    }

    static public Boolean doesExist(int id) {
        return employees.containsKey(id);
    }

    static public Boolean doesExist(Employee emp) {
        return employees.containsValue(emp);
    }

    /* 
    static public void uploadEmployees(HashMap<Integer, Employee> loadedEmployees) {
        employees.putAll(loadedEmployees);
    }
        */

    public static ArrayList<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }
    
    public static void uploadEmployees(HashMap<Integer, Employee> loadedEmployees) {
        if (loadedEmployees == null)
            return;
        employees.putAll(loadedEmployees);
        for (Integer id : employees.keySet()) {
            if (id > 1000 && (id - 1000) > Employee.getNoOfEmployee()) {
                Employee.setNoOfEmployee(id - 1000);
            }
        }
    }

}