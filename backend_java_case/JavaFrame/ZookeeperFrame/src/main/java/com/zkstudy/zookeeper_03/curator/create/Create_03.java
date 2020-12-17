package com.zkstudy.zookeeper_03.curator.create;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class Create_03 {
	
	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
    		.retryPolicy(retryPolicy).build();

	/**
	 * client.create().forPath(path),如果没有设置节点属性,那么默认创建的是持久节点
	 * 创建一个节点,附带初始内容:
	 * client.create().forPath(path, "init".getBytes())
	 * 创建一个临时节点,初始内容为空
	 * client.create().withMode(CreateMode.EPHEMERAL).forPath(path);
	 *创建一个临时节点,并自动递归创建父节点,ZooKeeper中规定了所有非叶子节点必须为持久节点,调用下面API后只有path参数对应的数据节点是临时节点,其余都是持久节点
	 *client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path);
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		
	    client.start();
	    client.create().creatingParentsIfNeeded()
	    .withMode(CreateMode.EPHEMERAL).forPath("/zkclient-test/test5", "init".getBytes());
	}
}
