package com.thread.chapter_06;

/**
 * 懒汉模式
 * 执行main之后发现在懒汉单例模式失效了,
 * 当然可以加入synchronized关键字,但此方法运行效率低
 * @author yangzuliang
 *
 */

class MyThrad extends Thread {
	
	public void run(){
		System.out.println(Ex_01_Lazy.getInstance().hashCode());
	}
}

public class Ex_01_Lazy {

	private static Ex_01_Lazy ex_01_Lazy;
	
	private Ex_01_Lazy(){}
	
	public static Ex_01_Lazy getInstance(){
		try {
			if(ex_01_Lazy != null){
				
			}else{
				//模拟在创建对象之前做一些准备工作
				Thread.sleep(3000);
				ex_01_Lazy = new Ex_01_Lazy();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ex_01_Lazy;
	}
	
	public static void main(String[] args) {
		MyThrad t1 = new MyThrad();
		MyThrad t2 = new MyThrad();
		MyThrad t3 = new MyThrad();
		t1.start();
		t2.start();
		t3.start();
		
	}
}
