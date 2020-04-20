package com.atgg.leancloud.order.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemConf {

    @Bean
    @LoadBalanced  // 开启负载均衡，否则在无法识别服务集群 地址
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
