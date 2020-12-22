package base.thread_api;

import java.util.Random;

/**
 *   高优先级的线程总是大部分先执行完,但不代表高优先级的线程全部执行完
 *   不要以为MyThread1线程先被main线程所调用就会先执行完,出现这样的结果,全市已因为
 * MyThread6线程的优先级是最高值为10造成的
 *   当线程优先级的差距很大时,谁先执行完和代码的调用顺序无关,具有随机性
 * @author yangzuliang
 *
 */
public class MyThread6 extends Thread {

	public void run(){
		
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		
		for(int j=0; j<10; j++){
			
			for(int i=0; i<5000; i++){
				
				Random random = new Random();
				random.nextInt();
				addResult = addResult + 1;
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("***1***用时 : " + (endTime - beginTime));
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++){
			
			MyThread6 myThread6 = new MyThread6();
			myThread6.setPriority(10);
			myThread6.start();
			
			MyThread6_2 myThread6_2 = new MyThread6_2();
			myThread6_2.setPriority(1);
			myThread6_2.start();
		}
	}
}
