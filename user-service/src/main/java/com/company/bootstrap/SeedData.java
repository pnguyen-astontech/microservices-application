package com.company.bootstrap;

import com.company.domains.User;
import com.company.domains.UserDetail;
import com.company.enums.Gender;
import com.company.enums.UserType;
import com.company.repositories.UserDetailRepository;
import com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by petenguy1 on 12/27/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private UserDetailRepository userDetailRepository;

    @Autowired
    public SeedData(UserService userService, UserDetailRepository userDetailRepository) {
        this.userService = userService;
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateData();
    }

    public void generateData() {
        UserDetail adminDetails = new UserDetail("Peter",
                                                  "Nguyen",
                                                  LocalDate.of(2001, Month.JANUARY, 01).toString(),
                                                  Gender.MALE);
        userDetailRepository.save(adminDetails);

        User admin = new User("admin",
                              "qwe123$!",
                              "admin@com.company",
                              ZonedDateTime.now().toString(),
                              UserType.ADMIN,
                              adminDetails);
        userService.saveUser(admin);
    }
}
