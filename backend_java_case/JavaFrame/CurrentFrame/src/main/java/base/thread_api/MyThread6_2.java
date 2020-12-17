package base.thread_api;

import java.util.Random;

public class MyThread6_2 extends Thread {
	
	public void run() {

		long beginTime = System.currentTimeMillis();
		long addResult = 0;

		for (int j = 0; j < 10; j++) {

			for (int i = 0; i < 5000; i++) {

				Random random = new Random();
				random.nextInt();
				addResult = addResult + 1;
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("---2---ÓÃÊ± : " + (endTime - beginTime));
	}
}
