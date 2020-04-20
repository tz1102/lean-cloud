package com.atgg.leancloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 表示 这是服务注册中心
@EnableEurekaServer
public class EurekaMain7001 {


    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class);
    }
}
