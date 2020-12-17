package com.thread.chapter_05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ���к�ɷ����߳�����ִ����(ʱ����ͻ�����ִ��)
 * ����ִ�к��߳�ȴ�����˳���Ϊ:Timer�Ĺ�������������һ���µ��߳�,������̲߳����ػ��߳�,һֱ��ִ��
 * TimerTask���Զ��еķ�ʽһ������˳��ִ�е�,����ִ�е�ʱ���п��ܺ�Ԥ�ڵ�ʱ�䲻һ��,��Ϊǰ��������п������ĵ�ʱ�䳤,�������������е�ʱ��Ҳ�ᱻ�ӳ�
 * @author yangzuliang
 *
 */
public class Ex_1_Run1 {

	private static Timer timer = new Timer();
	static public class MyTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("������ ʱ��Ϊ:" + new Date());
			//ִ�к��Ƴ�,�����һֱ�����߳�
			//Timer cancel:�ǽ���������е�ȫ���������
			//TimerTask cancel:�������
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
			//ִ�ж��
			MyTask task2 = new MyTask();
			dateString = "2017-08-15 16:49:00";
			dateRef = sdf.parse(dateString);
			timer.schedule(task2, dateRef);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
