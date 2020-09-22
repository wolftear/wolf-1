package com.example.demo.jvm;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/3/17
 **/
public class JhatTest {

    private static String getForumUserScoreDayKeyormat = "yiche.forumuser.score.%s.%s";


    public static String getForumUserScoreDayKey(Long userId, LocalDateTime nowTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStr = df.format(nowTime);
        return String.format(getForumUserScoreDayKeyormat,userId,dateStr);
    }
    public static void main(String[] args) {
//        String reidsiKey = getForumUserScoreDayKey(100L,LocalDateTime.now());
//        System.out.println(reidsiKey);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);System.out.println(today_start.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(today_start);
        System.out.println(today_end);
    }


}
