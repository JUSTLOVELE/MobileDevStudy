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
	 * Ϊ��ʵ�ֲ�ͬ��ZooKeeperҵ��֮��ĸ���,������Ϊÿ��ҵ��
	 * ����һ�������������ռ�,��ָ��һ��ZooKeeper��·��,��������
	 * ������ĳ���ͻ��˵Ķ��������ռ�Ϊ/base,��ô�ÿͻ��˶�ZooKeeper��
	 * ���ݽڵ���κβ������ǻ��ڸ����Ŀ¼���е�
	 */
	public void create(){
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
	    CuratorFramework client = CuratorFrameworkFactory.builder()
	    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
	    		.namespace("base")
	    		.retryPolicy(retryPolicy).build();
	}
}
