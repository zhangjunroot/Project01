package com.chazhangxinyuan.thread.t1;

/**
 * @author zhangjun
 * @create 2018/12/04/15:19
 */
public class NewThread implements Runnable{
    @Override
    public synchronized void run() {

        while (true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("自定义线程执行了......");
        }
    }

    //wait和notifyAll方法使用的时候需要加锁，sleep不需要
    public static void main(String[] args) {

        NewThread n = new NewThread();

        Thread thread = new Thread(n);

        thread.start();

        while (true){
            synchronized (n){
                System.out.println("主线程执行了......");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n.notifyAll();
            }

        }


    }
}
