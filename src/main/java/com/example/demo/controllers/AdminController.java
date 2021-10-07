package com.example.demo.controllers;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserDetailsServiceImpl;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping
public class AdminController {

    private final UserService userService;
    private final UserDetailsServiceImpl userServiceDetails;

    public AdminController(UserService userService, UserDetailsServiceImpl userServiceDetails) {
        this.userService = userService;
        this.userServiceDetails = userServiceDetails;
    }

    @GetMapping
    public String index(@ModelAttribute("newUser") User user, Model model, Principal principal) {
        model.addAttribute("users", userService.index());
        model.addAttribute("admin", userServiceDetails.loadUserByUsername(principal.getName()));
        model.addAttribute("roles", userService.getRoles());
        return "index";
    }

    @PostMapping("/new")
    public String creat(@ModelAttribute("user") User user
            , @RequestParam(value = "rolesSelected", required = false) String[] roles){
        for (String role : roles) {
            Role i = userService.getRole(Integer.parseInt(role));
            user.addRole(i);
        }
        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(User user, String[] roles){

        for (String role : roles) {
            System.out.println(role);
            Role i = userService.getRole(Integer.parseInt(role));
            user.addRole(i);
        }
        userService.update(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id", required = false) Integer id){
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/oneUser")
    @ResponseBody
    public User oneUser(Integer id){
        return userService.findById(id);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
