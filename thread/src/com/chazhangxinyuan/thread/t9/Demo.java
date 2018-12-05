package com.chazhangxinyuan.thread.t9;

import java.util.concurrent.locks.Lock;

/**
 * 自定义重入锁
 * @author zhangjun
 * @create 2018/12/05/11:11
 */
public class Demo
{
    Lock lock = new MyLock();
    public void a (){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"a");
        b();
        lock.unlock();
    }
    public void b (){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"b");
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
         new Thread(()->{
             demo1.a();
         }).start();
    }
}
