package com.thread.chapter_05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * ���к�Ѹ�ٽ�����ǰ�߳�,����TimerTask�е������ٱ�����,��Ϊ���̽�����
 * @author yangzuliang
 *
 */
public class Ex_2_RunIsDaemon {

	private static Timer timer = new Timer(true);
	static public class MyTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("������ ʱ��Ϊ:" + new Date());
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
