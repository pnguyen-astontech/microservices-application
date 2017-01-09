package com.company.controllers;

import com.company.domains.User;
import com.company.repositories.UserDetailRepository;
import com.company.repositories.UserRepository;
import com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by petenguy1 on 12/21/2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserDetailRepository userDetailRepository;

    @Autowired
    public UserController (UserService userService, UserDetailRepository userDetailRepository) {
        this.userService = userService;
        this.userDetailRepository = userDetailRepository;
    }

    // SAVE
    @RequestMapping(method = RequestMethod.POST)
    User saveUser (@RequestBody User user) {
        user.setCreate_date(ZonedDateTime.now().toString());
        userDetailRepository.save(user.getUser_detail());
        return userService.saveUser(user);
    }

    // FIND ALL
    @RequestMapping(method = RequestMethod.GET)
    List<User> findUsers (User criteria) {
        return (List<User>) userService.listAllUsers();
    }

    // FIND BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    // DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    Boolean deleteUser (@PathVariable long id) {
        boolean result = false;
        try {
            userService.deleteUser(id);
            result = true;
        } catch (Exception ex) {
            // LOG ERROR
        }
        return result;
    }
//
//    @RequestMapping(value = "{user}", method = RequestMethod.GET)
//    User userDetails (@PathVariable User user) {
//        if (user == null) {
//            throw new UserNotFoundException();
//        }
//        return user;
//    }
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    static class UserNotFoundException extends RuntimeException{}

}
