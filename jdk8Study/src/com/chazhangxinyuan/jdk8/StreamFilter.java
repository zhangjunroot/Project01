package com.chazhangxinyuan.jdk8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author zhangjun
 * @create 2018/11/20/22:41
 */
public class StreamFilter {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6,6,7,7);
//        List<Integer> list = integerList.stream().filter(a -> a % 2 == 0).collect(toList());
//        List<Integer> list = integerList.stream().distinct().collect(toList());
//        List<Integer> list = integerList.stream().skip(5).collect(toList());
        List<Integer> list = integerList.stream().limit(5).collect(toList());
        System.out.println(list);
    }
}
