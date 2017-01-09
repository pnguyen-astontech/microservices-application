package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by petenguy1 on 1/4/2017.
 */
@SpringBootApplication
@EnableHystrixDashboard
@Controller
public class HystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }

}
