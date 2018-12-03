package com.chazhangxinyuan.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author zhangjun
 * @create 2018/12/03/2:13
 */
public class CompletableFutureInAction4 {

    public static void main(String[] args) throws InterruptedException {
        //从数据库中查询出五个商品的单价然后变为十倍后输出
        ExecutorService executorService = Executors.newFixedThreadPool(2, r->{
            Thread t=new Thread(r);
            t.setDaemon(false);//设置为非守护线程
            return t;
        });

        List<Integer> productsId = Arrays.asList(1, 2, 3, 4, 5);
        Stream<CompletableFuture<Double>> completableFutureStream =
                productsId.stream().map(i -> CompletableFuture.supplyAsync(CompletableFutureInAction1::get, executorService));
        Stream<CompletableFuture<Double>> futureStream =
                completableFutureStream.map(i -> i.thenApply(CompletableFutureInAction4::multi));
        List<Double> doubles = futureStream.map(CompletableFuture::join).collect(toList());
        System.out.println(doubles);


    }

    private static double multi(double a){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a*10d;
    }
}
