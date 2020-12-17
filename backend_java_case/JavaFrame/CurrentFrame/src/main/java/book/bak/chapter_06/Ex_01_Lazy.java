package com.thread.chapter_06;

/**
 * ����ģʽ
 * ִ��main֮��������������ģʽʧЧ��,
 * ��Ȼ���Լ���synchronized�ؼ���,���˷�������Ч�ʵ�
 * @author yangzuliang
 *
 */

class MyThrad extends Thread {
	
	public void run(){
		System.out.println(Ex_01_Lazy.getInstance().hashCode());
	}
}

public class Ex_01_Lazy {

	private static Ex_01_Lazy ex_01_Lazy;
	
	private Ex_01_Lazy(){}
	
	public static Ex_01_Lazy getInstance(){
		try {
			if(ex_01_Lazy != null){
				
			}else{
				//ģ���ڴ�������֮ǰ��һЩ׼������
				Thread.sleep(3000);
				ex_01_Lazy = new Ex_01_Lazy();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ex_01_Lazy;
	}
	
	public static void main(String[] args) {
		MyThrad t1 = new MyThrad();
		MyThrad t2 = new MyThrad();
		MyThrad t3 = new MyThrad();
		t1.start();
		t2.start();
		t3.start();
		
	}
}
