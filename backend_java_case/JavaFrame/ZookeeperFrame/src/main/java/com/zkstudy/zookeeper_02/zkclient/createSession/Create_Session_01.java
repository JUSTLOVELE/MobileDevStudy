package com.zkstudy.zookeeper_02.zkclient.createSession;

import org.I0Itec.zkclient.ZkClient;

/**
 * 使用zkclient来创建zookeeper客户端
 * @author yangzuliang
 *
 */
public class Create_Session_01 {
	
	public static void main(String[] args) throws Exception{
		
		
		ZkClient zkClient = new ZkClient("192.168.1.96:2181", 5000);
		/**
		 * create api参数说明
		 * path : 指定数据节点的节点路径
		 * data:节点的初始数据内容,可以传入null
		 * mode:节点类型,是一个枚举类型,有四种可选
		 * acl:节点的acl策略
		 * callback:注册一个异步回调函数
		 * context:用于传递一个对象,可以在执行回调函数的时候使用
		 * createParents:是否创建父节点
		 */
		zkClient.createPersistent("/zkclient-test/test1", true);
	}
}
