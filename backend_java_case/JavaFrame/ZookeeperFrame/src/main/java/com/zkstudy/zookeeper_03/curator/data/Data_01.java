package com.zkstudy.zookeeper_03.curator.data;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class Data_01 {

	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
    		.retryPolicy(retryPolicy).build();
	
	public static void main(String[] args) throws Exception {
		
		client.start();
		String path = "/zkclient-test/curator";
		client.create().creatingParentsIfNeeded()
		.withMode(CreateMode.EPHEMERAL).forPath(path, "curator_01".getBytes());
		//读取一个节点的数据内容
		/*byte[] b = client.getData().forPath(path);
		String s1 = new String(b);
		System.out.println(s1);*/
		//读取一个节点的数据内容,同时获取到该节点的stat
		Stat stat = new Stat();
		byte[] b = client.getData().storingStatIn(stat).forPath(path);
		String s1 = new String(b);
		System.out.println(s1);
	}
}
