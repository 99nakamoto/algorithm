package epic.undone;

public class Calendar {

	public static void main(String[] args) {
		Calendar ins = new Calendar();

		ins.findWeek(10, 12, 2014, 3);

		System.out.println();
	}

	private void solution() {

	}

	int NUMBEROFDAYS[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	boolean isLeapYear(int year) {
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	}

	int numberOfDaysInMonthAndYear(int month, int year) {
		if (isLeapYear(year) && month == 2) {
			return 29;
		} else
			return NUMBEROFDAYS[month];
	}

	void printDay(int day, int month, int year, int whichDay) {
		System.out.println(day + "/" + month + "/" + year + " is " + whichDay);
	}

	void findWeek(int day, int month, int year, int whichDay) {
		for (int i = whichDay; i > 0; --i) {
			if (day == 1) {
				if (month == 1) {
					year--;
					month = 12;
					day = numberOfDaysInMonthAndYear(month, year);
				} else
					month--;
			} else
				day--;
		}

		for (int i = 0; i < 7; ++i) {
			printDay(day, month, year, i);
			day++;
			if (day > numberOfDaysInMonthAndYear(month, year)) {
				day = 1;
				month++;
				if (month > 12) {
					month = 1;
					year++;
				}
			}
		}
	}

}
