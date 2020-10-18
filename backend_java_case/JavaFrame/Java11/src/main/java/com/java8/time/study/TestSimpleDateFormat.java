package com.java8.time.study;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;


public class TestSimpleDateFormat {

    @Test
    public void modern_java8() {

        try {

            DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

            Callable<LocalDate> task = new Callable<LocalDate>() {

                @Override
                public LocalDate call() throws Exception {
                    return LocalDate.parse("20161218", dtf);
                }
            };

            ExecutorService pool = Executors.newFixedThreadPool(10);
            List<Future<LocalDate>> results = new ArrayList<>();

            for(int i=0; i<10; i++) {
                results.add(pool.submit(task));
            }

            for(Future<LocalDate> future : results) {
                System.out.println(future.get());
            }

            pool.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 现在的解决方式
     */
    @Test
    public void modern () {

        try {

            Callable<Date> task = new Callable<Date>() {

                @Override
                public Date call() throws Exception {

                    return DateFormatThreadLocal.convert("20161218");
                }
            };

            ExecutorService pool = Executors.newFixedThreadPool(10);
            List<Future<Date>> results = new ArrayList<>();

            for(int i=0; i<10; i++) {
                results.add(pool.submit(task));
            }

            for(Future<Date> future : results) {
                System.out.println(future.get());
            }

            pool.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 传统的time api 存在多线程安全问题,跑这个程序会报错
     */
    @Test
    public void traditionTimeAPI() {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            Callable<Date> task = new Callable<Date>() {

                @Override
                public Date call() throws Exception {
                    return sdf.parse("20161218");
                }
            };

            ExecutorService pool = Executors.newFixedThreadPool(10);
            List<Future<Date>> results = new ArrayList<>();

            for(int i=0; i<10; i++) {
                results.add(pool.submit(task));
            }

            for(Future<Date> future : results) {
                System.out.println(future.get());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
