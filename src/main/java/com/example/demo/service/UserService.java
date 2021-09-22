package com.example.demo.service;



import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.Set;

public interface UserService {
    User show(long id);
    void save(User user);
    Set<User> index();
    void delete(long id);
    void update(long id, User newUser);
    Set<Role> getRoles();
    void addRole(Role role);
    Role getRole(long id);
    public User getUserByName(String userName);
}
