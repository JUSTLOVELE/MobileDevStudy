package com.java8.optional.study;

import java.util.Optional;

import org.junit.Test;

import com.java8.lambda.first.Employee;
import com.java8.lambda.first.Employee.Status;

public class TestOptional {

	//运用 Optional 的实体类
	@Test
	public void test6(){
		Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));

	Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
		String name = getGodnessName2(op);
		System.out.println(name);
	}

	public String getGodnessName2(Optional<NewMan> man){
		return man.orElse(new NewMan())
				.getGodness()
				.orElse(new Godness("苍老师"))
				.getName();
	}

	/**
	 * map(function f) : 如果有值对其处理, 并返回处理后的Optional,否则返回Optional.empty()
	 * flatMap(Function mapper) : 与map类似,要求返回值必须是Optional
	 */
	@Test
	public void test4() {

		Optional<Employee> op = Optional.ofNullable(new Employee(1, "张三", 18, 888.88, Status.FREE));
		Optional<String> str = op.map((e) -> e.getName());
		System.out.println(str.get());
	}

	/**
	 * Optional.ofNullable(T t) 若t不为Null创建Optional实例
	 * isPresent() : 判断是否包含值
	 * orElse(T t) : 如果调用对象包含值,返回该值,否则返回t
	 *
	 */
	@Test
	public void test3() {

		Optional<Employee> op = Optional.ofNullable(null);

		if(op.isPresent()) {
			System.out.println(op.get());
		}

		Employee emp = op.orElse(new Employee(0, "张三", 18, 888.88, Status.FREE));
		System.out.println(emp);
	}


	@Test
	public void test2() {

		Optional<Employee> op = Optional.empty();
		System.out.println(op.get());

	}

	/**
	 * Optional.of : 创建一个Optional实例
	 */
	@Test
	public void test1() {

		Optional<Employee> op = Optional.of(new Employee());
		System.out.println(op.get());
	}
}
