package pa2.array_test2;

public class MovieTheaterTest {

	public static void main(String[] args) {

		MovieTheater theater = new MovieTheater();

		theater.setChairMap();
		theater.name = "1";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "2";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "3";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "4";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "5";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "6";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "7";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "8";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "9";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "10";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "11";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "12";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "13";
		theater.setChair();
		theater.displayChairMap();
		theater.name = "14";
		theater.setChair();
		theater.displayChairMap();
		
		theater.name = "13";
		theater.searchDesk();
	}

}

class MovieTheater {

	public String[][] chairArray;
	public String name;

	public void setChairMap() {
		chairArray = new String[3][4];
	}

	public void setChair() {
		boolean flag = false;
		for (int i = 0; i < chairArray.length; i++) {
			for (int j = 0; j < chairArray[i].length; j++) {
				if (chairArray[i][j] == null) {
					chairArray[i][j] = name;
					flag = true;
					System.out.printf("You seat number is: [%d][%d]%n", i, j);
					break;
				}
				if (flag)
					break;
			}
			if (flag)
				break;
		}

		if (!flag) {
			System.out.println("Sorry, there's any available tickets");
		}
	}

	public void displayChairMap() {
		for (int i = 0; i < chairArray.length; i++) {
			for (int j = 0; j < chairArray[i].length; j++) {
				if (chairArray[i][j] == null) {
					System.out.print("N ");
				} else {
					System.out.print(chairArray[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public void searchDesk() {
		boolean flag = false;
		for (int i = 0; i < chairArray.length; i++) {
			for (int j = 0; j < chairArray[i].length; j++) {
				if(chairArray[i][j] != null && chairArray[i][j].equals(name)) {
					System.out.printf("chair [%d][%d]", i, j);
					flag = true;
				}
				if(flag)
					break;
			}
			if(flag)
				break;
		}
		if(!flag)
			System.out.println("Person is not watching show");
	}
}