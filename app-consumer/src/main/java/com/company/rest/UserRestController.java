package com.company.rest;
import com.company.domains.UserDTO;
import com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by petenguy1 on 1/6/2017.
 */
//TODO: Add put, delete, get by id
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public UserDTO[] getAllUsers() {
        return userService.allUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
}
