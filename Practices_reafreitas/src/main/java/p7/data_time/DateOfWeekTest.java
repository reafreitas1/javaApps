package p7.data_time;

public class DateOfWeekTest {

	public static void main(String[] args) {

		DateOfWeek date = new DateOfWeek();

		date.dayNumber = 2;
		date.displayDay();

		GreetingTime time = new GreetingTime();

//		time.currentTime = 1900;

		time.displayPartOfDay();

	}

}

class DateOfWeek {

	int dayNumber = 1;

	public void displayDay() {
		if (dayNumber == 1) {
			System.out.println("Monday");
		} else if (dayNumber == 2) {
			System.out.println("Tuesday");
		} else if (dayNumber == 3) {
			System.out.println("Wednesday");
		} else if (dayNumber == 4) {
			System.out.println("Thursday");
		} else if (dayNumber == 5) {
			System.out.println("Friday");
		} else if (dayNumber == 6) {
			System.out.println("Saturday");
		} else if (dayNumber == 7) {
			System.out.println("Sunday");
		} else {
			System.out.println("Day not valid");
		}
	}
}

class GreetingTime {
	int currentTime = 559;

	public void displayPartOfDay() {
		if(checkNumber()) {
			if (currentTime >= 600 && currentTime <= 1200) {
				System.out.println("Good Morning");
			} else if (currentTime > 1200 && currentTime <= 1900) {
				System.out.println("Good Afternoon");
			} else {
				System.out.println("Good Evening");
			}
		} else {
			System.out.println("Not valid data");
		}
	}

	public boolean checkNumber() {
		if(currentTime < 0 || currentTime > 2359) {
			return false;
		} else {
			int number = currentTime / 10 % 10;
			if(number > 5) {
				return false;
			}
		}

		return true;
	}
}