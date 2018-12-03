package com.chazhangxinyuan.jdk8;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zhangjun
 * @create 2018/11/21/0:33
 */
public class StreamReduce {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        Integer reduce = stream.reduce(0, (x, y) -> x + y);
        Integer reduce = stream.reduce(0,Integer::sum);
        System.out.println(reduce);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Optional<Integer> reduce1 = stream.reduce((x, y) -> x + y);
        reduce1.ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        Optional<Integer> reduce2 = stream.reduce((x, y) -> x>y?x:y);
        Optional<Integer> reduce2 = stream.reduce(Integer::max);
        reduce2.ifPresent(System.out::println);


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Integer reduce3 = stream.filter(i -> i % 2 == 0).reduce(1, (x, y) -> x * y);
        System.out.println(reduce3);
    }
}
