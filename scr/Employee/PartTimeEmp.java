package Employee;

import Validation.SalaryValidation;

public class PartTimeEmp extends Employee {
 int hoursRate;
 int hoursWorked;
     
 public PartTimeEmp(String name, String dep, int age, Position po, int hoursRate, int hoursWorked) {
    super(name, dep, age, po, EmployeeType.part);
    if(SalaryValidation.ValidateHoursRate(hoursRate))
       this.hoursRate=hoursRate;

     if(SalaryValidation.ValidateHours(hoursWorked))
        this.hoursWorked=hoursWorked;
}


 public PartTimeEmp(int ID, String name, String dep, int age, Position po, int hoursRate, int hoursWorked) {
    super(ID, name, dep, age, po, EmployeeType.part);
    if(SalaryValidation.ValidateHoursRate(hoursRate))
       this.hoursRate=hoursRate;

     if(SalaryValidation.ValidateHours(hoursWorked))
        this.hoursWorked=hoursWorked;
}


 @Override
    public double calcSalary(){
       return hoursRate*hoursWorked;
    }

        public int getHoursRate() {
        return hoursRate;
    }

    public void setHoursRate(int hoursRate) {
        this.hoursRate = hoursRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }



}
