package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dxw
 * @date 2020-09-01 15:14
 **/
public class DateUtil {

    public static final String HOUR_FORMAT = "HH:mm:ss";
    public static final String DAY_FORMAT = "yyyyMMdd";
    public static final String DAY_FORMAT1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    public static final String MINUTES_TIME_FORMAT = "yyyyMMddHHmm";
    public static final String HOUR_TIME_FORMAT = "yyyyMMddHH";
    public static final String DATE_FORMAT_20 = "yyyy-MM-dd 20:00:00";
    public static final String DATE_FORMAT_08 = "yyyy-MM-dd 08:00:00";
    public static final String DATE_FORMAT_24 = "yyyy-MM-dd 23:59:59";
    public static final String DATE_FORMAT_00 = "yyyy-MM-dd 00:00:00";
    public static final int DAY_IN_MILLSECOND = 1000 * 3600 * 24;
    public static final int HOUR_IN_MILLSECOND = 1000 * 3600;
    public static final int MINUTE_IN_MILLSECOND = 1000 * 60;


    /**
     * 获取指定时刻固定间隔时刻集合
     * @param startDate
     * @param endDate
     * @param hour
     * @return
     * @throws Exception
     */
    public static List<Date> getHourList(Date startDate, Date endDate, int hour) throws Exception {
        String start = null;
        String end = null;
        if (hour == 20){
            start = formatDateTimetoString(startDate, DATE_FORMAT_20);
            end = formatDateTimetoString(endDate, DATE_FORMAT_20);
        }
        if (hour == 8){
            start = formatDateTimetoString(startDate, DATE_FORMAT_08);
            end = formatDateTimetoString(endDate, DATE_FORMAT_08);
        }
        Date startTime = DateUtil.parseToDate(start, DATE_FORMAT);
        Date endTime = DateUtil.parseToDate(end, DATE_FORMAT);
        List<Date> hourList = getIntervalTimeList(startTime, endTime, 1440);
        return hourList;
    }
    /**
     * 获取固定间隔时刻集合
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param interval 时间间隔(单位：分钟)
     * @return
     */
    public static List<Date> getIntervalTimeList(Date startDate, Date endDate, int interval){
        List<Date> list = new ArrayList<>();
        while(startDate.getTime()<=endDate.getTime()){
            list.add(startDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.MINUTE,interval);
            if(calendar.getTime().getTime()>endDate.getTime()){
                if(!startDate.equals(endDate)){
                    //list.add(endDate);
                    return list;
                }
                startDate = calendar.getTime();
            }else{
                startDate = calendar.getTime();
            }
        }
        return list;
    }

    /**
     * 返回val小时后的时间
     *
     * @param date
     *            指定日期
     * @return 新日期对象
     */
    public static Date getToHour(Date date, int val) {
        long day = date.getTime();
        long toHour = day + val * 60 * 60 * 1000;
        return new Date(toHour);
    }


    public static Integer getHourCount(Date startDate, Date endDate) {
        long sHour = startDate.getTime();
        long eHour = endDate.getTime();
        return Integer.parseInt(String.valueOf((eHour-sHour)/1000/60/60));
    }

    /**
     * 返回val小时后的时间
     *
     * @param date
     *            指定日期
     * @return 新日期对象
     */
    public static Date getToBeforeHour(Date date, int val) {
        long day = date.getTime();
        long toHour = day - val * 60 * 60 * 1000;
        return new Date(toHour);
    }

    /**
     * 根据给出的Date值和格式串采用操作系统的默认所在的国家风格来格式化时间，并返回相应的字符串
     *
     * @param date
     *            日期对象
     * @param formatStr
     *            日期格式
     * @return 如果为null，返回字符串""
     */
    public static String formatDateTimetoString(Date date, String formatStr) {
        String reStr = "";
        if (date == null || formatStr == null || formatStr.trim().length() < 1) {
            return reStr;
        }
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(formatStr);
        reStr = sdf.format(date);
        return reStr == null ? "" : reStr;
    }
    /**
     * 按指定的格式和指定国家的风格把给定的日期字符串格式化为一个Date型日期
     *
     * @param dateTimeStr
     *            日期字符串
     * @param formatStr
     *            日期格式
     * @param locale
     *            日期格式符号要被使用的语言环境
     * @return java.util.Date类型对象
     * @throws Exception
     *             可能抛出的异常
     */
    public static Date parseToDate(String dateTimeStr, String formatStr, Locale locale) throws Exception {
        if (dateTimeStr != null && formatStr != null && locale != null && dateTimeStr.trim().length() > 0
                && formatStr.trim().length() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr, locale);
            try {
                return sdf.parse(dateTimeStr);
            } catch (ParseException e) {
                throw new Exception(e);
            }
        } else {
            throw new IllegalArgumentException("参数dateTimeStr、formatStr、locale不能是null或空格串！");
        }

    }
    /**
     * 按指定的格式和操作系统默认国家的风格把给定的日期字符串格式化为一个Date型日期
     *
     * @param dateTimeStr
     *            日期毫秒字符串
     * @param formatStr
     *            日期格式
     * @return java.util.Date类型对象
     * @throws Exception
     *             可能抛出的异常
     */
    public static Date parseToDate(String dateTimeStr, String formatStr) throws Exception {
        if (dateTimeStr == null || formatStr == null || dateTimeStr.trim().length() < 1
                || formatStr.trim().length() < 1) {
            throw new IllegalArgumentException("参数dateTimeStr、formatStr不能是null或空格串！");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            return sdf.parse(dateTimeStr);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    /**
     * 按指定年份获得操作系统默认国家的风格的该年第一天的日期字符串格式化为一个Date型日期
     * @param year
     * @return java.util.Date类型对象
     * @throws Exception
     *    可能抛出的异常
     */
    public static Date parseToYearStartDate(Integer year) throws Exception {
        String dateTimeStr = year+"-01-01 00:00:00";
        String formatStr = "yyyy-MM-dd HH:mm:ss";
        if (dateTimeStr.trim().length() < 1) {
            throw new IllegalArgumentException("参数dateTimeStr、formatStr不能是null或空格串！");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            return sdf.parse(dateTimeStr);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    /**
     * 按指定年份获得操作系统默认国家的风格的该年最后一天的日期字符串格式化为一个Date型日期
     * @param year
     * @return java.util.Date类型对象
     * @throws Exception
     *    可能抛出的异常
     */
    public static Date parseToYearEndDate(Integer year) throws Exception {
        String dateTimeStr = year+"-12-31 23:59:59";
        String formatStr = "yyyy-MM-dd HH:mm:ss";
        if (dateTimeStr.trim().length() < 1) {
            throw new IllegalArgumentException("参数dateTimeStr、formatStr不能是null或空格串！");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            return sdf.parse(dateTimeStr);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    /**
     * 返回10分钟后的时间
     *
     * @param date
     *            指定日期
     * @return 新日期对象
     */
    public static Date getLast10Minute(Date date) {
        long day = date.getTime();
        long lastDay = day + 10 * 60 * 1000;
        return new Date(lastDay);
    }

    /**
     * 返回20分钟后的时间
     *
     * @param date
     *            指定日期
     * @return 新日期对象
     */
    public static Date getLast20Minute(Date date) {
        long day = date.getTime();
        long lastDay = day + 20 * 60 * 1000;
        return new Date(lastDay);
    }
    /**
     * 返回10分钟前的时间
     *
     * @param date
     *            指定日期
     * @return 新日期对象
     */
    public static Date getBefore10Minute(Date date) {
        long day = date.getTime();
        long lastDay = day - 10 * 60 * 1000;
        return new Date(lastDay);
    }

    public static Date getDateFormat(Date date, String format) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String dateStr = simpleDateFormat.format(date);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    /**
     * 获取整分钟的时间戳
     * @param date
     * @return
     */
    public static String getStringMinute(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        Date dateTime = format.parse(date);
        calendar.setTime(dateTime);
        int i = calendar.get(Calendar.MINUTE);
        i /= 10;
        i *= 10;
        calendar.set(Calendar.MINUTE,i);
        Date time = calendar.getTime();
        return format.format(time);
    }

    /**
     * 获取年
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取时
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR);
    }

    /**
     * 获取指定日期七天后的数据
     * @param date 日期
     * @return 七天后的日期
     */
    public static Date getSevenDaysLaterTime(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,6);
        return calendar.getTime();
    }

    /**
     * 获取指定日期N天后的数据
     * @param date 日期
     * @return N天后的日期
     */
    public static Date getDaysLaterTime(Date date, Integer off){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,off-1);
        return calendar.getTime();
    }

    public static String getCurrentDateStr(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            String time = sdf.format(date);
            return time;
        } catch (Exception ex) {
        }
        return null;
    }

    public static Date getCurrentDate(String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String dateStr = simpleDateFormat.format(new Date());
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 将字符串转换成指定的时间格式的字符串
     *
     * @Title: getTimeStringChangeFormat
     * @Description: TODO
     * @param time
     *            yyyyMMddHHmmss
     * @param
     * @return String
     */
    public static String getTimeStringChangeFormat(String time, String inFormat, String outFormat) {
        SimpleDateFormat inSdf = new SimpleDateFormat(inFormat);
        SimpleDateFormat outSdf = new SimpleDateFormat(outFormat);
        try {
            return outSdf.format(inSdf.parse(time));
        } catch (Exception e) {
//			LogUtils.error("convert date to String error:" + e);
        }
        return null;
    }

    /**
     *
     * @Title: futureDay
     * @Description: 未来的第几天的string
     * @param start
     * @param day
     *            (负号表示过去几天)
     * @return
     */
    public static String futureDay(String start, String format, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long startTime;
        try {
            startTime = sdf.parse(start).getTime();
            long endTime = startTime + ((long) DAY_IN_MILLSECOND * day);
            return sdf.format(new Date(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @Title: futureHour
     * @Description: 指定几小时后的string
     * @param start
     * @param hour
     *            (负号表示过去几小时)
     * @return
     */
    public static String futureHour(String start, String format, int hour) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long startTime;
        try {
            startTime = sdf.parse(start).getTime();
            long endTime = startTime + ((long) HOUR_IN_MILLSECOND * hour);
            return sdf.format(new Date(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @Title: futureMinutes
     * @Description: 指定分钟后的string
     * @param start
     * @param minute
     *            (负号表示过去几分钟)
     * @return
     */
    public static String futureMinute(String start, String format, int minute) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long startTime;
        try {
            startTime = sdf.parse(start).getTime();
            long endTime = startTime + ((long) MINUTE_IN_MILLSECOND * minute);
            return sdf.format(new Date(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws Exception {
//        Date date = new Date();
//        System.out.println(getCurrentDate(DateUtil.DATE_FORMAT));
//    }
}
