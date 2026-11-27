
package Employee;
import Validation.*;


public class FullTimeEmp extends Employee{
    private int basicSalary;
    private int monthlyBonus;
    
    public FullTimeEmp(String name, String dep, int age, Position po,
         int basic, int bonus){
        super (name, dep, age, po, EmployeeType.full);
        if(SalaryValidation.ValidataSalary(basic))
        basicSalary=basic;
        
           if(SalaryValidation.ValidateBonus(bonus))
        monthlyBonus=bonus; 
                 
    }
        
    
    public FullTimeEmp(int id, String name, String dep, int age, Position po,
         int basic, int bonus){
        super (id, name, dep, age, po, EmployeeType.full);
        if(SalaryValidation.ValidataSalary(basic))
        basicSalary=basic;
        
           if(SalaryValidation.ValidateBonus(bonus))
        monthlyBonus=bonus; 
           
    }


    @Override
    public double calcSalary(){
        return basicSalary+monthlyBonus;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(int monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }
    
    
}
