package com.chazhangxinyuan.jdk8;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangjun
 * @create 2018/12/03/20:39
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        //吐槽1
        /*Date date= new Date(118,11,3);
        System.out.println(date);*/
        //吐槽2（放到多线程下会报错）
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        for (int i=0;i<30;i++){
            new Thread(()->{
                for (int x =0;x<100;x++){
                    Date parseDate = null;
                    try {
                        parseDate = simpleDateFormat.parse("20180808");
                        System.out.println(parseDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }*/

//        testLocalDate();
//        testLocalTime();
//        combineLocalDateAndTime();
//        testInstant();
//        testDuration();
//        testPeriod();
//        testDateFormat();
        testDateParse();
    }

    private static void testDateParse() {
        String date1="20181203";
        LocalDate parse = LocalDate.parse(date1,DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);
        DateTimeFormatter customerFormat = DateTimeFormatter.ofPattern("yyyyMMdd");//有问题
        String date2="20181203";
        LocalDate parse1 = LocalDate.parse(date2, customerFormat);
        System.out.println(parse1);
    }

    private static void testDateFormat() {
        LocalDate localDate = LocalDate.now();
        String formatTime = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
//        String formatTime1 = localDate.format(DateTimeFormatter.ISO_LOCAL_TIME); 此方法有问题
        System.out.println(formatTime);
//        System.out.println(formatTime1);
        DateTimeFormatter customerFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String customerFormat1 = localDate.format(customerFormat);
        System.out.println(customerFormat1);

    }

    private static void testPeriod() {
        Period between = Period.between(LocalDate.of(2001, 12, 1), LocalDate.of(2018, 12, 3));
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }

    private static void testDuration() {
        LocalTime time = LocalTime.now();
        LocalTime beginTime = time.minusHours(1L);
        Duration d = Duration.between(time, beginTime);
        System.out.println(d.toHours());
    }

    private static void testInstant() {
        Instant begin = Instant.now();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(begin, end);
        System.out.println(duration.toMillis());

    }

    private static void combineLocalDateAndTime() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime= LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    private static void testLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
    }

    /////////////////////////////////////(jdk8中的日期)////////////////////////////////////////////////
    private static void testLocalDate() {
        LocalDate localDate = LocalDate.of(2018,12,3);
        System.out.println(localDate.getYear());//2018
        System.out.println(localDate.getMonth());//DECEMBER
        System.out.println(localDate.getMonthValue());//12
        System.out.println(localDate.getDayOfYear());//337
        System.out.println(localDate.getDayOfMonth());//3
        System.out.println(localDate.getDayOfWeek());//MONDAY
    }

}
