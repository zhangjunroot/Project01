package com.chazhangxinyuan.jdk8;

/**
 * @author zhangjun
 * @create 2018/11/21/10:56
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return
                "{name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
