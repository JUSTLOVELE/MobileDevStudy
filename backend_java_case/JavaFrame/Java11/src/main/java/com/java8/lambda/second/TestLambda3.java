package com.java8.lambda.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 *	Java8 内置的四大核心函数式接口
 *
 *	Consumer<T> : 消费型接口
 *		void accept(T t);
 *	Supplier<T> : 供给型接口
 *		T get();
 *	Function<T, R> : 函数型接口
 *		R apply(T t);
 *	Predicate<T> : 断言型接口
 *		boolean test(T t)
 */
public class TestLambda3 {

	public static void main(String[] args) {

		TestLambda3 testLambda3 = new TestLambda3();
		testLambda3.test1();
		testLambda3.test2();
		testLambda3.test3();
		testLambda3.test4();
	}

	//Predicate<T> : 断言型接口
	public void test4() {

		List<String> list = Arrays.asList("aaa", "aav", "vv", "ccc");
		List<String> data = filterStr(list, (str) -> str.contains("a"));

		data.forEach(System.out::println);
	}

	public List<String> filterStr(List<String> list, Predicate<String> pre){

		List<String> strList = new ArrayList<>();

		for(String str : list) {

			if(pre.test(str)) {
				strList.add(str);
			}
		}

		return strList;
	}


	//Function<T, R> : 函数型接口
	public void test3() {

		String a =strHandler(" 牛逼    ", (str) -> str.trim());
		System.out.println(a);
	}


	public String strHandler(String str, Function<String, String> fun) {
		return fun.apply(str);
	}

	//Supplier<T> : 供给型接口
	public void test2() {
		Random random = new Random();
		List<Integer> list = getNumList(10, ()-> random.nextInt(10));
		list.forEach(System.out::println);

	}
	//需求:产生指定个数的整数,并放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> sup){

		List<Integer> list = new ArrayList<>();

		for(int i=0; i<num; i++) {

			list.add(sup.get());
		}

		return list;
	}

	//Consumer<T> 消费型接口:
	public void test1() {
		happy(10000, (m) -> System.out.println("消费" + m));
	}

	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
}
