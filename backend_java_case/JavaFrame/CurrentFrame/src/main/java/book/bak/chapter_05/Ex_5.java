package com.thread.chapter_05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * �ڲ���ʱ�������,���ִ�������ʱ��û�б���ʱ,����һ��ִ�������ʱ������һ������Ŀ�ʼʱ�����delayʱ��
 * @author yangzuliang
 *
 */
public class Ex_5 {

	private static Timer timer = new Timer();
	private static int runCount = 0;
	static public class MyTask extends TimerTask {
		@Override
		public void run() {
			try {
				System.out.println("1 begin ������!ʱ��Ϊ:" + new Date());
				Thread.sleep(5000);
				System.out.println("1 end ������!ʱ��Ϊ:" + new Date());
				runCount++;
				if(runCount == 5){
					timer.cancel();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2014-08-15 16:45:00";
			Date dateRef = sdf.parse(dateString);
			timer.schedule(task, dateRef, 2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
