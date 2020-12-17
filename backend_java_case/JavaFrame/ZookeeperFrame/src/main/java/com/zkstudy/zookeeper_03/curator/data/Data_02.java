package com.zkstudy.zookeeper_03.curator.data;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class Data_02 {

	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
    		.retryPolicy(retryPolicy).build();
	
	
	public static void main(String[] args) throws Exception {
		client.start();
		String path = "/zkclient-test/curator";
		client.create().creatingParentsIfNeeded()
		.withMode(CreateMode.EPHEMERAL).forPath(path, "curator_01".getBytes());
		Stat stat = new Stat();
		byte[] b = client.getData().storingStatIn(stat).forPath(path);
		String s1 = new String(b);
		System.out.println(s1);
		client.setData().forPath(path, "curator_01_test".getBytes());
		b = client.getData().storingStatIn(stat).forPath(path);
		s1 = new String(b);
		System.out.println(s1);
	}
}
