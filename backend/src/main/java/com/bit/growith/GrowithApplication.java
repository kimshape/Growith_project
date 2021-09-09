package com.bit.growith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GrowithApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrowithApplication.class, args);
    }

}
