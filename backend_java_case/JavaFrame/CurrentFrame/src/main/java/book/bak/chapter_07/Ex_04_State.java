package com.thread.chapter_07;

class Lock{
	public static final Byte lock = new Byte("0");
}

/**
 * WAITING : ִ��wait����
 * @author yangzuliang
 *
 */
public class Ex_04_State extends Thread{
	
	public void run(){
		try {
			synchronized (Lock.lock) {
				Lock.lock.wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Ex_04_State t = new Ex_04_State();
			t.start();
			Thread.sleep(1000);
			System.out.println("main�����е�t״̬:" + t.getState());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
