package com.chazhangxinyuan.jdk8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author zhangjun
 * @create 2018/11/20/23:41
 */
public class StreamMatch {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        boolean b = stream.allMatch(a -> a > 10);
        System.out.println(b);


         stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        boolean b1 = stream.anyMatch(a -> a > 5);
        System.out.println(b1);


         stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        boolean b2 = stream.noneMatch(a -> a < 0);
        System.out.println(b2);


    }
}
