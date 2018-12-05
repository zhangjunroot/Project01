package com.chazhangxinyuan.thread.t3;

/**
 * 线程安全性问题演示
 * 出现线程安全性问题的条件：1多线程环境下2多个线程共享一个资源（变量）3对资源进行非原子性操作（读写）
 * @author zhangjun
 * @create 2018/12/04/21:24
 */
public class Sequence {

    private int a;
    private static int b;


    /**
     *synchronized放在实例方法上，内置锁就是当前类的实例
     * @return
     */
    //给该方法加锁解决线程安全性问题所出现的重复性数字问题
    private synchronized int next(){
        return ++a;
    }
    /**
     *synchronized放在静态方法上，内置锁是当前的Class字节码对象
     * Sequence.class
     * @return
     */
    private static synchronized int previous(){
        return b--;
    }

    public int xx(){
//        synchronized (this){
//        synchronized (Integer.valueOf(a)){
        //monitorenter指令
        synchronized (Sequence.class){
            if(true){

            }else {

            }
        }
        return 1;
    }
    //monitorexit指令

    public static void main(String[] args) {

        /*Sequence s= new Sequence();
        while (true){
            System.out.println(s.next());
        }*/

        Sequence sequence= new Sequence();
        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+sequence.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+sequence.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+sequence.next());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
