package EmployeeManager;
import Employee.*;
import HashMap.EmpHashMap;
public class EmployeeManager {

//add emp
 public boolean addEmployee(
       String name,
       String dep,
       int age,
       Position pos,
       int salaryOrRate,
       int bonusOrHours,
       EmployeeType type) {

        Employee emp;

        if (null == type) {
            return false;
        } else switch (type) {
            case full -> emp = new FullTimeEmp(
               name,
                dep,
                age,
                pos,
                salaryOrRate,       
                 bonusOrHours);
            case part -> emp = new PartTimeEmp(
                name,
                dep,
                age,
                pos,
                salaryOrRate,   
                 bonusOrHours);
      default -> {
      return false;}
  }
   return EmpHashMap.addEmp(emp.getID(), emp) == null;}
    

//delete emp
public boolean deleteEmployee(int id) {
    // Check if employee exists
    if (!EmpHashMap.doesExist(id)) {
        return false;}
    // Delete employee
    EmpHashMap.delEmp(id);
    return true;}


//update emp
public boolean updateEmployee(
        int id,
        String name,
        String dep,
        int age,
        Position pos,
        int salaryOrRate,
        int bonusOrHours,
        EmployeeType type) {

    Employee oldEmp = EmpHashMap.IDsearch(id);

    if (oldEmp == null || type == null) {
        return false;
    }

    Employee newEmp;
        switch (type) {
            case full -> newEmp = new FullTimeEmp(
                 id, name, dep, age, pos,
                salaryOrRate, bonusOrHours);
            case part -> newEmp = new PartTimeEmp(
                 id, name, dep, age, pos,
                 bonusOrHours, salaryOrRate);
            default -> {
                return false;}}
    EmpHashMap.getEmployees().put(id, newEmp);

    return true;
}

  
}
