package com.thread.chapter_07;

/**
 * NEW : 线程实例化还未执行start()的状态
 * RUNNABLE:线程进入运行的状态
 * TERMINATED:线程被销毁时的状态
 * @author yangzuliang
 *
 */
public class Ex_01_State extends Thread{

	public Ex_01_State(){
		System.out.println("构造方法中的状态:" + Thread.currentThread().getState());
	}
	
	public void run(){
		System.out.println("run方法中的状态:" + Thread.currentThread().getState());
	}
	
	public static void main(String[] args) {
		
		try {
			Ex_01_State t = new Ex_01_State();
			System.out.println("main中的状态:" + t.getState());
			Thread.sleep(1000);
			t.start();
			Thread.sleep(1000);
			System.out.println("main中的状态2" + t.getState());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
