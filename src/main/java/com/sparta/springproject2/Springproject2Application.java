package com.sparta.springproject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Springproject2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springproject2Application.class, args);
    }

}
