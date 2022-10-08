package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) {
        log.info("===> springApplication start success, time:{}, args:{}", LocalDateTime.now(), args);
    }
}
