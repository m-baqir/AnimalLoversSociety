package com.AnimalLoversSociety.MyApplication.employeeseminar;

import com.AnimalLoversSociety.MyApplication.employees.Employees;
import com.AnimalLoversSociety.MyApplication.seminars.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeSeminarService {
    private final EmployeeSeminarRepository employeeSeminarRepository;

    @Autowired
    public EmployeeSeminarService(EmployeeSeminarRepository employeeSeminarRepository) {
        this.employeeSeminarRepository = employeeSeminarRepository;
    }

    public List<EmployeeSeminar> getAttendanceForAllSeminars() { return employeeSeminarRepository.findAll(); }

    // saveRegistration
    public void saveRegistration(Employees employee, Seminar seminar) {
        EmployeeSeminar attendance = new EmployeeSeminar();
        attendance.setEmployee(employee); // need to be returned from repository?
        attendance.setSeminar(seminar);
        employeeSeminarRepository.save(attendance);
        // do i have to update the seminar and employees tables? don't think so because i can just save that info in this table
    }

    public List<Employees> getEmployeesBySeminar(Seminar seminar) {
        List<EmployeeSeminar> attendance = employeeSeminarRepository.findBySeminar(seminar);
        List<Employees> employees = new ArrayList<>();
        for (EmployeeSeminar employeeSeminar : attendance) {
            // for each employee-seminar relationship, take the employee and add to the list
            employees.add(employeeSeminar.getEmployee()); // maybe have to do this through repository?
        }
        return employees;
    }

    public List<EmployeeSeminar> findByEmployeeAndSeminar(Employees employee, Seminar seminar) {
        return employeeSeminarRepository.findByEmployeeAndSeminar(employee, seminar);
    }

    // error handling?
}
