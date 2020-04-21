package com.xp.leancloud.service.impl;

import com.xp.leancloud.service.CloudStreamProviderService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


// 客户端 业务类实现注解
@EnableBinding(Source.class)
public class CloudStreamProviderServiceImpl implements CloudStreamProviderService {

    @Resource
    private MessageChannel output;

    @Override
    public void send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("========>>> serial: "+serial);
    }
}
