package com.thread.chapter_07;

/**
 * �߳����Զ��������� �Զ����������Զ��鵽��ǰ�߳�����
 * 
 * @author yangzuliang
 * 
 */
public class Ex_07_Group {

	public static void main(String[] args) {
		System.out.println("A���߳�:" + Thread.currentThread().getName() + "�������߳�����Ϊ:"
				+ Thread.currentThread().getThreadGroup().getName() + " �����߳�������:"
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup group = new ThreadGroup(" �µ��� ");// �Զ��ӵ�main����
		System.out.println("B���߳�: " + Thread.currentThread().getName() + " �������߳�����Ϊ:"
				+ Thread.currentThread().getThreadGroup().getName() + " �����߳�������:"
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		
		ThreadGroup[] threadGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadGroup);
		for(int i=0; i<threadGroup.length; i++){
			System.out.println(" ��һ���߳�������Ϊ: " + threadGroup[i].getName());
		}
	}
}
