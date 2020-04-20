package com.atgg.leancloud.pay.controller;

import com.atgg.leancloud.common.entities.entity.Pay;
import com.atgg.leancloud.common.entities.dto.ResponseDTO;
import com.atgg.leancloud.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @Value("${server.port}")
    private String  port;

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

    @GetMapping("/api/pay/getport")
    public String getPort(){
        return port;
    }
}
