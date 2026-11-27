package EmployeeSearch;

import Department.*;
import Employee.Employee;
import HashMap.*;
import java.util.HashSet;
import java.util.Set;

public abstract class SearchByDep {
    
    public static Set<Employee> depEmployees(String dep){
        Department d= DepHashMap.search(dep);
        if(d==null) return null;
        Set<Employee> employeeSet = new HashSet<>(d.getEmployees().values());
        return employeeSet;
    }

    public static Set<Employee> depEmployees(Department dep){
        if(dep==null) return null;
        Set<Employee> employeeSet = new HashSet<>(dep.getEmployees().values());
        return employeeSet;
    }

    public static Employee empSearch(String dep, int id){
        Department d= DepHashMap.search(dep);
        if(d==null) return null;
        return d.getEmployees().get(id);
    }

    public static Employee empSearch(Department dep, int id){
        if(dep==null) return null;
        return dep.getEmployees().get(id);
    }

    
}
