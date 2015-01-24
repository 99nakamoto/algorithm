package cmu.codility.practice;
public class CountDaysBetweenMonths {

	// 计算出指定的某年的两个月之间的完整（周1到7）的星期数.

	private final int NUMBEROFDAYS[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
			31, 30, 31 };

	public static void main(String[] args) {
		CountDaysBetweenMonths ins = new CountDaysBetweenMonths();

		System.out.println(ins.countDays(2014, 10, 2014, 10));
		System.out.println(ins.countDays(2013, 11, 2014, 10));
	}

	public int countDays(int y1, int m1, int y2, int m2) {
		// eg. 2014.10 - 2014.11 = 61 days
		// invalid cases
		if (y1 > y2) {
			return 0;
		} else if (y1 == y2 && m1 > m2) {
			return 0;
		}
		// valid cases
		if (y1 != y2) {
			int count1 = countDays(y1, m1, y1, 12);
			int count2 = countDays(y1 + 1, y2 - 1);
			int count3 = countDays(y2, 1, y2, m2);
			return count1 + count2 + count3;
		} else {
			int count = 0;
			for (int i = m1; i <= m2; i++) {
				count += numberOfDays(y1, i);
			}
			return count;
		}
	}

	public int countDays(int y1, int y2) {
		if (y1 > y2) {
			return 0;
		}
		int total = 0;
		for (int i = y1; i <= y2; i++) {
			total += isLeapYear(i) ? 366 : 365;
		}
		return total;
	}

	private boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			return false;
		} else if (year % 100 != 0) {
			return true;
		} else if (year % 400 != 0) {
			return false;
		} else {
			return true;
		}
	}

	private int numberOfDays(int year, int month) {
		if (isLeapYear(year) && month == 2) {
			return 29;
		} else
			return NUMBEROFDAYS[month];
	}
}
