package com.chazhangxinyuan.thread.t6;

/**
 * 保证可见性的前提是多个线程拿到的是同一把锁，否则是保证不了的
 * @author zhangjun
 * @create 2018/12/05/11:11
 */
public class Demo
{
    private int a = 1;

    /*public  int getA() {
        return a;
    }

    public  void setA(int a) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a = a;
    }*/
    public  synchronized int getA() {
        return a;
    }

    public  synchronized void setA(int a) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a = a;
    }

    public static void main(String[] args) {
        Demo demo= new Demo();
        while (true){


            new Thread(()->{
                demo.setA(10);
            }).start();

            new Thread(()->{
                System.out.println(demo.getA());
            }).start();

        }

    }
}
