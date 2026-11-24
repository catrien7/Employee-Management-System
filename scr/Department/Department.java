package Department;
import Employee.*;
import java.io.Serializable;
import Validation.DepNameValidation;
import java.util.List;
import java.util.ArrayList;

public class Department implements Serializable {
    private static int noOfDeps;
    private int ID;
    private String name;
    private List<Employee> employees= new ArrayList<>();


    //expects valid and new name
    public Department( String name) {
        ID = newID();
        setName(name); 
    }

    public Department( String name, List<Employee> employees) {
        this( name);
        setEmployees(employees);
    }

    
    public List<Employee> getEmployees() {
        return employees;
    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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
