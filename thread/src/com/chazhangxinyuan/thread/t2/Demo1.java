package com.chazhangxinyuan.thread.t2;

/**
 * @author zhangjun
 * @create 2018/12/04/15:36
 */
public class Demo1 extends Thread{

    @Override
    public void run() {
        while (!interrupted()){//默认为true
            System.out.println(getName()+"线程执行了......");
        }
    }

    public static void main(String[] args) {
        Demo1 d1 = new Demo1();
        Demo1 d2 = new Demo1();
//        d1.setDaemon(true);//守护线程会随着主线程的结束而结束
//        d2.setDaemon(true);
        d1.start();
        d2.start();
//        d1.stop();//该种方法终止线程是非常不好的，线程所获取的锁和资源都没有被释放掉，所以废弃了不建议使用
        //使用interrupt和interrupted
        d1.interrupt();

    }
}
