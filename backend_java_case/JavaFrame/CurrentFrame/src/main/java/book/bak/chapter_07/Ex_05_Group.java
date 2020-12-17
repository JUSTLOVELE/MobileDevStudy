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
 * �ֳ���������߳���:1������(�����������Ӷ���,�����������������)
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
		System.out.println("��ֳ���Ϊ: " + group.activeCount());
		System.out.println("�߳��������: " + group.getName());
	}
}
