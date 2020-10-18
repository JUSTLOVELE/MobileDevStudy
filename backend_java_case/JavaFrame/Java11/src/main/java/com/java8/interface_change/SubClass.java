package com.java8.interface_change;

public class SubClass extends MyClass implements MyFun {

	public static void main(String[] args) {
		//调用的是继承类的方法
		//类优先原则
		SubClass sub = new SubClass();
		System.out.println(sub.getName());
	}
}