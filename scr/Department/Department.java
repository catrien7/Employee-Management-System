package Department;
import java.io.Serializable;
import Validation.DepNameValidation;

public class Department implements Serializable {
    private static int noOfDeps;
    private int ID;
    private String name;


    //expects valid and new name
    public Department( String name) {
        ID = newID();
        setName(name); 
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
