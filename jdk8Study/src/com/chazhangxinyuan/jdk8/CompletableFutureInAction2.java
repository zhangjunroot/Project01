package com.chazhangxinyuan.jdk8;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhangjun
 * @create 2018/12/03/2:13
 */
public class CompletableFutureInAction2 {
    public static void main(String[] args) throws InterruptedException {

        //这是一个守护线程，要想main线程执行完成后守护线程不随之也停止，两种办法：1：join(主线程永远不会停止，通常不用)
        // 2：判断
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        CompletableFuture.supplyAsync(CompletableFutureInAction1::get).whenComplete((v, t)->{
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(x->x.getMessage());
            atomicBoolean.set(true);
        });

        ExecutorService executorService3 = Executors.newFixedThreadPool(2, r->{
            Thread t=new Thread(r);
            t.setDaemon(false);//设置为非守护线程
            return t;
        });

        CompletableFuture.supplyAsync(CompletableFutureInAction1::get,executorService3).whenComplete((v, t)->{
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(x->x.getMessage());
            atomicBoolean.set(true);
        });

        System.out.println("==============没有阻塞=============");
        while (!atomicBoolean.get()){
            Thread.sleep(1);
        }

        executorService3.shutdown();
//        Thread.currentThread().join();

        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(()-> System.out.println("====test===="));
        executorService.shutdown();//必须退出线程*/


        //会自动退出线程，但是有问题？？？？？？？？？？
        /*ExecutorService executorService2 = Executors.newFixedThreadPool(2,r->{
            Thread t=new Thread(r);
            t.setDaemon(true);//设置为守护线程
            return t;
        });
        executorService2.execute(()-> System.out.println("====test2===="));*/
    }
}
