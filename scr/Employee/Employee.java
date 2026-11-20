package Employee;

import Department.*;
import HashMap.*;
import Validation.*;


abstract public class Employee {
    static private int noOfEmployee=0;
    private int ID;
    private String name;
    private String dep;
    private int age;
    private Position po;
    private EmployeeType type;
    
    // Expects valid parameters (name, dep, age, po, type).
    // Note: Does NOT automatically add the employee to the HashMap.
    public Employee (String name, String dep, int age, Position po, EmployeeType type){
        this.ID = newID();
        this.name = name;
        setDep(dep);
        this.age = (age > 0) ? age : 18; 
        this.po = po;
        this.type = type;
    }

    public Employee (int ID, String name, String dep, int age, Position po, EmployeeType type){
        setID(ID);
        this.name = name;
        setDep(dep);
        this.age = (age > 0) ? age : 18; 
        this.po = po;
        this.type = type;
        
    }

    
    int newID(){
        return ++noOfEmployee +1000;
    }

    abstract int calcSalary();

    public static int getNoOfEmployee() {
        return noOfEmployee;
    }

    public int getID() {
        return ID;
    }

    public Boolean setID(int id) {
        if (EmpIDValidation.validateEmpID(id)) {
            this.ID = id;
            return true;
        }
        else return false;
        
    }

    public String getDep() {
        return dep;
    }

    public Boolean setDep(String dep) {
        if(DepHashMap.doesExistByKey(dep)){
            //fi el function by7sl validation 
            this.dep = dep;
            return true;
        }
        else return false;
        
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = (age > 0) ? age : 18; 
    }

    public Position getPo() {
        return po;
    }

    public void setPo(Position po) {
        this.po = po;
    }

    public String getName() {
        return name;
    }

    public Boolean setName(String name) {
        if(NameValidation.validateName(name)) {
            this.name = name;
            return true;
        }
        else return false;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + ID + "\nname=" + name + "\ndep=" + dep + "\nage=" + age + "\npo=" + po + "\ntype="
                + type + "]";
    }

    
   


    
}
