package com.example.demo.service;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private RoleRepository roleDao;

    @Override
    public User show(long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> index() {
        return userDao.findAll();
    }

    @Override
    public void delete(long id) {
        userDao.deleteById(id);
    }

    @Override
    public void update(User newUser) {

        userDao.save(newUser);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role getRole(long id) {
        return roleDao.findById(id).get();
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public Role findByName(String name){
        return roleDao.findByName(name);
    }

    @Override
    public User findById(long id) {
        return userDao.getById(id);
    }
}
