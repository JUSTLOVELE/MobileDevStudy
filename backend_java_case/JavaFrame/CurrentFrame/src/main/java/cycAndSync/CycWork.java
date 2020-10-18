package cycAndSync;

import java.util.concurrent.CyclicBarrier;

public class CycWork implements Runnable{

	private CyclicBarrier cyclicBarrier;
	private String name;
	
	public CycWork(CyclicBarrier cyclicBarrier, String name){
		this.name = name;
		this.cyclicBarrier = cyclicBarrier;
	}
	
	@Override
	public void run() {
		System.out.println("正在打桩,毕竟不轻松....");
		try {
			Thread.sleep(5000);
			System.out.println(name + "不容易,终于把桩打完了");
			//BrokenBarrierException 表示栅栏已经被破坏，破坏的原因可能是其中一个线程 await() 时被中断或者超时
			cyclicBarrier.await();//表示自己已经到达了柵栏的位置了
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(name + ":其他逗比把桩都打完了,又得忙活了");
	}
}
