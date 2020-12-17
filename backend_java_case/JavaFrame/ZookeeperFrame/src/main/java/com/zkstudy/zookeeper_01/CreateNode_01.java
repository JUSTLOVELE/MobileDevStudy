package com.zkstudy.zookeeper_01;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class CreateNode_01 implements Watcher{
	
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
	
	
	public static ZooKeeper create() throws Exception{
		
		ZooKeeper zk = new ZooKeeper("192.168.1.96:2181", 5000, new CreateNode_01());
		String path = zk.create("/zk-test-", "user-yzl".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println("path = " + path);
		return zk;
	}
	

	public static void main(String[] args) throws Exception {
		
		ZooKeeper zk = new ZooKeeper("192.168.1.96:2181", 5000, new CreateNode_01());
		connectedSemaphore.await();
		/*
		 path:��Ҫ���������ݽڵ�Ľڵ�·��,����:/zk-book/foo
		 data[]:һ���ֽ�����,�ǽڵ㴴����ĳ�ʼ����
		 acl:�ڵ��ACL����
		 createMode: �ڵ�����,��һ��ö������,ͨ�������ֿ�ѡ�Ľڵ�����
		    1.�־�;2.�־�˳��;3.��ʱ;4.��ʱ˳��
		  cb:ע��һ���첽�ص�����,������Ա��Ҫʵ��StringCallback�ӿ�,��Ҫ�Ƕ����������������д:
		    void processResult(int rc, String path, Object ctx, String name);
		           ������˽ڵ�Ĵ�����Ϻ�,ZooKeeper�ͻ��˾ͻ��Զ������������,�����Ϳ��Դ�����ص�ҵ���߼���
		  ctx:���ڴ���һ������,�����ڻص�����ִ�е�ʱ��ʹ��,ͨ���Ƿ�һ��������(Context)��Ϣ
       */
		//��������ʱ�ڵ�,API�ķ���ֵ���ǵ�ʱ�����path
		String path1 = zk.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		//��������ʱ˳��ڵ�,��ôZooKeeper���Զ��ڽڵ��׺����һ������,����API�ӿڵķ���ֵ�з��ظ����ݽڵ��һ�������Ľڵ�·��
	    String path2 = zk.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
	    System.out.println("path1 = " + path1);
	    System.out.println("path2 = " + path2);
	}

	public void process(WatchedEvent arg0) {
		System.out.println("receive watched event:" + arg0);
		if(KeeperState.SyncConnected == arg0.getState()){
			connectedSemaphore.countDown();
		}
	}
}
