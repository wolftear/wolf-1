package com.example.demo;

import io.netty.util.internal.StringUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/9/16
 **/
public class StringTest {
    public static void main(String[] args) {
//        System.out.println(getUserLevelTodayScoreKey(260033));
//        System.out.println(getUserLevelRuleLimitKey(260033,1));
//        System.out.println(getUserLevelRuleObjLimitKey(260033,1,1000L));
//        Date nowDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println(getIntervalTime(nowDate,1));
        System.out.println(getUgcMemoInfo("ugcResult测试",""));
    }

    public static String getUserLevelTodayScoreKey(Integer userId){
        return (String.format("yiche.forum.userLevel.totalScore.%s",userId));
    }

    /**
     * 用户等级积分 每日规则次数 最大限制
     **/
    public static String getUserLevelRuleLimitKey(Integer userId,Integer ruleId){
        return String.format("yiche.forum.userLevel.ruleLimit.%s.%s",userId,ruleId);
    }

    /**
     * 用户等级积分 对象规则内容 最大限制
     **/
    public static String getUserLevelRuleObjLimitKey(Integer userId,Integer ruleId,Long objId){
        return String.format("yiche.forum.userLevel.ruleObjLimit.%s.%s.%s",userId,ruleId,objId);
    }

    public static Integer getIntervalTime(Date currentDate, Integer type) {
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
        return intervalTime == null ? 0:intervalTime;
    }

    public static String getUgcMemoInfo(String ugcResult, String ugcMemo) {
        if (!StringUtil.isNullOrEmpty(ugcMemo)) {
            return ugcMemo;
        } else {
            // ugcMemo为空，使用ugcResult作为ugcMemo 避免查询时解析错误
            String realUgcMemo = ("<KeyWords><KeyWord>").concat(ugcResult).concat("</KeyWord></KeyWords>");
            return realUgcMemo;
        }
    }
}
