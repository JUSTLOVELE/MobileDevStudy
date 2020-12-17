package com.thread.chapter_06;

/**
 * Ex_01_Lazy解决方案:DCL,双重检查锁功能
 * DCL也是大多数多线程结合单利模式使用的解决方案
 * @author yangzuliang
 *
 */

class MyThread1 extends Thread {
	
	public void run(){
		System.out.println(Ex_01_handler.getInstance().hashCode());
	}
}

public class Ex_01_handler {


	private volatile static Ex_01_handler ex_01_handler;
	
	private Ex_01_handler(){}
	
	public static Ex_01_handler getInstance(){
		try {
			if(ex_01_handler != null){
				
			}else{
				//模拟在创建对象之前做一些准备工作
				Thread.sleep(3000);
				synchronized (Ex_01_handler.class) {
					if(ex_01_handler == null){
						ex_01_handler = new Ex_01_handler();
					}
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ex_01_handler;
	}
	
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread1 t2 = new MyThread1();
		MyThread1 t3 = new MyThread1();
		t1.start();
		t2.start();
		t3.start();
		
	}

}
