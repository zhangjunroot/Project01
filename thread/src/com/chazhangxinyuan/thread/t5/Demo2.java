package com.chazhangxinyuan.thread.t5;

import java.util.Random;

/**
 * 自旋
 * @author zhangjun
 * @create 2018/12/05/11:11
 */
public class Demo2
{
    public static void main(String[] args) {
         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println(Thread.currentThread().getName() + "开始执行");
                 try {
                     Thread.sleep(new Random().nextInt(2000));
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+"执行完毕");
             }
         }).start();

         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println(Thread.currentThread().getName() + "开始执行");
                 try {
                     Thread.sleep(new Random().nextInt(2000));
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+"执行完毕");
             }
         }).start();

         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println(Thread.currentThread().getName() + "开始执行");
                 try {
                     Thread.sleep(new Random().nextInt(2000));
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+"执行完毕");
             }
         }).start();

         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println(Thread.currentThread().getName() + "开始执行");
                 try {
                     Thread.sleep(new Random().nextInt(2000));
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+"执行完毕");
             }
         }).start();

        new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println(Thread.currentThread().getName() + "开始执行");
                 try {
                     Thread.sleep(new Random().nextInt(2000));
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+"执行完毕");
             }
         }).start();

        while (Thread.activeCount()!=2){
            //自旋等待
        }
        System.out.println("所有线程执行完毕");
    }
}
