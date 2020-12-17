package base.thread_api;

/**
 * 不建议使用Thread.stop()来暂停线程(已废弃)
 * 大多数停止一个线程的操作使用Thread.interrupt(),但这个方法不会终止一个正在运行的线程,还需要加入一个判断才可以完成停止
 * 在java中有三种方法可以终止正在运行得线程:
 *  1.使用退出标志,使线程正常退出,也就是当run完成后
 *  2.使用stop方法强行终止线程,但是不推荐使用,因为stop和suspend及resume一样,都是作废过期的
 *  3.使用interrupt方法中断
 *  
 * interrupted : 测试当前线程是否已经中断,执行后具有将状态标志置清除为false的功能,假若连续两次调用就变为true
 * isInterrupted : 测试线程是否已经中断,但不清除状态标志
 * @author yangzuliang
 *
 */
public class MyThread5 extends Thread{

	public void run(){
		super.run();
		for(int i=0; i< 50000; i++){
			System.out.println("i = " + (i+1));
		}
	}
	
	public static void main(String[] args) {
		run2();
		//run3();
	}
	
	/**
	 * 测试当前线程是否中断,main从未中断过,所以一直是false
	 */
	public static void run3(){
		
		try {
			
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			Thread.sleep(1000);
			myThread5.interrupt();
			System.out.println("是否停止1? = " + myThread5.isInterrupted());
			System.out.println("是否停止2? = " + myThread5.isInterrupted());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 线程的中断状态由该方法清除,换句话说,如果连续两次调用该方法,第二次调用将返回false(在第一次调用已清除了其中断状态之后
	 * 且第二次调用检验完中断状态前,当前线程再次中断的情况除外)
	 */
	public static void run2(){
		
		Thread.currentThread().interrupt();
		System.out.println("是否停止1? = " + Thread.interrupted());
		System.out.println("是否停止2? = " + Thread.interrupted());
		System.out.println("end!");
	}
	
	public static void  run1(){
		
		try {
			
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			Thread.sleep(1000);
			myThread5.interrupt();
			System.out.println("是否停止1? = " + Thread.interrupted());
			System.out.println("是否停止2? = " + Thread.interrupted());
		} catch (Exception e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
}
