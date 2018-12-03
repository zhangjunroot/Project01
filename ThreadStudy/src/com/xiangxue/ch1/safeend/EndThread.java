package com.xiangxue.ch1.safeend;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *更多课程咨询 安生老师 QQ：669100976  VIP课程咨询 依娜老师  QQ：2470523467
 *
 *类说明：如何安全中断线程
 */
public class EndThread {
	
	private static class UseThread extends Thread{
		
		public UseThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			while(!isInterrupted()) {//改为true，线程不会中断;改为Thread.interrupted()，标志位被复位
				System.out.println(Thread.currentThread().getName()
						+ " I am extends Thread.");
			}
			System.out.println(Thread.currentThread().getName()
					+" interrupt flag is "+isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread("endThread");
		endThread.start();
		endThread.interrupt();
		Thread.sleep(9000);//
		System.out.println(123);


	}

}
