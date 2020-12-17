package com.zkstudy.zookeeper_01.authority;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * addAuthInfo
 *  schema : 权限控制模式分为:world,auth,digest,ip,super
 *  auth : 具体的权限信息
 * @author yangzuliang
 *
 */
public class AuthSample {

	final static String Path = "/zk-book-auth_test";
	
	public static void main(String[] args) throws Exception {
		ZooKeeper zk = new ZooKeeper("192.168.1.96:2181", 5000, null);
		//权限信息是foo:true,这非常类似于username:password的格式
		zk.addAuthInfo("digest", "foo:true".getBytes());
		zk.create(Path, "init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
		//下面的代码就会报错了:KeeperErrorCode = NoAuth for /zk-book-auth_test
		ZooKeeper zk2 = new ZooKeeper("192.168.1.96:2181", 5000, null);
		zk2.getData(Path, false, null);
	}
}
