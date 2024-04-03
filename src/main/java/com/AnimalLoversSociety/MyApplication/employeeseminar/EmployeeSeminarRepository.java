package com.AnimalLoversSociety.MyApplication.employeeseminar;

import com.AnimalLoversSociety.MyApplication.employees.Employees;
import com.AnimalLoversSociety.MyApplication.seminars.Seminar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSeminarRepository extends JpaRepository<EmployeeSeminar, Integer> {
    @Query
    public List<EmployeeSeminar> findBySeminar(Seminar seminar); // Returns list of employee-seminar entries for a specific seminar

    @Query
    public List<EmployeeSeminar> findByEmployeeAndSeminar(Employees employee, Seminar seminar);
}
