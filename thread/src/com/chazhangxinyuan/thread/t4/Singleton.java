package com.chazhangxinyuan.thread.t4;

/**
 * 单例模式：饿汉式
 * @author zhangjun
 * @create 2018/12/04/23:57
 */
public class Singleton {

    //私有化构造方法
    private Singleton(){}

    //饿汉式没有线程安全性问题
    private static Singleton instance = new Singleton();//饿汉式（耗费内存）
    //对外提供获取实例的方法
    public static Singleton getInstance(){
        return instance;
    }
}
