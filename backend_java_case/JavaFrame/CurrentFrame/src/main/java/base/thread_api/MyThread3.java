package base.thread_api;

public class MyThread3 extends Thread {

	public MyThread3(){
		System.out.println("构造方法打印:" + Thread.currentThread());
	}

	public void run(){
		System.out.println("run : " + Thread.currentThread());
	}

	public static void main(String[] args) {
		MyThread3 myThread3 = new MyThread3();
		//Thread-0线程调用
		//myThread3.start();
		//main线程调用
		myThread3.run();
	}

}