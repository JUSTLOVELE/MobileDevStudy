package base.thread_api;

/**
 * 共享变量: 多个线程公用一个实例
 * synchronize可以在任意对象及方法上枷锁,枷锁的 这段代码
 * 称为互斥区或临界区
 * @author yangzuliang
 * 
 */
public class MyThread2 extends Thread {

	private int count = 5;

	public static void main(String[] args) {

		MyThread2 myThread2 = new MyThread2();
		Thread a = new Thread(myThread2, "A");
		Thread b = new Thread(myThread2, "B");
		Thread c = new Thread(myThread2, "C");
		Thread d = new Thread(myThread2, "D");
		Thread e = new Thread(myThread2, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}

	/**
	 * 加锁后强制同步
	 */
	public synchronized void run() {

		super.run();
		count--;
		System.out.println("由" + this.currentThread().getName() + "计算,count = " + count);
	}

	/**
	 * 线程乱入
	 */
	/*public void run() {

		super.run();
		count--;
		System.out.println("由" + this.currentThread().getName() + "计算,count = " + count);
	}*/
}
