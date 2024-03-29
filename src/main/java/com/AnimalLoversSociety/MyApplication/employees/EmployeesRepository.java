package com.AnimalLoversSociety.MyApplication.employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    //commenting out for now until filter is configured properly
    Iterable<Employees> findByDepartment(String department);
    Iterable<Employees> findByProject(String project);
    Iterable<Employees> findByDepartmentAndProject(String department, String project);
}