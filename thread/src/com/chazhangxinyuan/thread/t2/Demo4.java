package com.chazhangxinyuan.thread.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建有返回值的线程
 * @author zhangjun
 * @create 2018/12/04/15:36
 */
public class Demo4 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行结果计算......");
        Thread.sleep(1000);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo4 demo4 = new Demo4();

        FutureTask<Integer> task = new FutureTask<Integer>(demo4);
        Thread thread = new Thread(task);
        thread.start();

        System.out.println("我先干点别的......");

        Integer result = task.get();
        System.out.println("返回结果"+result);
    }
}
