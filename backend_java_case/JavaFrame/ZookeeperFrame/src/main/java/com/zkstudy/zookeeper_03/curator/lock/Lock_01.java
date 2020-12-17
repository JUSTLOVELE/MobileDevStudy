package com.zkstudy.zookeeper_03.curator.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * ʵ�ֲַ�ʽ��
 *  �ڷֲ�ʽ������,Ϊ�˱�֤���ݵ�һ����,�����ڳ����ĳ�����е�,��Ҫ����ͬ������.
 *  ������ˮ������,��ͨ�ĺ�̨Ӧ��ͨ������ʹ��ʱ�����ʽ��������ˮ��,�������û���
 *����ֲ�������:����ֺܶ���ͬ����ˮ��
 * @author yangzuliang
 *
 */
public class Lock_01 {
    static String lock_path = "/curator_recipes_lock_path";
	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").retryPolicy(new ExponentialBackoffRetry(1000, 3))
    		.retryPolicy(retryPolicy).build();
    
    /**
     * ��ȡ��:
     * public void acquire() throws Exception;
     * �ͷ���:
     * public void release() throws Exception;
     * @param args
     */
    public static void main(String[] args) {
		client.start();
		final InterProcessMutex lock = new InterProcessMutex(client, lock_path);
		final CountDownLatch down = new CountDownLatch(1);
		for(int i=0; i<30; i++){
			new Thread(new Runnable() {
				public void run() {
					// TODO Auto-generated method stub
					try {
						down.await();
						lock.acquire();
					} catch (Exception e) {
						e.printStackTrace();
					}
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
					String orderNo = sdf.format(new Date());
					System.out.println("������:" + orderNo);
					try {
						lock.release();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		down.countDown();
	}
}
