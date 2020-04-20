package com.atgg.leancloud.common.entities.tpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/*****
 *  基本线程池配置大小：
 *  IO密集型任务：2*CPU数，因为IO密集型任务，线程不是一直在运行，所以可以配置多一点；
 *  CPU密集型任务：因为一直在使用CPU，所以要保证线程数不能太多，可以CPU数+1；
 *
 *  CPU密集型 => 线程池的大小推荐为CPU数量 + 1，CPU数量可以根据Runtime.availableProcessors方法获取
 *
 * IO密集型 => CPU数量 * CPU利用率 * (1 + 线程等待时间/线程CPU时间)
 *
 * 混合型 => 将任务分为CPU密集型和IO密集型，然后分别使用不同的线程池去处理，从而使每个线程池可以根据各自的工作负载来调整
 *
 * 阻塞队列 => 推荐使用有界队列，有界队列有助于避免资源耗尽的情况发生
 *
 * 拒绝策略 => 默认采用的是AbortPolicy拒绝策略，直接在程序中抛出RejectedExecutionException异常【因为是运行时异常，不强制catch】，这种处理方式不够优雅。处理拒绝策略有以下几种比较推荐：
 *
 *
 *  问题：handler处理策略都有哪些？
 *
 *  当线程池满了并且队列已经满了，这个时候线程池是无法处理和接收任务的，因此就有处理新进来的任务策略：
 *
 * 1、AbortPolicy：默认的策略，直接拒绝，抛出RejectedExecutionException异常；
 * 2、CallerRunsPolicy：新任务交给任务发起者自己执行；
 * 3、DiscardPolicy：新任务直接抛弃，无任何反应；
 * 4、DiscardOldestPolicy：从队列里面抛弃head的一个任务，并再次执行此任务；
 * 5、自定义策略：实现 RejectedExecutionHandler 这个接口类就可以了。
 *
 *
 * ThreadPoolExecutor 构造参数详解
 *
 * corePoolSize：线程池的基本大小
 * maximumPoolSize：可创建最大线程数
 * keepAliveTime：线程空闲存活时间，时间单位为unit
 * workQueue：用于存放任务的阻塞队列
 * threadFactory：用于创建线程的工厂
 * handler：线程池和队列都满了之后的任务处理策略
 */
@Component
@Slf4j
public class ThreadPoolCommon extends ThreadPoolTaskExecutor  {

    private void showThreadPoolInfo(String prefix){
        ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();
        prefix = prefix +""+Thread.currentThread().getName();
        if (null == threadPoolExecutor) {
            return;
        }
        log.info("{}, {},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                this.getThreadNamePrefix(),
                prefix,
                threadPoolExecutor.getTaskCount(),
                threadPoolExecutor.getCompletedTaskCount(),
                threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getQueue().size());
    }

    @Override
    public void execute(Runnable task) {
        showThreadPoolInfo("1. do execute");
        super.execute(task);
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        showThreadPoolInfo("2. do execute");
        super.execute(task, startTimeout);
    }

    @Override
    public Future<?> submit(Runnable task) {
        showThreadPoolInfo("1. do submit");
        return super.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        showThreadPoolInfo("2. do submit");
        return super.submit(task);
    }

    @Override
    public ListenableFuture<?> submitListenable(Runnable task) {
        showThreadPoolInfo("1. do submitListenable");
        return super.submitListenable(task);
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        showThreadPoolInfo("2. do submitListenable");
        return super.submitListenable(task);
    }

}
