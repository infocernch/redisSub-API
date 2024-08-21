package org.example.pubsubapi.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisRunner implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(RedisRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Redis Pub/Sub listener is running ...");
        Thread.currentThread().join();
    }
}
