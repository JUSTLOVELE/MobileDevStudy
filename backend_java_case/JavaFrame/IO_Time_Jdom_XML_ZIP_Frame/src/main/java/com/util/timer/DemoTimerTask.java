package com.util.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DemoTimerTask {

	public static void main(String[] args) {
		Timer timer = new Timer(true);
		TimerTask task = new TimerTask(){
			@Override
			public void run() {
				System.out.println("需要定时执行的任务...");
			}			
		};
		Date time = new Date();
		long delay = 2000;
		long period = 5000;
		//启动定时任务，在 time 指定的时间执行壹次，然后每隔两秒执行壹次
		timer.schedule(task, time, delay);
		//启动定时任务，从现在起过两秒执行壹次，然后退出
		//timer.schedule(task, delay);
		//启动定时任务，从现在起过两秒以后，每隔五秒执行壹次
		//timer.schedule(task, delay, period);
		while(true){
			
		}
	}
}
