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
	 * client.create().forPath(path),���û�����ýڵ�����,��ôĬ�ϴ������ǳ־ýڵ�
	 * ����һ���ڵ�,������ʼ����:
	 * client.create().forPath(path, "init".getBytes())
	 * ����һ����ʱ�ڵ�,��ʼ����Ϊ��
	 * client.create().withMode(CreateMode.EPHEMERAL).forPath(path);
	 *����һ����ʱ�ڵ�,���Զ��ݹ鴴�����ڵ�,ZooKeeper�й涨�����з�Ҷ�ӽڵ����Ϊ�־ýڵ�,��������API��ֻ��path������Ӧ�����ݽڵ�����ʱ�ڵ�,���඼�ǳ־ýڵ�
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
