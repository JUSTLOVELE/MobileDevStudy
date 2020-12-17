package com.zkstudy.zookeeper_03.curator.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * �ֲ�ʽBarrier
 *  Barrier��һ���������ƶ��߳�֮��ͬ���ľ��䷽ʽ
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
					    System.out.println(Thread.currentThread().getName() + " ��barrier����");
					    barrier2.setBarrier();//���Barrier����
					    barrier2.waitOnBarrier();//�ȴ��ͷ�
					    System.out.println("����...");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		Thread.sleep(2000);
		barrier2.removeBarrier();//�ͷ�Barrier,ͬʱ�������еȴ���Barrier��5���߳�ͬʱ���и��Ե�ҵ���߼�
	}
	
	/**
	 * ʹ��JDK�Դ���CyclicBarrierʵ�ֵ����ܱ���,���Կ������߳��ڲ�������¶���׼ȷ
	 * �ĵȴ������̶߳����ھ���״̬��ſ�ʼͬʱִ������ҵ��
	 * @throws Exception
	 */
	public void jdkMethod() throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(new Thread(new Runner("1��ѡ��")));
		executor.submit(new Thread(new Runner("2��ѡ��")));
		executor.submit(new Thread(new Runner("3��ѡ��")));
		executor.shutdown();
	}
	
	class Runner implements Runnable{
		private String name;
		public Runner(String name){
			this.name = name;
		}
		public void run() {
			System.out.println(name + "׼������.");
			try {
				Lock_03.barrier.await();
				System.out.println(name + "��ʼ");
			} catch (Exception e) {
				System.out.println(name + "����!");
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
