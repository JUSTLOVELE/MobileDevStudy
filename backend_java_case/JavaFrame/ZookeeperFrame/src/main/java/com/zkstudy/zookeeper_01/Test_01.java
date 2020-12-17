package com.zkstudy.zookeeper_01;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;

/**
 * ZooKeeper¹¹½¨
 * @author yangzuliang
 *
 */
public class Test_01 implements Watcher{
	
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

	public static void main(String[] args) throws Exception{
		
		//buildZooKeeper_01();
		//buildZooKeeper_02();
	}
	
	public static void buildZooKeeper_02() throws Exception {
		
		ZooKeeper zk = new ZooKeeper("192.168.1.96:2181", 5000, new Test_01());
		connectedSemaphore.await();
		long sessionId = zk.getSessionId();
		byte[] passwd = zk.getSessionPasswd();
		zk = new ZooKeeper("192.168.1.96:2181", 5000, new Test_01(), 1l, "test".getBytes());
		zk = new ZooKeeper("192.168.1.96:2181", 5000, new Test_01(), sessionId, passwd);
	    Thread.sleep(Integer.MAX_VALUE);
	}
	
	public static void buildZooKeeper_01() throws Exception {

		ZooKeeper zk = new ZooKeeper("192.168.1.96:2181", 5000, new Test_01());
		System.out.println(zk.getState());
		try {
			connectedSemaphore.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void process(WatchedEvent arg0) {
		System.out.println("receive watched event:" + arg0);
		if(KeeperState.SyncConnected == arg0.getState()){
			connectedSemaphore.countDown();
		}
	}
}
