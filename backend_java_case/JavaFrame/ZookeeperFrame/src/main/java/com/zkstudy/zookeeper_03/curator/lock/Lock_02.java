package com.zkstudy.zookeeper_03.curator.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

/**
 * 分布式计数器
 * 有了Lock_01 就容易基于其实现一个分布式计数器,分布式计数器一个典型场景是统计系统的在线人数,
 * 基于ZooKeeper的分布式计数器的实现思路也很简单:
 *    指定一个ZooKeeper数据节点作为计算器,多个应用实例在分布式锁的控制下,通过更新该数据节点的内容来实现计数功能
 *    
 *Curator同样将这一系列逻辑封装在了DistributedAtomicInteger类中,这是一个可以在分布式环境中使用的原子整型
 * @author yangzuliang
 *
 */
public class Lock_02 {

	static String lock_path = "/curator_recipes_distatomicint_path";
	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").retryPolicy(new ExponentialBackoffRetry(1000, 3))
    		.retryPolicy(retryPolicy).build();
    public static void main(String[] args) throws Exception{
		client.start();
		DistributedAtomicInteger atomicInteger = new DistributedAtomicInteger(client, lock_path, new RetryNTimes(1000, 3));
		AtomicValue<Integer> rc = atomicInteger.add(-8);
	    System.out.println("Result:" + rc.succeeded() + "; value = " + rc.postValue());
    }
}
