package com.AnimalLoversSociety.MyApplication.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    //Filter employees by department, project
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

    //Add employees
    @GetMapping("/employees/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employees());
        return "employees_add";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employees employee) {
        employeesRepository.save(employee);
        return "redirect:/employees";
    }

    //Modify employees
    @PostMapping("/employees/modify/{employeeData}")
    public String showModifyEmployeeForm(@PathVariable("employeeData") int employeeData, Model model) {
        Employees employee = employeesRepository.findById(employeeData).orElseThrow(() -> new IllegalArgumentException("Invalid employee Data"));
        model.addAttribute("employee", employee);
        return "employees_modify";
    }

    @PostMapping("/employees/modify")
    public String modifyEmployee(@ModelAttribute Employees employee) {
        employeesRepository.save(employee);
        return "redirect:/employees";
    }

    //Delete employees
   /*@PostMapping("/employees/delete")
    public String showDeleteEmployeeForm(Model model) {
    return "employees_delete";
    } */


    @GetMapping("/employees/delete/{employeeData}")
    public String showDeleteEmployeeForm(@PathVariable("employeeData") int employeeData, Model model) {
        Employees employee = employeesRepository.findById(employeeData).orElseThrow(() -> new IllegalArgumentException("Invalid employee Data"));
        model.addAttribute("employee", employee);
        return "employees_delete";
    }


    @PostMapping("/employees/delete/{employeeData}")
    public String deleteEmployee(@PathVariable("employeeData") int employeeData) {
        employeesRepository.deleteById(employeeData);
        return "redirect:/employees";
    }
}