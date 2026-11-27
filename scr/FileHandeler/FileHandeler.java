package FileHandeler;

import java.io.*;
//import HashMap.EmpHashMap;
//import java.io.IOException;
import java.util.HashMap;
import Employee.Employee;
import Department.Department;

public class FileHandeler {

    public static HashMap<Integer, Employee> LoadEmployees() {
        try (FileInputStream file = new FileInputStream("employees.ser");
                ObjectInputStream fileIn = new ObjectInputStream(file)) {
            HashMap<Integer, Employee> Loadedemployees = (HashMap<Integer, Employee>) fileIn.readObject();
            // fileIn.close();
            return Loadedemployees;
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load employees", e);
        }

    }

    public static void SaveEmployees(HashMap<Integer, Employee> employees) {
        try (FileOutputStream file = new FileOutputStream("employees.ser");
                ObjectOutputStream fileOut = new ObjectOutputStream(file)) {
            fileOut.writeObject(employees);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save employees", e);
        }
    }

    public static HashMap<String, Department> LoadDepartments() {
        try (FileInputStream file = new FileInputStream("Deparments.ser");
                ObjectInputStream fileIn = new ObjectInputStream(file)) {
            HashMap<String, Department> LoadedDepartments = (HashMap<String, Department>) fileIn.readObject();
            return LoadedDepartments;
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Departments", e);
        }
    }

    public static void SaveDepartments(HashMap<String, Department> Departments) {
        try (FileOutputStream file = new FileOutputStream("Departments.ser");
                ObjectOutputStream fileOut = new ObjectOutputStream(file)) {
            fileOut.writeObject(Departments);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save employees", e);
        }

    }

}
