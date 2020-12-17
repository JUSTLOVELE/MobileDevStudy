package com.zkstudy.zookeeper_03.curator.create;

import org.apache.curator.RetryPolicy;
import org.apache.curator.RetrySleeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 在重试策略上Curator通过一个借口RetryPlicy来让用户实现自定义策略
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
		 * baseSleepTimeMs:初始sleep时间
		 * maxRetires:最大重试次数
		 * maxSleepMs:最大sleep时间
		 */
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		/**
		 * connecString : host:port,例如:192.168.1.1:2181,192.168.1.2:2181
		 * retryPolicy : 重试策略,默认有四种实现:ExponentialBackoffRetry,RetryNTimes,RetryOneTime,RetryUtilElapsed
		 */
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.96:2181", 5000, 3000, retryPolicy);
		client.start();
		Thread.sleep(Integer.MAX_VALUE);
	}

	/**
	 * 
	 * @param retryCount:已重试的次数,第一次为0
	 * @param elapsedTimeMs:从第一次重试开始已花费的时间(毫秒)
	 * @param sleeper:用于sleep指定时间, Curator建议不要使用Threed.sleep来进行sleep操作
	 * @return
	 */
	public boolean allowRetry(int retryCount, long elapsedTimeMs, RetrySleeper sleeper) {
		// TODO Auto-generated method stub
		return false;
	}
}
