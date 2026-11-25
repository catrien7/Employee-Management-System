package search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Department.*;
import Employee.Employee;
import HashMap.*;

public abstract class SearchByDep {
    
    public static Set<Employee> depEmployees(String dep){
        Department d= DepHashMap.search(dep);
        if(d==null) return null;
        Set<Employee> employeeSet = new HashSet<>(d.getEmployees().values());
        return employeeSet;
    }

    public static Employee empSearch(String dep, int id){
        Department d= DepHashMap.search(dep);
        if(d==null) return null;
        return d.getEmployees().get(id);
    }

    
}
