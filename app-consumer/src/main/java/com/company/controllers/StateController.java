package com.company.controllers;

import com.company.domains.State;
import com.company.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by petenguy1 on 12/28/2016.
 */

//TODO: Unfinished controller
@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    @RequestMapping(value = "/states", method = RequestMethod.GET)
    public State[] getAllStates() {
        return stateService.allStates();
    }

    @RequestMapping(value = "/states{stateId}", method = RequestMethod.GET)
    public String getStateById(Model model, @PathVariable String stateId) {
        model.addAttribute("state", stateService.stateDetails(stateId));
        return "state";
    }
}
