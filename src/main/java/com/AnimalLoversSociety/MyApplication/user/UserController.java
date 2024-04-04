package com.AnimalLoversSociety.MyApplication.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "/index";
    }

    @GetMapping("/user_register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "user_register";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        user.setUsername(user.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "users"; // return the name of the view
    }

    @GetMapping("/users/{username}")
    public String userDetails(@PathVariable("username") String username, Model model) {
        model.addAttribute("users", userRepo.findAll());
        List<String> roles = userRepo.getRoleNamesByUsername(username);
        model.addAttribute("roles", roles);
        return "user_roles"; // return the name of the view
    }
}
