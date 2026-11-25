package Department;
import Employee.*;
import java.io.Serializable;
import Validation.DepNameValidation;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Department implements Serializable {
    private static int noOfDeps;
    private int ID;
    private String name;
    private HashMap<Integer, Employee> employees = new HashMap<>();


    //expects valid and new name
    public Department( String name) {
        ID = newID();
        setName(name); 
    }

    public Department( String name, HashMap<Integer, Employee> employees) {
        this( name);
        setEmployees(employees);
    }

    
    public HashMap<Integer, Employee> getEmployees() {
        return employees;
    }


    public void setEmployees(HashMap<Integer, Employee> employees) {
        this.employees = employees;
    }

    public Boolean addEmployee(Employee emp){
        if(this.employees.putIfAbsent(emp.getID(),emp) != null) return true;
        return false;
    }


    private int newID(){
        return ++noOfDeps+100;
    }

    public static int getNoOfDeps() {
        return noOfDeps;
    }
    
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Boolean setName(String name) {
        if (DepNameValidation.isValid(name)){
            this.name = name;
            return true;
        }
        else return false;
        
    }

    

    
}
