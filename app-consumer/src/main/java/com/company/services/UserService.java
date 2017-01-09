package com.company.services;

import com.company.domains.UserDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by petenguy1 on 1/6/2017.
 */
@Service
public class UserService {
    private RestTemplate restTemplate;
    private volatile UserDTO[] users = new UserDTO[0];

    @Autowired
    public UserService(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "cachedUsers", threadPoolProperties = @HystrixProperty(name = "coreSize", value = "50"))
    public UserDTO[] allUsers() {
        users = restTemplate.getForObject("http://pn-user-service/users", UserDTO[].class);
        return users;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        System.out.println(userDTO.getUser_detail().getFirst_name());
        return restTemplate.postForObject("http://pn-user-service/users", userDTO, UserDTO.class);
    }

    public UserDTO[] cachedUsers() {
        return users;
    }

    public UserDTO userDetails(String userId) {
        return restTemplate.getForObject("http://pn-user-service/users/{id}", UserDTO.class, userId);
    }
}

