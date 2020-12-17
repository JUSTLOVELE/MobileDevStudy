package base.thread_api;

/**
 * sleep中中断会抛出异常
 * @author yangzuliang
 *
 */
public class MyThread8 extends Thread {

	public static void main(String[] args) {
		try {
			MyThread8 thread = new MyThread8();
			thread.start();
			Thread.sleep(200);
			thread.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
	
	public void run(){
		super.run();
		try {
			System.out.println("run begin");
			Thread.sleep(200000);
			System.out.println("run end");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sleep stop!" + this.isInterrupted());
		    e.printStackTrace();
		}
	}
}
