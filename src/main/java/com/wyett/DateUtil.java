package com.wyett;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : wyettLei
 * @date : Created in 2021/12/13 11:43
 * @description: date utils
 */

public class DateUtil {

    public static String defaultDatePattern = "yyyy-MM-dd HH:mm:ss.SSS";

    public static String getDefaultDatePattern() {
        return defaultDatePattern;
    }

    /**格式化date为字符串*/
    public static String format(Date date) {
        return date == null ? null: format(date, getDefaultDatePattern());
    }

    public static String format(Date date, String pattern) {
        return date == null ? null: new SimpleDateFormat(pattern).format(date);
    }

    /**字符串解析为date*/
    public static Date parse(String dateStr) throws ParseException {
        return StringUtils.isBlank(dateStr) ? null : parse(dateStr, defaultDatePattern);
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        return StringUtils.isBlank(dateStr) ? null : new SimpleDateFormat(pattern).parse(dateStr);
    }

    /**返回当前日期*/
    public static String getToday() {
        Date date = new Date();
        return format(date);
    }

}
