package cycAndSync;

import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable {

	private CountDownLatch downLatch;
	
	public Boss(CountDownLatch downLatch){
		this.downLatch = downLatch;
	}
	
	@Override
	public void run() {
		System.out.println("老板正在等待所有的工人干完活");
		try {
			this.downLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("工人活都干完了,老板开始检查了");
	}

}
