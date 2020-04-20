package com.atgg.leancloud.common.entities.tcommon;

import java.util.Date;

/******
 *  基础线程类  处理方法
 *
 *  2.改造，实现卖票窗口买票功能，一共100张票
 *
 */
public class ThreadCommon implements Runnable {

    // 第一种实现 多个窗口卖票 解决余票数重复问题 （同步票数）  变量类型设置为static
//    private  static int tNum = 100;

    private  int tNum = 100;


//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName()+" : "+threadNum);
//    }

    @Override
    public void run() {
        while (true){
            /*****
             *  1.第二种解决 票数重复读取的问题 ，加锁 这里是加的对象锁 对象为 字符串""
             *  2.双重判断，提高线程运行效率，保证数据不会出现负数 错误数据
             */
            Long startDate = new Date().getTime();
            if(tNum>0){
            synchronized (""){
                if(tNum>0){
                    try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
                    tNum--;
                    System.out.println("当前窗口为："+Thread.currentThread().getName()+"\t 当前余票为：\t"+ tNum);
                    if(tNum==0){
                        Long endDate = new Date().getTime();
                        System.out.println("总共用时为：\t"+ String.valueOf(endDate.longValue()-startDate.longValue())+"\t ms");
                    }
                }
            }
            }
        } // 第一种耗时	3542	 ms  第二种耗时  500	 ms
    }
}
