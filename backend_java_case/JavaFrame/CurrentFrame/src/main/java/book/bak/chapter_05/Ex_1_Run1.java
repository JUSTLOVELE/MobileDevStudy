package com.thread.chapter_05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 运行后可发现线程马上执行了(时间早就会立刻执行)
 * 但是执行后线程却不会退出因为:Timer的构造器就是启动一个新的线程,而这个线程不是守护线程,一直在执行
 * TimerTask是以队列的方式一个个被顺序执行的,所以执行的时间有可能和预期的时间不一致,因为前面的任务有可能消耗的时间长,则后面的任务运行的时间也会被延迟
 * @author yangzuliang
 *
 */
public class Ex_1_Run1 {

	private static Timer timer = new Timer();
	static public class MyTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了 时间为:" + new Date());
			//执行后移除,否则会一直启动线程
			//Timer cancel:是将任务队列中的全部任务清空
			//TimerTask cancel:清除自身
			//timer.cancel();
			this.cancel();
		}
	}
	
	public static void main(String[] args) {
		try {
			
			MyTask task = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2016-08-15 16:49:00";
			Date dateRef = sdf.parse(dateString);
			timer.schedule(task, dateRef);
			//执行多个
			MyTask task2 = new MyTask();
			dateString = "2017-08-15 16:49:00";
			dateRef = sdf.parse(dateString);
			timer.schedule(task2, dateRef);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
