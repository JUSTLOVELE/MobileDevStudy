package com.java8.lambda.second;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一.Lambda表达式基础语法 "->" 箭头操作符/Lambda操作符
 * @author Administrator
 * 左侧:Lambda 表达式的参数列表
 * 右侧:Lambda 表达式所需执行的功能,即Lambda体
 *
 * 语法格式一:无参数, 无返回值
 * 	() -> System.out.println("hello Lambda!");
 * 语法格式二:一个参数, 无返回值
 * 	(x) -> System.out.println(x);
 * 语法格式三:一个参数小括号是可以不写的
 * 	 x -> System.out.println(x);
 * 语法格式四:两个以上参数,有返回值,并且Lambda体重有多条语句,要用大括号
 * 		Comparator<Integer> com = (x, y) -> {
 *			System.out.println("函数式接口");
 *			return Integer.compare(x, y);
 *		};
 *	语法格式5:若Lambda体积中只有一条语句,return和大括号都可以省略不写
 *		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *	语法格式六:Lambda表达式的参数列表的数据类型可以省略不写,因为JVM编译器可以通过上下文推断出数据类型,即:"类型推断"
 *		Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
 *
 *	上联:左右遇一括号省
 *	下联:左侧推断类型省
 *	横批:能省则省
 *
 * 二.Lambda表达式需要函数式接口的支持
 *	函数式接口:接口中只有一个抽象方法的接口,称为函数式接口,可是使用注解修饰@FunctionalInterface
 *			可以检查是否是函数式接口
 *
 */
public class TestLambda2 {

	public static void main(String[] args) {

		TestLambda2 testLambda2 = new TestLambda2();
		testLambda2.test6();
		//testLambda2.test5();
		//testLambda2.test4();
		//testLambda2.test3();
		//testLambda2.test2();
		//testLambda2.test1();
	}

	public void test6() {

		MyFun my = (x) -> {
			return x;
		};
		System.out.println(my.getValue(5));
		System.out.println(operation(100, (x) -> {int a=x*x; return a;}));
		System.out.println(operation(100, (x) -> x+x));
	}

	public Integer operation(Integer num, MyFun my) {
		return my.getValue(num);
	}

	public void test1() {

		final int num_v2 = 1;
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world!" + num_v2);
			}
		};
		int num = 0;
		System.out.println("-------------------");
		Runnable r1 = () -> System.out.println("Hello Lambda!" + num);
		r.run();
		r1.run();
	}

	public void test2() {

		Consumer<String> con = new Consumer<String>() {
			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
			}
		};

		Consumer<String> con1 = (x) -> System.out.println(x);
		con1.accept("你牛逼");
	}

	public void test3() {
		Comparator<Integer> com = (x, y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
	}

	public void test4() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
	}

	public void test5() {
		Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
	}
}
