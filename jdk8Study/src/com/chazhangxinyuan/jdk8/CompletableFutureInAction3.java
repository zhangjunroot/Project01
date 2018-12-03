package com.chazhangxinyuan.jdk8;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangjun
 * @create 2018/12/03/2:13
 */
public class CompletableFutureInAction3 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2, r->{
            Thread t=new Thread(r);
            t.setDaemon(false);//设置为非守护线程
            return t;
        });

        CompletableFuture.supplyAsync(CompletableFutureInAction1::get,executorService)
                .thenApply(CompletableFutureInAction3::multi)//让输出结果扩大十倍
                .whenComplete((v, t)->{
            Optional.ofNullable(v).ifPresent(System.out::println);
        });

        executorService.shutdown();

    }

    private static double multi(double a){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a*10d;
    }
}
