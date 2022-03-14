package com.pfm.halterocms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication(scanBasePackages = "com.pfm.halterocms")
public class HalteroCMSApplication {

    public static void main(String... args) {
        SpringApplication.run(HalteroCMSApplication.class, args);
    }
}