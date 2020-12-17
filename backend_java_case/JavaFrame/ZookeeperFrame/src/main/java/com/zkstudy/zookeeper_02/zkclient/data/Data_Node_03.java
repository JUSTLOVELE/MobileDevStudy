package com.zkstudy.zookeeper_02.zkclient.data;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.ZooDefs.Ids;

/**
 * 1.�ͻ��˿��Զ�һ�������ڵĽڵ�����ӽڵ����ļ���
 * 2.�Ľڵ㱾��Ĵ�����ɾ��Ҳ��֪ͨ���ͻ���
 * 3.һ���ͻ��˶�һ���ڵ�ע�����ӽڵ��б�������֮��,��ô���ýڵ���ӽڵ��б���
 * ���ʱ��,����������֪ͨ�ͻ���,�������µ��ӽڵ��б��͸��ͻ���
 * @author yangzuliang
 *
 */
public class Data_Node_03 {

	/**
	 * ��zookeeper��watcher��ͬ����zkClient�ṩ��
	 * Listener����һ���Ե�,�ͻ���ֻ��Ҫע��һ�ξͿ�����
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
