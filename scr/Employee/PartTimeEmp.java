package Employee;


public class PartTimeEmp extends Employee {
 int hoursRate;
 int hoursWorked;
     
 public PartTimeEmp(String name, String dep, int age, Position po, int hoursRate, int hoursWorked) {
    super(name, dep, age, po, EmployeeType.part);
    this.hoursRate = hoursRate;
    this.hoursWorked = hoursWorked;
}


 public PartTimeEmp(int ID, String name, String dep, int age, Position po, int hoursRate, int hoursWorked) {
    super(ID, name, dep, age, po, EmployeeType.part);
    this.hoursRate = hoursRate;
    this.hoursWorked = hoursWorked;
}


 @Override
    public double calcSalary(){
       return hoursRate*hoursWorked;
    }



}
