package com.example.qcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class QcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QcDemoApplication.class, args);
    }

}
