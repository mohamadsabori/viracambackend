package com.viracam.backend.util;

import java.util.Date;

/**
 * Created by msabori on 1/24/18.
 */
public class DateUtil {
    public static String getDate(Date date) {
        return "";
        /*SimplePersianCalendar persianCalendar = new SimplePersianCalendar();
        persianCalendar.setTime(date);
        int day = persianCalendar.getDateFields().getDay();
        int month = persianCalendar.getDateFields().getMonth() + 1;
        int year = persianCalendar.getDateFields().getYear();
        return generateDate(year, month, day);*/
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
}
