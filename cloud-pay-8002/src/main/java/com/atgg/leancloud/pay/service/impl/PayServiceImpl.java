package com.atgg.leancloud.pay.service.impl;

import com.atgg.leancloud.common.entities.entity.Pay;
import com.atgg.leancloud.pay.dao.PayDao;
import com.atgg.leancloud.pay.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayDao payDao;


    public int create(Pay pay) {
        return payDao.create(pay);
    }

    public Pay getPayById(Long id) {
        return payDao.getPayById(id);
    }
}
