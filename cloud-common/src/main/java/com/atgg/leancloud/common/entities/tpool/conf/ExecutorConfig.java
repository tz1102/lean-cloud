package com.atgg.leancloud.common.entities.tpool.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/*****
 * springboot 中实现线程池
 * 定义一个全局Bean，加上  @EnableAsync
 *  使用线程池，直接注入
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    private final static String THREAD_NAME_PREFIX="app-async-service-";


    @Bean(value = "appServiceExeCutor")
    public Executor  appServiceExeCutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 线程核心线程数
        executor.setCorePoolSize(5);
        // 最大线程数
        executor.setMaxPoolSize(5);
        // 线程队列大小
        executor.setQueueCapacity(9999);
        // 线程存货时间
        executor.setKeepAliveSeconds(2);

        // 配置线程池中的线程名称前缀
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        // 当线程池满了，采用由当前调用者所在的线程处理任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化线程池
        executor.initialize();

        return executor;
    }


























}
