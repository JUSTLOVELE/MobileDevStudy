package cycAndSync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *闭锁:
 *   一种同步方法，可以延迟线程的进度直到线程到达某个终点状态。
 *通俗的讲就是，一个闭锁相当于一扇大门，在大门打开之前所有线程都被阻断，
 *一旦大门打开所有线程都将通过，但是一旦大门打开，所有线程都通过了，那么
 *这个闭锁的状态就失效了，门的状态也就不能变了，只能是打开状态。也就是说
 *闭锁的状态是一次性的，它确保在闭锁打开之前所有特定的活动都需要在闭锁打
 *开之后才能完成
 * 应用场景:
 *   1.确保某个计算在其需要的所有资源都被初始化之后才继续执行。二元闭锁（包括
 *两个状态）可以用来表示“资源R已经被初始化”，而所有需要R的操作都必须先
 *在这个闭锁上等待。
 *   2.确保某个服务在其依赖的所有其他服务都已经启动之后才启动。
 *   3.等待直到某个操作的所有参与者都就绪在继续执行。（例如：多人游戏中需要所有玩家准备才能开始）
 *CountDownLatch是JDK 5+里面闭锁的一个实现，允许一个或者多个线程等待某个事件的发生。
 *CountDownLatch有一个正数计数器，
 *countDown方法对计数器做减操作，
 *await方法等待计数器达到0。所有await的线程都会阻塞直到计数器为0或者等待线程中断或者超时。
 * @author Administrator
 *
 */
public class TestLatch {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(3);
		Work w1 = new Work(latch, "张三");
		Work w2 = new Work(latch, "李四");
		Work w3 = new Work(latch, "王五");
		
		Boss boss = new Boss(latch);
		
		executorService.execute(w3);
		executorService.execute(w2);
		executorService.execute(w1);
		executorService.execute(boss);
		executorService.shutdown();
	}
}
