
package Employee;
import Department.*;


public class FullTimeEmp extends Employee{
    private int basicSalary;
    private int monthlyBonus;
    
    public FullTimeEmp(String name, String dep, int age, Position po, EmployeeType type, int basic, int bonus){
        super (name, dep, age, po, type);
        basicSalary= basic;
        monthlyBonus= bonus;
 
    }
    public FullTimeEmp(int id, String name, String dep, int age, Position po, EmployeeType type, int basic, int bonus){
        super (id, name, dep, age, po, type);
        basicSalary= basic;
        monthlyBonus= bonus;
 
    }
    @Override
    public double calcSalary(){
        return basicSalary+monthlyBonus;
    }
    
    
}
