package com.thread.chapter_07;

class ThreadA extends Thread{
	
	public void run(){
		try {
			while(!Thread.currentThread().isInterrupted()){
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ThreadB extends Thread{
	
	public void run(){
		try {
			while(!Thread.currentThread().isInterrupted()){
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 现场对象关联线程组:1级关联(父对象中有子对象,但并不创建子孙对象)
 * @author yangzuliang
 *
 */
public class Ex_05_Group {

	public static void main(String[] args) {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		ThreadGroup group = new ThreadGroup("yzl's group");
		Thread aThread = new Thread(group, a);
		Thread bThread = new Thread(group, b);
		aThread.start();
		bThread.start();
		System.out.println("活动现场数为: " + group.activeCount());
		System.out.println("线程组的名称: " + group.getName());
	}
}
