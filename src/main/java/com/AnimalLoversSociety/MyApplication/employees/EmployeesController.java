package com.AnimalLoversSociety.MyApplication.employees;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.util.Optional;

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
    public String addEmployee(@ModelAttribute("employee") Employees employee, Model model) {
        Optional<Employees> existingEmployeeOptional = employeesRepository.findByEmployeeID(employee.getEmployeeID());
        if (existingEmployeeOptional.isPresent()) {
            Employees existingEmployee = existingEmployeeOptional.get();
            if (existingEmployee.getEmployeeName().equals(employee.getEmployeeName())) {
                employeesRepository.save(employee);
                return "redirect:/employees";
            } else {
                model.addAttribute("error", "Employee ID already exists with a different name.");
                return "employees_add";
            }
        } else {
            employeesRepository.save(employee);
            return "redirect:/employees";
        }
    }

    //Modify employees
    @GetMapping("/employees/modify")
    public String showModifyMode(Model model) {
        Iterable<Employees> employees = employeesRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("modifyMode", true);
        return "employees_modifypage";
    }

    @GetMapping("/employees/modify/{employeeData}")
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

    //private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

    @GetMapping("/employees/delete")
    public String showDeleteMode(Model model) {
        Iterable<Employees> employees = employeesRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("deleteMode", true);
        return "employees_deletepage";
    }

    @GetMapping("/employees/delete/{employeeData}")
    public String showDeleteEmployeeDataForm(@PathVariable("employeeData") int employeeData, Model model) {
        Employees employee = employeesRepository.findById(employeeData)
            .orElseThrow(() -> new IllegalArgumentException("Invalid employee Data: " + employeeData));
        model.addAttribute("employee", employee);
        return "employees_delete";  
    }

    @PostMapping("/employees/delete/{employeeData}")
    public String deleteEmployeeData(@PathVariable("employeeData") int employeeData) {
        employeesRepository.deleteById(employeeData);
        return "redirect:/employees";
    }
}