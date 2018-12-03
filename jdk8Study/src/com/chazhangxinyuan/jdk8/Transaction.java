package com.chazhangxinyuan.jdk8;

/**
 * @author zhangjun
 * @create 2018/11/21/10:58
 */
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return
                "{trader:" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
