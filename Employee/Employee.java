package Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Department.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Catri
 */
abstract public class Employee {
    static int noOfEmployee=0;
    int ID;
    String name;
    Department dep;
    int age;
    Position po;
    EmployeeType type;
    
    public Employee (String name, Department dep, int age, Position po, EmployeeType type){
        this.ID = newID();
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
}
