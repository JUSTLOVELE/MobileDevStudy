package cycAndSync;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *栅栏
 *  栅栏类似于闭锁，它能阻塞一组线程直到某个事件发生。 栅栏与闭锁的关键区别在于，所有的线程必须同时到
 *达栅栏位置，才能继续执行。闭锁用于等待事件，而栅栏用于等待其他线程.
 *  场景： 应用一些协议，比如几个家庭成员决定在某个地方集合，所有人在6：00在某地集合，到了以后要等待
 *其他人，之后才能讨论去哪里吃饭。 并行迭代，将一个问题分成很多子问题，当一系列的子问题都解决之后其他人，
 *之后才能讨论去哪里吃饭。 并行迭代，将一个问题分成很多子问题，当一系列的子问题都解决之后
 * @author Administrator
 *
 */
public class CycTest {

	public static void main(String[] args) {
		ExecutorService executorService  = Executors.newFixedThreadPool(3);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		CycWork c1 = new CycWork(cyclicBarrier, "张三");
		CycWork c2 = new CycWork(cyclicBarrier, "李四");
		CycWork c3 = new CycWork(cyclicBarrier, "王五");
		executorService.execute(c1);
		executorService.execute(c2);
		executorService.execute(c3);
		executorService.shutdown();
	}
}
