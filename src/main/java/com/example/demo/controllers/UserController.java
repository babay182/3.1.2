package com.example.demo.controllers;

import com.example.demo.service.UserDetailsServiceImpl;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
public class UserController {

    private final UserDetailsServiceImpl userServiceDetails;

    @Autowired
    public UserController(UserDetailsServiceImpl userServiceDetails) {
        this.userServiceDetails = userServiceDetails;
    }

    @GetMapping("/user")
    public String userProfile(Principal principal, Model model) {
        model.addAttribute("user", userServiceDetails.loadUserByUsername(principal.getName()));
        return "user";
    }
}
