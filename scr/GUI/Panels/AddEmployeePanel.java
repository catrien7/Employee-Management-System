package GUI.Panels;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

import Department.Department;
import Employee.*;
import EmployeeManager.*;
import HashMap.*;
import Validation.*;

public class AddEmployeePanel extends JPanel implements ActionListener {
    private JTextField nameField;
    private JTextField AgeField;
    private JComboBox<EmployeeType> Type;
    private JComboBox DepBox;
    private JComboBox<Position> PosBox;
    private CardLayout cardLayout = new CardLayout(); // cardLayout
    private JPanel SalaryPanel;
    private JPanel FUllSalaryPanel;
    private JTextField BasicSalaryField;
    private JTextField BonusField;
    private JPanel PartSalaryPanel;
    private JTextField HoursWorkedField;
    private JTextField HoursRateField;
    private JCheckBox IdCheck;
    private JPanel IdPanel;
    private JTextField IdField;
    private JButton SaveButton;
    private JButton CancelButton;
    private JPanel buttonPanel;
    // private NumberFormatter formatter=new
    // NumberFormatter(NumberFormat.getIntegerInstance());

    public AddEmployeePanel(EmployeeManager employeeManager) {
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new GridLayout(9, 1, 10, 15));
        JPanel namPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namPanel.setBackground(Color.LIGHT_GRAY);
        nameField = new JTextField(20);
        JLabel nameLabel = new JLabel("Name");
        namPanel.add(nameLabel);
        namPanel.add(nameField);

        // formatter.setValueClass(Integer.class);
        // formatter.setAllowsInvalid(true);
        JPanel AgePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        AgeField = new JTextField(20);
        // AgeField.setColumns(20);
        JLabel AgeLabel = new JLabel("Age");
        AgePanel.add(AgeLabel);
        AgePanel.add(AgeField);
        AgePanel.setBackground(Color.LIGHT_GRAY);

        JPanel DepartmentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] department = { "IT", "Human Resources", "Finance ", "Marketing", "Sales" };
        DepBox = new JComboBox(department);
        JLabel DepartmentLabel = new JLabel("Department");
        DepartmentPanel.add(DepartmentLabel);
        DepartmentPanel.add(DepBox);
        DepartmentPanel.setBackground(Color.LIGHT_GRAY);

        JPanel PositionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // String[]position={"Full Stack Developer","Technical consultant","Ai Engineer
        // ","DevOps","UX Designer"};
        PosBox = new <Position>JComboBox(Position.values());
        JLabel PositionLabel = new JLabel("Position");
        PositionPanel.add(PositionLabel);
        PositionPanel.add(PosBox);
        PositionPanel.setBackground(Color.LIGHT_GRAY);

        JPanel TypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // String[]employeeType={"Full Time","Part Time"};
        Type = new JComboBox<EmployeeType>(EmployeeType.values());
        JLabel TypeLabel = new JLabel("Type");
        TypePanel.add(TypeLabel);
        TypePanel.add(Type);
        Type.addActionListener(this);
        TypePanel.setBackground(Color.LIGHT_GRAY);

        SalaryPanel = new JPanel(cardLayout);
        FUllSalaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        BasicSalaryField = new JTextField(20);
        JLabel BasicSalaryLabel = new JLabel("Salary");
        BonusField = new JTextField(20);
        JLabel BonusLabel = new JLabel("Bonus");
        FUllSalaryPanel.setBackground(Color.LIGHT_GRAY);

        FUllSalaryPanel.add(BasicSalaryLabel);
        FUllSalaryPanel.add(BasicSalaryField);
        FUllSalaryPanel.add(BonusLabel);
        FUllSalaryPanel.add(BonusField);

        PartSalaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        HoursWorkedField = new JTextField(20);
        JLabel HoursWorkedLabel = new JLabel("Working Hours");
        HoursRateField = new JTextField(20);
        JLabel HourseRateLabel = new JLabel("Hours Rate");
        PartSalaryPanel.setBackground(Color.LIGHT_GRAY);

        PartSalaryPanel.add(HoursWorkedLabel);
        PartSalaryPanel.add(HoursWorkedField);
        PartSalaryPanel.add(HourseRateLabel);
        PartSalaryPanel.add(HoursRateField);

        SalaryPanel.add(FUllSalaryPanel, "Full time Salary");
        SalaryPanel.add(PartSalaryPanel, "Part time Salary");

        IdCheck = new JCheckBox();
        IdCheck.setText("Enter Id manually");
        IdCheck.setFocusable(false);
        IdCheck.addActionListener(this);

        IdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        IdField = new JTextField(20);
        IdField.setEnabled(false);
        IdField.setBackground(Color.GRAY);
        JLabel IdLabel = new JLabel("ID");
        IdPanel.add(IdLabel);
        IdPanel.add(IdField);
        IdPanel.setBackground(Color.LIGHT_GRAY);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));

        SaveButton = new JButton();
        SaveButton.setBounds(5, 5, 5, 5);
        SaveButton.setText("Add");
        SaveButton.setFocusable(false);
        SaveButton.addActionListener(this);
        buttonPanel.add(SaveButton);

        CancelButton = new JButton();
        CancelButton.setBounds(5, 5, 5, 5);
        CancelButton.setText("Cancel");
        CancelButton.setFocusable(false);
        CancelButton.addActionListener(this);
        buttonPanel.add(CancelButton);

        add(namPanel);
        add(AgePanel);
        add(DepartmentPanel);
        add(PositionPanel);
        add(TypePanel);
        add(SalaryPanel);
        add(IdCheck);
        add(IdPanel);
        add(buttonPanel);
    }

    // public boolean ValidateIdField(int id){
    // if(EmpIDValidation.validateEmpID(id)){return true;}
    // else return false;}

    public boolean IsFieldEmpty(JTextField field) {
        if (field.getText().isBlank()) {
            // field.setBorder(BorderFactory.createLineBorder(Color.RED));
            return true;
        }
        return false;
    }

    public boolean CheckAllFields() {
        boolean empty = false;
        if (Type.getSelectedItem() == EmployeeType.full) {
            empty = (IsFieldEmpty(nameField) | IsFieldEmpty(AgeField) | IsFieldEmpty(BasicSalaryField)
                    | IsFieldEmpty(BonusField));
            return empty;
        }
        if (Type.getSelectedItem() == EmployeeType.part) {
            empty = (IsFieldEmpty(nameField) | IsFieldEmpty(AgeField) | IsFieldEmpty(HoursWorkedField)
                    | IsFieldEmpty(HoursRateField));
            return empty;
        }
        return empty;
    }

    public Employee ReadData() {
        int basicSalary = 0;
        int bonus = 0;
        int HoursWorked = 0;
        int HoursRate = 0;
        int id = 0;
        int age = 0;
        String dep = "";
        String name = "";
        Employee emp;
        if (NameValidation.validateName(nameField.getText())) {
            name = Normalization.normalize(nameField.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Name is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            if (AgeValidation.ValidateAge(Integer.parseInt(AgeField.getText()))) {
                age = Integer.parseInt(AgeField.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Age is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, " please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (DepHashMap.search((String) DepBox.getSelectedItem()) != null) {
            dep = (String) DepBox.getSelectedItem();
        }
        EmployeeType type = (EmployeeType) Type.getSelectedItem();
        Position pos = (Position) PosBox.getSelectedItem();
        if (IdCheck.isSelected()) {
            try {
                if (EmpIDValidation.validateEmpID(Integer.parseInt(IdField.getText()))) {
                    id = Integer.parseInt(IdField.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "ID is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " please enter a  ID number", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

        if (type == EmployeeType.full) {
            try {
                if (SalaryValidation.ValidateSalary(Integer.parseInt(BasicSalaryField.getText()))) {
                    basicSalary = Integer.parseInt(BasicSalaryField.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Salary is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            try {
                if (SalaryValidation.ValidateBonus(Integer.parseInt(BonusField.getText()))) {
                    bonus = Integer.parseInt(BonusField.getText());
                }

                else {
                    JOptionPane.showMessageDialog(this, "Bonus is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        }

        else {
            try {
                if (SalaryValidation.ValidateHours(Integer.parseInt(HoursWorkedField.getText()))) {
                    HoursWorked = Integer.parseInt(HoursWorkedField.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "Hours Worked is not valid", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            try {
                if (SalaryValidation.ValidateHoursRate(Integer.parseInt(HoursRateField.getText()))) {
                    HoursRate = Integer.parseInt(HoursRateField.getText());
                }

                else {
                    JOptionPane.showMessageDialog(this, "Hours rate is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        }

        if (Type.getSelectedItem() == EmployeeType.full) {
            if (IdCheck.isSelected()) {
                emp = new FullTimeEmp(id, name, dep, age, pos, basicSalary, bonus);
                return emp;
            } else {
                emp = new FullTimeEmp(name, dep, age, pos, basicSalary, bonus);
                return emp;
            }
        } else {
            if (IdCheck.isSelected()) {
                emp = new PartTimeEmp(id, name, dep, age, pos, HoursWorked, HoursRate);
                return emp;
            } else {
                emp = new PartTimeEmp(name, dep, age, pos, HoursWorked, HoursRate);
                return emp;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Type) {
            // System.out.println(Type.getSelectedItem());
            if (Type.getSelectedItem() == EmployeeType.full) {
                cardLayout.show(SalaryPanel, "Full time Salary");
            } else {
                cardLayout.show(SalaryPanel, "Part time Salary");
            }
        }
        if (e.getSource() == IdCheck) {
            if (IdCheck.isSelected()) {
                IdField.setEnabled(true);
                IdField.setBackground(Color.white);
            } else {
                IdField.setEnabled(false);
                IdField.setBackground(Color.GRAY);
            }
        }

        if (e.getSource() == SaveButton) {
            boolean empty = CheckAllFields();
            if (empty) {
                JOptionPane.showMessageDialog(this, "please enter requiered fields", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Employee emp = ReadData();
                if (emp != null) {
                    EmployeeManager.AddEmployee(emp); // add to hash map and save to file
                    JOptionPane.showMessageDialog(this, "Employee was added successfully", "Operation done",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }

        if (e.getSource() == CancelButton) {
            nameField.setText("");
            AgeField.setText(null);
            Type.setSelectedIndex(0);
            DepBox.setSelectedIndex(0);
            PosBox.setSelectedIndex(0);
            BasicSalaryField.setText("");
            BonusField.setText("");
            HoursRateField.setText("");
            HoursRateField.setText("");
            IdField.setText("");
            IdCheck.setSelected(false);
        }

        // ||
        // (IsFieldEmpty(nameField)|IsFieldEmpty(AgeField)|IsFieldEmpty(HoursWorkedField)|IsFieldEmpty(HoursRateField))

    }

}
