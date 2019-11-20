package com.study.managersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication

public class ManagerSystem01Application {

    public static void main(String[] args) {
        SpringApplication.run(ManagerSystem01Application.class, args);
    }

}
