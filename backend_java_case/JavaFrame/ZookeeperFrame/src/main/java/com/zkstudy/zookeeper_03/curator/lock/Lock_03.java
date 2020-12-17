package com.zkstudy.zookeeper_03.curator.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 分布式Barrier
 *  Barrier是一种用来控制多线程之间同步的经典方式
 * @author yangzuliang
 *
 */
public class Lock_03 {

	public static CyclicBarrier barrier = new CyclicBarrier(3);
	static String barrier_path = "/curator_recipes_barrier_path";
	static DistributedBarrier barrier2;
	
	public static void main(String[] args) throws Exception {
		//new Lock_03().jdkMethod();
		new Lock_03().curMethod();
	}
	
	public void curMethod() throws Exception {
		
		for(int i=0; i<5; i++){
			new Thread(new Runnable() {
				public void run() {
					try {
						CuratorFramework client = CuratorFrameworkFactory.builder().connectString("192.168.1.96:2181").retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
					    client.start();
					    barrier2 = new DistributedBarrier(client, barrier_path);
					    System.out.println(Thread.currentThread().getName() + " 号barrier设置");
					    barrier2.setBarrier();//完成Barrier设置
					    barrier2.waitOnBarrier();//等待释放
					    System.out.println("启动...");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		Thread.sleep(2000);
		barrier2.removeBarrier();//释放Barrier,同时触发所有等待该Barrier的5个线程同时进行各自的业务逻辑
	}
	
	/**
	 * 使用JDK自带的CyclicBarrier实现的赛跑比赛,可以看到多线程在并发情况下都会准确
	 * 的等待所有线程都处于就绪状态后才开始同时执行其他业务
	 * @throws Exception
	 */
	public void jdkMethod() throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(new Thread(new Runner("1号选手")));
		executor.submit(new Thread(new Runner("2号选手")));
		executor.submit(new Thread(new Runner("3号选手")));
		executor.shutdown();
	}
	
	class Runner implements Runnable{
		private String name;
		public Runner(String name){
			this.name = name;
		}
		public void run() {
			System.out.println(name + "准备好了.");
			try {
				Lock_03.barrier.await();
				System.out.println(name + "开始");
			} catch (Exception e) {
				System.out.println(name + "起跑!");
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
