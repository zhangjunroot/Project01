package com.chazhangxinyuan.thread.t2;

/**
 * 匿名内部类的方式创建线程
 * @author zhangjun
 * @create 2018/12/04/15:36
 */
public class Demo3 {
    public static void main(String[] args) {

        /*new Thread(){
            @Override
            public void run() {
                System.out.println("thread的方式");
            }
        }.start();*/

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable的方式");
            }
        }){
        }.start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("混合runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("混合thread");//输出这个
            }
        }.start();
    }
}
