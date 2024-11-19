package org.example.employeemanagementsql;

public class FullTimeEmployee extends Employee {
    public FullTimeEmployee() {
    }

    public FullTimeEmployee(int id, String name, String position, double salary) {
        super(id, name, position, salary);
    }

    @Override
    public double calculateSalary() {
        return this.salary;
    }
}
