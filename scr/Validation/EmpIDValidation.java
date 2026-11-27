package Validation;
import Employee.*;
import HashMap.*;

public class EmpIDValidation {
    
    // Validates a custom employee ID:
    // 1. Must be positive (> 0).
    // 2. Must not collide with auto-generated IDs (1000 up to 1000 + total employees created).
    // 3. Must not already exist in EmpHashMap.
    static public Boolean validateEmpID(int id){
        if(id<=0 || (id>=1000 && id<(Employee.getNoOfEmployee()+1000))) return false;
        else return !EmpHashMap.doesExist(id);
    }
    
}
