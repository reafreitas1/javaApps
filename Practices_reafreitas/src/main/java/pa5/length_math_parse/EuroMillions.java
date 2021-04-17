package pa5.length_math_parse;

import java.util.Arrays;

public class EuroMillions {

	public static void main(String[] args) {

		int randomNum = 0;
		int guess;

		System.out.println(Arrays.toString(args));
		
		if (args.length == 0) {
			System.out.println("Enter a number when calling this application. Or enter help to bring this help text");
		} else if (args[0].equalsIgnoreCase("help")) {
			System.out.println("Enter a number when calling this application.");
		} else {
			randomNum = ((int) (Math.random() * 5) + 1);
			guess = Integer.parseInt(args[0]);
			if (randomNum == guess) {
				System.out.println("Congratulations");
			} else {
				System.out.println("Wrong. Random number was " + randomNum);
			}
		}
	}
}
