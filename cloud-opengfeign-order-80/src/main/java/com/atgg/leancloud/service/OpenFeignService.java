package com.atgg.leancloud.service;

import com.atgg.leancloud.common.entities.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PAY-SERVICE")
public interface OpenFeignService {

    @GetMapping("/api/getPay/{id}")
    ResponseDTO getPay(@PathVariable("id")Long id);

}
