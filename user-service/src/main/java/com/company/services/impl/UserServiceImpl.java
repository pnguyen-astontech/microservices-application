package com.company.services.impl;

import com.company.domains.User;
import com.company.repositories.UserRepository;
import com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by petenguy1 on 12/27/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveUserList(Iterable<User> userIterable) {
        return userRepository.save(userIterable);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
