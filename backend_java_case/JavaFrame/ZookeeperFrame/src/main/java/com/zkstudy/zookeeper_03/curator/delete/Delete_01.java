package com.zkstudy.zookeeper_03.curator.delete;

public class Delete_01 {

	/**
	 *删除叶子节点:
	 * client.delete().forPath()
	 *删除一个节点,并递归删除其所有子节点 :
	 * client.delete().deletingChildrenIfNeed().forPath()
	 * 删除一个节点,强制指定版本进行删除:
	 * client.delete().withVersion(version).forPath()
	 * 删除一个节点,强制保证删除:guaranteed()接口是一个保障措施,只要客户端会话有效,那么Curator会在后台持续进行删除操作,直到成功
	 * client.delete().guaranteed().forPath()
	 * guaranteed:
	 *   在zookeeper客户端使用过程中,可能会碰到这样的问题:客户端执行一个删除节点操作,但是由于一些网络原因,导致
	 *删除操作失败,对于这个异常,在有些场景中是致命的,如"master"选举,在这个场景中,ZooKeeper客户端通常是通过
	 *节点的创建与删除来实现的,针对这个问题,Curator中引入了一种重试机制:如果我们调用guaranteed()方法,那么当客户端碰
	 *到上面这些网络异常的时候,会记录下这次失败的删除操作,只要客户端会话有效,那么其就会在后台反复重试,直到删除成功,
	 *通过这样的措施,就可以保证节点删除操作一定会生效
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
