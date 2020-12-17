package com.thread.chapter_07;

/**
 * TIMED_WAITING : ��ʾ�߳�ִ����Thread.sleep()����,�ʵȴ�״̬
 * @author yangzuliang
 *
 */
public class Ex_02_State extends Thread{

	public void run(){
		try {
			System.out.println("begin sleep");
			Thread.sleep(10000);
			System.out.println(" end sleep");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Ex_02_State t = new Ex_02_State();
			t.start();
			Thread.sleep(1000);
			System.out.println("main�����е�״̬:" + t.getState());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
