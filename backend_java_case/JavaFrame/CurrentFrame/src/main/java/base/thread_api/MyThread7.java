package base.thread_api;

/**
 * java线程中有两种线程,一种是用户线程,另一种守护线程,守护线程是一种特殊的线程,
 * 当进程中不存在非守护线程,则守护线程自动销毁,例如垃圾回收线程
 * @author yangzuliang
 *
 */
public class MyThread7 extends Thread{

	private int i=0;
	
	public void run() {
		
		try {
			
			while(true){
				i++;
				System.out.println("i=" + i);
				Thread.sleep(1000);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			MyThread7 thread7 = new MyThread7();
			thread7.setDaemon(true);
			thread7.start();
			Thread.sleep(5000);
			System.out.println("我离开thread对象也不再打印了,也就是停止了");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
