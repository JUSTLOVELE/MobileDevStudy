package com.thread.chapter_06;

import java.sql.Connection;
import java.sql.DriverManager;


class MyThread04 extends Thread {
	
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(Ex_4_Enum.getConnection().hashCode());
		}
	}
}

public class Ex_4_Enum {

	public static Connection getConnection(){
		return MyEnumSingleton.connectionFactory.getConnection();
	}
	
	public enum MyEnumSingleton{

		connectionFactory;
		private Connection connection;
		
		private MyEnumSingleton(){
			try {
				System.out.println("调用Ex_03_Enum的构造");
				String url = "jdbc:mysql://localhost:3306/medical";
				String username = "root";
				String pwd = "root";
				String drivername = "com.mysql.jdbc.Driver";
				Class.forName(drivername);
				connection = DriverManager.getConnection(url, username, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public Connection getConnection(){
			return connection;
		}

	}
	
	public static void main(String[] args) {
		MyThread04 t1 = new MyThread04();
		MyThread04 t2 = new MyThread04();
		MyThread04 t3 = new MyThread04();
		t1.start();
		t2.start();
		t3.start();
	}
}
