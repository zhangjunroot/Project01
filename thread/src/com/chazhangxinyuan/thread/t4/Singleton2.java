package com.chazhangxinyuan.thread.t4;

/**
 * 单例模式：懒汉式
 * @author zhangjun
 * @create 2018/12/04/23:57
 */
public class Singleton2 {

    //私有化构造方法
    private Singleton2(){}

    //懒汉式存在线程安全性问题
    private static volatile Singleton2 instance;
    //对外提供获取实例的方法
    //轻量级锁中的自旋是非常消耗CPU资源的相等于while（true）
    //不能用偏向锁、轻量级锁、和重量级锁，性能太低了，所以不能直接加synchronized
    /*public static synchronized Singleton2 getInstance() throws InterruptedException {
        if(instance==null) {
            Thread.sleep(2000);
            instance = new Singleton2();
        }

        return instance;
    }*/

    /**
     * 双重检查加锁(还是存在线程安全的问题，因为虚拟机在执行代码的时候可能不是按照编码的顺序，也就是指令重排序，要想避免
     * 指令重排序，需要使用volatile关键字)
     * @return
     * @throws InterruptedException
     */
    public static Singleton2 getInstance() throws InterruptedException {
        if(instance==null) {
            synchronized (Singleton2.class){
                if(instance==null)
                    instance = new Singleton2();
                    Thread.sleep(2000);
            }
        }

        return instance;
    }
}
