package berlinclock;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.*;

public class BerlinClockConverter {

	public static String getSecond(DateTime dt) {

		int second = dt.getSecondOfMinute();
		if (second % 2 == 0) {
			return "Y";
		}
		return "O";
	}

	private static String createROString(int rs, int os) {
		String out = StringUtils.leftPad("", rs, "R");
		out = StringUtils.rightPad(out, os, "O");
		return out;
	}

	private static String createYOString(int rs, int os) {
		String out = StringUtils.leftPad("", rs, "Y");
		out = StringUtils.rightPad(out, os, "O");
		return out;
	}

	public static String getHour5(DateTime dt) {
		int hour = dt.getHourOfDay();
		int rs = hour / 5;
		return createROString(rs, 4);
	}

	public static String getHour1(DateTime dt) {
		int hour = dt.getHourOfDay();
		int rs = hour % 5;
		return createROString(rs, 4);
	}

	public static String getMinute5(DateTime dt) {
		int minute = dt.getMinuteOfHour();
		
		String output = generateYRString(minute);
		
		return StringUtils.rightPad(output, 11, "O");
		
	}

	private static String generateYRString(int minute) {
		String output ="";
		int counter = 1;
		while (minute / 5 > 0){
			output = decideBetweenRedAndYellow(output, counter);
			counter++;
			minute = minute - 5;
		}
		return output;
	}

	private static String decideBetweenRedAndYellow(String output, int counter) {
		if (counter % 3 == 0){
			output = output + "R";
		}else {
			output = output + "Y";
		}
		return output;
	}

	public static String getMinute1(DateTime dt) {
		int minute = dt.getMinuteOfHour();
		int rs = minute % 5;
		return createYOString(rs, 4);
	}

}
