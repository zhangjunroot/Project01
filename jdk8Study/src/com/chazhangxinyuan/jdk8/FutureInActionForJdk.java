package com.chazhangxinyuan.jdk8;

import java.util.concurrent.*;

/**
 * @author zhangjun
 * @create 2018/11/30/14:22
 */
public class FutureInActionForJdk {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();//创建一个线程的线程服务,最后一定记得将其关闭，否则进程会一直运行。
        Future<String> future = executorService.submit(()->{
            try {
                Thread.sleep(10000L);
                return "I am finished";
            } catch (InterruptedException e) {
                return "I am error";
            }
        });
        //.....
        //做业务
        //.....
//        String value = future.get();//线程会阻塞住等到线程执行完成返回结果，相当于阻塞，不能达到异步的效果。
//        String a = future.get(10,TimeUnit.MICROSECONDS);//设置时间为10秒，如果没有拿到结果失败
        while (!future.isDone()){
            Thread.sleep(10);
        }
        System.out.println(future.get());
        executorService.shutdown();//关闭

    }
}
