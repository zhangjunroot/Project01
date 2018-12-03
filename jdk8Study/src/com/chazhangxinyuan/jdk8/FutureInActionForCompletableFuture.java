package com.chazhangxinyuan.jdk8;

/**
 * @author zhangjun
 * @create 2018/11/30/15:56
 */
public class FutureInActionForCompletableFuture {

    public static void main(String[] args) {

        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(10000);
                return "I am finished";
            } catch (InterruptedException e) {
                return "I am error";
            }
        });

        future.setCompletable(new Completable<String>() {
            @Override
            public void complete(String s) {
                System.out.println(s);
            }

            @Override
            public void exception(Throwable cause) {
                cause.printStackTrace();
            }
        });
    }

    /**
     * future的方式达到异步的效果，提高程序的运行效率
     * @param callable
     * @param <T>
     * @return
     */
    private static <T> Future<T> invoke(Callable<T> callable){


        Future<T> future = new Future<T>() {

            private Completable<T> completable;

            @Override
            public void setCompletable(Completable<T> completable) {
                this.completable=completable;
            }

            @Override
            public Completable<T> getCompletable() {
                return completable;
            }
        };

        Thread t = new Thread(()->{
            try{
                T value = callable.action();
                if(future.getCompletable()!=null) future.getCompletable().complete(value);
            }catch (Throwable cause){
                if(future.getCompletable()!=null) future.getCompletable().exception(cause);
            }


        });
        t.start();

        return future;
    }

    private interface Future<T>{

        void setCompletable(Completable<T> completable);
        Completable<T> getCompletable();
    }

    private interface Callable<T>{
        //返回一个动作
        T action();
    }

    /**
     * 线程执行完成之后通知，不用我们再自己主动去调用了
     * @param <T>
     */
    private interface Completable<T>{

        //通知完成
        void complete(T t);
        //通知异常
        void exception(Throwable cause);
    }
}
