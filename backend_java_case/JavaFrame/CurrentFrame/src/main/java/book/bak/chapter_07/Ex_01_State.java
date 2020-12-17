package com.thread.chapter_07;

/**
 * NEW : �߳�ʵ������δִ��start()��״̬
 * RUNNABLE:�߳̽������е�״̬
 * TERMINATED:�̱߳�����ʱ��״̬
 * @author yangzuliang
 *
 */
public class Ex_01_State extends Thread{

	public Ex_01_State(){
		System.out.println("���췽���е�״̬:" + Thread.currentThread().getState());
	}
	
	public void run(){
		System.out.println("run�����е�״̬:" + Thread.currentThread().getState());
	}
	
	public static void main(String[] args) {
		
		try {
			Ex_01_State t = new Ex_01_State();
			System.out.println("main�е�״̬:" + t.getState());
			Thread.sleep(1000);
			t.start();
			Thread.sleep(1000);
			System.out.println("main�е�״̬2" + t.getState());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
