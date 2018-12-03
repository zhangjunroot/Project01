package com.chazhangxinyuan.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @author zhangjun
 * @create 2018/11/16/12:06
 */
public class LambdaUse {

    private static List<Apple> filterApple(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList();
        for (Apple apple : source) {
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterAppleByWeight(List<Apple> source, LongPredicate predicate){
        List<Apple> result = new ArrayList();
        for (Apple apple : source) {
            if(predicate.test(apple.getWeight())){
                result.add(apple);
            }
        }
        return result;
    }
    private static List<Apple> filterAppleByWeightAndColor(List<Apple> source, BiPredicate<Long,String> predicate){
        List<Apple> result = new ArrayList();
        for (Apple apple : source) {
            if(predicate.test(apple.getWeight(),apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }
    private static void  filterAppleByConsumer(List<Apple> source, Consumer<Apple> consumer){
        List<Apple> result = new ArrayList();
        for (Apple apple : source) {
            consumer.accept(apple);
        }
    }
    private static void  filterAppleByBiConsumer(String a,List<Apple> source, BiConsumer<Apple,String> consumer){
        List<Apple> result = new ArrayList();
        for (Apple apple : source) {
            consumer.accept(apple,a);
        }
    }

    private static String filterAppleByFunction(Apple apple, Function<Apple,String> function){
        String apple1 = function.apply(apple);
        return apple1;
    }

    private static Apple filterAppleByBiFunction(String color,long weight, BiFunction<String,Long,Apple> function){
        Apple apple = function.apply(color, weight);
        return apple;
    }

    private static Apple filterAppleBySupplier(Supplier<Apple> appleSupplier){
        return appleSupplier.get();
    }

    public static void main(String[] args) {

        Runnable runnable = ()-> System.out.println("123");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        };
        runnable.run();
        runnable1.run();
        List<Apple> list = Arrays.asList(new Apple("green",120),new Apple("green",130),new Apple("red",120));
        List<Apple> apples = filterApple(list, a -> a.getColor().equals("green"));
        List<Apple> apples1 = filterAppleByWeight(list, a -> a > 100);
        List<Apple> apples2 = filterAppleByWeightAndColor(list, (a, b) -> a > 100 && b.equals("green"));
        System.out.println(apples2);
        filterAppleByConsumer(list,a -> System.out.println(a));
        filterAppleByBiConsumer("xxx",list,(b,c)-> System.out.println(b.getColor()+c+"weight:"+b.getWeight()));
        String s = filterAppleByFunction(new Apple("blue", 12), apple -> String.valueOf(apple.getWeight() * 10));
        System.out.println(s);

        IntFunction<Double> intFunction = i -> i * 10.0d;
        double apply = intFunction.apply(2);
        System.out.println(apply);
        Apple yellow = filterAppleByBiFunction("yellow", 5l, (a, b) -> new Apple(a, b));
        System.out.println(yellow);

        Supplier<String> s3 = String::new;
        String s1 = s3.get();
        System.out.println(s1.getClass());

        Apple red = filterAppleBySupplier(() -> new Apple("red", 15l));
        System.out.println(red);

        int i=0;
        //i为final类型
//        Runnable runnable = () -> System.out.println(i);
        //        i++;
        runnable.run();
    }
}
