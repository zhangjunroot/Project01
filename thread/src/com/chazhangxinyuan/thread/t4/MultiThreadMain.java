package com.chazhangxinyuan.thread.t4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程获取懒汉式中的线程安全问题
 * @author zhangjun
 * @create 2018/12/05/0:01
 */
public class MultiThreadMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i =0;i<20;i++){
            executorService.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+":"+Singleton2.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
