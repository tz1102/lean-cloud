package com.atgg.leancloud.common.entities.tcommon;

public class ThreadCommonTest {


    public static void main(String[] args) {

        ThreadCommon threadCommon = new ThreadCommon();
        Thread common = new Thread(threadCommon);
        Thread common2 = new Thread(threadCommon);
        common.start();
        common2.start();
    }


}
