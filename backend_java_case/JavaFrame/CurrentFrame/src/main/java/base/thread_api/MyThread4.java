package base.thread_api;

/**
 * sleep的作用是在指定的毫秒数内让当前正在执行的线程休眠
 * 
 * @author yangzuliang
 * 
 */
public class MyThread4 extends Thread {

	public void run() {

		try {
			System.out.println("run beigin");
			System.out.println("this.currentThread().getName()" + this.currentThread().getName());
			Thread.sleep(2000);
			System.out.println("this.currentThread().getName()" + this.currentThread().getName());
			System.out.println("run end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		MyThread4 myThread4 = new MyThread4();
		System.out.println("begin = " + System.currentTimeMillis());
		myThread4.run();
		System.out.println("end = " +System.currentTimeMillis() );
	}
}
