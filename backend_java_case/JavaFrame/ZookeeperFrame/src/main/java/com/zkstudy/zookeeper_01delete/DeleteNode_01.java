package com.zkstudy.zookeeper_01delete;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * P110
 * ��zookeeper��,ֻ����ɾ��Ҷ�ӽڵ�,Ҳ����˵���һ���ڵ��������һ���ӽڵ�Ļ�,��ô�ýڵ㽫�޷���ֱ��ɾ��,������ɾ���������ӽڵ�
 * @author yangzuliang
 *
 */
public class DeleteNode_01 implements Watcher{
	
	public static void main(String[] args) throws Exception {
		
		ZooKeeper zooKeeper = new ZooKeeper("192.168.1.96:2181", 5000, new DeleteNode_01());
		//path:ָ�����ݽڵ�Ľڵ�·��,��API���õ�Ŀ����ɾ���ýڵ�
		//version:ָ���ڵ�����ݰ汾,����������ɾ����������Ը����ݰ汾���е�
		//zooKeeper.delete(path, version);
		//cb:ע��һ���첽�ص�����
		//ctx:���ڴ�����������Ϣ�Ķ���
		//zooKeeper.delete(path, version, cb, ctx);
	}

	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		
	}

}
