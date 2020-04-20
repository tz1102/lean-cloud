package com.atgg.leancloud.controller;

import com.atgg.leancloud.common.entities.dto.ResponseDTO;
import com.atgg.leancloud.service.OpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OpenFeignController {

    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/api/getPay/{id}")
    public ResponseDTO getPay(@PathVariable("id")Long id){
        ResponseDTO responseDTO = openFeignService.getPay(id);
        if(responseDTO!=null){
            return new ResponseDTO(200,"操作成功！",responseDTO);
        }else{
            return new ResponseDTO(500,"操作失败！",null);
        }

    }
}
