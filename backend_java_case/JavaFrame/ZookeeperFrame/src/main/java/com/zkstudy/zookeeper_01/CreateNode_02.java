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
 * 异步创建节点(包括网络通信和服务端的节点创建过程都是异步的)
 *  在同步接口调用过程中,我们需要关注接口抛出异常的可能,但是在异步接口中,接口本身是不会抛异常的
 *  所有的异常都会在回调函数中通过Result Code(响应码)来体现
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
	 * rc : Result Code服务端响应码
	 *      0:接口调用成功;-4客户端和服务端连接已断开;-110:指定节点已存在;-112:会话已过期
	 * path : 接口调用时传入API的数据节点的节点路径参数
	 * ctx : 接口调用时传入API的ctx参数值
	 * name : 实际在服务端创建的节点名
	 */
	public void processResult(int rc, String path, Object ctx, String name) {
		System.out.println("Create path result :[" + rc + "," + path + "," + ctx + ",real path name:" + name);
	}
}
