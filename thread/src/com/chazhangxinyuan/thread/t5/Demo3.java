package com.chazhangxinyuan.thread.t5;

/**
 * 死锁
 * @author zhangjun
 * @create 2018/12/05/11:11
 */
public class Demo3
{
    Object object1 = new Object();
    Object object2 = new Object();
    public  void a (){
        synchronized (object1){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){
                System.out.println("a");
            }
        }
    }
    public  void b (){
        synchronized (object2){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1){
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {
        Demo3 demo = new Demo3();
         new Thread(()->{
             demo.a();
         }).start();

         new Thread(()->{
             demo.b();
         }).start();

    }
}
