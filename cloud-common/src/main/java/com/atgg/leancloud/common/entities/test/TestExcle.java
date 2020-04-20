package com.atgg.leancloud.common.entities.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.atgg.leancloud.common.entities.entity.SiteInfo;

import java.util.*;

public class TestExcle {


    public static void main(String[] args) {

        /****
         * 获取excle 中第二个sheet 页数据
         */
        ExcelReader  excelReader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\Administrator\\Desktop\\czData\\重建河长制数据程序测试版本.xlsx"),1);
        List<List<Object>> readList = excelReader.read();
        List<SiteInfo>  siteInfos = new ArrayList<>();
        List<Object> titileList = readList.get(0);

        int allLineCount = 0;
        int fatherCellsCount = 0 ;
        int nextCell = 0;
        // 遍历总行
        for (allLineCount = 1; allLineCount < readList.size(); allLineCount++) {
            SiteInfo fatherSiteInfo = new SiteInfo();
            List<Object>  readCells = readList.get(allLineCount);
            // 遍历当前行的每列
            for (fatherCellsCount=0; fatherCellsCount < readCells.size(); fatherCellsCount++) {
                // 序号
                if(fatherCellsCount==0) fatherSiteInfo.setSite_id(String.valueOf(readCells.get(fatherCellsCount)));
                // 点位名称
                if(fatherCellsCount==1) fatherSiteInfo.setSite_name(String.valueOf(readCells.get(fatherCellsCount)));
                // 取水地址
                if(fatherCellsCount==2) fatherSiteInfo.setSite_address(String.valueOf(readCells.get(fatherCellsCount)));
                    // 监测指标
                    if(fatherCellsCount>2){
                        // 高锰酸盐
                        fatherSiteInfo.setPermanganate_value(String.valueOf(readCells.get(fatherCellsCount)));
                        //氨氮 在下一行的 这一列
                        // 获取下一行
                        if(allLineCount<(readList.size()-1)){
                            List<Object>  nextCellList = readList.get(allLineCount+1);
                            fatherSiteInfo.setAn_value(String.valueOf(nextCellList.get(fatherCellsCount)));
                        }
                        //总磷 在下两行的这一列
                        if(allLineCount<(readList.size()-2)){
                            List<Object>  nextCellList = readList.get(allLineCount+2);
                            fatherSiteInfo.setP_value(String.valueOf(nextCellList.get(fatherCellsCount)));
                        }
                        // 水质等级
                        if(fatherCellsCount!=readCells.size()){
                            fatherSiteInfo.setWater_levle(String.valueOf(readCells.get(fatherCellsCount+1)));
                        }
                        // 时间
                        fatherSiteInfo.setDateTime(String.valueOf(titileList.get(fatherCellsCount-1)));
//                        siteInfos.add(fatherSiteInfo);

                        // 开始循环这列后面的数据

                        for (nextCell = fatherCellsCount; nextCell < readCells.size();nextCell++) {

                            SiteInfo childSiteInfo = new SiteInfo();
                            childSiteInfo.setSite_id(fatherSiteInfo.getSite_id());
                            childSiteInfo.setSite_name(fatherSiteInfo.getSite_name());
                            childSiteInfo.setSite_address(fatherSiteInfo.getSite_address());

                            // 高猛酸盐
                            childSiteInfo.setPermanganate_value(String.valueOf(readCells.get(nextCell)));
                            // 总磷
                            // 获取下一行
                            if(allLineCount<(readList.size()-1)){
                                List<Object>  childCells = readList.get(allLineCount+1);
                                childSiteInfo.setAn_value(String.valueOf(childCells.get(nextCell)));
                            }

                            //总磷 在下两行的这一列
                            if(allLineCount<(readList.size()-2)){
                                List<Object>  childCells = readList.get(allLineCount+2);
                                childSiteInfo.setP_value(String.valueOf(childCells.get(nextCell)));
                            }
                            // 水质等级
                            if(nextCell!=readCells.size()){
                                childSiteInfo.setWater_levle(String.valueOf(readCells.get(nextCell+1)));
                            }
                            // 时间
                            childSiteInfo.setDateTime(String.valueOf(titileList.get(nextCell)));
                            nextCell++;
                            siteInfos.add(childSiteInfo);

                        }
                        allLineCount++;
                        break;
                    }
            }

        }

        System.out.println(JSONUtil.parseArray(siteInfos));



    }
}

class mailTest{
    public static void main(String[] args) {
        System.out.println(4%2);

    }
}
