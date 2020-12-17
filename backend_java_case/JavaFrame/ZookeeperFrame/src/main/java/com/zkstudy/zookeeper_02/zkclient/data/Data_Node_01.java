package com.zkstudy.zookeeper_02.zkclient.data;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.ZooDefs.Ids;

public class Data_Node_01 {

	
	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient("192.168.1.96:2181", 5000);
		//zkClient.createPersistent("/zkclient-test/test2", "user-zkclient-yzl", Ids.OPEN_ACL_UNSAFE);
		Object obj = zkClient.readData("/zkclient-test/test2");
		System.out.println(obj.toString());
	}
}
