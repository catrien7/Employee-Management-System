package EmployeeSearch;
import Employee.Employee;
import HashMap.*;

public abstract class SearchByID {
    public static Employee search(int id){
        return EmpHashMap.IDsearch(id);
    }

    
}
