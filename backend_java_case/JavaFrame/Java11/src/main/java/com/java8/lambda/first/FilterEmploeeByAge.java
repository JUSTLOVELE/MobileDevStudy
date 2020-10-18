package com.java8.lambda.first;

public class FilterEmploeeByAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() >= 35;
	}
}
