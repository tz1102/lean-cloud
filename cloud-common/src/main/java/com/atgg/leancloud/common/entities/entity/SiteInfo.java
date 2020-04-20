package com.atgg.leancloud.common.entities.entity;

import lombok.Data;

@Data
public class SiteInfo  {

    // 序号
    private String site_id;

    // 点位名称
    private String site_name;

    //取水地址
    private String site_address;

    //高锰酸盐
    private String permanganate_value;

    //氨氮
    private String an_value;

    //总磷
    private String p_value;

    // 水质等级  几类水
    private String water_levle;

    // 时间
    private String dateTime;

    // 負責人
    private String user_name;

    //河流名稱
    private String river_name;

}
