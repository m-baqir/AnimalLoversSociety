package com.AnimalLoversSociety.MyApplication.employeeseminar;

import com.AnimalLoversSociety.MyApplication.employees.Employees;
import com.AnimalLoversSociety.MyApplication.employees.EmployeesRepository;
import com.AnimalLoversSociety.MyApplication.seminars.Seminar;
import com.AnimalLoversSociety.MyApplication.seminars.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeSeminarController {
    private final EmployeeSeminarService employeeSeminarService;
    private final SeminarService seminarService;
    private final EmployeesRepository employeesRepository; // is this the same as the other?

    @Autowired
    public EmployeeSeminarController(EmployeeSeminarService employeeSeminarService, SeminarService seminarService, EmployeesRepository employeesRepository) {
        this.employeeSeminarService = employeeSeminarService;
        this.seminarService = seminarService;
        this.employeesRepository = employeesRepository;
    }

    @GetMapping("/seminars/attendance/{seminarId}")
    public String showSeminarAttendance(@PathVariable Integer seminarId, Model model) {
        Seminar seminar = seminarService.getSeminarById(seminarId);
        model.addAttribute("seminar", seminar);
        model.addAttribute("employees", employeeSeminarService.getEmployeesBySeminar(seminar));
        return "seminars_attendance";
    }

//    @PostMapping("/seminars/register/{seminarId}")
//    public String processRegistration(@PathVariable Integer seminarId, @ModelAttribute("seminar") Seminar seminar, Model model) {
//        Seminar seminarForRegistration = seminarService.getSeminarById(seminarId);
//        seminarService.incrementEnrollment(seminarForRegistration);
//        seminarService.saveSeminar(seminarForRegistration);
//        return "redirect:/seminars";
//    }

    @PostMapping("/seminars/register/{seminarId}")
    public String processRegistration(@PathVariable Integer seminarId,
                                      @ModelAttribute("employee") Employees employee,
                                      Model model,
                                      RedirectAttributes redirectAttributes) {
        // Check if employee ID exists
        if (!employeesRepository.findByEmployeeID(employee.getEmployeeID()).isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Employee ID does not exist");
            return "redirect:/seminars/register/{seminarId}";
        }



//        // Check if employee is already registered for this seminar
//        if (!(employeeSeminarService.findByEmployeeAndSeminar(employeeRegistering, seminarForRegistration)).isEmpty()) {
//            System.out.print("test");
//            redirectAttributes.addFlashAttribute("message","Already registered for this seminar");
//            return "redirect:/seminars";
//        }
        else {
            Employees employeeRegistering = employeesRepository.getEmployeesByEmployeeID(employee.getEmployeeID());
            Seminar seminarForRegistration = seminarService.getSeminarById(seminarId);
            seminarService.incrementEnrollment(seminarForRegistration);
            seminarService.saveSeminar(seminarForRegistration);
            employeeSeminarService.saveRegistration(employeeRegistering, seminarForRegistration);
        }
        return "redirect:/seminars";
    }
//    @GetMapping("/suggest-event")
//    public String suggestEvent() {
//        return "/suggested-event/suggestEvent";
//    }

}
