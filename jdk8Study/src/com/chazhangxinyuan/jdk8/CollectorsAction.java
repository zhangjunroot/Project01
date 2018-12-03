package com.chazhangxinyuan.jdk8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangjun
 * @create 2018/11/27/22:39
 */
public class CollectorsAction {

    public static final List<Dish> dishList = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {
        testAveragingDouble();
        testAveragingInt();
        testAveragingLong();
        testCollectingAndThen();
        testCollectingAndThenNomodify();
        testCounting();
        testGroupingBy();
        testGroupingByAndCounting();
        testGroupingByAndAverging();
        System.out.println("+++++++++++++++++++++++++++++++++++++++=");
        testGroupingByAndAvergingAndReturnCustomerMap();
        testSummarizingInt();
        testSummarizingDouble();
        testSummarizingLong();
    }

    private static void testAveragingDouble(){
        Optional.ofNullable(dishList.stream()
                .collect(Collectors.averagingDouble(Dish::getCalories)))
                .ifPresent(System.out::println);

    }
    private static void testAveragingInt(){
        Optional.ofNullable(dishList.stream()
                .collect(Collectors.averagingInt(Dish::getCalories)))
                .ifPresent(System.out::println);

    }
    private static void testAveragingLong(){
        Optional.ofNullable(dishList.stream()
                .collect(Collectors.averagingLong(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testCollectingAndThen(){
        Optional.ofNullable(dishList.stream()
                .collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories),a->"字符串的平均值"+a)))
                .ifPresent(System.out::println);
    }
    //返回一个不能修改的list
    private static void testCollectingAndThenNomodify(){
        List<Dish> dishes = dishList
                .stream()
                .filter(a -> a.getType().equals(Dish.Type.MEAT))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        /*Exception in thread "main" java.lang.UnsupportedOperationException
        dishes.add(new Dish("",false,100,Dish.Type.OTHER));*/

        System.out.println(dishes);

    }

    private static void testCounting(){
        Optional.ofNullable(dishList.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }

    private static void testGroupingBy(){
        Optional.ofNullable(dishList.stream().collect(Collectors.groupingBy(Dish::getType))).ifPresent(System.out::println);
    }
    private static void testGroupingByAndCounting(){
        Optional.ofNullable(dishList.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.counting()))).ifPresent(System.out::println);
    }
    private static void testGroupingByAndAverging(){
        Optional.ofNullable(dishList.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.averagingInt(Dish::getCalories)))).ifPresent(System.out::println);
    }
    private static void testGroupingByAndAvergingAndReturnCustomerMap(){
        TreeMap<Dish.Type, Double> map = dishList.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(map.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(map).ifPresent(System.out::println);
    }
    private static void testSummarizingInt(){
        Optional.ofNullable(dishList.stream().collect(
                Collectors.summarizingInt(Dish::getCalories))).ifPresent(System.out::println);
    }
    private static void testSummarizingDouble(){
        Optional.ofNullable(dishList.stream().collect(
                Collectors.summarizingDouble(Dish::getCalories))).ifPresent(System.out::println);
    }
    private static void testSummarizingLong(){
        Optional.ofNullable(dishList.stream().collect(
                Collectors.summarizingLong(Dish::getCalories))).ifPresent(System.out::println);
    }

}
