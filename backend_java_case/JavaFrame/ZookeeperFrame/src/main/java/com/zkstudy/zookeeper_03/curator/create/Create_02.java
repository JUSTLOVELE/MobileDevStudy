package com.zkstudy.zookeeper_03.curator.create;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Create_02 {

	
	public static void main(String[] args) throws Exception{
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
	    CuratorFramework client = CuratorFrameworkFactory.builder()
	    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
	    		.retryPolicy(retryPolicy).build();
	    client.start();
	    Thread.sleep(Integer.MAX_VALUE);
	}
	
	/**
	 * 为了实现不同的ZooKeeper业务之间的隔离,往往会为每个业务
	 * 分配一个独立的命名空间,即指定一个ZooKeeper根路径,例如下面
	 * 定义了某个客户端的独立命名空间为/base,那么该客户端对ZooKeeper上
	 * 数据节点的任何操作都是基于该相对目录进行的
	 */
	public void create(){
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
	    CuratorFramework client = CuratorFrameworkFactory.builder()
	    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
	    		.namespace("base")
	    		.retryPolicy(retryPolicy).build();
	}
}
