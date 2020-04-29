package com.javasm.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.javasm.handler")
@ComponentScan(basePackages = "com.javasm.service")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
