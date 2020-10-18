package cycAndSync;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 *
 */
public class Work implements Runnable{

	private CountDownLatch downLatch;
	private String name;
	
	public Work(CountDownLatch downLatch, String name){
		this.downLatch= downLatch;
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.doWork();
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.name + "活干完了");
		this.downLatch.countDown();
	}
	
	private void doWork(){
		System.out.println(this.name + "正在干活");
	}

}
