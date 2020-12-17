package com.zkstudy.zookeeper_01.data;

import org.apache.zookeeper.ZooKeeper;

import com.zkstudy.zookeeper_01.CreateNode_01;

public class Data_Node_01 {

public static void main(String[] args) throws Exception {
		
		//ZooKeeper zk = CreateNode_01.create();
		ZooKeeper zk = new ZooKeeper("192.168.1.96:2181", 5000, new CreateNode_01());
		byte[] b = zk.getData("/zk-test-", null, null);
		String s = new String(b, "utf-8");
		System.out.println("s = " + s);
	}
}
