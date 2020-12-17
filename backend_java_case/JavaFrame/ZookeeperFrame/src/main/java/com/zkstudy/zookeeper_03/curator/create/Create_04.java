package com.zkstudy.zookeeper_03.curator.create;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.EnsurePath;

/**
 * EnsurePath:
 *  �ṩ��һ���ܹ�ȷ�����ݽڵ���ڵĻ���,������������ҵ��:
 *�ϲ�ҵ��ϣ����һ�����ݽڵ����һЩ����,���ǲ���֮ǰ��Ҫȷ���ýڵ����,��Ȼʹ��ZooKeeper
 *��ԭ���ӿ�Ҫȥ���ǽڵ��Ƿ���ڻ��в���������,EnsurePath���ÿ������������Щ���˵�����,
 *����ȡ�˾�Ĭ�Ľڵ㴴����ʽ,���ڲ�ʵ�־�����ͼ����ָ���ڵ�,����ڵ��Ѿ�����,��ô�Ͳ������κ�
 *����,Ҳ�������׳��쳣,���������������ݽڵ�
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
