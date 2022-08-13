package com.saturne.redwire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedWireBackendApplication {

    private static final Logger logger = LoggerFactory.getLogger(RedWireBackendApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RedWireBackendApplication.class, args);
        logger.info("Application Launched on port :8080");
    }
}
