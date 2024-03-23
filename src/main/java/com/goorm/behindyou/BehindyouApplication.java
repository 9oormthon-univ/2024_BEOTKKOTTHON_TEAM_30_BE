package com.goorm.behindyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BehindyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(BehindyouApplication.class, args);
    }
}
