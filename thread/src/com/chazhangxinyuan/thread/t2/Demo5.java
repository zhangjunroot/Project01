package com.chazhangxinyuan.thread.t2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 * @author zhangjun
 * @create 2018/12/04/16:56
 */
public class Demo5 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //每隔一秒执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //完成定时任务的业务
                System.out.println("timertask is run");
            }
        },0,1000);
    }
}
