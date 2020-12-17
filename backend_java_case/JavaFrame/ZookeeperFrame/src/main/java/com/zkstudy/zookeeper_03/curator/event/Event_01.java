package com.zkstudy.zookeeper_03.curator.event;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * zookeeper原生支持通过注册Watcher来进行事件监听,但是其使用并不是特别方便,
 * 需要开发人员自己反复注册Watcher,比较繁琐,Curator引入了Cache来实现对ZooKeeper
 * 服务端事件的监听,Cache是Curator中对事件监听的包装,其对事件的监听其实可以近似看作是一个
 * 本地缓存视图和远程zookeeper视图的对比过程,同时Curator能够自动为开发人员处理反复注册监听,从而大大
 * 简化原生API开发的繁琐的过程,Cache分为两类监听类型:节点监听和子节点监听
 * @author yangzuliang
 *
 */
public class Event_01 {

	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
    		.retryPolicy(retryPolicy).build();
    
    /**
     * NodeCache用于监听指定ZooKeeper数据节点本身的变化,当数据节点的内容发生变化的时候,
     * 就会回调该方法
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
		client.start();
		String path = "/zkclient-test/curator";
		client.create().creatingParentsIfNeeded()
		.withMode(CreateMode.EPHEMERAL).forPath(path, "curator_01".getBytes());
		//client:curator客户端实例; path:节点路径; dataIsCompressed:是否进行数据压缩
		final NodeCache cache = new NodeCache(client, path, false);
		//默认是false,设置true,那么NodeCache在第一次启动的时候就会立刻从zookeeper上读取对应
		//节点的数据内容,并保存在Cache中,NodeCache也能监听节点是否存在,如果原本节点不存在,那么Cache
		//就会在节点被创建后触发NodeCacheListener,但是如果该数据节点被删除,那么Curator就无法触发NodeCacheListener
		cache.start(true);
		cache.getListenable().addListener(new NodeCacheListener() {
			
			public void nodeChanged() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Node data update, new data: " + new String(cache.getCurrentData().getData()));
			}
		});
		
		client.setData().forPath(path, "u".getBytes());
		Thread.sleep(1000);
		client.delete().deletingChildrenIfNeeded().forPath(path);
		Thread.sleep(Integer.MAX_VALUE);
	}
}
