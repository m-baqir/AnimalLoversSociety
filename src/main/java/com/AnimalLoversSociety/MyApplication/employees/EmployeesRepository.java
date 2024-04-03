package com.AnimalLoversSociety.MyApplication.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    //commenting out for now until filter is configured properly
    Iterable<Employees> findByDepartment(String department);
    Iterable<Employees> findByProject(String project);
    Iterable<Employees> findByDepartmentAndProject(String department, String project);
    Optional<Employees> findByEmployeeID(int employeeID);
    Optional<Employees> findByEmployeeName(String employeeName);

    Optional <Employees> findById(int employeeData);
    boolean existsByEmployeeID(int employeeID);

    Employees getEmployeesByEmployeeID(int employeeID); // Return a single employee
}