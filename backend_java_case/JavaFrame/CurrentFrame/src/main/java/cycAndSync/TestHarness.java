package cycAndSync;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

	public long timeTasks(int nThreads, final Runnable task) throws InterruptedException{
		
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		
		for(int i=0; i<nThreads; i++){
			
			Thread t = new Thread(){
				
				public void run(){
					
					try {
						
						startGate.await();
						try {
							task.run();
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							endGate.countDown();
						}
					} catch (Exception e) {
						
					}
				}
			};
			t.start();
		}
		
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return end - start;
	}
}
