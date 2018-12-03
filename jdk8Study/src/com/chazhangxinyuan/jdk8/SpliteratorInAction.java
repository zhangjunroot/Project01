package com.chazhangxinyuan.jdk8;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author zhangjun
 * @create 2018/11/29/15:26
 */
public class SpliteratorInAction {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(0, 10);
        Spliterator.OfInt spliterator = intStream.spliterator();
        Consumer<Integer> consumer = i -> System.out.println(i);
        spliterator.forEachRemaining(consumer);
    }
}
