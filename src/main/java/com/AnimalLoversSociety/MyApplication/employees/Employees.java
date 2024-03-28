package com.AnimalLoversSociety.MyApplication.employees;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeData")
    private int employeeData;

    @Column(name = "employeeID")
    private int employeeID;

    @Column(name = "employeeName", nullable = false)
    private String employeeName;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "supervisor", nullable = false)
    private String supervisor;

    @Column(name = "project", nullable = false)
    private String project;

    // Constructors
    public Employees() {
    }

    public Employees(int employeeID, String employeeName, String title, int salary, String department, String supervisor, String project) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.title = title;
        this.salary = salary;
        this.department = department;
        this.supervisor = supervisor;
        this.project = project;
    }

    // Getters and Setters

    public int getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(int employeeData) {
        this.employeeData = employeeData;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}