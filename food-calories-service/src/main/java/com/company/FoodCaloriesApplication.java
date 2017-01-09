package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by petenguy1 on 12/29/2016.
 */
@SpringBootApplication
@EnableEurekaClient
public class FoodCaloriesApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodCaloriesApplication.class, args);
    }
}
