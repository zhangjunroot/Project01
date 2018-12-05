package com.chazhangxinyuan.thread.t2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用
 * @author zhangjun
 * @create 2018/12/04/16:56
 */
public class Demo6 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);//创建固定容量的线程池

        for (int i=0;1<10;i++){

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
//        executorService.shutdown();
    }
}
