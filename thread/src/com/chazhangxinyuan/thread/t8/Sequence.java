package com.chazhangxinyuan.thread.t8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock
 * @author zhangjun
 * @create 2018/12/04/21:24
 */
public class Sequence {

    private int a;

    /**
     * Lock需要显示的获取锁和释放锁  繁琐  能让代码更灵活
     * Synchronized不需要显示的获取锁和释放锁  简单
     *
     * 使用Lock可以方便的实现公平性
     * 非阻塞的获取锁
     * 能被中断的获取锁
     * 超时获取锁
     */
    Lock lock = new ReentrantLock();

    private int next(){
        lock.lock();//获取锁
         int result=a++;
         lock.unlock();//释放锁
         return result;
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
