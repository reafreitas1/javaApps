package p2.basic_calcs; // If necessary remove this to work as the practice book

import java.util.Scanner;

public class TotalSum {

	public static void main(String args[]) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println();
			System.out.println("Enter 4 Integers separated only by spaces: (example 20 30 40 50)");
			int i1 = sc.nextInt();
			int i2 = sc.nextInt();
			int i3 = sc.nextInt();
			int i4 = sc.nextInt();
			int sum = i1 + i2 + i3 + i4;
			System.out.println();

			System.out.println("Sum = " + sum);
		}
	} // end of main method
} // end of class