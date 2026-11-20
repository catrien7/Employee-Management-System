package  HashMap;

import java.util.HashMap;

import Employee.Employee;

public abstract class EmpHashMap {
    private static final HashMap<Integer, Employee> employees = new HashMap<>();

    static public Employee IDsearch(int id){
        Integer x= new Integer(id);
        return employees.get(x);
    }

    static public Employee addEmp(int id, Employee emp){
        Integer x= new Integer(id);
        return employees.putIfAbsent(x,emp);
    }

    static public Employee delEmp(int id){
        Integer x= new Integer(id);
        return employees.remove(id);
    }
    
    static public Boolean doesExist(int id){
        return employees.containsKey(id);
    }

    static public Boolean doesExist(Employee emp){
        return employees.containsValue(emp);
    }




    
}