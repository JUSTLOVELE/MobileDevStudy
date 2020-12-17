package com.thread.chapter_05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * ���Timer��cancel()����û��������queue��,��ô����������������
 * @author yangzuliang
 *
 */
public class Ex_4 {

	static int i=0;
	
	static public class MyTask extends TimerTask {
		@Override
		public void run() {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
		while(true){
			try {
				i++;
				Timer timer = new Timer();
				MyTask task = new MyTask();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = "2016-08-15 16:49:00";
				Date dateRef = sdf.parse(dateString);
				timer.schedule(task, dateRef);
				timer.cancel();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
