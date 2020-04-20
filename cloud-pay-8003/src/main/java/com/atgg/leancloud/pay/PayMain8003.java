package com.atgg.leancloud.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//该注解用于使用 consul 或者 zookeeper 作为注册中心时注册服务
@EnableDiscoveryClient
public class PayMain8003 {

    public static void main(String[] args) {
        SpringApplication.run(PayMain8003.class);
    }
}
