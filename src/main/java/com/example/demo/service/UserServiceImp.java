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
    public void update(long id, User newUser) {
        newUser.setId(id);
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

//    public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
//        return roles.stream().map(e->new SimpleGrantedAuthority(e.getName())).collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userDao.getUserByName(s);
//        if(user == null){
//            throw new UsernameNotFoundException(String.format("User %s not found", s));
//        }
//        return new org.springframework.security.core.userdetails.User(user.getName(),
//                user.getPassword(), getAuthorities(user.getRoles()));
//    }
}
