package com.chazhangxinyuan.jdk8;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangjun
 * @create 2018/12/03/1:32
 */
public class CompletableFutureInAction1 {

    private final static Random RANDOM=new Random(System.currentTimeMillis());

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Double> doubleCompletableFuture = new CompletableFuture<>();

        new Thread(()->{
            double value = get();
            doubleCompletableFuture.complete(value);//设值
        }).start();

        System.out.println("======noblock(未阻塞)......");

//        Optional.ofNullable(doubleCompletableFuture.get()).ifPresent(System.out::println);//阻塞的去拿

        //通知的方式去拿
        doubleCompletableFuture.whenComplete((v,t)->{
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(x->System.out.println(x.getMessage()));
        });
    }

     static double get(){
        try {
            Thread.sleep(RANDOM.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         double d=RANDOM.nextDouble();
         System.out.println(d);
        return d;
    }
}
