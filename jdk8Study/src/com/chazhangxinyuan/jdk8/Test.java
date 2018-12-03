package com.chazhangxinyuan.jdk8;

/**
 * @author zhangjun
 * @create 2018/11/26/16:37
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "a";
        String s2=s1+"b";
        String s3="a"+"b";
        System.out.println(s2);//ab
        System.out.println(s2=="ab");//false
        System.out.println(s3=="ab");//true


    }

    public class innerClass{
//        private static  int i;//内部类中不能定义静态变量

        public void get(){
//            private int a =1;
//            final int b;
              class t{//内部类可以在方法外边定义，也可以在方法里边定义,定义在方法内部的类不能有访问权限修饰,
                  //跟局部变量一样.这种内部类对其他类是不可见的其他类无法引用该内部类。

            }

        }
//        private static void set(){ //内部类中不能定义静态方法
//
//        }

    }
}

