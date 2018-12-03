package com.chazhangxinyuan.jdk8;

import java.util.concurrent.ForkJoinPool;

/**
 * @author zhangjun
 * @create 2018/11/29/12:13
 */
public class ForkJoinPoolTest {
    private static int[] a={1,2,3,4,5,6,7,8,9,10};

    public static void main(String[] args) {
        System.out.println(caculate(a));

        AccumulatorRecursiveTask accumulatorRecursiveTask=new AccumulatorRecursiveTask(0,a.length, a);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer result = forkJoinPool.invoke(accumulatorRecursiveTask);
        System.out.println("AccumulatorRecursiveTask计算结果"+result);

        AccumulatorRecursiveAction accumulatorRecursiveAction=new AccumulatorRecursiveAction(0,a.length, a);
        forkJoinPool.invoke(accumulatorRecursiveAction);
        System.out.println("AccumulatorRecursiveAction计算结果"+AccumulatorRecursiveAction.AccumulatorHelper.getResult());
    }

    private static int caculate(int[] a){
        int result=0;
        for (int i=0;i<a.length;i++){
            result+=a[i];
        }
        return result;
    }
}
