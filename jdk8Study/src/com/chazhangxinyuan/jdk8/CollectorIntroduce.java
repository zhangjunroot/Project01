package com.chazhangxinyuan.jdk8;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author zhangjun
 * @create 2018/11/27/20:55
 */
public class CollectorIntroduce {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("green", 100),
                new Apple("green", 110),
                new Apple("yellow", 200),
                new Apple("blue", 300),
                new Apple("blue", 310)
        );

        /*List<Apple> redApples = apples.stream().filter(a -> "green".equals(a.getColor())).collect(toList());
        Optional.ofNullable(redApples).ifPresent(System.out::println);*/

        /*Map<String, List<Apple>> stringListMap = groupByNormal(apples);
        System.out.println(stringListMap);*/

//        Optional.ofNullable(groupByFunction(apples)).ifPresent(System.out::println);

        Optional.ofNullable(groupByCollector(apples)).ifPresent(System.out::println);

    }


    /**
     * 以前的方式
     * @param apples
     * @return
     */
    private static Map<String,List<Apple>> groupByNormal(List<Apple> apples){
        Map<String,List<Apple>> map = new HashMap<>();
        for (Apple apple : apples) {
            List<Apple> appleList = map.get(apple.getColor());
            if(null==appleList){
                appleList=new ArrayList<>();
                map.put(apple.getColor(),appleList);
            }
            appleList.add(apple);
        }
        return map;
    }
    /**
     * 没有使用collector的方式
     * @param apples
     * @return
     */
    private static Map<String,List<Apple>> groupByFunction(List<Apple> apples){
        Map<String,List<Apple>> map = new HashMap<>();
        apples.stream().forEach(apple -> {
            List<Apple> appleList = Optional.ofNullable(map.get(apple.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList();
                map.put(apple.getColor(), list);
                return list;
            });
            appleList.add(apple);
        });
        return map;
    }
    /**
     * 使用collector的方式
     * @param apples
     * @return
     */
    private static Map<String,List<Apple>> groupByCollector(List<Apple> apples){
        return apples.stream().collect(groupingBy(Apple::getColor));
    }
}
