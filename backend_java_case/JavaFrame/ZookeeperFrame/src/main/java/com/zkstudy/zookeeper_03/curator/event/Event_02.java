package com.zkstudy.zookeeper_03.curator.event;

/**
 * PathChildrenCache用于监听指定ZooKeeper数据节点的子节点变化情况
 * client : Curator客户端实例
 * path : 数据节点的节点路径
 * dataIsCompressed : 是否进行数据压缩
 * cacheData : 用于配置是否把节点内容缓存起来,如果配置为true,那么客户端在接收到节点列表变更的同时,也能够获取到节点的数据内容
 * 如果配置为false,则无法获取到节点的数据内容
 * threadFactory/executorService 利用这两个参数可以通过构造一个专门的线程池,来处理事件通知
 * @author yangzuliang
 *
 */
public class Event_02 {

	public static void main(String[] args) {
		//Curator也无法对二级子节点进行事件监听
	}
}
