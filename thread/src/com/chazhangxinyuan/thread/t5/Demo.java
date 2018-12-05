package com.chazhangxinyuan.thread.t5;

/**
 * 重入锁
 * @author zhangjun
 * @create 2018/12/05/11:11
 */
public class Demo
{
    public synchronized void a (){
        System.out.println(Thread.currentThread().getName()+"a");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b();
    }
    public synchronized void b (){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"b");
    }

    public static void main(String[] args) {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
         new Thread(()->{
             demo1.a();
         }).start();

         new Thread(()->{
             demo2.b();
         }).start();

    }
}
