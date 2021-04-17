package p2.basic_calcs;

import java.util.Scanner;

public class CalculateBmi {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please, enter your weight in kg: ");
		double weight = scanner.nextDouble();
		
		System.out.print("Please, enter your height in m: ");
		double height = scanner.nextDouble();
		
		double bmi = weight / (height * height);
		System.out.println("Your BMI is " + bmi);
		
		scanner.close();
	}

}
