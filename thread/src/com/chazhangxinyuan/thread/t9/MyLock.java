package com.chazhangxinyuan.thread.t9;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义锁
 * @author zhangjun
 * @create 2018/12/06/0:03
 */
public class MyLock implements Lock{

    private boolean isLocked = false;
    private Thread t=null;
    private int count=0;

    /**
     * 拿锁
     */
    @Override
    public synchronized void lock() {
        Thread currentThread = Thread.currentThread();
        while (isLocked && currentThread!=t){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked=true;
        t=currentThread;
        count++;
    }

    /**
     * 释放锁
     */
    @Override
    public synchronized void unlock() {
        if(t==Thread.currentThread()){
            count--;
            if(count==0){
                notify();
                isLocked=false;
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
