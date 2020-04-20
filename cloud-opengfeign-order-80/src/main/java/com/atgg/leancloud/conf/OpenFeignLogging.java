package com.atgg.leancloud.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/******
 *  feign 自带的日志
 */
@Configuration
public class OpenFeignLogging {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
