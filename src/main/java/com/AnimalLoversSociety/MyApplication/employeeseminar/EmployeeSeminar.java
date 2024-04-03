package com.AnimalLoversSociety.MyApplication.employeeseminar;

import com.AnimalLoversSociety.MyApplication.employees.Employees;
import com.AnimalLoversSociety.MyApplication.seminars.Seminar;
import jakarta.persistence.*;

@Entity
@Table(name = "employee_seminar")
public class EmployeeSeminar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employeeID", nullable = false)
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "seminarId", nullable = false)
    private Seminar seminar;

    public EmployeeSeminar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }
}
