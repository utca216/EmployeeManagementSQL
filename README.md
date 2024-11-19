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

## User Interface

The application uses **JavaFX** to display a list of employees.

### Key Features:
1. **Dynamic Employee List**:  
   A `ListView` UI component displays employee data imported from the database on startup.  
2. **Add Employees**:  
   Users can add new employees, and the data is saved to the database.  

---

## How It Works  

### 1. Startup
- Connects to the PostgreSQL database.  
- Retrieves all stored employee records using the DAO classes.  
- Displays employee data in the `ListView`.  

### 2. Adding Employees
- Users can add new full-time or part-time employees via the UI.  
- Data is saved to the database in real time.  

### 3. Salary Calculation
- Each employee type has a unique method to calculate salaries based on their employment type.  

---

## Database Connection  

The project uses **JDBC** to connect to the PostgreSQL database. Connection parameters are defined in the DAO classes.

![image](https://github.com/user-attachments/assets/c1cc226d-3740-4d5e-b090-7c80fb11d1e7)
Employees imported from a database after program startup. Program automatically calculates salary and adds employee to list on add button click. Method of salary calculation depends on radiobutton selected. 


