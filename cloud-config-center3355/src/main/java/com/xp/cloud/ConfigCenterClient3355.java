package com.xp.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
@EnableEurekaClient
@RequestScope// 添加这个的原因是为了自动刷新 不用每次修改了配置文件都需要重启
public class ConfigCenterClient3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterClient3355.class,args);
    }
}
