package base.thread_api;

/**
 * 线程不共享变量
 * @author yangzuliang
 *
 */
public class MyThread1 extends Thread {

	private int count = 5;

	public static void main(String[] args) {

		execute();
	}

	public MyThread1(String name) {

		super();
		this.setName(name);
	}

	public void run() {

		super.run();
		while (count > 0) {
			count--;
			System.out.println("由" + this.currentThread().getName() + "计算,count = " + count);
		}
	}

	/**
	 * 线程不共享变量,访问的是不同的实例 这里创建了三个不同的线程,每个线程都有自己的count变量
	 */
	public static void execute() {

		MyThread1 a = new MyThread1("A");
		MyThread1 b = new MyThread1("B");
		MyThread1 c = new MyThread1("C");
		a.start();
		b.start();
		c.start();
	}
}
