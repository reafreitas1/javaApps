package p5.basic_arrays2;

import java.util.Scanner;

import p4.basic_arrays.Actor;

public class Main {

	public static Actor[] actors = new Actor[10];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Actor actor = new Actor();
		actor.id = 1;
		
		System.out.print("Please, enter your firstname: ");
		actor.firstName = scanner.nextLine().strip();

		System.out.print("Please, enter your last name: ");
		actor.lastName = scanner.nextLine().strip();
		
		System.out.print("Please, enter your biography: ");
		actor.bio = scanner.nextLine().strip();
		
		actors[0] = actor;
		
		actor = actors[0];
		actor.displayInfo();
		scanner.close();
	}
	
}
