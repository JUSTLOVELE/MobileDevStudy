package com.zkstudy.zookeeper_03.curator.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

/**
 * �ֲ�ʽ������
 * ����Lock_01 �����׻�����ʵ��һ���ֲ�ʽ������,�ֲ�ʽ������һ�����ͳ�����ͳ��ϵͳ����������,
 * ����ZooKeeper�ķֲ�ʽ��������ʵ��˼·Ҳ�ܼ�:
 *    ָ��һ��ZooKeeper���ݽڵ���Ϊ������,���Ӧ��ʵ���ڷֲ�ʽ���Ŀ�����,ͨ�����¸����ݽڵ��������ʵ�ּ�������
 *    
 *Curatorͬ������һϵ���߼���װ����DistributedAtomicInteger����,����һ�������ڷֲ�ʽ������ʹ�õ�ԭ������
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
