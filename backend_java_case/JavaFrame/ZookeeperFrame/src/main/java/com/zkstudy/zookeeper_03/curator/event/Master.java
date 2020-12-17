package com.zkstudy.zookeeper_03.curator.event;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Master选举
 *  在分布式系统中,经常会碰到这样的场景:对于一个复杂的任务,仅需要从集群中选举出一台进行处理即可,
 *诸如此类的分布式问题,我们统称为"Master选举",借助zookeeper,我们可以比较方便地实现Master
 *选举的功能,其大体思路非常简单:选择一个根节点,例如/master_select,多台机器同时向该节点创建一
 *个子节点/master_select/lock,利用ZooKeeper的特性,最终只有一台机器能够创建成功,成功的
 *那台机器就作为Master
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
     * Curator会在竞争到Master后自动调用该方法,一旦执行完takeLeadership方法,Curator就会立即释放Master权力
     * 开始新一轮的Master选举
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
				System.out.println("成为Master角色");
				Thread.sleep(3000);
				System.out.println("完成Master操作,释放Master权力");
			}
		});
    	selector.autoRequeue();
    	selector.start();
    	Thread.sleep(Integer.MAX_VALUE);
	}
}
