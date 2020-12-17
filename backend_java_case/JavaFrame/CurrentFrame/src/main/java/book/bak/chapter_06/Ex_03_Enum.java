package com.thread.chapter_06;

import java.sql.Connection;
import java.sql.DriverManager;

class MyThread03 extends Thread {
	
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(Ex_03_Enum.connectionFactory.getConnection().hashCode());
		}
	}
}

public enum Ex_03_Enum {

	connectionFactory;
	private Connection connection;
	
	private Ex_03_Enum(){
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
	
	public static void main(String[] args) {
		MyThread03 t1 = new MyThread03();
		MyThread03 t2 = new MyThread03();
		MyThread03 t3 = new MyThread03();
		t1.start();
		t2.start();
		t3.start();
		
		/*try {
			String drivername = "com.mysql.jdbc.Driver";
			Class.forName(drivername);
			String url = "jdbc:mysql://localhost:3306/medical?user=root&password=root";
			String username = "root";
			String pwd = "root";
			DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
