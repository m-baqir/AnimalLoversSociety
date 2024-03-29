package com.AnimalLoversSociety.MyApplication.projects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectsController {

    @GetMapping("/projects")
    public String showProjectsPage() {
        return "projects";
    }

    @GetMapping("/projects/agoc")
    public String showAgocProjectPage() {
        return "projects_agoc";
    }

    @GetMapping("/projects/dfas")
    public String showDfasProjectPage() {
        return "projects_dfas";
    }

    @GetMapping("/projects/olno")
    public String showOlnoProjectPage() {
        return "projects_olno";
    }
}