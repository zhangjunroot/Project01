package com.chazhangxinyuan.jdk8;

import java.util.concurrent.CompletableFuture;

/**
 * 常用API学习
 * @author zhangjun
 * @create 2018/12/03/2:13
 */
public class CompletableFutureInAction5 {

    public static void main(String[] args) throws InterruptedException {
        //CompletableFuture创建出来的线程默认为守护线程，当主线程结束后守护线程不管是否完成也要结束，所以让主线程
        //休眠一段时间等待守护线程执行结束
        /*CompletableFuture
                .supplyAsync(()->1)
                .thenApply(i->Integer.sum(i,10))
                .whenComplete((v,t)->{
                System.out.println(v);
        });*/
        /*CompletableFuture
                .supplyAsync(()->1)
                .handle((v,e)->Integer.sum(v,10))
                .whenComplete((v,t)->{
                System.out.println(v);
        });*/
        /*CompletableFuture
                .supplyAsync(()->1)
                .thenAccept(System.out::println);*/

        /*CompletableFuture
                .supplyAsync(()->1)
                .thenCompose(i->CompletableFuture.supplyAsync(()->i*10))
                .thenAccept(System.out::println);*/

        /*CompletableFuture
                .supplyAsync(()->1)
                .thenCombine(CompletableFuture.supplyAsync(()->2.0d),(a,b)->a+b)
                .thenAccept(System.out::println);*/

        CompletableFuture
                .supplyAsync(()->1)
                .thenAcceptBoth(CompletableFuture.supplyAsync(()->2.0d),(a,b)->{
                    System.out.println(a);
                    System.out.println(b);
                    System.out.println(a+b);
                });



        Thread.sleep(1000L);

    }

}
