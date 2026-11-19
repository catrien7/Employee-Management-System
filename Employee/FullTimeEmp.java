/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;
import Department.Department;

/**
 *
 * @author Catri
 */
public class FullTimeEmp extends Employee{
    private int basicSalary;
    private int monthlyBonus;
    
    public FullTimeEmp(String name, Department dep, int age, Position po, EmployeeType type, int basic, int bonus){
        super (name, dep, age, po, type);
        basicSalary= basic;
        monthlyBonus= bonus;
        
    }
    @Override
    int calcSalary(){
        return basicSalary+monthlyBonus;
    }
    
    
}
