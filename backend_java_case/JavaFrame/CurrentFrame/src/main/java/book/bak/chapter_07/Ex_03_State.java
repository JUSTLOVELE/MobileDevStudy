package com.thread.chapter_07;

/**
 * BLOCKED:某一个线程在等待锁的时候
 * @author yangzuliang
 *
 */
class MyThread1 extends Thread{
	public void run(){
		Ex_03_State.serviceMethod();
	}
}

class MyThread2 extends Thread{
	public void run(){
		Ex_03_State.serviceMethod();
	}
}


public class Ex_03_State {

	synchronized static public void serviceMethod(){
		try {
			System.out.println(Thread.currentThread().getName() + "进入业务方法!");
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		t1.setName("a");
		t1.start();
		MyThread2 t2 = new MyThread2();
		t2.setName("b");
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main方法中t2状态:" + t2.getState());
	}
}
