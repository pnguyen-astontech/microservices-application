package com.company.services;

import com.company.domains.State;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by petenguy1 on 12/27/2016.
 */
@Service
public class StateService {

    private RestTemplate restTemplate;
    private volatile State[] states = new State[0];

    @Autowired
    public StateService(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "cachedStates", threadPoolProperties = @HystrixProperty(name = "coreSize", value = "50"))
    public State[] allStates() {
        states = restTemplate.getForObject("http://pn-state-service/states", State[].class);
        return states;
    }

    public State[] cachedStates() {
        return states;
    }

    public State stateDetails(String stateId) {
        return restTemplate.getForObject("http://pn-state-service/states/{id}", State.class, stateId);
    }
}
