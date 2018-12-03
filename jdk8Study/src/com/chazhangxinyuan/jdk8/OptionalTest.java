package com.chazhangxinyuan.jdk8;

import java.util.Optional;

/**
 * @author zhangjun
 * @create 2018/11/27/18:28
 */
public class OptionalTest
{
    public static void main(String[] args) {
        //书写方式一
        /*String name = getInsuranceNameByOptional(null);
        System.out.println(name);*/
        //书写方式二
        Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(System.out::println);

    }

    private static String getInsuranceNameByOptional(Person person){

        //书写方式一
        /*Optional<Person> person1 = Optional.ofNullable(person);
        Optional<Car> car = person1.flatMap(Person::getCar);
        Optional<Insurance> insurance = car.flatMap(Car::getInsurance);
        Optional<String> name = insurance.map(Insurance::getName);
        String returnStr = name.orElse("unkown");
        return returnStr;*/


        //书写方式二
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unkown");


    }
}
