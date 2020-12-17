package com.thread.chapter_07;

/**
 * 线程组自动归属特性 自动归属就是自动归到当前线程组中
 * 
 * @author yangzuliang
 * 
 */
public class Ex_07_Group {

	public static void main(String[] args) {
		System.out.println("A处线程:" + Thread.currentThread().getName() + "所属的线程组名为:"
				+ Thread.currentThread().getThreadGroup().getName() + " 中有线程组数量:"
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		ThreadGroup group = new ThreadGroup(" 新的组 ");// 自动加到main组中
		System.out.println("B处线程: " + Thread.currentThread().getName() + " 所属的线程组名为:"
				+ Thread.currentThread().getThreadGroup().getName() + " 中有线程组数量:"
				+ Thread.currentThread().getThreadGroup().activeGroupCount());
		
		ThreadGroup[] threadGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadGroup);
		for(int i=0; i<threadGroup.length; i++){
			System.out.println(" 第一个线程组名称为: " + threadGroup[i].getName());
		}
	}
}
