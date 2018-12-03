package com.chazhangxinyuan.jdk8;

import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangjun
 * @create 2018/11/28/11:39
 */
public class CollectorsAction2 {

    public static void main(String[] args) {
        testSummingDouble();
        testSummingLong();
        testSummingInt();
        testToCollection();
        testToConcurrentMap();
        testToConcurrentMapOfTypeTotal();
        testToConcurrentMapOfTypeTotalAndCustomerMap();
        testToList();
        testToSet();
        testToMap();
        testToMapOfTypeTotal();
        testToMapOfTypeTotalAndCustomerMap();
        testToMapAboutSynchronized();
    }

    /**
     * 求和
     */
    private static void testSummingDouble(){
        //方式一
        Optional.of(CollectorsAction.dishList.stream().collect(Collectors.summingDouble(Dish::getCalories)))
        .ifPresent(System.out::println);

        //方式二
        Stream<Integer> integerStream = CollectorsAction.dishList.stream().map(Dish::getCalories);
        IntStream intStream = integerStream.mapToInt(Integer::intValue);
        int sum = intStream.sum();
        System.out.println(sum);

        //方式二连起来写
        Optional.of(CollectorsAction.dishList.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum())
        .ifPresent(System.out::println);

    }
    private static void testSummingLong(){
        Optional.of(CollectorsAction.dishList.stream().collect(Collectors.summingLong(Dish::getCalories)))
        .ifPresent(System.out::println);
    }
    private static void testSummingInt(){
        Optional.of(CollectorsAction.dishList.stream().collect(Collectors.summingInt(Dish::getCalories)))
        .ifPresent(System.out::println);
    }
    private static void testToCollection(){
        Optional.of(CollectorsAction.dishList.stream().filter(a->a.getCalories()>500).collect(Collectors.toCollection(LinkedList::new)))
        .ifPresent(System.out::println);
    }
    private static void testToConcurrentMap(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .collect(Collectors.toConcurrentMap(Dish::getName,Dish::getCalories)))
                .ifPresent(a->{System.out.println(a);
                                System.out.println(a.getClass());
                              });
    }

    /**
     * Type:total
     */
    private static void testToConcurrentMapOfTypeTotal(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .collect(Collectors.toConcurrentMap(Dish::getType,a->1,(s,b)->s+b)))
                .ifPresent(a->{System.out.println(a);
                                System.out.println(a.getClass());
                              });
    }

    /**
     * Type:total并且自定义map
     */
    private static void testToConcurrentMapOfTypeTotalAndCustomerMap(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .collect(Collectors.toConcurrentMap(Dish::getType,a->1,(s,b)->s+b, ConcurrentSkipListMap::new)))
                .ifPresent(a->{System.out.println(a);
                                System.out.println(a.getClass());
                              });
    }

    private static void testToList(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList()))
                .ifPresent(a->{System.out.println(a);
                                System.out.println(a.getClass());
                              });
    }
    private static void testToSet(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toSet()))
                .ifPresent(a->{System.out.println(a);
                                System.out.println(a.getClass());
                              });
    }

    private static void testToMap(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .collect(Collectors.toMap(Dish::getName,Dish::getCalories)))
                .ifPresent(a->{System.out.println(a);
                    System.out.println(a.getClass());
                });
    }

    private static void testToMapAboutSynchronized(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toMap(Dish::getName,Dish::getCalories), Collections::synchronizedMap)))
                .ifPresent(a->{System.out.println(a);
                    System.out.println(a.getClass());
                });
    }

    /**
     * Type:total
     */
    private static void testToMapOfTypeTotal(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .collect(Collectors.toMap(Dish::getType,a->1,(s,b)->s+b)))
                .ifPresent(a->{System.out.println(a);
                    System.out.println(a.getClass());
                });
    }

    /**
     * Type:total并且自定义map
     */
    private static void testToMapOfTypeTotalAndCustomerMap(){
        Optional.of(CollectorsAction.dishList
                .stream()
                .collect(Collectors.toMap(Dish::getType,a->1,(s,b)->s+b, Hashtable::new)))
                .ifPresent(a->{System.out.println(a);
                    System.out.println(a.getClass());
                });
    }
}
