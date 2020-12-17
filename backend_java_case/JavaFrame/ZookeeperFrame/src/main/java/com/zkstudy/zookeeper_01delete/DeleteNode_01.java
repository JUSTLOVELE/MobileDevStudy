package com.zkstudy.zookeeper_01delete;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * P110
 * 在zookeeper中,只允许删除叶子节点,也就是说如果一个节点存在至少一个子节点的话,那么该节点将无法被直接删除,必须先删除其所有子节点
 * @author yangzuliang
 *
 */
public class DeleteNode_01 implements Watcher{
	
	public static void main(String[] args) throws Exception {
		
		ZooKeeper zooKeeper = new ZooKeeper("192.168.1.96:2181", 5000, new DeleteNode_01());
		//path:指定数据节点的节点路径,即API调用的目的是删除该节点
		//version:指定节点的数据版本,即表明本次删除操作是针对该数据版本进行的
		//zooKeeper.delete(path, version);
		//cb:注册一个异步回调函数
		//ctx:用于传递上下文信息的对象
		//zooKeeper.delete(path, version, cb, ctx);
	}

	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		
	}

}
