package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/user")
    public String userProfile(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "admin/show";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
