package com.company.services;

import com.company.domains.User;

import java.util.Iterator;

/**
 * Created by petenguy1 on 12/27/2016.
 */
public interface UserService {

    Iterable<User> listAllUsers();

    User getUserById(Long id);

    User saveUser(User user);

    Iterable<User> saveUserList(Iterable<User> userIterable);

    void deleteUser(Long id);
}
