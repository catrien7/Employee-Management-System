package Validation;
import Employee.*;
import HashMap.*;

public class EmpIDValidation {
    static public Boolean validateEmpID(int id){
        if(id<=0 || (id>=1000 && id<(Employee.getNoOfEmployee()+1000))) return false;
        else if (EmpHashMap.doesExist(id)) return false;
        else return true;
    }
    
}
