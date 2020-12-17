package com.zkstudy.zookeeper_03.curator.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 实现分布式锁
 *  在分布式环境中,为了保证数据的一致性,经常在程序的某个运行点,需要进行同步控制.
 *  比如流水号生成,普通的后台应用通常都是使用时间戳方式来生成流水号,但是在用户大
 *会出现并发问题:会出现很多相同的流水号
 * @author yangzuliang
 *
 */
public class Lock_01 {
    static String lock_path = "/curator_recipes_lock_path";
	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").retryPolicy(new ExponentialBackoffRetry(1000, 3))
    		.retryPolicy(retryPolicy).build();
    
    /**
     * 获取锁:
     * public void acquire() throws Exception;
     * 释放锁:
     * public void release() throws Exception;
     * @param args
     */
    public static void main(String[] args) {
		client.start();
		final InterProcessMutex lock = new InterProcessMutex(client, lock_path);
		final CountDownLatch down = new CountDownLatch(1);
		for(int i=0; i<30; i++){
			new Thread(new Runnable() {
				public void run() {
					// TODO Auto-generated method stub
					try {
						down.await();
						lock.acquire();
					} catch (Exception e) {
						e.printStackTrace();
					}
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
					String orderNo = sdf.format(new Date());
					System.out.println("订单号:" + orderNo);
					try {
						lock.release();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		down.countDown();
	}
}
