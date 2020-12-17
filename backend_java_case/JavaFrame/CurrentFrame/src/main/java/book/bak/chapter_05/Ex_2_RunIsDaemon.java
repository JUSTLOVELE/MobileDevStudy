package com.thread.chapter_05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 运行后迅速结束当前线程,并且TimerTask中的任务不再被运行,因为进程结束了
 * @author yangzuliang
 *
 */
public class Ex_2_RunIsDaemon {

	private static Timer timer = new Timer(true);
	static public class MyTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了 时间为:" + new Date());
		}
	}
	
	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2014-08-15 16:45:00";
			Date dateRef = sdf.parse(dateString);
			timer.schedule(task, new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
