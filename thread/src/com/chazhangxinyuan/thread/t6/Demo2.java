package com.chazhangxinyuan.thread.t6;

/**
 *volatile
 * 当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
 而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的，当其他线程去读取时，
 此时内存中可能还是原来的旧值，因此无法保证可见性。
 * @author zhangjun
 * @create 2018/12/05/11:11
 */
public class Demo2
{
    private volatile boolean a = false;

    public static void main(String[] args) {
//        要想并发程序正确地执行，必须要保证原子性、可见性以及有序性。
//        只要有一个没有被保证，就有可能会导致程序运行不正确。
//        在Java中，对基本数据类型的变量的读取和赋值操作是原子性操作，即这些操作是不可被中断的，
//        要么执行，要么不执行。
        Demo2 demo= new Demo2();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("执行了第" + i + "次");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            demo.a = true;
        }).start();

        new Thread(() -> {
            while (!demo.a) {
                //不执行（自旋等待）
            }
            System.out.println("线程2执行了。。。");
        }).start();
    }
}
