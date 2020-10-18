package com.java8.lambda.third;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.java8.lambda.first.Employee;

/**
 * 方法引用:若Lambda体中的内容有方法已经实现了,我们可以使用方法引用
 * 	(可以理解为方法引用是Lambda表达式的另一种表现形式)
 * 主要有三种语法格式:
 *
 * 	对象::实例方法名
 *
 * 	类::静态方法名
 *
 * 	类::实例方法名
 *
 * 注意:
 * 	1.Lambda体重调用方法的参数列表与返回类型,要与函数式接口中抽象方法的函数列表和返回值类型保持一致!
 * 	2.若Lambda参数列表中的第一参数是实例方法的调用者,而第二个参数是实例方法的参数时,可以使用ClassName::method
 *
 * 二.构造器引用:
 * 	格式:
 *
 * 		ClassName::new
 * @author Administrator
 *
 */
public class TestMethodRef {

	public static void main(String[] args) {

		TestMethodRef testMethodRef = new TestMethodRef();
		/*testMethodRef.test1();
		testMethodRef.test2();
		testMethodRef.test3();
		testMethodRef.test4();
		testMethodRef.test5();*/
		testMethodRef.test6();
	}

	//数组引用
	public void test6() {
		Function<Integer, String[]> fun = (x) -> new String[x];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);

		Function<Integer, String[]> fun2 = String[]::new;
		String[] strs2 = fun2.apply(20);
		System.out.println(strs2.length);
	}

	public void test5() {

		Supplier<Employee> sup = () ->new Employee();
		//构造器引用方式
		Supplier<Employee> sup2 = Employee::new;
		Employee emp = sup2.get();
		System.out.println(emp);
		Function<Integer, Employee> fun = (x) -> new Employee(x);
		Function<Integer, Employee> fun2 = Employee::new;
		emp = fun2.apply(101);
		System.out.println(emp);
		BiFunction<Integer, Integer, Employee> bf = Employee::new;
		emp = bf.apply(11, 22);
		System.out.println(emp);
	}

	public void test4() {

		BiPredicate<String, String> bp = (x, y) -> x.equals(y);
		//这种写法有规则,第一个方法是实例方法的调用者,第二个方法是实例方法的参数,便可以用
		BiPredicate<String, String> bp2 = String::equals;
	}

	public void test3() {
		Comparator<Integer> com1 = Integer::compare;
	}

	public void test2() {

		Employee emp = new Employee();
		Supplier<String> sup = () -> emp.getName();
		String str = sup.get();
		System.out.println(str);

		Supplier<Integer> sup2 = emp::getAge;
		Integer num = sup2.get();
		System.out.println(num);
	}

	public void test1() {

		Consumer<String> con = (x) -> System.out.println(x);

		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
	}
}
