package EmployeeManager;

import java.util.Collection;
import FileHandeler.FileHandeler;
import Employee.Employee;
import HashMap.EmpHashMap;
import javax.swing.JPanel;


public class EmployeeManager {
    public Collection<Employee> getAllEmployees() {
    return EmpHashMap.getEmployees().values();
    }
  
  public static  void AddEmployee(Employee employee){
    EmpHashMap.addEmp(employee.getID(), employee);
    FileHandeler.SaveEmployees(EmpHashMap.getEmployees());
  }




}