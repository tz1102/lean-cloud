package com.atgg.leancloud.common.entities.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.atgg.leancloud.common.entities.entity.SiteInfo;

import java.util.ArrayList;
import java.util.List;

public class Test2Excle {


    public static void main(String[] args) {

        /****
         * 获取excle 中第三个sheet 页数据
         */
        ExcelReader excelReader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\Administrator\\Desktop\\czData\\重建河长制数据整理版.xlsx"), 2);
        List<List<Object>> readList = excelReader.read();
        List<SiteInfo> siteInfos = new ArrayList<>();
        List<Object> titileList = readList.get(0);

        int allLineCount = 0;
        int cellsCount = 0;
        // 遍历总行
        for (allLineCount = 1; allLineCount < readList.size(); allLineCount++) {
            List<Object> readCells = readList.get(allLineCount);
            // 遍历当前行的每列
            for (cellsCount = 0; cellsCount < readCells.size(); cellsCount++) {
                // 监测指标
                if (cellsCount > 4) {
                    SiteInfo childSiteInfo = new SiteInfo();
                    // 負責人
                    childSiteInfo.setUser_name(String.valueOf(readCells.get(0)));
                    // 河流名稱
                    childSiteInfo.setRiver_name(String.valueOf(readCells.get(1)));
                    // 序号
                    childSiteInfo.setSite_id(String.valueOf(readCells.get(2)));
                    // 点位名称
                    childSiteInfo.setSite_name(String.valueOf(readCells.get(3)));
                    // 取水地址
                    childSiteInfo.setSite_address(String.valueOf(readCells.get(4)));

                    // 高猛酸盐
                    String  gmsy = "0.00";
                    try {
                        gmsy = String.valueOf(Double.parseDouble(String.valueOf(readCells.get(cellsCount))));
                    } catch (Exception e) {

                    }
                    childSiteInfo.setPermanganate_value(gmsy);
                    // 氨氮
                    // 获取下一行
                    if (allLineCount < (readList.size() - 1)) {
                        List<Object> childCells = readList.get(allLineCount + 1);

                        String ad = "0.00";
                        try {
                            ad = String.valueOf(Double.parseDouble(String.valueOf(childCells.get(cellsCount))));
                        } catch (Exception e) {

                        }
                        childSiteInfo.setAn_value(ad);
                    }

                    //总磷 在下两行的这一列
                    if (allLineCount < (readList.size() - 2)) {
                        List<Object> childCells = readList.get(allLineCount + 2);

                        String zl = "0.00";
                        try {
                            zl = String.valueOf(Double.parseDouble(String.valueOf(childCells.get(cellsCount))));
                        } catch (Exception e) {

                        }
                        childSiteInfo.setP_value(zl);
                    }
                    // 水质等级
                    if (cellsCount != readCells.size()) {
                        childSiteInfo.setWater_levle(String.valueOf(readCells.get(cellsCount + 1)));
                    }
                    // 时间
                    childSiteInfo.setDateTime(String.valueOf(titileList.get(cellsCount)));
                    siteInfos.add(childSiteInfo);
                    cellsCount++;
                }
                //
                if (cellsCount == readCells.size() - 1) allLineCount= allLineCount+2;
            }

        }

        System.out.println(JSONUtil.parseArray(siteInfos));
        // 寫入excle 文件  C:\Users\Administrator\Desktop\czData
        ExcelWriter writer = ExcelUtil.getWriter("C:\\Users\\Administrator\\Desktop\\czData\\河长制java写出.xlsx");
        writer.write(siteInfos,true);
        writer.close();

    }
}

