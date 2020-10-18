package com.java8.lambda.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class LambdaStudy {

	public static void main(String[] args) {

		LambdaStudy lambdaStudy = new LambdaStudy();
		lambdaStudy.test1();
		lambdaStudy.test2();
	}

	//原来的匿名内部类
	public void test1() {

		Comparator<Integer> com = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//最重要的就是这么一句,其他代码都是为了写他而已
				return Integer.compare(o1, o2);
			}
		};

		TreeSet<Integer> ts = new TreeSet<>(com);
	}

	//Lambda表达式
	public void test2() {

		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		TreeSet<Integer> ts = new TreeSet<>(com);
	}

	List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 33.33),
			new Employee("李四", 19, 332.33),
			new Employee("王五",	21, 333.33),
			new Employee("赵六", 48, 313.33),
			new Employee("田七", 68, 343.33)
	);

	/**
	 *
	 */
	public void test3() {

		List<Employee> list1 = filterEmployees(employees);
		List<Employee> list2 = filterEmployees(employees, new FilterEmploeeByAge());
	}

	//获取当前公司中员工年龄大于35的员工信息
	public List<Employee> filterEmployees(List<Employee> list){

		List<Employee> emps = new ArrayList<>();

		for(Employee emp : list) {
			//如果是改为工资大于5K的员工信息,要改这里
			//如果是改为年龄小于35的员工信息,也要改这里
			if(emp.getAge() >= 35) {
				emps.add(emp);
			}
		}

		return emps;
	}

	//优化1
	public List<Employee> filterEmployees(List<Employee> list, MyPredicate<Employee> mp){

		List<Employee> emps = new ArrayList<>();

		for(Employee employee : list) {

			if(mp.test(employee)) {
				emps.add(employee);
			}
		}

		return emps;
	}

	public void test5() {

		List<Employee> list = filterEmployees(employees, new MyPredicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				// TODO Auto-generated method stub
				return t.getSalary() <= 5000;
			}
		});
	}

	//Lambda
	public void test6() {

		List<Employee> list = filterEmployees(employees, (e) -> e.getSalary() <= 5000);
		list.forEach(System.out::println);
	}
	//stream API
	public void test7() {
		employees.stream()
				.filter((e) -> e.getSalary() >= 5000)
				.limit(2)
				.forEach(System.out::println);
	}
}
