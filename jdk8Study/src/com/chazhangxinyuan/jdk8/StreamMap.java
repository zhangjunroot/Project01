package com.chazhangxinyuan.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author zhangjun
 * @create 2018/11/20/22:41
 */
public class StreamMap {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6,6,7,7);
        List<Integer> list = integerList.stream().map(a->a*2).collect(toList());
//        System.out.println(list);

//        listDish().stream().map(a->a.getName()).forEach(System.out::println);
        List<String> list1 = listDish().stream().map(a -> a.getName()).collect(toList());
//        System.out.println(list1);

        String[] s ={"Hello","World"};
        //{H,e,l,l,o},{W,o,r,l,d}
        Stream<String[]> stream = Arrays.stream(s).map(a->a.split(""));
        //H,e,l,l,o,W,o,r,l,d
        Stream<String> stream1 = stream.flatMap(Arrays::stream);
        stream1.forEach(System.out::println);
    }

    private static List<Dish> listDish(){
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
        return dishList;
    }
}
