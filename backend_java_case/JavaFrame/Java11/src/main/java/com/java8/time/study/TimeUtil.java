package com.java8.time.study;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TimeUtil {

    /**
     * 比较两个算法的时间
     */
    @Test
    public void timeDifference02() {

        Instant start = Instant.now();
        runAlgorithm();
        Instant end = Instant.now();
        //Duration是两个时刻之间的时间量
        Duration timeElapsed = Duration.between(start, end);
        long mills = timeElapsed.toMillis();
        System.out.println(mills);

        Instant start02 = Instant.now();
        runAlgorithm2();
        Instant end02 = Instant.now();
        Duration timeElapsed02 = Duration.between(start02, end02);
        long mills02 = timeElapsed02.toMillis();
        System.out.println(mills02);

        boolean overTimeFaster = timeElapsed.multipliedBy(10).minus(timeElapsed02).isNegative();
        System.out.println(overTimeFaster);
    }

    @Test
    public void timeDifference() {

        Instant start = Instant.now();
        runAlgorithm();
        Instant end = Instant.now();
        //Duration是两个时刻之间的时间量
        Duration timeElapsed = Duration.between(start, end);
        long mills = timeElapsed.toMillis();
        System.out.println(mills);
    }

    public static void runAlgorithm2() {

        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i%100).limit(size).boxed().collect(Collectors.toList());

        while (!IntStream.range(1, list.size()).allMatch(i -> list.get(i-1).compareTo(list.get(i)) <= 0))
            Collections.shuffle(list);

        System.out.println(list);
    }

    public static void runAlgorithm() {
        int size = 10;
        List<Integer> list = new Random().ints().map(i -> i%100).limit(size).boxed().collect(Collectors.toList());
        Collections.sort(list);
        System.out.println(list);
    }
}
