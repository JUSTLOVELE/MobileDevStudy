package com.java8.stream.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.java8.lambda.first.Employee;

/**
 * 筛选与切片
 * filter : 接收Lambda,从流中排除某些元素
 * limit : 截断流,使其元素不超过给定数量
 * skip(n) : 跳过元素,返回一个扔掉了前n个元素的流,若元素不足n个,则返回一个空流,与limit(n)互补
 * distinct : 筛选,通过流所生成元素的hashCode()和equals去除重新元素,需要重写hashCode和equals
 *
 */
public class TestStreamAPI_v2 {

	List<Employee> emps = Arrays.asList(new Employee(101, "张三", 18, 9999.99), new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33), new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55));

	public static void main(String[] args) {

		TestStreamAPI_v2 test = new TestStreamAPI_v2();
		//test.test1();
		//test.test3();
		//test.test4();
		//test.test5();

	}

	public static Stream<Character> filterCharacter(String str){

		List<Character> list = new ArrayList<>();

		for(Character ch : str.toCharArray()) {

			list.add(ch);
		}

		return list.stream();
	}

	/**
	 * 自然排序:
	 * 	sorted() : 自然排序(Comparable)
	 * 	sorted(Comparator com) : 定制排序(Comparator)
	 */
	public void test7() {

		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
		list.stream().sorted().forEach(System.out::println);
		System.out.println("---------------------------");
		emps.stream().sorted((e1, e2) -> {

			if(e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return e1.getAge().compareTo(e2.getAge());
			}
		}).forEach(System.out::println);;
	}

	/**
	 * 映射
	 * map : 接收Lambda,将元素转换成其他形式或提取信息,接收一个函数作为参数,该函数会被应用到每个元素上,
	 * 并将其映射成一个新的元素
	 * flatMap : 接收一个函数作为参数,将流中的每个值都换成另一个流,然后把所有流连接成一个流
	 */
	public void test5() {

		List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
		list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
		System.out.println("-----------------");
		emps.stream().map(Employee::getName).forEach(System.out::println);
		System.out.println("-----------------");
		Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI_v2::filterCharacter);
		stream.forEach((sm) -> {
			sm.forEach(System.out::println);
		});
	}

	public void test4() {

		emps.stream().filter((e) -> e.getSalary() > 5000).skip(2).forEach(System.out::println);;
	}

	public void test3() {

		Stream<Employee>  stream = emps.stream().limit(2);
		stream.forEach(System.out::println);
	}

	public void test2() {

		Iterator<Employee> it = emps.iterator();

		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void test1() {

		Stream<Employee>  stream = emps.stream().filter( (e) -> e.getAge() > 35 );
		stream.forEach(System.out::println);
	}

}
