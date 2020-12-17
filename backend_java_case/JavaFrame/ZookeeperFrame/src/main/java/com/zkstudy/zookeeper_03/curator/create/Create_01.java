package com.zkstudy.zookeeper_03.curator.create;

import org.apache.curator.RetryPolicy;
import org.apache.curator.RetrySleeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * �����Բ�����Curatorͨ��һ�����RetryPlicy�����û�ʵ���Զ������
 * @author yangzuliang
 *
 */
public class Create_01 implements RetryPolicy{

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		/**
		 * baseSleepTimeMs:��ʼsleepʱ��
		 * maxRetires:������Դ���
		 * maxSleepMs:���sleepʱ��
		 */
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		/**
		 * connecString : host:port,����:192.168.1.1:2181,192.168.1.2:2181
		 * retryPolicy : ���Բ���,Ĭ��������ʵ��:ExponentialBackoffRetry,RetryNTimes,RetryOneTime,RetryUtilElapsed
		 */
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.96:2181", 5000, 3000, retryPolicy);
		client.start();
		Thread.sleep(Integer.MAX_VALUE);
	}

	/**
	 * 
	 * @param retryCount:�����ԵĴ���,��һ��Ϊ0
	 * @param elapsedTimeMs:�ӵ�һ�����Կ�ʼ�ѻ��ѵ�ʱ��(����)
	 * @param sleeper:����sleepָ��ʱ��, Curator���鲻Ҫʹ��Threed.sleep������sleep����
	 * @return
	 */
	public boolean allowRetry(int retryCount, long elapsedTimeMs, RetrySleeper sleeper) {
		// TODO Auto-generated method stub
		return false;
	}
}
