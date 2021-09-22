package com.example.demo.dao;



import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.Set;

public interface UserDao {
    User show(long id);
    void save(User user);
    Set<User> index();
    void delete(long id);
    void update(long id, User newUser);
    public Set<Role> getRoles();
    public void addRole(Role role);
    public Role getRole(long id);
    public User getUserByName(String userName);
}
