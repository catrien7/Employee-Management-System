package Validation;

public class SalaryValidation {

static public Boolean ValidateSalary(int salary){
if (salary<10000 || salary>50000) {
    return false;
}
return true;
}    

static public Boolean ValidateBonus(int bonus){
if ((bonus<0 || bonus>7000)) {
    return false;
}
return true;
}    

static public Boolean ValidateHoures(int hours){
if (hours<80 || hours>200) {
    return false;
}
return true;
}    

static public Boolean ValidateHoursRate(int hoursRate){
if (hoursRate<100 || hoursRate>200) {
    return false;
}
return true;
}    





}
