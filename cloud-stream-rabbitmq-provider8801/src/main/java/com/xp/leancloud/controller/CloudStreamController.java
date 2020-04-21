package com.xp.leancloud.controller;

import com.xp.leancloud.service.CloudStreamProviderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CloudStreamController {

    @Resource
    private CloudStreamProviderService cloudStreamProviderService;

    @PostMapping("/rabbit/send")
    public void sendMessage(){
        cloudStreamProviderService.send();
    }

}
