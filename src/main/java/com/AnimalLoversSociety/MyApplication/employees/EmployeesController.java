package com.AnimalLoversSociety.MyApplication.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("/employees")
    public String showAllEmployees(Model model) {
        Iterable<Employees> employees = employeesRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/employees/filter")
    public String filterEmployees(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String project,
            Model model) {
        Iterable<Employees> employees;
        if (department != null && !department.isEmpty() && project != null && !project.isEmpty()) {
            employees = employeesRepository.findByDepartmentAndProject(department, project);
        } else if (department != null && !department.isEmpty()) {
            employees = employeesRepository.findByDepartment(department);
        } else if (project != null && !project.isEmpty()) {
            employees = employeesRepository.findByProject(project);
        } else {
            employees = employeesRepository.findAll();
        }
        model.addAttribute("employees", employees);
        return "employees";
    }
}