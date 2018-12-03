package com.chazhangxinyuan.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author zhangjun
 * @create 2018/11/21/11:02
 */
public class StreanInAction {

    public static void main(String[] args) {

        Trader raoul= new Trader("Raoul","Cambridge");
        Trader mario= new Trader("Mario","Milan");
        Trader alan= new Trader("Alan","Cambridge");
        Trader brian= new Trader("Brian","Cambridge");

        List<Transaction> list = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        //1获取某年中的所有交易然后通过交易金额从小到大排序
//        Stream<Transaction> sorted = list.stream().filter(a -> a.getYear() == 2011).sorted(Comparator.comparing(b -> b.getValue()));
        Stream<Transaction> sorted = list.stream().filter(a -> a.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue));
//        sorted.forEach(System.out::println);
        List<Transaction> collect = sorted.collect(toList());
//        System.out.println(collect);

        //2获取trader工作的唯一城市
        List<String> collect1 = list.stream().map(s->s.getTrader().getCity()).distinct().collect(toList());
        System.out.println(collect1);
        //3

    }
}
