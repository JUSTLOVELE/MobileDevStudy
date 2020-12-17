package com.thread.chapter_07;

/**
 * 多级关联
 *   多级关联就是父对象中有子对象,子对象中再创建子对象
 * 但这种写法不太常见,线程树结构设计得非常复杂反而不利于线程对象的管理
 * 但JDK却提供了支持多级关联的线程树结构
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
		newThread.setName("Z");//线程必须启动然后才归到数组A中
		newThread.start();
		ThreadGroup[] listGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(listGroup);
		System.out.println("main线程中有多少个子线程组:" + listGroup.length + "名字为:" + listGroup[0].getName());
		Thread[] listThread = new Thread[listGroup[0].activeCount()];
		listGroup[0].enumerate(listThread);
		System.out.println(listThread[0].getName());
	}
}
