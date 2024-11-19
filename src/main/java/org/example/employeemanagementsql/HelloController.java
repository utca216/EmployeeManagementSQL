package org.example.employeemanagementsql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField Name;
    @FXML
    private TextField Hours;
    @FXML
    private TextField Rate;
    @FXML
    private TextField Salary;
    @FXML
    private RadioButton RadioButtonFullTime;
    @FXML
    private RadioButton RadioButtonPartialTime;
    @FXML
    private RadioButton RadioButtonContractor;
    @FXML
    private ListView<Employee> listView;

    ObservableList<Employee> EmployeeLIst = FXCollections.observableArrayList();

    FullTimeEmployeeDAO EmployeeInit=new FullTimeEmployeeDAO();
    @FXML
    public void initialize(){
        listView.setItems(EmployeeLIst);
        EmployeeLIst.addAll(EmployeeInit.getAllEmployees());
    }
    @FXML
    private void handleRadioButtonAction() {
        if (RadioButtonFullTime.isSelected()) {
            Salary.setVisible(true);
            //Hours.setVisible(false);
           // Rate.setVisible(false);
        } else if (RadioButtonContractor.isSelected()) {
            Hours.setVisible(true);
            Rate.setVisible(true);
           // Salary.setVisible(false);
        } else if (RadioButtonPartialTime.isSelected()) {
            Hours.setVisible(true);
            Rate.setVisible(true);
           // Salary.setVisible(false);
        }
    }
    @FXML
    void AddClick() {

        if(RadioButtonFullTime.isSelected()) {
            FullTimeEmployee FL = new FullTimeEmployee();
            FullTimeEmployeeDAO FLDAO = new FullTimeEmployeeDAO();
            FL.setName(Name.getText());
            FL.setSalary(Double.parseDouble(Salary.getText()));
            FL.setPosition("Fulltime");
            EmployeeLIst.add(FL);
            FLDAO.addEmployee(FL);
        }
        if(RadioButtonPartialTime.isSelected()) {
            PartTimeEmployee PT = new PartTimeEmployee();
            PartTimeEmployeeDAO PTDAO = new PartTimeEmployeeDAO();
            PT.setName(Name.getText());
            PT.setHoursWorked(Integer.parseInt(Hours.getText()));
            PT.setHourlyWage(Integer.parseInt(Rate.getText()));
            PT.setSalary(PT.calculateSalary());
            PT.setPosition("Parttime");
            EmployeeLIst.add(PT);
            PTDAO.addEmployee(PT);
        }
        if(RadioButtonContractor.isSelected()) {
            PartTimeEmployee PT = new PartTimeEmployee();
            PartTimeEmployeeDAO PTDAO = new PartTimeEmployeeDAO();
            PT.setName(Name.getText());
            PT.setHoursWorked(Integer.parseInt(Hours.getText()));
            PT.setHourlyWage(Integer.parseInt(Rate.getText()));
            PT.setSalary(PT.calculateSalary());
            PT.setPosition("Contractor");
            EmployeeLIst.add(PT);
            PTDAO.addEmployee(PT);
        }
        }

    }
