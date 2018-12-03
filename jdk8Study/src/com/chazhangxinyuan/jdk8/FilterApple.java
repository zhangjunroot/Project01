package com.chazhangxinyuan.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @create 2018/11/15/22:37
 */
public class FilterApple {
    /**
     * 1.找到绿色苹果并返回
     * @param list
     * @return
     */
    public  static List<Apple> findGreenApple(List<Apple> list ){

        List<Apple> listData = new ArrayList<>();
        for (Apple apple : list) {
            if(apple.getColor().equals("green")){
                listData.add(apple);
            }
        }
        return  listData;
    }
    /**
     * 2.找各种颜色的苹果并返回
     * @param list
     * @return
     */
    public  static List<Apple> findApple(List<Apple> list,String color ){

        List<Apple> listData = new ArrayList<>();
        for (Apple apple : list) {
            if(apple.getColor().equals(color)){
                listData.add(apple);
            }
        }
        return  listData;
    }

    @FunctionalInterface
    public interface AppleFilter{

        boolean filter(Apple apple);

        default  void a(){

        };
        static  void b(){

        };
    }

    /**
     * 通过匿名内部类的方式就不需要写下边这个实现类了（例如找黄色大于100的苹果）
     */
    public  static class FindApple implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {

            return (apple.getColor().equals("green")&&apple.getWeight()>=100);
        }
    }

    /**
     * 3.找绿色并且重量最小为100的苹果并返回
     * @param list
     * @return
     */
    public  static List<Apple> findApple(List<Apple> list, AppleFilter filterApple){

        List<Apple> listData = new ArrayList<>();
        for (Apple apple : list) {
            if(filterApple.filter(apple)){
                listData.add(apple);
            }
        }
        return  listData;
    }
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green", 100l), new Apple("yellow", 200l), new Apple("yellow", 300l));
//        List<Apple> greenApple = findGreenApple(apples);
        //jdk自帶的断言机制
//        assert greenApple.size()==2;
//        System.out.println(greenApple);

//        List<Apple> appleList = findApple(apples, "red");
//        System.out.println(appleList);

//        List<Apple> greenAnd100Apple = findApple(apples, new FindApple());
//        System.out.println(greenAnd100Apple);

        List<Apple> yellowApples = findApple(apples, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return ("yellow".equals(apple.getColor()) && apple.getWeight() >= 100);
            }
        });
        System.out.println(yellowApples);

//        List<Apple> lambdaApple = findApple(apples, apple -> "yellow".equals(apple.getColor()) && apple.getWeight() >= 100);
//        System.out.println(lambdaApple);

//        new  Thread(()-> System.out.println(Thread.currentThread().getName()+"1111")).start();
//        try {
//            Thread.currentThread().sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
