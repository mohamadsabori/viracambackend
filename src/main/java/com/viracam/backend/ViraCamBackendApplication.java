package com.viracam.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Mohammad on 1/8/2018.
 */
@SpringBootApplication
public class ViraCamBackendApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ViraCamBackendApplication.class, args);
    }
}
