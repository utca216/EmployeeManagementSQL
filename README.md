# Employee Management System

This project is a **JavaFX application** for managing employees and their salaries. It connects to a **PostgreSQL database** and supports the display, storage, and calculation of employee salaries. The application features a simple user interface where employees are listed and imported from the database on startup.

---

## Features

- **Employee Data Management**: View, add, and manage employee records.  
- **Salary Calculation**: Unique salary calculation logic for full-time and part-time employees.  
- **Database Integration**: Data persistence using the **DAO pattern** with PostgreSQL.  
- **Dynamic UI Updates**: Automatically imports and displays employee records from the database at startup.  

---

## Project Structure

The project is organized around an abstract `Employee` class, with specific implementations for different employee types. Each type has its own DAO class for database interaction.  

### 1. `Employee` (Abstract Class)  
- Parent class for all employees.  
- Defines common attributes: `id`, `name`, `position`.  
- Includes an abstract method: `calculateSalary()`.  

### 2. `FullTimeEmployee` (Child Class)  
- Inherits from `Employee`.  
- Contains logic for calculating full-time employee salaries.  
- Has a dedicated `FullTimeEmployeeDAO` class for database operations.  

### 3. `PartTimeEmployee` (Child Class)  
- Inherits from `Employee`.  
- Contains logic for calculating part-time employee salaries.  
- Has its own `PartTimeEmployeeDAO` class for database interaction.  

---

## DAO Classes  

DAO (Data Access Object) classes handle database operations for each employee type.  

#### Example:  
```java
public class FullTimeEmployeeDAO {
    public List<FullTimeEmployee> getAllEmployees() {
        // Connect to the database and return a list of FullTimeEmployees
    }
}
