package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import Employee.Employee;

public abstract class EmpHashMap {
    private static final HashMap<Integer, Employee> employees = new HashMap<>();

    static public Employee IDsearch(int id) {
        return employees.get(id);
    }

    public static HashMap<Integer, Employee> getEmployees() {
        return employees;
    }

    static public Employee addEmp(int id, Employee emp) {
        return employees.putIfAbsent(id, emp);
    }

    static public Employee delEmp(int id) {
        return employees.remove(id);
    }

    static public Boolean doesExist(int id) {
        return employees.containsKey(id);
    }

    static public Boolean doesExist(Employee emp) {
        return employees.containsValue(emp);
    }

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
