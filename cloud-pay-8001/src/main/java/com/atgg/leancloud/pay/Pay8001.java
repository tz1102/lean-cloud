package com.atgg.leancloud.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Pay8001 {

    public static void main(String[] args) {
        SpringApplication.run(Pay8001.class);
    }
}
