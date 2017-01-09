package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by petenguy1 on 1/4/2017.
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigurationServer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServer.class, args);
    }
}
