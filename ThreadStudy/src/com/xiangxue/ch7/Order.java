package com.xiangxue.ch7;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *更多课程咨询 安生老师 QQ：669100976  VIP课程咨询 依娜老师  QQ：2470523467
 *
 *类说明：订单的实体类
 */
public class Order {
	private final String orderNo;
	private final double orderMoney;
	
	public Order(String orderNo, double orderMoney) {
		super();
		this.orderNo = orderNo;
		this.orderMoney = orderMoney;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public double getOrderMoney() {
		return orderMoney;
	}
	
	
	
}
