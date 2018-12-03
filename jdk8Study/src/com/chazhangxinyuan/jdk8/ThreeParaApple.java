package com.chazhangxinyuan.jdk8;

/**
 * @author zhangjun
 * @create 2018/11/18/21:44
 */
@FunctionalInterface
public interface ThreeParaApple<S,T, U, R> {

    R getObj(S s, T t, U u);
}
