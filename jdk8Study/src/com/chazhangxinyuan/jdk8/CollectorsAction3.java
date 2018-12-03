package com.chazhangxinyuan.jdk8;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author zhangjun
 * @create 2018/11/28/11:39
 */
public class CollectorsAction3 {

    public static void main(String[] args) {
        testPartitionBy();
        testPartitionByWithPredicateAndCollector();
        testReducing();
        testReducing2();
        testReducing3();
    }


    private static void testPartitionBy(){
        Optional.of(CollectorsAction.dishList.stream().collect(
                Collectors.partitioningBy(a->a.isVegetarian())))
        .ifPresent(System.out::println);
    }

    private static void testPartitionByWithPredicateAndCollector(){
        Optional.of(CollectorsAction.dishList.stream().collect(
                Collectors.partitioningBy(a->a.isVegetarian(),Collectors.averagingInt(Dish::getCalories))))
        .ifPresent(System.out::println);
    }

    private static void testReducing(){
        Optional<Dish> d = CollectorsAction.dishList.stream().collect(
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories))));
        d.ifPresent(System.out::println);
    }

    private static void testReducing2(){
        Integer collect = CollectorsAction.dishList.stream()
                .map(Dish::getCalories)
                .collect(
                        Collectors.reducing(0, (d1, d2) -> d1 + d2));
        System.out.println(collect);
    }
    private static void testReducing3(){
        Integer collect = CollectorsAction.dishList.stream()
                .collect(
                        Collectors.reducing(0,Dish::getCalories, (d1, d2) -> d1 + d2));
        System.out.println(collect);
    }

}
