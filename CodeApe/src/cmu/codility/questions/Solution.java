package cmu.codility.questions;

// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

	private final int[] DAYSOFMONTH = new int[] { 0, 31, 28, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31 };

	public int solution(int Y, String A, String B, String W) {
		// write your code in Java SE 8
		int startMon = decodeMonth(A);
		int endMon = decodeMonth(B);
		int dayJanFirst = decodeDay(W);
		// find which day of week is startMon and endMon
		int startMonDayOfWeek = calculateDayOfWeek(Y, dayJanFirst, startMon, 1);
		// startMonDayOfWeek - first day
		int endMonDayOfWeek = calculateDayOfWeek(Y, dayJanFirst, endMon,
				DAYSOFMONTH[endMon]);
		// endMonDayOfWeek - last day
		// find next Monday in startMon
		int adjustedStartDate = (8 - startMonDayOfWeek) % 7 + 1;
		// find last Sunday in endMon
		int adjustedEndDate = DAYSOFMONTH[endMon] - (endMonDayOfWeek % 7);
		int adjustedInBetweenDayCount = countDays(Y, startMon,
				adjustedStartDate, endMon, adjustedEndDate);
		return (adjustedInBetweenDayCount + 1) / 7;
	}

	private int countDays(int year, int m1, int d1, int m2, int d2) {
		// count number of days given 2 dates (d/m/y all given)
		if (m1 == m2) {
			return d2 - d1;
		} else {
			int daysInAmonth = DAYSOFMONTH[m1] - d1 + 1;
			return daysInAmonth + countDays(year, m1 + 1, 1, m2, d2);
		}
	}

	private int calculateDayOfWeek(int Y, int dayJanFirst, int mon, int day) {
		return (dayJanFirst - 1 + countDays(Y, 1, 1, mon, day)) % 7 + 1;
	}

	private int getNumOfDays(int year, int month) {
		if (year % 4 == 0 && month == 2) {
			return 29;
		}
		return DAYSOFMONTH[month];
	}

	private int decodeMonth(String month) {
		if (month.equals("January")) {
			return 1;
		} else if (month.equals("February")) {
			return 2;
		} else if (month.equals("March")) {
			return 3;
		} else if (month.equals("April")) {
			return 4;
		} else if (month.equals("May")) {
			return 5;
		} else if (month.equals("June")) {
			return 6;
		} else if (month.equals("July")) {
			return 7;
		} else if (month.equals("August")) {
			return 8;
		} else if (month.equals("September")) {
			return 9;
		} else if (month.equals("October")) {
			return 10;
		} else if (month.equals("November")) {
			return 11;
		} else if (month.equals("December")) {
			return 12;
		}
		return -1;
	}

	private int decodeDay(String day) {
		if (day.equals("Monday")) {
			return 1;
		} else if (day.equals("Tuesday")) {
			return 2;
		} else if (day.equals("Wednesday")) {
			return 3;
		} else if (day.equals("Thursday")) {
			return 4;
		} else if (day.equals("Fridy")) {
			return 5;
		} else if (day.equals("Saturday")) {
			return 6;
		} else if (day.equals("Sunday")) {
			return 7;
		}
		return -1;
	}
}
