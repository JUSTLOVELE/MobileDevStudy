package com.java8.stream.study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8.lambda.first.Employee;
import com.java8.lambda.first.Employee.Status;

/**
 * 终止操作
 *
 * @author User
 *
 */
public class TestStreamAPI_v3 {


	public static void main(String[] args) {

		TestStreamAPI_v3 t3 = new TestStreamAPI_v3();
		//t3.test1();
		//t3.test3();
		//t3.test4();
		//t3.test5();
		//t3.test6();
		//t3.test7();
		t3.test8();
	}

	public void test8() {

		Map<Boolean, List<Employee>> map = emps.stream().
				collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
		System.out.println(map);
	}

	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99, Status.FREE),
			new Employee(102, "李四", 59, 6666.66, Status.BUSY),
			new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Status.VOCATION),
			new Employee(105, "田七", 38, 5555.55, Status.BUSY));

	/**
	 * 多级分组
	 */
	public void test7() {
		Map<Status, Map<String,List<Employee>>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(

				(e) -> {
					if(e.getAge() <= 35) {
						return "青年";
					}else if(e.getAge() <= 50) {
						return "中年";
					}else {
						return "老年";
					}
				}
		)));

		System.out.println(map);
	}


	/**
	 * 按照状态分组
	 */
	public void test6() {

		Map<Status, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);
	}

	public void test5() {

		Long count = emps.stream().collect(Collectors.counting());
		System.out.println(count);
		System.out.println("---------------");
		Double avg = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		System.out.println("-------------------");
		Double sum = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
	}

	/**
	 * 收集
	 */
	public void test4() {

		List<String> list = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.toList());

		list.forEach(System.out::println);
		System.out.println("----------------");
		Set<String> set = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.toSet());
		set.forEach(System.out::println);
		System.out.println("-------------------");
		emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
	}

	/**
	 * 归约
	 * reduce(T iden, BinaryOperator b):可以将流中元素反复结合起来,得到一个值,返回T
	 * reduce(BinaryOperator b):可以将流中元素反复结合起来,得到一个值返回给Optional<T>
	 */
	public void test3() {

		List<Integer> list = Arrays.asList(3,4,5);
		Integer sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(sum);
		System.out.println("------------------");
		Optional<Double> op = emps.stream()
				.map(Employee::getSalary)
				.reduce(Double::sum);
		System.out.println(op.get());
	}


	/**
	 * 查找与匹配
	 * allMatch : 检查是否匹配所有元素
	 * anyMatch : 检查是否至少匹配一个元素
	 * noneMatch : 检查是否没有匹配所有元素
	 * findFirst : 返回第一个元素
	 * findAny : 返回当前流中的任意元素
	 * count : 返回流中元素的个数
	 * max : 返回流中最大值
	 * min : 返回流中最小值
	 */
	public void test1() {

		boolean b1 = emps.stream().allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);
		boolean b2 = emps.stream().anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);
		boolean b3 = emps.stream().noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b3);
		Optional<Employee> op = emps.stream()
				.sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
				.findFirst();
		System.out.println(op.get());
		Optional<Employee> op2 = emps.stream().filter( (e) -> e.getStatus().equals(Status.FREE)).findAny();
		System.out.println(op2.get());

		Long count = emps.stream().count();
		System.out.println(count);
		Optional<Employee> op3 = emps.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(op3.get());
		Optional<Double> op4 = emps.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println(op4.get());

	}
}
