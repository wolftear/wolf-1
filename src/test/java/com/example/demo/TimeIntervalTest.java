package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/3/2
 **/
public class TimeIntervalTest {
    public static void main(String[] args) {
        Integer intervalDayTime = getIntervalTime(new Date(),1);
        Integer intervalYearTime = getIntervalTime(new Date(),2);
        System.out.println(intervalDayTime);
        Calendar calendar = Calendar.getInstance();
        LocalDate localDate = LocalDate.ofYearDay(calendar.get(Calendar.YEAR), 1);
        int dayCount = localDate.isLeapYear() ? 366 : 365;
        intervalYearTime = (dayCount - calendar.get(Calendar.DAY_OF_YEAR))*24*3600 + intervalDayTime;
        System.out.println(intervalYearTime);
    }

    private static Integer getIntervalTime(Date currentDate,Integer type) {
        Integer intervalTime = null;
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long intervalDayTime = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        if (type == 1) {
            intervalTime = (int)intervalDayTime;
        }
        if (type == 2) {
            Calendar calendar = Calendar.getInstance();
            LocalDate localDate = LocalDate.ofYearDay(calendar.get(Calendar.YEAR), 1);
            int dayCount = localDate.isLeapYear() ? 366 : 365;
            intervalTime = (dayCount - calendar.get(Calendar.DAY_OF_YEAR))*24*3600 + (int)intervalDayTime;
        }
        return intervalTime;
    }

    private static Integer getDayIntervalTime(Date currentDate) {
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return (int) seconds;
    }

}
