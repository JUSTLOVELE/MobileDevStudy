package base;

public class CountOperate1 extends Thread {

	public CountOperate1() {
		
		System.out.println("CountOperate1 beigin");
		System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
	    System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
		System.out.println("this.getName() = " + this.getName());
		System.out.println("this.isAlive() = " + this.isAlive());
	    System.out.println("CountOperate1 end");
	}
	
	public void run(){

		
		System.out.println("run beigin");
		System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
	    System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
		System.out.println("this.getName() = " + this.getName());
		System.out.println("this.isAlive() = " + this.isAlive());
	    System.out.println("run end");
	}
	
	public static void main(String[] args) {
		
		CountOperate1 c = new CountOperate1();
		Thread t1 = new Thread(c);
		System.out.println("main begin t1 isAlive : " + t1.isAlive());
		t1.setName("A");
		t1.start();
		System.out.println("main end t1 isAlive : " + t1.isAlive());
	}
}
