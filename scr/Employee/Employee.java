package Employee;

import Department.*;
import HashMap.*;
import Validation.*;
import java.io.Serializable;
import javax.swing.JOptionPane;

abstract public class Employee implements Serializable {
    static private int noOfEmployee = 0;
    private int ID;
    private String name;
    private Department dep;
    private int age;
    private Position po;
    private EmployeeType type;

    // Expects valid parameters (name, dep, age, po, type).
    // Note: Does NOT automatically add the employee to the HashMap.
    public Employee(String name, String dep, int age, Position po, EmployeeType type) {
        this.ID = newID();
        setEmployee(name, dep, age, po, type);
        
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    
    public Employee(int ID, String name, String dep, int age, Position po, EmployeeType type) {
        if (!setID(ID))
            this.ID = newID();
        setEmployee(name, dep, age, po, type);
    }

    private void setEmployee(String name, String depName, int age, Position po, EmployeeType type) {
        setName(name);
        setDep(depName);
        this.age = (age > 0) ? age : 18;
        this.po = po;
        this.type = type;
    }
    /*
     * private int newID() {
     * return ++noOfEmployee + 1000;
     * }
     */

    private int newID() {
        int candidate;
        do {
            candidate = ++noOfEmployee + 1000;
        } while (EmpHashMap.doesExist(candidate));
        return candidate;
    }

    public abstract double calcSalary();

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
        } else {

            JOptionPane.showMessageDialog(null, "Please enter a valid Employee ID");

            return false;
        }

    }

    public Department getDep() {
        return dep;
    }

    public String getDepName() {
        return dep.getName();
    }

    public Department setDep(String depName) {
        Department foundDep = DepHashMap.search(depName); // fi el function by7sl validation
        if (foundDep != null) {
            this.dep = foundDep;
        }
        return foundDep;
    }

    public Department setDep(Department dep) {
        if (dep!=null && DepHashMap.doesExistByValue(dep)) {
            this.dep = dep;
        }
        return dep;
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
        if (NameValidation.validateName(name)) {
            this.name = name;
            return true;
        } else
            return false;
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

    public static void setNoOfEmployee(int noOfEmployee) {
        Employee.noOfEmployee = noOfEmployee;
    }

}
