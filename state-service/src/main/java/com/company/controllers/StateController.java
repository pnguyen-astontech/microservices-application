package com.company.controllers;

import com.company.domains.State;
import com.company.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by petenguy1 on 12/28/2016.
 */
@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<State> findStates() {
        return (List<State>) stateRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    State getById(@PathVariable int id) {
        return stateRepository.findOne(id);
    }
}
