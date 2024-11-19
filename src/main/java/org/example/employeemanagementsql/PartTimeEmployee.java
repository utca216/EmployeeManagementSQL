package org.example.employeemanagementsql;

public class PartTimeEmployee extends Employee {

    int hoursWorked;
    int hourlyWage;
    public PartTimeEmployee() {
    }

    public PartTimeEmployee(int id, String name, String position, double salary) {
        super(id, name, position, salary);
    }

    @Override
    public double calculateSalary() {
        return hourlyWage*hoursWorked;
    }

    public int getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
