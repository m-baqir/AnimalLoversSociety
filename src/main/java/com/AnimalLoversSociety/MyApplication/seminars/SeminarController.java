package com.AnimalLoversSociety.MyApplication.seminars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SeminarController {

    private final SeminarService seminarService;

    @Autowired
    public SeminarController(SeminarService seminarService) {
        this.seminarService = seminarService;
    }

    // Handler method to handle list of seminars and return view
    @GetMapping("/seminars")
    public String getSeminars(Model model) {
        model.addAttribute("seminars", seminarService.getSeminars());
        return "seminars";
    }

    @GetMapping("/seminars/add")
    public String showAddSeminarForm(Model model) {
        Seminar seminar = new Seminar(); // Create seminar object to hold form data
        model.addAttribute("seminar", seminar);
        return "seminars_create";
    }

    @PostMapping("/seminars")
    public String saveSeminar(@ModelAttribute("seminar") Seminar seminar) {
        seminarService.saveSeminar(seminar);
        return "redirect:/seminars";
    }

    @GetMapping("/seminars/manage")
    public String showManageSeminarsView(Model model) {
        model.addAttribute("seminars", seminarService.getSeminars());
        return "seminars_manage";
    }

    @GetMapping("/seminars/edit/{seminarId}")
    public String showEditSeminarForm(@PathVariable Integer seminarId, Model model) {
        model.addAttribute("seminar", seminarService.getSeminarById(seminarId));
        return "seminars_edit";
    }

    @PostMapping("/seminars/edit/{seminarId}")
    public String editSeminar(@PathVariable Integer seminarId, @ModelAttribute("seminar") Seminar seminar, Model model) {
        // Get seminar from database by id
        Seminar existingSeminar = seminarService.getSeminarById(seminarId);

        // Update the info
        existingSeminar.setSeminarId(seminarId);
        existingSeminar.setTitle(seminar.getTitle());
        existingSeminar.setDate(seminar.getDate());
        existingSeminar.setTime(seminar.getTime());
        existingSeminar.setLocation(seminar.getLocation());
        existingSeminar.setCapacity(seminar.getCapacity());

        // Save updated seminar object
        seminarService.saveSeminar(existingSeminar);
        return "redirect:/seminars/manage";
    }

    // Handler method to handle delete seminar request
    @GetMapping("/seminars/{seminarId}")
    public String deleteSeminar(@PathVariable Integer seminarId) {
        seminarService.deleteSeminarById(seminarId);
        return "redirect:/seminars/manage";
    }

    @GetMapping("/seminars/register/{seminarId}")
    public String showRegisterForm(@PathVariable Integer seminarId, Model model) {
        model.addAttribute("seminar", seminarService.getSeminarById(seminarId));
        return "seminars_register";
    }

    @PostMapping("/seminars/register/{seminarId}")
    public String processRegistration(@PathVariable Integer seminarId, @ModelAttribute("seminar") Seminar seminar, Model model) {
        Seminar seminarForRegistration = seminarService.getSeminarById(seminarId);
        seminarService.incrementEnrollment(seminarForRegistration);
        seminarService.saveSeminar(seminarForRegistration);
        return "redirect:/seminars";
    }

}
