package com.chazhangxinyuan.jdk8;

import java.util.stream.IntStream;

/**
 * @author zhangjun
 * @create 2018/11/21/9:46
 */
public class NumericStream {


    public static void main(String[] args) {

//        Stream<Integer> integerStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        Integer result = integerStream.filter(i -> i > 3).reduce(0, Integer::sum);
//        Integer result = integerStream.filter(i -> i > 3).reduce(0, (x,y)->x+y);

//        int intSum = integerStream.mapToInt(i -> i.intValue()).filter(i -> i > 3).sum();
//        int intSum = integerStream.mapToInt(i -> i.intValue()).filter(i -> i > 3).reduce(0,(x,y)->x+y);
//        System.out.println(intSum);

        int a=9;
        //1..100  满足勾股定理
//        IntStream intStream = IntStream.rangeClosed(1, 100);
//        intStream.forEach(x->System.out.println(x));

//        IntStream intStream1 = IntStream.rangeClosed(1, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0);
//        intStream1.forEach(x->System.out.println(x));

        IntStream.rangeClosed(1, 100)
                 .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                 .boxed()
                 .map(x -> new int[]{a, x, (int) Math.sqrt(a * a + x * x)})
                 .forEach(s->System.out.println("a="+s[0]+"b="+s[1]+"c="+s[2]));

        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(x -> new int[]{a, x, (int) Math.sqrt(a * a + x * x)})
                .forEach(s->System.out.println("a="+s[0]+"b="+s[1]+"c="+s[2]));

    }
}
