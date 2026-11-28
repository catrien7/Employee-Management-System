package FileHandeler;


import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import HashMap.*;
import java.io.IOException;
import Employee.*;
import Department.*;

public class FileHandeler {

  public static HashMap<Integer, Employee> LoadEmployees(){
    try(FileInputStream file =new FileInputStream("employees.ser");
        ObjectInputStream fileIn=new ObjectInputStream(file)
    ){
        HashMap<Integer, Employee>Loadedemployees=(HashMap<Integer, Employee>)fileIn.readObject();
        //fileIn.close();
        return Loadedemployees;  
    }
    catch (FileNotFoundException e) {
            return new HashMap<>();
         }
    catch (InvalidClassException e) {
     // The saved data was created by an incompatible class version. Start clean.
     return new HashMap<>();
    }
    catch (Exception e) {
     // A damaged data file must not prevent the GUI from starting.
     return new HashMap<>();
    }

}


 public static void SaveEmployees(HashMap<Integer,Employee> employees){
   try (FileOutputStream file = new FileOutputStream("employees.ser");
        ObjectOutputStream fileOut=new ObjectOutputStream(file)
    ){
    fileOut.writeObject(employees);
   }
   catch (Exception e) {
      throw new RuntimeException("Failed to save employees", e);
   }
}



 public static HashMap<String, Department> LoadDepartments(){
    try(FileInputStream file =new FileInputStream("Departments.ser");
        ObjectInputStream fileIn=new ObjectInputStream(file)
    ){
        HashMap<String, Department>LoadedDepartments=(HashMap<String, Department>)fileIn.readObject();
        return LoadedDepartments;  
    }
    catch (FileNotFoundException e) {
            return new HashMap<>();
         }
    catch (InvalidClassException e) {
     // The saved data was created by an incompatible class version. Start clean.
     return new HashMap<>();
    }
    catch (Exception e) {
     // A damaged data file must not prevent the GUI from starting.
     return new HashMap<>();
    }
}


 public static void SaveDepartments(HashMap<String, Department>Departments){
   try (FileOutputStream file = new FileOutputStream("Departments.ser");
        ObjectOutputStream fileOut=new ObjectOutputStream(file)
    ){
    fileOut.writeObject(Departments);
   }
   catch (Exception e) {
      throw new RuntimeException("Failed to save employees", e);
   }  

 }










 }