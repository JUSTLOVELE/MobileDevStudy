package com.java8.lambda.first;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
}
