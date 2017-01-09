package com.company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by petenguy1 on 1/5/2017.
 */
@Controller
public class UserController {

    // For angular HTML5 url refresh issue
    @RequestMapping(value = {
            "/users",
            "/states",
            "/signup"
    })
    public String usersHome() {
        return "forward:/index.html";
    }
}
