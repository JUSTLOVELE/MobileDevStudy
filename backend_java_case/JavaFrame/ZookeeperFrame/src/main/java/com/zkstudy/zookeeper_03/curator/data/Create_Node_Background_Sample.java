package com.zkstudy.zookeeper_03.curator.data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * 使用Curator的异步接口
 * @author yangzuliang
 *
 */
public class Create_Node_Background_Sample {

	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
    		.retryPolicy(retryPolicy).build();
    static CountDownLatch semaphore = new CountDownLatch(2);
    static ExecutorService tp = Executors.newFixedThreadPool(2);
    
    public static void main(String[] args) throws Exception{
    	client.start();
    	String path = "/zkclient-test/curator";
    	System.out.println("Main thread: " + Thread.currentThread().getName());
    	client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
			
			public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("event[code: " + event.getResultCode() + ", type: " + event.getType() + "]");
			    System.out.println("Thread of processResult: " + Thread.currentThread().getName() );
			    semaphore.countDown();
			}
		}, tp).forPath(path, "inti".getBytes());
    	semaphore.await();//阻塞方法直到计数器为0
    	tp.shutdown();
	}
}
