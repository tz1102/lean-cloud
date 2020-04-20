package com.atgg.leancloud.pay.dao;

import com.atgg.leancloud.common.entities.entity.Pay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayDao {


    public int create(Pay pay);

    public Pay  getPayById(@Param("id")Long id);
}
