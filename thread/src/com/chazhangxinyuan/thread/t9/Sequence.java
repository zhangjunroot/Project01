package com.chazhangxinyuan.thread.t9;

import java.util.concurrent.locks.Lock;

/**
 * 自定义锁
 * @author zhangjun
 * @create 2018/12/04/21:24
 */
public class Sequence {

    private int a;

    Lock lock = new MyLock();

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
