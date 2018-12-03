package com.chazhangxinyuan.jdk8;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjun
 * @create 2018/11/29/12:17
 */
public class AccumulatorRecursiveAction extends RecursiveAction {

    private final int start;
    private final int end;
    private final int[] data;
    private final int limit=3;

    public AccumulatorRecursiveAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        if(end-start<=limit){
            int result=0;
            for (int i=start;i<end;i++){
//                result+=data[i];
                AccumulatorHelper.accumulate(data[i]);
            }
        }else{
            int mid=(end+start)/2;
            AccumulatorRecursiveAction left = new AccumulatorRecursiveAction(start,mid,data);
            AccumulatorRecursiveAction right = new AccumulatorRecursiveAction(mid,end,data);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }

    }

    static class AccumulatorHelper{

        private static final AtomicInteger result=new AtomicInteger();

         static void accumulate(int value){
            result.getAndAdd(value);
        }

        public static int getResult(){
             return result.get();
        }

    }
}
