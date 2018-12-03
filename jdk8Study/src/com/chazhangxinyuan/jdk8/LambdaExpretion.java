package com.chazhangxinyuan.jdk8;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zhangjun
 * @create 2018/11/16/10:32
 */
public class LambdaExpretion {

    public static void main(String[] args) {

        Comparator<Apple> byColor= new Comparator<Apple>() {
            //相等返回0，前者大返回大于0，否则返回小于0
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();
        //排序
        list.sort(byColor);

        Comparator<Apple> byColorLambda = (o1, o2) -> o1.getColor().compareTo(o2.getColor());


        //lambda表达式
        Predicate<String> filter1 = s -> false;

        Function<String,Integer> filter = s -> s.length();
        Function<String,Boolean> filter2 = s -> false;

        Consumer<String> consumer = s -> System.out.println(s.length());

        Runnable runnable = () -> {};

        Supplier<String> supplier = () -> new String();


    }


}
