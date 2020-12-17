package com.zkstudy.zookeeper_02.zkclient.data;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.ZooDefs.Ids;

/**
 * 1.客户端可以对一个不存在的节点进行子节点变更的监听
 * 2.改节点本身的创建或删除也会通知到客户端
 * 3.一旦客户端对一个节点注册了子节点列表变更监听之后,那么当该节点的子节点列表发送
 * 变更时候,服务器都会通知客户端,并将最新的子节点列表发送给客户端
 * @author yangzuliang
 *
 */
public class Data_Node_03 {

	/**
	 * 和zookeeper的watcher不同的是zkClient提供的
	 * Listener不是一次性的,客户端只需要注册一次就可以了
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		String path = "/zkclient-book";
		ZkClient zkClient = new ZkClient("192.168.1.96:2181", 5000);
		zkClient.subscribeChildChanges(path, new IZkChildListener() {
			
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(parentPath + " 's child changed, currentChilds:" + currentChilds);
			}
		});
		
		zkClient.createPersistent(path);
		Thread.sleep(1000);
		zkClient.createPersistent(path + "/c1");
		Thread.sleep(1000);
		System.out.println(zkClient.getChildren(path));
		Thread.sleep(1000);
		zkClient.delete(path + "/c1");
		Thread.sleep(1000);
		zkClient.delete(path);
		Thread.sleep(1000);
		zkClient.close();
	}
}
