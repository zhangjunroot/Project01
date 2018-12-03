package com.chazhangxinyuan.jdk8;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author zhangjun
 * @create 2018/11/18/22:39
 */
public class SimpleStream {

    public static void main(String[] args) {

        List<Dish> dishList = Arrays.asList(
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

        Stream<Dish> dishStream1 = Stream.of(new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        dishStream1.forEach(System.out::println);

//        Stream<Dish> dishStream = dishList.stream();
//        dishStream.forEach(System.out::println);
//        dishStream.forEach(System.out::println);

//        List<String> list = findNameByCaloriesStream(dishList);
//        System.out.println(list);

    }

    public  static List<String> findNameByCaloriesStream(List<Dish> dishes){
        return  dishes.stream().filter(a->a.getCalories()<400).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
    }

    public  static List<String> findNameByCalories(List<Dish> dishes){
        List<Dish> result = new ArrayList<>();
        List<String> finalResult = new ArrayList<>();

        for (Dish dish : dishes) {
            if(dish.getCalories()<400){
                result.add(dish);
            }
        }
//        result.sort(Comparator.comparing(Dish::getCalories));
        Collections.sort(result,(d1, d2)->Integer.compare(d1.getCalories(),d2.getCalories()));

        for (Dish dish : result) {
            finalResult.add(dish.getName());
        }
        return finalResult;
    }
}
