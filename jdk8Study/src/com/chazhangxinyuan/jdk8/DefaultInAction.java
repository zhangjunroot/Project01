package com.chazhangxinyuan.jdk8;

/**
 * @author zhangjun
 * @create 2018/11/30/10:26
 */
public class DefaultInAction {

    private interface A{

        int size();

        default boolean isEmpty(){
            return size()==0;
        }

        static String identity() {
            return "123";
        }
    }


    private void confuse(Object o){
        System.out.println("object");

    }
    private void confuse(int[] i){
        System.out.println("int[]");
    }

    public static void main(String[] args) {
       /* A a= ()->10;
        System.out.println(a.size());
        System.out.println(a.isEmpty());*/

       /*DefaultInAction defaultInAction = new DefaultInAction();
       int[] i= null;
       Object o=i;
       defaultInAction.confuse(o);
       defaultInAction.confuse(null);*/


       w s=new t();
       s.hello();
    }

    /**
     * jdk8后接口中的方法不是全部需要实现，default和static方法可以不实现
     */
    private class b implements A{

        @Override
        public int size() {
            return 0;
        }
    }

    private interface w{
        default void hello(){
            System.out.println("w.hello");
        }
    }
    private interface e extends w{
        @Override
        default void hello(){
            System.out.println("e.hello");
        }
    }
    private interface u {
        default void hello(){
            System.out.println("u.hello");
        }
    }
    private static class t implements w,e{

        @Override
        public void hello(){
            System.out.println("t.hello");
        }
    }
//    private static class y implements w,u{
//
//    }
}
