package com.chazhangxinyuan.jdk8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author zhangjun
 * @create 2018/11/29/9:08
 */
public class ParallelProcessing {

    public static void main(String[] args) {

//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12");

        //获取计算机CPU核数
//        System.out.println(Runtime.getRuntime().availableProcessors() );
        //传统
        System.out.println("传统计算时间"+sumTen(ParallelProcessing::normalAdd,100000000l)+"ms");
        //stream
//        System.out.println("stream串行计算时间"+sumTen(ParallelProcessing::iterateStream,50000000l)+"ms");
        //stream
//        System.out.println("stream串行计算时间(拆箱)"+sumTen(ParallelProcessing::iterateStream3,50000000l)+"ms");
        //stream
//        System.out.println("stream并行计算时间"+sumTen(ParallelProcessing::iterateStream2,50000000l)+"ms");
        //stream
        System.out.println("stream并行计算时间2"+sumTen(ParallelProcessing::iterateStream4,100000000l)+"ms");


    }

    /**
     *计算10次求和
     * @param
     * @return
     */
    private static long sumTen(Function<Long,Long> adder,long limit){

        Long fastTime=Long.MAX_VALUE;
        for (int i=0;i<10;i++){
            Long startTime = System.currentTimeMillis();
            Long caculateResult = adder.apply(limit);
            Long caculateTime = System.currentTimeMillis()-startTime;
            System.out.println("计算结果：->"+caculateResult);
            if(caculateTime<fastTime) fastTime=caculateTime;
        }
        return fastTime;
    }

    /**
     *stream求和(串行)
     * @param limit
     * @return
     */
    private static long iterateStream(Long limit){

        return Stream.iterate(1l,i->i+1).limit(limit).reduce(0l,Long::sum);
    }
    /**
     *stream求和(串行2)
     * @param limit
     * @return
     */
    private static long iterateStream3(Long limit){

        return Stream.iterate(1l,i->i+1).mapToLong(Long::longValue).limit(limit).reduce(0l,Long::sum);
    }
    /**
     *stream求和(并行)
     * @param limit
     * @return
     */
    private static long iterateStream2(Long limit){

        return Stream.iterate(1l,i->i+1).parallel().limit(limit).reduce(0l,Long::sum);
    }
    /**
     *stream求和(并行2)
     * @param limit
     * @return
     */
    private static long iterateStream4(long limit){

        return LongStream.rangeClosed(1,limit).parallel().reduce(0l,Long::sum);
    }

    /**
     *传统方式求和
     * @param limit
     * @return
     */
    private static long normalAdd(long limit){
        long result = 0l;
        for (long i =1;i<=limit;i++){
            result+=i;
        }
        return result;
    }

}
