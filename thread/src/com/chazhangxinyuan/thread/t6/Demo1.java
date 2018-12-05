package com.chazhangxinyuan.thread.t6;

/**
 *volatile
 * 将当前缓存行的内容立即回写到系统内存
 * 这个回写到内存的操作会使其它cup里的缓存数据失效
 * @author zhangjun
 * @create 2018/12/05/11:11
 */
public class Demo1
{
    //synchronized可以替换volatile，但volatile不能替换synchronized，因为volatile的使用场景为原子性操作，是有局限性的
    private volatile int a = 1;

    public static void main(String[] args) {
        Demo1 demo= new Demo1();
        while (true){
            new Thread(()->{
                demo.a=10;
            }).start();

            new Thread(()->{
                System.out.println(demo.a);
            }).start();
        }

    }
}
