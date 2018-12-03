package com.chazhangxinyuan.jdk8;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author zhangjun
 * @create 2018/11/20/23:59
 */
public class StreamFind {

    public static void main(String[] args) {

        Stream<Integer> integerList = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6,7});
//        Optional<Integer> any = integerList.filter(a -> a > 1).findAny();
//        Optional<Integer> any1 = integerList.filter(a -> a >10).findAny();
        int i = find(new Integer[]{1, 2, 3, 4, 5, 6, 7}, -1, a -> a > 10);
        System.out.println(i);
//        System.out.println(any1.get());
//        System.out.println(any1.orElse(-1));

        integerList = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6,7});
        Optional<Integer> first = integerList.filter(a -> a > 1).findFirst();
        System.out.println(first.get());
        first.ifPresent(System.out::println);

        integerList = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6,7});
        Optional<Integer> any3 = integerList.filter(a -> a%2==0).findAny();
//        System.out.println(any3.get());???????????????????????
        System.out.println(any3.filter(a->a==2).get());

    }

    private static int find(Integer[] integers, Integer defaultValue, Predicate<Integer> predicate){
        for (Integer integer : integers) {
            if(predicate.test(integer)){
                return integer;
            }
        }
        return defaultValue;
    }
}
