package gui.main;
import EmployeeManager.EmployeeManager;

public class Main {

    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();

        // Load employees into manager first
        // if your project has saved employee data.

        new MainFrame(manager);
    }
}
