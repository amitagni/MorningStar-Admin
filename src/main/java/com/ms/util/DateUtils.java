package com.ms.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	public static final int CURRENT_YEAR = Calendar.getInstance().get(1);

	public static Date getCurrentDateTimeInGMT() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(14, cal.getTimeZone().getRawOffset() * -1);
		return cal.getTime();
	}

	public static Date getCurrentDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.getTime();
	}

	public static Calendar getCustomCalendarInstance() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(0);
		return cal;
	}

	public static Date getPreviousDateByDays(Date currentDate, int noOfDays) {
		Calendar currentCalander = Calendar.getInstance();
		currentCalander.setTime(currentDate);
		currentCalander.add(6, -noOfDays);
		return currentCalander.getTime();
	}

	public static long getTimeInMilis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	public static Date convertToDateObject(String dateinStr, String format) {
		Date date = null;
		if (dateinStr != null && !dateinStr.equals("")) {
			try {
				SimpleDateFormat e = new SimpleDateFormat(format);
				date = e.parse(dateinStr);
			} catch (ParseException arg3) {
				arg3.printStackTrace();
			}
		}

		return date;
	}

	public static String convertToStringObject(Date date, String format) {
		String dateStr = null;
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(format);
			dateStr = df.format(date);
		}

		return dateStr;
	}

	public static Timestamp convertStrtDatetoTimeStamp(String dateStr) {
		Date date = convertToDateObject(dateStr, "MM/dd/yyyy");
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			Timestamp tm = new Timestamp(cal.getTimeInMillis());
			return tm;
		} else {
			return null;
		}
	}

	public static String convertTimeStampToDateStr(Timestamp timestamp) {
		if (timestamp != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(timestamp.getTime());
			return convertToStringObject(cal.getTime(), "MM/dd/yyyy");
		} else {
			return null;
		}
	}

	public static String convertDateFormat(String sourceDate) {
		String formattedDate = "";
		SimpleDateFormat readFormat = new SimpleDateFormat("MMM dd yyyy hh:mmaaa", Locale.US);
		SimpleDateFormat writeFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;

		try {
			date = readFormat.parse(sourceDate);
		} catch (ParseException arg5) {
			arg5.printStackTrace();
		}

		if (date != null) {
			formattedDate = writeFormat.format(date);
		}

		return formattedDate;
	}

	public static void main(String[] args) {
		System.out.println("date" + convertToStringObject(getCurrentDateTime(), "dd MMMM, yyyy"));
		System.out.println("date" + convertToDateObject("06 December, 2017", "dd MMMM, yyyy"));
	}
}