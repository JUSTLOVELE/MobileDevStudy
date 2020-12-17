package com.thread.chapter_06;

/**
 * Ex_01_Lazy�������:DCL,˫�ؼ��������
 * DCLҲ�Ǵ�������߳̽�ϵ���ģʽʹ�õĽ������
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
				//ģ���ڴ�������֮ǰ��һЩ׼������
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
