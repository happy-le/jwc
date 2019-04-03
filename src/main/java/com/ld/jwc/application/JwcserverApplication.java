package com.ld.jwc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author miaoguangqiang on 2019-04-03
 * @version 1.0
 */
@SpringBootApplication
@EnableScheduling
public class JwcserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwcserverApplication.class, args);
    }
}
