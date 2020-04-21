package com.xp.leancloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamProvicer8801 {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamProvicer8801.class,args);
    }
}
