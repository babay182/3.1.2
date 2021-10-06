package com.example.demo.controllers;

import com.example.demo.model.Role;
import com.example.demo.model.User;
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

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Principal principal, @RequestParam(value = "id", required = false) String idStr, Model model) {
        model.addAttribute("admin", userService.findByName(principal.getName()));
        List<Role> roles = userService.getRoles();
        model.addAttribute("roles", roles);
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        if (idStr == null) {
            model.addAttribute("users", userService.index());
            return "index";
        } else {
            int id = Integer.parseInt(idStr);
            model.addAttribute("user", userService.show(id));
            return "user";
        }
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

    @GetMapping("/user")
    public String userProfile(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
