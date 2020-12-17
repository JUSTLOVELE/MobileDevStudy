package com.thread.chapter_07;

/**
 * �༶����
 *   �༶�������Ǹ����������Ӷ���,�Ӷ������ٴ����Ӷ���
 * ������д����̫����,�߳����ṹ��Ƶ÷ǳ����ӷ����������̶߳���Ĺ���
 * ��JDKȴ�ṩ��֧�ֶ༶�������߳����ṹ
 * @author yangzuliang
 *
 */
public class Ex_06_Group {

	public static void main(String[] args) {
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		ThreadGroup group = new ThreadGroup(mainGroup, "A");
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("runMethod");
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread newThread = new Thread(group, runnable);
		newThread.setName("Z");//�̱߳�������Ȼ��Ź鵽����A��
		newThread.start();
		ThreadGroup[] listGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(listGroup);
		System.out.println("main�߳����ж��ٸ����߳���:" + listGroup.length + "����Ϊ:" + listGroup[0].getName());
		Thread[] listThread = new Thread[listGroup[0].activeCount()];
		listGroup[0].enumerate(listThread);
		System.out.println(listThread[0].getName());
	}
}
