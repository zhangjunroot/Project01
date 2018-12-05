package com.chazhangxinyuan.thread.t2;

import java.util.Arrays;
import java.util.List;

/**
 * Lambada的使用
 * @author zhangjun
 * @create 2018/12/04/16:56
 */
public class Demo7 {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(10, 20, 30, 40, 50);
        int add = add(integers);
        System.out.println(add);

    }

    private  static int add(List<Integer> list){
        int result = list.parallelStream().mapToInt(i -> i).sum();
        return result;
    }

}
