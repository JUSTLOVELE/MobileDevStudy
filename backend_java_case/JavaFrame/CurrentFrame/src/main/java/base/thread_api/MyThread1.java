package base.thread_api;

/**
 * �̲߳��������
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
			System.out.println("��" + this.currentThread().getName() + "����,count = " + count);
		}
	}

	/**
	 * �̲߳��������,���ʵ��ǲ�ͬ��ʵ�� ���ﴴ����������ͬ���߳�,ÿ���̶߳����Լ���count����
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
