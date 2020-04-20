package com.atgg.leancloud.pay.service;

import com.atgg.leancloud.common.entities.entity.Pay;
import org.apache.ibatis.annotations.Param;

public interface PayService {

    public int create(Pay pay);

    public Pay  getPayById(@Param("id")Long id);
}
