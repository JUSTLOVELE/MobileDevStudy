package com.java8.stream.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.java8.lambda.first.Employee;

/**
 * 1.创建Stream
 *
 * 2.中间操作
 *
 * 3.终止操作
 *
 * @author Administrator
 */
public class TestStreamAPI_v1 {

	public static void main(String[] args) {
		TestStreamAPI_v1 testStreamAPI_v1 = new TestStreamAPI_v1();
	}

	public void test1() {
		//1.可通过Con
		List<String> list = new ArrayList<>();
		Stream<String>stream1 = list.stream();
		//2.通过Arrays中的静态方法stream()获取数组流
		Employee[] emps = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(emps);
		//3.通过Stream类中的静态方法of()
		Stream<String> string3 = Stream.of("aa", "bb", "cc");
		//4.创建无限流
		//迭代
		Stream<Integer> stream4 = Stream.iterate(0, (x)->x+2);
		stream4.forEach(System.out::println);
	}
}
