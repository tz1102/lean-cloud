package com.atgg.leancloud.order.controller;

import com.atgg.leancloud.common.entities.entity.Pay;
import com.atgg.leancloud.common.entities.dto.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    /****
     * 改成用服务名代替地址
     */
    //    public static final String PAY_URL="http://localhost:8001";
    public static final String PAY_URL="http://CLOUD-PAY-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/api/getPay/{id}")
    public ResponseDTO create(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAY_URL+"/api/getPay/"+id,ResponseDTO.class);
    }

    @GetMapping("/consumer/api/crate")
    public ResponseDTO create(Pay pay){
        return restTemplate.postForObject(PAY_URL+"/api/crate",pay,ResponseDTO.class);
    }
}
