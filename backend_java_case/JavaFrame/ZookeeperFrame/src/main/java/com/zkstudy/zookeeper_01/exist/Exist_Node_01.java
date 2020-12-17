package com.zkstudy.zookeeper_01.exist;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import com.zkstudy.zookeeper_01.CreateNode_01;

/**
 * 检测节点是否存在
 * @author yangzuliang
 *
 */
public class Exist_Node_01 {

	public static void main(String[] args) throws Exception {
		
		//ZooKeeper zk = CreateNode_01.create();
		ZooKeeper zk = new ZooKeeper("192.168.1.96:2181", 5000, new CreateNode_01());
		Stat s = zk.exists("/zk-test-", null);
		System.out.println("状态 = " + s);
	}
}
