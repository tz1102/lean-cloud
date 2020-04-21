package com.xp.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProvider9001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProvider9001.class);
    }
}
