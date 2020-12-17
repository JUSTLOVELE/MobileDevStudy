package com.zkstudy.zookeeper_02.zkclient.data;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.ZooDefs.Ids;

/**
 *  π”√getChildren
 * @author yangzuliang
 *
 */
public class Data_Node_02 {
	
	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient("192.168.1.96:2181", 5000);
		//zkClient.createPersistent("/zkclient-test", true);
		//zkClient.createPersistent("/zkclient-test/test1", "user-zkclient-test1", Ids.OPEN_ACL_UNSAFE);
		//zkClient.createPersistent("/zkclient-test/test2", "user-zkclient-test2", Ids.OPEN_ACL_UNSAFE);
		List<String> list = zkClient.getChildren("/zkclient-test");
		zkClient.close();
		System.out.println(list.toString());
	}

}
