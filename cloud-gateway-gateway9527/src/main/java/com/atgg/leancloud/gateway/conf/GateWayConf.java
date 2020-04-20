package com.atgg.leancloud.gateway.conf;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConf {

    @Bean
    public RouteLocator myRoutLocator(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("my_rout1",o -> o.path("/myPath").uri("https://tieba.baidu.com/index.html")).build();

        return routes.build();
    }


}
