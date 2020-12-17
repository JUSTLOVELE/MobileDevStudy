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
 * zookeeperԭ��֧��ͨ��ע��Watcher�������¼�����,������ʹ�ò������ر𷽱�,
 * ��Ҫ������Ա�Լ�����ע��Watcher,�ȽϷ���,Curator������Cache��ʵ�ֶ�ZooKeeper
 * ������¼��ļ���,Cache��Curator�ж��¼������İ�װ,����¼��ļ�����ʵ���Խ��ƿ�����һ��
 * ���ػ�����ͼ��Զ��zookeeper��ͼ�ĶԱȹ���,ͬʱCurator�ܹ��Զ�Ϊ������Ա������ע�����,�Ӷ����
 * ��ԭ��API�����ķ����Ĺ���,Cache��Ϊ�����������:�ڵ�������ӽڵ����
 * @author yangzuliang
 *
 */
public class Event_01 {

	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
    		.retryPolicy(retryPolicy).build();
    
    /**
     * NodeCache���ڼ���ָ��ZooKeeper���ݽڵ㱾��ı仯,�����ݽڵ�����ݷ����仯��ʱ��,
     * �ͻ�ص��÷���
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
		client.start();
		String path = "/zkclient-test/curator";
		client.create().creatingParentsIfNeeded()
		.withMode(CreateMode.EPHEMERAL).forPath(path, "curator_01".getBytes());
		//client:curator�ͻ���ʵ��; path:�ڵ�·��; dataIsCompressed:�Ƿ��������ѹ��
		final NodeCache cache = new NodeCache(client, path, false);
		//Ĭ����false,����true,��ôNodeCache�ڵ�һ��������ʱ��ͻ����̴�zookeeper�϶�ȡ��Ӧ
		//�ڵ����������,��������Cache��,NodeCacheҲ�ܼ����ڵ��Ƿ����,���ԭ���ڵ㲻����,��ôCache
		//�ͻ��ڽڵ㱻�����󴥷�NodeCacheListener,������������ݽڵ㱻ɾ��,��ôCurator���޷�����NodeCacheListener
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
