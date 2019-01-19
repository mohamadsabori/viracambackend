package com.viracam.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.apache.log4j.Logger;

/**
 * Created by Mohammad on 1/8/2018.
 */
@SpringBootApplication
public class ViraCamBackendApplication {
   static Logger log = Logger.getLogger(ViraCamBackendApplication.class.getName());

    public static void main(String[] args) {
        log.info("Try for starting application");
        ConfigurableApplicationContext ctx = SpringApplication.run(ViraCamBackendApplication.class, args);
    }
}
