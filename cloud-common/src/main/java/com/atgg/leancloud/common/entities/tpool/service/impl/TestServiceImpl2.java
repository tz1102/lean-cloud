package com.atgg.leancloud.common.entities.tpool.service.impl;

import com.atgg.leancloud.common.entities.tpool.service.TestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class TestServiceImpl2 implements TestService {

    @Async("appServiceExeCutor")
    @Override
    public Future<String> test() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(String.format("Test2"));
    }
}
