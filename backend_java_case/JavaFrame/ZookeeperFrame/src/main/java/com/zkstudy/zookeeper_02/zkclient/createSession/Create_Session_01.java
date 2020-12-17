package com.zkstudy.zookeeper_02.zkclient.createSession;

import org.I0Itec.zkclient.ZkClient;

/**
 * ʹ��zkclient������zookeeper�ͻ���
 * @author yangzuliang
 *
 */
public class Create_Session_01 {
	
	public static void main(String[] args) throws Exception{
		
		
		ZkClient zkClient = new ZkClient("192.168.1.96:2181", 5000);
		/**
		 * create api����˵��
		 * path : ָ�����ݽڵ�Ľڵ�·��
		 * data:�ڵ�ĳ�ʼ��������,���Դ���null
		 * mode:�ڵ�����,��һ��ö������,�����ֿ�ѡ
		 * acl:�ڵ��acl����
		 * callback:ע��һ���첽�ص�����
		 * context:���ڴ���һ������,������ִ�лص�������ʱ��ʹ��
		 * createParents:�Ƿ񴴽����ڵ�
		 */
		zkClient.createPersistent("/zkclient-test/test1", true);
	}
}
