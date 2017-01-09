package com.company.bootstrap;

import com.company.domains.State;
import com.company.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by petenguy1 on 12/27/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${states.csv.path}")
    private String csvPath;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateData();
    }

    public void generateData() {
        BufferedReader br = null;
        String line = "";
        String deliminator = ",";

        try {
            br = new BufferedReader(new FileReader(csvPath));

            while ((line = br.readLine()) != null) {
                String[] state = line.split(deliminator);
                stateRepository.save(new State(state[0].replaceAll("[^a-zA-Z]", ""), state[1].replaceAll("[^a-zA-Z]", "")));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
