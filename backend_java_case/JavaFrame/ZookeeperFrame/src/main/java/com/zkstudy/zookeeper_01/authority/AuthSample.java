package com.zkstudy.zookeeper_01.authority;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * addAuthInfo
 *  schema : Ȩ�޿���ģʽ��Ϊ:world,auth,digest,ip,super
 *  auth : �����Ȩ����Ϣ
 * @author yangzuliang
 *
 */
public class AuthSample {

	final static String Path = "/zk-book-auth_test";
	
	public static void main(String[] args) throws Exception {
		ZooKeeper zk = new ZooKeeper("192.168.1.96:2181", 5000, null);
		//Ȩ����Ϣ��foo:true,��ǳ�������username:password�ĸ�ʽ
		zk.addAuthInfo("digest", "foo:true".getBytes());
		zk.create(Path, "init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
		//����Ĵ���ͻᱨ����:KeeperErrorCode = NoAuth for /zk-book-auth_test
		ZooKeeper zk2 = new ZooKeeper("192.168.1.96:2181", 5000, null);
		zk2.getData(Path, false, null);
	}
}
