package com.zkstudy.zookeeper_03.curator.create;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.EnsurePath;

/**
 * EnsurePath:
 *  提供了一种能够确保数据节点存在的机制,多用于这样的业务:
 *上层业务希望对一个数据节点进行一些操作,但是操作之前需要确保该节点存在,显然使用ZooKeeper
 *的原生接口要去考虑节点是否存在还有并发的问题,EnsurePath正好可以用来解决这些烦人的问题,
 *它采取了静默的节点创建方式,其内部实现就是试图创建指定节点,如果节点已经存在,那么就不进行任何
 *操作,也不对外抛出异常,否则正常创建数据节点
 * @author yangzuliang
 *
 */
public class Create_04 {
	
	static String path = "/zk-book/c1";
	static CuratorFramework client = CuratorFrameworkFactory.builder()
			.connectString("192.168.1.96:2181")
			.sessionTimeoutMs(5000)
			.retryPolicy(new ExponentialBackoffRetry(1000, 3))
			.build();
	
	public static void main(String[] args) throws Exception{
		client.start();
		client.usingNamespace("zk-book");
		EnsurePath ensurePath = new EnsurePath(path);
		ensurePath.ensure(client.getZookeeperClient());
		ensurePath.ensure(client.getZookeeperClient());
		
		EnsurePath ensurePath2 = client.newNamespaceAwareEnsurePath("/c1");
		ensurePath2.ensure(client.getZookeeperClient());
		
	}

}
