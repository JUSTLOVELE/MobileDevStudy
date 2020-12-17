package com.zkstudy.zookeeper_03.curator.event;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Masterѡ��
 *  �ڷֲ�ʽϵͳ��,���������������ĳ���:����һ�����ӵ�����,����Ҫ�Ӽ�Ⱥ��ѡ�ٳ�һ̨���д�����,
 *�������ķֲ�ʽ����,����ͳ��Ϊ"Masterѡ��",����zookeeper,���ǿ��ԱȽϷ����ʵ��Master
 *ѡ�ٵĹ���,�����˼·�ǳ���:ѡ��һ�����ڵ�,����/master_select,��̨����ͬʱ��ýڵ㴴��һ
 *���ӽڵ�/master_select/lock,����ZooKeeper������,����ֻ��һ̨�����ܹ������ɹ�,�ɹ���
 *��̨��������ΪMaster
 * @author yangzuliang
 *
 */
public class Master {

	static RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    static CuratorFramework client = CuratorFrameworkFactory.builder()
    		.connectString("192.168.1.96:2181").sessionTimeoutMs(5000)
    		.retryPolicy(retryPolicy).build();
    static String leaderPath = "/curator_recipes_master_path";
    
    /**
     * Curator���ھ�����Master���Զ����ø÷���,һ��ִ����takeLeadership����,Curator�ͻ������ͷ�MasterȨ��
     * ��ʼ��һ�ֵ�Masterѡ��
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
    	
    	client.start();
    	LeaderSelector selector = new LeaderSelector(client, leaderPath, new LeaderSelectorListener() {
			
			public void stateChanged(CuratorFramework client, ConnectionState newState) {
				// TODO Auto-generated method stub
			}
			
			public void takeLeadership(CuratorFramework client) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("��ΪMaster��ɫ");
				Thread.sleep(3000);
				System.out.println("���Master����,�ͷ�MasterȨ��");
			}
		});
    	selector.autoRequeue();
    	selector.start();
    	Thread.sleep(Integer.MAX_VALUE);
	}
}
