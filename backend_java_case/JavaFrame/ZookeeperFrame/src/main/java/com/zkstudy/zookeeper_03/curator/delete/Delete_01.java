package com.zkstudy.zookeeper_03.curator.delete;

public class Delete_01 {

	/**
	 *ɾ��Ҷ�ӽڵ�:
	 * client.delete().forPath()
	 *ɾ��һ���ڵ�,���ݹ�ɾ���������ӽڵ� :
	 * client.delete().deletingChildrenIfNeed().forPath()
	 * ɾ��һ���ڵ�,ǿ��ָ���汾����ɾ��:
	 * client.delete().withVersion(version).forPath()
	 * ɾ��һ���ڵ�,ǿ�Ʊ�֤ɾ��:guaranteed()�ӿ���һ�����ϴ�ʩ,ֻҪ�ͻ��˻Ự��Ч,��ôCurator���ں�̨��������ɾ������,ֱ���ɹ�
	 * client.delete().guaranteed().forPath()
	 * guaranteed:
	 *   ��zookeeper�ͻ���ʹ�ù�����,���ܻ���������������:�ͻ���ִ��һ��ɾ���ڵ����,��������һЩ����ԭ��,����
	 *ɾ������ʧ��,��������쳣,����Щ��������������,��"master"ѡ��,�����������,ZooKeeper�ͻ���ͨ����ͨ��
	 *�ڵ�Ĵ�����ɾ����ʵ�ֵ�,����������,Curator��������һ�����Ի���:������ǵ���guaranteed()����,��ô���ͻ�����
	 *��������Щ�����쳣��ʱ��,���¼�����ʧ�ܵ�ɾ������,ֻҪ�ͻ��˻Ự��Ч,��ô��ͻ��ں�̨��������,ֱ��ɾ���ɹ�,
	 *ͨ�������Ĵ�ʩ,�Ϳ��Ա�֤�ڵ�ɾ������һ������Ч
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
