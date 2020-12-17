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
		 path:需要创建的数据节点的节点路径,例如:/zk-book/foo
		 data[]:一个字节数组,是节点创建后的初始内容
		 acl:节点的ACL策略
		 createMode: 节点类型,是一个枚举类型,通常有四种可选的节点类型
		    1.持久;2.持久顺序;3.临时;4.临时顺序
		  cb:注册一个异步回调函数,开发人员需要实现StringCallback接口,主要是对下面这个方法的重写:
		    void processResult(int rc, String path, Object ctx, String name);
		           当服务端节点的创建完毕后,ZooKeeper客户端就会自动调用这个方法,这样就可以处理相关的业务逻辑了
		  ctx:用于传递一个对象,可以在回调方法执行的时候使用,通常是放一个上下文(Context)信息
       */
		//创建了临时节点,API的返回值就是当时传入的path
		String path1 = zk.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		//创建了临时顺序节点,那么ZooKeeper会自动在节点后缀加上一个数字,并在API接口的返回值中返回该数据节点的一个完整的节点路径
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
