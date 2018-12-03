package com.chazhangxinyuan.jdk8;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhangjun
 * @create 2018/11/30/11:56
 */
public class FutureInActionForCustomer {

    public static void main(String[] args) {
        /*System.out.println("当前线程的名字"+Thread.currentThread().getName());
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("当前线程的名字"+Thread.currentThread().getName());
                return "I am finished.";
            } catch (InterruptedException e) {
                return "Error";
            }
        });
        System.out.println(future.get());
        //做自己的业务逻辑，让线程先运行，自己的业务逻辑做完之后拿线程的返回结果
        while (!future.isDone()){
            try {
                System.out.println("当前线程的名字"+Thread.currentThread().getName());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //最后拿到线程的执行结果
        System.out.println(future.get());*/


        //阻塞
        String value = block(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("当前线程的名字" + Thread.currentThread().getName());
                return "I am finished.";
            } catch (InterruptedException e) {
                return "Error";
            }
        });
        System.out.println(value);

    }

    /**
     * 传统的方式，同步阻塞，降低程序的运行效率
     * @param <T>
     * @return
     */
    private static <T> T block(Callable<T> callable){
        return callable.action();
    }

    /**
     * future的方式达到异步的效果，提高程序的运行效率
     * @param callable
     * @param <T>
     * @return
     */
    private static <T> Future<T> invoke(Callable<T> callable){

        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished= new AtomicBoolean(false);

        Thread t = new Thread(()->{
            T value = callable.action();
            result.set(value);
            finished.set(true);
        });
        t.start();

        Future<T> future = new Future<T>() {
            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }
        };
        return future;
    }

    private interface Future<T>{
        //做事情的方法
        T get();
        //是否做完的方法
        boolean isDone();
    }

    private interface Callable<T>{
        //返回一个动作
        T action();
    }
}
