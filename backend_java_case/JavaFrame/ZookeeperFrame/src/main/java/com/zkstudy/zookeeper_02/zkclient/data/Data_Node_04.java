package com.zkstudy.zookeeper_02.zkclient.data;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

public class Data_Node_04 {

	public static void main(String[] args) throws Exception {
		
		String path = "/zk-book";
		ZkClient zkClient = new ZkClient("192.168.1.96:2181", 5000);
		zkClient.createEphemeral(path, "123");
		
		zkClient.subscribeDataChanges(path, new IZkDataListener() {
			
			public void handleDataDeleted(String dataPath) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Node " + dataPath + " deleted");
			}
			
			public void handleDataChange(String dataPath, Object data) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Node " + dataPath + " change, new Data : " + data);
			}
		});
		
		System.out.println(Boolean.valueOf((zkClient.readData(path))));
		zkClient.writeData(path, "456");
		Thread.sleep(1000);
		zkClient.delete(path);
		Thread.sleep(Integer.MAX_VALUE);
	}
}
