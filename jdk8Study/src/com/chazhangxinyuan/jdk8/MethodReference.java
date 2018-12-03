package com.chazhangxinyuan.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author zhangjun
 * @create 2018/11/16/14:51
 */
public class MethodReference {


    private static <T> void useComsumer(Consumer<T> consumer, T t){
        consumer.accept(t);

    }

    public static void main(String[] args) {

//        Consumer<String> consumer = a -> System.out.println(a);
//        useComsumer(consumer,"hello");
//        useComsumer(a -> System.out.println(a),"hello1");
//        useComsumer(System.out::println,"hello2");

        List<Apple> list = Arrays.asList(new Apple("red",10),new Apple("Green",20),new Apple("yellow",30));
        System.out.println(list);
        System.out.println("========================================");
        list.sort((o1, o2) -> o1.getColor().compareTo(o2.getColor()));
        System.out.println(list);

        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);

//        list.stream().forEach(a-> System.out.println(a));
//        Consumer comsumer = System.out::println;
//        list.stream().forEach(System.out::println);

        Integer i = Integer.parseInt("123");
        Function<String, Integer> function = Integer::parseInt;
        Integer apply = function.apply("123");
//        System.out.println(apply);

        BiFunction<String, Integer, Character> stringIntegerCharacterBiFunction = String::charAt;
        Character c1 = stringIntegerCharacterBiFunction.apply("hello", 2);
//        System.out.println(c1);

        String s1= new String("hello");
        Function<Integer, Character> integerCharacterFunction = s1::charAt;
        Character apply1 = integerCharacterFunction.apply(1);
//        System.out.println(apply1);

        Supplier<String> snew = String::new;
        String s2 = snew.get();
//        System.out.println(s2.getClass());

        BiFunction<String,Long,Apple>  function1 = Apple::new;
        Apple apple = function1.apply("yellow", 121l);
//        System.out.println(apple);

        ThreeParaApple<String,String,Long,ComplexApple> paraApple= ComplexApple::new;
        ComplexApple appleObj = paraApple.getObj("红富士", "red", 23l);
//        System.out.println(appleObj);

    }
}
