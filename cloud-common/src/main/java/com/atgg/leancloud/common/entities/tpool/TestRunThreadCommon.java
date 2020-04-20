package com.atgg.leancloud.common.entities.tpool;

import java.time.ZonedDateTime;

public class TestRunThreadCommon implements Runnable {
    @Override
    public void run() {
        System.out.println("当前时间为："+ ZonedDateTime.now());
    }
}
