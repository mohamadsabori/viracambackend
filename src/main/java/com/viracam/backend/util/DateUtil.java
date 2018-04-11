package com.viracam.backend.util;

import com.ghasemkiani.util.SimplePersianCalendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by msabori on 1/24/18.
 */
public class DateUtil {

    public static String getDate(){
        SimplePersianCalendar persianCalendar = new SimplePersianCalendar();
        Calendar c = Calendar.getInstance();
        Calendar c2 = (Calendar) c.clone();
        c.set(Calendar.HOUR_OF_DAY, 6);
        persianCalendar.setTime(c.getTime());
        int day = persianCalendar.getDateFields().getDay();
        int month = persianCalendar.getDateFields().getMonth() + 1;
        int year = persianCalendar.getDateFields().getYear();
        return generateDate(year, month, day);
    }


    public static String getDate(Date date) {
        SimplePersianCalendar persianCalendar = new SimplePersianCalendar();
        persianCalendar.setTime(date);
        int day = persianCalendar.getDateFields().getDay();
        int month = persianCalendar.getDateFields().getMonth() + 1;
        int year = persianCalendar.getDateFields().getYear();
        return generateDate(year, month, day);
    }

    public static String generateDate(int intYear, int intMonth, int intDay) {
        String day = (intDay >= 10) ? String.valueOf(intDay) : ("0" + intDay);
//        intMonth = intMonth + 1;
        String month = (intMonth >= 10) ? String.valueOf(intMonth) : ("0" + intMonth);
        String year = String.valueOf(intYear);
        return generateDate(year, month, day);
    }

    private static String generateDate(String year, String month, String day) {
        return year + "/" + month + "/" + day;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getDate());
    }
}
