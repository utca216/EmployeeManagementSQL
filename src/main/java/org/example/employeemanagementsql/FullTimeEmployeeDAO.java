package org.example.employeemanagementsql;

import java.sql.*;
import java.util.ArrayList;

public class FullTimeEmployeeDAO {
    private Connection conn;
    public FullTimeEmployeeDAO() {
        String url = "jdbc:postgresql:employee_db"; // testdb is a name of localhost database
        String username = "postgres";
        String password = "123";

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database is successfully connected...");
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }

    }
    public ArrayList<FullTimeEmployee> getAllEmployees(){
        ArrayList<FullTimeEmployee> employees = new ArrayList<FullTimeEmployee>();

        try {

            String sql = "SELECT * FROM employee";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            //preparedStatement.setString(1, "HIGH");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");


                FullTimeEmployee employee = new FullTimeEmployee(id, name, position,salary);
                employees.add(employee);
                //System.out.println(employee);
            }
            resultSet.close();
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
        return employees;
    }

    public ArrayList<FullTimeEmployee> getEmployeeByName(String Name){
        ArrayList<FullTimeEmployee> employees = new ArrayList<FullTimeEmployee>();

        try {

            String sql = "SELECT * FROM employee" +
                    "WHERE Name = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement.setString(1, Name);
            //preparedStatement.setString(1, "HIGH");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");


                FullTimeEmployee employee = new FullTimeEmployee(id, name, position,salary);
                employees.add(employee);
                //System.out.println(employee);
            }
            resultSet.close();
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
        return employees;
    }

    public void addEmployee(FullTimeEmployee employee){
        try {
            String sql = "INSERT INTO employee (Name, Position, Salary)" +
                    "VALUES ( ?,?,?);";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public void deleteEmployee(FullTimeEmployee employee){
        try{
            String sql = "DELETE FROM employee WHERE id = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getId());
            ResultSet  resultSet= preparedStatement.executeQuery();
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public void updateEmployee(FullTimeEmployee employee){
        FullTimeEmployee employeeUpdate = new FullTimeEmployee();
        try {
            String sql = "SELECT * FROM employee" +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement.setString(1,Double.toString(employee.getId()));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");

                employeeUpdate.setName(name);
                employeeUpdate.setPosition(position);
                employeeUpdate.setSalary(salary);
            }
            resultSet.close();
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
        if(employee.getName()==null)employee.setName(employeeUpdate.getName());
        if(employee.getPosition()==null)employee.setPosition(employeeUpdate.getPosition());
        if(employee.getSalary()==0)employee.setSalary(employeeUpdate.getSalary());

        try{
            String sql ="UPDATE employee"+
                    "SET Name = ?, Position = ?, Salary = ? WHERE Id = 1;";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getPosition());
            preparedStatement.setDouble(3,employee.getSalary());
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }
}
