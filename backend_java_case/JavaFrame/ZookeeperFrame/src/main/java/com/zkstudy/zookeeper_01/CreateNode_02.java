package com.zkstudy.zookeeper_01;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * �첽�����ڵ�(��������ͨ�źͷ���˵Ľڵ㴴�����̶����첽��)
 *  ��ͬ���ӿڵ��ù�����,������Ҫ��ע�ӿ��׳��쳣�Ŀ���,�������첽�ӿ���,�ӿڱ����ǲ������쳣��
 *  ���е��쳣�����ڻص�������ͨ��Result Code(��Ӧ��)������
 * @author yangzuliang
 *
 */
public class CreateNode_02 implements Watcher {

	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {

		ZooKeeper zooKeeper = new ZooKeeper("192.168.1.96:2181", 5000, new CreateNode_02());
		connectedSemaphore.await();
		zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
				new IStringCallBack(), "i am context.");
		zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
				new IStringCallBack(), "i am context.");
		zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,
				new IStringCallBack(), "i am context.");
		Thread.sleep(Integer.MAX_VALUE);
	}

	public void process(WatchedEvent event) {
		if(KeeperState.SyncConnected == event.getState()){
			connectedSemaphore.countDown();
		}
	}
}

class IStringCallBack implements AsyncCallback.StringCallback {

	/**
	 * rc : Result Code�������Ӧ��
	 *      0:�ӿڵ��óɹ�;-4�ͻ��˺ͷ���������ѶϿ�;-110:ָ���ڵ��Ѵ���;-112:�Ự�ѹ���
	 * path : �ӿڵ���ʱ����API�����ݽڵ�Ľڵ�·������
	 * ctx : �ӿڵ���ʱ����API��ctx����ֵ
	 * name : ʵ���ڷ���˴����Ľڵ���
	 */
	public void processResult(int rc, String path, Object ctx, String name) {
		System.out.println("Create path result :[" + rc + "," + path + "," + ctx + ",real path name:" + name);
	}
}
