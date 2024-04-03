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
        attendance.setEmployee(employee);
        attendance.setSeminar(seminar);
        employeeSeminarRepository.save(attendance);
    }

    public List<Employees> getEmployeesBySeminar(Seminar seminar) {
        List<EmployeeSeminar> attendance = employeeSeminarRepository.findBySeminar(seminar);
        List<Employees> employees = new ArrayList<>();
        for (EmployeeSeminar employeeSeminar : attendance) {
            // for each employee-seminar relationship, take the employee and add to the list
            employees.add(employeeSeminar.getEmployee());
        }
        return employees;
    }

    public List<EmployeeSeminar> findByEmployeeAndSeminar(Employees employee, Seminar seminar) {
        return employeeSeminarRepository.findByEmployeeAndSeminar(employee, seminar);
    }
}
