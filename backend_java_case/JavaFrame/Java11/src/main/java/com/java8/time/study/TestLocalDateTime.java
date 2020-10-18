package com.java8.time.study;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TestLocalDateTime {


    @Test
    public void test8() {

        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Athens"));
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.now();
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Europe/Athens"));
        System.out.println(zdt);
    }

    @Test
    public void test7() {
        //时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    //DateTimeFormatter : 格式化时间日期
    @Test
    public void test6() {

        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);
        System.out.println("-----------------");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);
        LocalDateTime newDate = ldt.parse(strDate2, dtf2);
        System.out.println(newDate);
    }

    //TemporalAdjuster : 时间校正器
    @Test
    public void test5() {

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义:下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();

            if(dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            }else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    @Test
    public void test4() {

        LocalDate ld1 = LocalDate.of(2015, 1, 1);
        LocalDate ld2 = LocalDate.now();

        Period p = Period.between(ld1, ld2);
        System.out.println(p);
        System.out.println(p.getYears());
    }

    @Test
    public void test3() {

        try {
            Instant ins1 = Instant.now();
            Thread.sleep(1000);
            Instant ins2 = Instant.now();
            Duration duration = Duration.between(ins1, ins2);
            System.out.println(duration.getSeconds());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //instant:时间戳(以Unix元年:1970.1.1)
    @Test
    public void test2() {
        //默认获取UTC时区
        Instant ins1 = Instant.now();
        System.out.println(ins1);
        //跟UTC差了8个小时,把偏移量补上就可以了
        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(ins1.toEpochMilli());
        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);
    }

    @Test
    public void test1() {

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2015, 10, 19, 13, 22, 33);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println("--"+ldt3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());

    }
}
