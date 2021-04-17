package p2.basic_calcs;

import java.util.Scanner;

public class CalculateDigits {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please, enter a five digit number: ");
		int input = scanner.nextInt();
		
		int dig1 = input / 10_000;
		System.out.println(dig1);
		int dig2 = input / 1_000 % 10;
		System.out.println(dig2);
		int dig3 = input / 100 % 10;
		System.out.println(dig3);
		int dig4 = input / 10 % 10;
		System.out.println(dig4);
		int dig5 = input % 10;
		System.out.println(dig5);
		
		int sum = dig1 + dig2 + dig3 + dig4 + dig5;
		System.out.println("The sum of each digit from the enter number " + input + " is: " + sum);
		
		scanner.close();
	}
}
