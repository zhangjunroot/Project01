package com.chazhangxinyuan.jdk8;

/**
 * @author zhangjun
 * @create 2018/11/18/21:40
 */
public class ComplexApple {
    private  String name;
    private String color;
    private Long weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ComplexApple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public ComplexApple(String name, String color, Long weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }
}
