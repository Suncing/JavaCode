package utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author lengon
 * ClassName: DateUtils
 * Description: 时间类操作
 * date 2016年1月18日 上午11:49:39
 */
public class DateUtils {



	public static final String DAY_FORMAT = "yyyyMMdd";
	public static final String DAY_FORMAT1 = "yyyy-MM-dd";
	public static final String HOUR_FORMAT = "yyyyMMddHH";
	public static final String HOUR_FORMAT2 = "yyyy-MM-dd HH";
	public static final String MINUTE_FORMAT = "yyyyMMddHHmm";
	public static final String MINUTE_FORMAT1 = "yyyy-MM-dd HH:mm";
	public static final String SECOND_FORMAT = "yyyyMMddHHmmss";
	public static final String SECOND_FORMAT1 = "yyyy-MM-dd HH:mm:ss";
	public static final String HOUR_FORMAT1 = "MM月dd日 HH时";

	public static final int DAY_IN_MILLSECOND = 1000 * 3600 * 24;
	public static final int HOUR_IN_MILLSECOND = 1000 * 3600;
	public static final int MINUTE_IN_MILLSECOND = 1000 * 60;
	public static final int MINUTE_IN_SECOND = 60;
	public static final int DAY_IN_SECOND = 3600 * 24;
	public static final int HOUR_IN_SECOND = 3600;

	public static String buildTodayStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);
		Date date = new Date();
		try {
			String time = sdf.format(date);
			return time;
		} catch (Exception ex) {
		}
		return null;
	}

	public static String buildNowStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			String time = sdf.format(date);
			return time;
		} catch (Exception ex) {
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

	public static List<String> buildHourTimes(String startTime, String endTime, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			long startTimeMillus = sdf.parse(startTime).getTime();
			long endTimeMillus = sdf.parse(endTime).getTime();
			if (endTimeMillus < startTimeMillus) {
				return null;
			}

			List<String> hours = new ArrayList<String>();

			while (endTimeMillus >= startTimeMillus) {
				hours.add(sdf.format(new Date(startTimeMillus)));
				startTimeMillus += HOUR_IN_MILLSECOND;
			}
			return hours;
		} catch (Exception ex) {
		}
		return null;

	}

	public static List<String> buildTimes(String startTime, String endTime, String format, long timeGap) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			long startTimeMillus = sdf.parse(startTime).getTime();
			long endTimeMillus = sdf.parse(endTime).getTime();
			if (endTimeMillus < startTimeMillus) {
				return null;
			}

			List<String> hours = new ArrayList<String>();

			while (endTimeMillus >= startTimeMillus) {
				hours.add(sdf.format(new Date(startTimeMillus)));
				startTimeMillus += timeGap;
			}
			return hours;
		} catch (Exception ex) {
		}
		return null;

	}

	public static List<String> buildDayTimes(String startTime, String endTime, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			long startTimeMillus = sdf.parse(startTime).getTime();
			long endTimeMillus = sdf.parse(endTime).getTime();
			if (endTimeMillus < startTimeMillus) {
				return null;
			}

			List<String> hours = new ArrayList<String>();

			while (endTimeMillus >= startTimeMillus) {
				hours.add(sdf.format(new Date(startTimeMillus)));
				startTimeMillus += DAY_IN_MILLSECOND;
			}
			return hours;
		} catch (Exception ex) {
		}
		return null;

	}

	/**
	 * 
	 * @Title: futureHour
	 * @Description: 未来的第几小时的string
	 * @param start
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
	 * @Title: futureHour
	 * @Description: 未来的第几分钟的string
	 * @param start
	 * @param format
	 * @param minute
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

	public static int dayGap(String start, String end, String startFormat, String endFormat) {
		SimpleDateFormat startSdf = new SimpleDateFormat(startFormat);
		SimpleDateFormat endSdf = new SimpleDateFormat(endFormat);
		long startTime;
		try {
			startTime = startSdf.parse(start).getTime();
			long endTime = endSdf.parse(end).getTime();
			return (int) ((endTime - startTime) / DAY_IN_MILLSECOND);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int hourGap(String start, String end, String startFormat, String endFormat) {
		SimpleDateFormat startSdf = new SimpleDateFormat(startFormat);
		SimpleDateFormat endSdf = new SimpleDateFormat(endFormat);
		long startTime;
		try {
			startTime = startSdf.parse(start).getTime();
			long endTime = endSdf.parse(end).getTime();
			return (int) ((endTime - startTime) / HOUR_IN_MILLSECOND);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int minuteGap(String start, String end, String startFormat, String endFormat) {
		SimpleDateFormat startSdf = new SimpleDateFormat(startFormat);
		SimpleDateFormat endSdf = new SimpleDateFormat(endFormat);
		long startTime;
		try {
			startTime = startSdf.parse(start).getTime();
			long endTime = endSdf.parse(end).getTime();
			return (int) ((endTime - startTime) / MINUTE_IN_MILLSECOND);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static long getTime(String time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(time).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String getTime(long time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(new Date(time));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String formatDataFromString(String time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(sdf.parse(time));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String formatDataFromString(Date time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(time);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将字符串转换成指定的时间格式的字符串
	 * 
	 * @Title: getTimeString
	 * @Description: TODO
	 * @param time
	 *            yyyyMMddHHmmss
	 * @param format
	 * @return String
	 */
	public static String getTimeString(String time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		SimpleDateFormat sdfTemp = new SimpleDateFormat(SECOND_FORMAT);
		try {
			return sdf.format(sdfTemp.parse(time));
		} catch (Exception e) {
//			LogUtils.error("convert date to String error:" + e);
		}
		return null;
	}

	/**
	 * 将字符串转换成指定的时间格式的字符串
	 * 
	 * @Title: getTimeString
	 * @Description: TODO
	 * @param time
	 *            yyyyMMddHHmmss
	 * @param
	 * @return String
	 */
	public static String getTimeString(String time, String inFormat, String outFormat) {
		SimpleDateFormat inSdf = new SimpleDateFormat(inFormat);
		SimpleDateFormat outSdf = new SimpleDateFormat(outFormat);
		try {
			return outSdf.format(inSdf.parse(time));
		} catch (Exception e) {
//			LogUtils.error("convert date to String error:" + e);
		}
		return null;
	}

	public static Date formatDate(String dateStr) {
		Date date = null;

		try {
			SimpleDateFormat e = new SimpleDateFormat(MINUTE_FORMAT);
			date = e.parse(dateStr);
		} catch (Exception e) {
//			LogUtils.error("format date to String error:" + e);
		}

		return date;
	}

	public static String parseDate(Date date) {
		String str = "";

		try {
			SimpleDateFormat e = new SimpleDateFormat(MINUTE_FORMAT);
			str = e.format(date);
		} catch (Exception e) {
//			LogUtils.error("parse date to String error:" + e);
		}

		return str;
	}

	public static Date parseToDate(String timeStr, String formatStr) {
		Date date = null;
		try {
			SimpleDateFormat sf = new SimpleDateFormat(formatStr);
			date = sf.parse(timeStr);
		} catch (Exception e) {
//			LogUtils.error("format date to String error:" + e);
		}
		return date;
	}

	public static int getDayIndex(String timeStr) {
		long time = DateUtils.getTime(timeStr, DateUtils.DAY_FORMAT);
		Calendar startCal = Calendar.getInstance();
		startCal.setTimeInMillis(time);
		return startCal.get(Calendar.DAY_OF_YEAR);
	}

	public static String getDayStr(int index, String year) {
		long time = DateUtils.getTime(year, "yyyy");
		Calendar timeCal = Calendar.getInstance();
		timeCal.setTimeInMillis(time);
		timeCal.add(Calendar.DAY_OF_YEAR, index - 1);
		return DateUtils.getTime(timeCal.getTimeInMillis(), DateUtils.DAY_FORMAT);
	}

	/**
	 * 日期转星期
	 *
	 * @param datetime
	 * @return
	 */
	public static String dateToWeek(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

public  static  String getNewFormat(String data)
{
	String result="";

	try{
		Date date = new SimpleDateFormat("yyyyMMddHHmm").parse(data);
    result= new SimpleDateFormat("yyyy年MM月dd日HH:mm").format(date);
		return  result;
		}catch (Exception e)
	{
		return  data;
	}
}

	/**
	 * 计算天数(该年第几天)
	 * */
	public static Integer getDays(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,month-1);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 计算两个日期间小时数
	 * */
	public static int getHours(int year1, int day1, int hour1, int year2, int day2, int hour2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.YEAR, year1);
		calendar1.set(Calendar.DAY_OF_YEAR, day1);
		calendar1.set(Calendar.HOUR_OF_DAY, hour1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.YEAR, year2);
		calendar2.set(Calendar.DAY_OF_YEAR, day2);
		calendar2.set(Calendar.HOUR_OF_DAY, hour2);
		long time1 = calendar1.getTime().getTime();
		long time2 = calendar2.getTime().getTime();
		long hours = (time2-time1)/(1000*60*60);
		return (int)hours;
	}

	/**
	 * 增加小时数
	 * */
	public static Map<String,Integer> addHours(int year, int day, int hour, int addHours) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.add(Calendar.HOUR_OF_DAY,addHours);
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		map.put("year",calendar.get(Calendar.YEAR));
		map.put("day",calendar.get(Calendar.DAY_OF_YEAR));
		map.put("hour",calendar.get(Calendar.HOUR_OF_DAY));
		return map;
	}
	public static Map<String,Integer> addHours1(int year, int month,int day, int hour, int addHours) {
		String startDate=year+String.format("%02d", month)+String.format("%02d", day)+String.format("%02d", hour);
		String date=futureHour(startDate, HOUR_FORMAT,addHours);
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.YEAR, year);
//		calendar.set(Calendar.MONTH,month);
//		calendar.set(Calendar.DAY_OF_MONTH, day);
//		calendar.set(Calendar.HOUR_OF_DAY, hour);
//		calendar.add(Calendar.HOUR_OF_DAY,addHours);
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//		map.put("year",calendar.get(Calendar.YEAR));
//		map.put("month",calendar.get(Calendar.MONTH));
//		map.put("day",calendar.get(Calendar.DAY_OF_MONTH));
//		map.put("hour",calendar.get(Calendar.HOUR_OF_DAY));
		map.put("year",Integer.parseInt(date.substring(0,4)));
		map.put("month",Integer.parseInt(date.substring(4,6)));
		map.put("day",Integer.parseInt(date.substring(6,8)));
		map.put("hour",Integer.parseInt(date.substring(8)));
		return map;
	}



}
