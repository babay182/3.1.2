package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class Con {

    private UserService userService;

    @Autowired
    public Con(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void doInit(){
        userService.addRole(new Role("ROLE_ADMIN"));
        userService.addRole(new Role("ROLE_USER"));
        Set<Role> roles = new HashSet<>(userService.getRoles());
        User user = new User("$2a$12$YTKLT6btiBw0USx.s2a8BubFvWzJ8TQy55nIiTWdINJd/sc4hRN7u", "Vasya","Adminov", 22, "Admin");
        for (Role role : roles) {
            user.addRole(role);
        }
        userService.save(user);
    }
}
