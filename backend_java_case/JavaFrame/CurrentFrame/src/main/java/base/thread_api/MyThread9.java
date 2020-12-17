package base.thread_api;

public class MyThread9 extends Thread{

	public void run(){
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for(int i=0; i<50000000; i++){
			Thread.yield();
			count = count + (i+1);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ÓÃÊ±:" + (endTime - beginTime) + "ºÁÃë!");
	}
	
	public static void main(String[] args) {
		MyThread9 thread = new MyThread9();
		thread.start();
	}
}
