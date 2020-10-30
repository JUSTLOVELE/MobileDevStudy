package com.java8.time.study;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 日期调整期
 * 对于日程安排应用来说经常需要计算诸如每个月的第一个星期二这样的日期
 * TemporalAdjuster提供了解决方案
 */
public class TemporalAdjusterTest {

    public void case01() {
        TemporalAdjuster NEXT_WORKDAY = w -> {
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            }
            while (result.getDayOfWeek().getValue() >= 6);
            return result;
        };
    }

    @Test
    public void case02() {
        //with会返回一个新的LocalDate对象,而不会修改原来的对象
        //某年某月的第一个星期二
        LocalDate firstTuesday = LocalDate.of(2019, 2, 1).with(
                TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)
        );
        System.out.println(firstTuesday.toString());
    }
}
