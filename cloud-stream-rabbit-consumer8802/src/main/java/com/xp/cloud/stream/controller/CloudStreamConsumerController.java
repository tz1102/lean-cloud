package com.xp.cloud.stream.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class CloudStreamConsumerController {

    @Value("${server.port}")
    public String consumerPort;

    @StreamListener(Sink.INPUT)
    public void input(Message message){
        System.out.println("消费者 接收到的消息=====》"+message.toString()+"\t this port :"+consumerPort);
    }


}
