package Validation;

public class SalaryValidation {

static public Boolean ValidateSalary(int salary){
return !(salary<10000 || salary>50000);
}    

static public Boolean ValidateBonus(int bonus){
return !(bonus<500 || bonus>7000);
}    

static public Boolean ValidateHours(int hours){
return !(hours<80 || hours>200);
}    

static public Boolean ValidateHoursRate(int hoursRate){
return !(hoursRate<100 || hoursRate>200);
}    

    public static boolean ValidataSalary(int basic) {
        throw new UnsupportedOperationException("Not supported yet.");
    }





}
