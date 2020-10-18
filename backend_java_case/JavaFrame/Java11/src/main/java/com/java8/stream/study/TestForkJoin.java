package com.java8.stream.study;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;


public class TestForkJoin {

	@Test
	public void test3() {

		Instant s = Instant.now();
		LongStream.rangeClosed(0, 100000000000L)
				.parallel()//并行流
				.reduce(0, Long::sum);
		Instant e = Instant.now();
		System.out.println(Duration.between(s, e).toMillis());
	}

	@Test
	public void test2() {

		Instant s = Instant.now();
		long sum = 0L;

		for(long i=0; i<100000000L; i++) {
			sum += i;
		}

		System.out.println(sum);
		Instant e = Instant.now();
		System.out.println(Duration.between(s, e).toMillis());
	}

	@Test
	public void test1() {

		Instant s = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoin(0, 100000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
		Instant e = Instant.now();
		System.out.println(Duration.between(s, e).toMillis());
	}
}
