package com.zkstudy.zookeeper_03.curator.util;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.ZooKeeper;

/**
 * 工具类ZKPaths使用示例
 * @author yangzuliang
 *
 */
public class ZKPaths_Sample {

	static String path = "/curator_zkpath_sample";
	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").retryPolicy(new ExponentialBackoffRetry(1000, 3))
    		.retryPolicy(retryPolicy).build();
    
    public static void main(String[] args) throws Exception {
    	client.start();
    	ZooKeeper zooKeeper = client.getZookeeperClient().getZooKeeper();
	    System.out.println(ZKPaths.fixForNamespace(path, "sub"));
	    System.out.println(ZKPaths.makePath(path, "sub"));
	    System.out.println(ZKPaths.getNodeFromPath("/curator_zkpath_sample/sub1"));
    }
}
