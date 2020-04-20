package com.atgg.leancloud.pay.controller;

import com.atgg.leancloud.common.entities.entity.Pay;
import com.atgg.leancloud.common.entities.dto.ResponseDTO;
import com.atgg.leancloud.pay.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PayController {

    @Autowired
    private PayService payService;

    @Value("${server.port}")
    private String  port;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/api/crate")
    public ResponseDTO create(@RequestBody Pay pay){
        int i= payService.create(pay);
        if(i>0){
            return new ResponseDTO(200,"操作成功！"+port,i);
        }else{
            return new ResponseDTO(500,"操作失败！",i);
        }

    }

    @GetMapping("/api/getPay/{id}")
    public ResponseDTO getPay(@PathVariable("id")Long id){
        Pay pay = payService.getPayById(id);
        if(pay!=null){
            return new ResponseDTO(200,"操作成功！"+port,pay);
        }else{
            return new ResponseDTO(500,"操作失败！");
        }

    }

    @GetMapping("/api/pay/getPayInfo")
    public Object getPayInfo(){
        // 获取扩展服务
        List<String> services = discoveryClient.getServices();
        for(String o:services){
            log.info("=== service ==="+o+"\n");
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAY-SERVICE");
        for(ServiceInstance instance:instances){
            log.info("==== instance ===="+instance.getHost()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }
    @GetMapping("/api/pay/getport")
    public String getPort(){
        return port;
    }
}
