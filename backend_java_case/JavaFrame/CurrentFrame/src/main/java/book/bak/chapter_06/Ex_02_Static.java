package com.thread.chapter_06;

class MyThread02 extends Thread {
	
	public void run(){
		System.out.println(Ex_02_Static.getInstance().hashCode());
	}
}
/**
 * 使用static 也可以实现单例(区别于Ex_01_handler.java模式)
 * @author yangzuliang
 *
 */
public class Ex_02_Static {

	private static Ex_02_Static instance = null;
	
	private Ex_02_Static(){
		
	}
	static {
		instance = new Ex_02_Static();
	}
	
	public static Ex_02_Static getInstance(){
		return instance;
	}
	
	public static void main(String[] args) {
		MyThread02 t1 = new MyThread02();
		MyThread02 t2 = new MyThread02();
		MyThread02 t3 = new MyThread02();
		t1.start();
		t2.start();
		t3.start();
	}
	
}
