package com.zipcodewilmington.centrallibrary;

import java.text.NumberFormat;
import java.util.Locale;

public class Librarian extends Person {
    
    private String employeeId;
    private String department;
    private double salary;

    public Librarian(String name, int age, String email, String phoneNumber,
                 String employeeId, String department, double salary) {
        super(name, age, email, phoneNumber);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
    return "Name: " + getName() + " | Age: " + getAge() + 
    " | Email: " + getEmail() + " | Phone Number: " + getPhoneNumber() + 
    " | Employee ID: " + employeeId + " | Department: " + department + 
    " | Salary: " + formatter.format(salary);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if (employeeId != null && !employeeId.isEmpty()) {
            this.employeeId = employeeId;
        } else {
            System.out.println("Invalid Employee ID");
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department != null && !department.isEmpty()) {
            this.department = department;
        } else {
            System.out.println("Invalid Department");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid Salary");
        }
    }

    public void addItemToLibrary(Library library, LibraryItem item) {
        library.addItem(item);
    }

    public void removeItemFromLibrary(Library library, LibraryItem item) {
        library.removeItem(item);
    }

}
