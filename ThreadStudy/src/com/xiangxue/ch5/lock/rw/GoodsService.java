package com.xiangxue.ch5.lock.rw;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *更多课程咨询 安生老师 QQ：669100976  VIP课程咨询 依娜老师  QQ：2470523467
 *
 *类说明：商品相关服务的接口
 */
public interface GoodsService {

	public GoodsInfo getNum();
	public void setNum(int number);
}
