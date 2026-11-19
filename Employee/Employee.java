package Employee;

import Department.*;
import HashMap.*;
import Validation.*;


abstract public class Employee {
    static private int noOfEmployee=0;
    private int ID;
    private String name;
    private Department dep;
    private int age;
    private Position po;
    private EmployeeType type;
    
    // Expects valid parameters (name, dep, age, po, type).
    // Note: Does NOT automatically add the employee to the HashMap.
    public Employee (String name, Department dep, int age, Position po, EmployeeType type){
        this.ID = newID();
        this.name = name;
        this.dep = dep;
        this.age = (age > 0) ? age : 18; 
        this.po = po;
        this.type = type;
    }

    public Employee (int ID, String name, Department dep, int age, Position po, EmployeeType type){
        this.ID=ID;
        this.name = name;
        this.dep = dep;
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

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
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

   


    
}
