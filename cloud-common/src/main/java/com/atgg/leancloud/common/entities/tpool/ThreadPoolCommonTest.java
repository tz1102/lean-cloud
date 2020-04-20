package com.atgg.leancloud.common.entities.tpool;

import cn.hutool.core.date.DateUtil;
import com.atgg.leancloud.common.entities.tpool.service.TestService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ThreadPoolCommonTest {

    // 注入线程池
//    @Resource(name = "appServiceExeCutor")
//    private Executor executor;

    @Resource(name="appServiceExeCutor")
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource(name="testServiceImpl1")
    private TestService testService;

    @Resource(name="testServiceImpl2")
    private TestService testService2;

    @Resource(name="testServiceImpl3")
    private TestService testService3;

    @Resource(name="testServiceImpl4")
    private TestService testService4;


   /* @GetMapping("/testCommon")
    public String testCommon() {
        StringBuffer buffer = new StringBuffer();
        // 使用线程池
        executor.execute(()-> buffer.append(" 线程:\t"+ Thread.currentThread().getName()+" 已执行"));
        executor.execute(()-> buffer.append(" 线程:\t"+ Thread.currentThread().getName()+" 已执行"));
        executor.execute(()-> buffer.append(" 线程:\t"+ Thread.currentThread().getName()+" 已执行"));
        executor.execute(new TestRunThreadCommon());

        return buffer.toString();
    }*/


    /*******
     *  用多线程到底可以在工程中帮我们干嘛，以下两个例子对比
     * @return
     */
    @GetMapping("/testSveTime")
    public List<String>  testSaveTime(){
        Date startDate = new Date();
        ArrayList<Future<String>> futures = Lists.newArrayList(testService.test(), testService2.test(), testService3.test(), testService4.test());
        List<String> list = futures.stream().map(o -> {
            try {
                return o.get();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        Date endDate = new Date();
        log.info(String.valueOf("执行时间为：\t"+DateUtil.betweenMs(startDate,endDate))+"\t ms");
        return list;
    }

    /*****
     *  将以上方法 初步优化
     *   使用
     * @return
     */
    @GetMapping("/testSveTime/update1")
    public List<String>  testSaveTimeUp1(){
        Date startDate = new Date();
        Future<String> future1 =  taskExecutor.submit(this::test1);
        Future<String> future2 =  taskExecutor.submit(this::test2);
        Future<String> future3 =  taskExecutor.submit(this::test3);
        Future<String> future4 =  taskExecutor.submit(this::test4);
        ArrayList<Future<String>> futures = Lists.newArrayList(future1, future2, future3, future4);
        List<String> list = futures.stream().map(o -> {
            try {
                return o.get();
            }catch (Exception e){
                return null;
            }
        }).collect(Collectors.toList());
        Date endDate = new Date();
        log.info(String.valueOf("执行时间为：\t"+DateUtil.betweenMs(startDate,endDate))+"\t ms");
        return list;
    }


    /*****
     *  将以上方法 初步优化
     *   使用
     * @return
     */
    @GetMapping("/testSveTime/update2")
    public List<String>  update2(){
        Date startDate = new Date();
        List<CompletableFuture<String>> futures = Lists.newArrayList(
                CompletableFuture.supplyAsync(this::test1,taskExecutor),
                CompletableFuture.supplyAsync(this::test2,taskExecutor),
                CompletableFuture.supplyAsync(this::test3,taskExecutor),
                CompletableFuture.supplyAsync(this::test4,taskExecutor));
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[4])
        );
        CompletableFuture<List<String>>  listFuture  =  allFutures.thenApplyAsync(
                value -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()),taskExecutor
        );
        List<String>  list = listFuture.join();
        return list;
    }

    private String test1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "test1";
    }
    private String test2(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "test2";
    }
    private String test3(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "test3";
    }
    private String test4(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "test4";
    }




}
