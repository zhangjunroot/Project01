package com.chazhangxinyuan.thread.t7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用原子类解决线程安全性问题
 * @author zhangjun
 * @create 2018/12/04/21:24
 */
public class Sequence {

    private AtomicInteger a = new AtomicInteger(1);

    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(12);

    AtomicReference<User> userAtomicReference =  new AtomicReference<>();

    AtomicIntegerFieldUpdater<User> userAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    private int next(){
        return a.getAndIncrement();
    }


    public static void main(String[] args) {

        Sequence sequence= new Sequence();
        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+sequence.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+sequence.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+sequence.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
