package com.chazhangxinyuan.thread.t2;

/**
 * 作为线程任务存在
 * @author zhangjun
 * @create 2018/12/04/15:36
 */
public class Demo2 implements Runnable{


    @Override
    public void run() {
        while (true){
            System.out.println("线程运行了......");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo2());
        thread.start();
    }
}
