package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Set;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public Set<User> index() {
        return userDao.index();
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void update(long id, User newUser) {
        userDao.update(id, newUser);
    }

    @Override
    public Set<Role> getRoles() {
        return userDao.getRoles();
    }

    @Override
    public void addRole(Role role) {
        userDao.addRole(role);
    }

    @Override
    public Role getRole(long id) {
        return userDao.getRole(id);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
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
