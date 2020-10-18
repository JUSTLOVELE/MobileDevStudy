package com.java.lambda.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.java8.lambda.first.Employee;

public class TestLambda {

	public static void main(String[] args) {

	}

	List<Employee> emps = Arrays.asList(new Employee(101, "张三", 18, 9999.99), new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33), new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55));

	public void test1() {

		Collections.sort(emps, (e1, e2) -> {

			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			} else {
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
	}

	public void test2() {

		String s = strHandler(" dsds ", (str) -> str.trim());
		System.out.println(s);
		strHandler("dsdsd", (str) -> str.toUpperCase());
	}

	public String strHandler(String str, MyFunction mf) {
		return mf.getValue(str);
	}

}
