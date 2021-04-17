package p4.basic_arrays;

public class Main {
	
	public static void main(String[] args) {
		
		// Exercise 01
		int id = 1;
		String firstName = "Denzel";
		String lastName = "Washington";
		String bio = "Small bio";
		
		System.out.println("Actor information:"
				+ "\nId: " + id
				+ "\nFirstName: " + firstName
				+ "\nLastName: " + lastName
				+ "\nBiography: " + bio);
		
		
		firstName = "Denzel";
		lastName = "Washington";
		bio = "Small bio";
		
		System.out.println("Actor information:"
				+ "\nId: " + id
				+ "\nFirstName: " + firstName
				+ "\nLastName: " + lastName
				+ "\nBiography: " + bio);
		
		// Exercise 02
		Actor bruce = new Actor();
		bruce.id = 1;
		bruce.firstName = "Bruce";
		bruce.lastName = "Willis";
		bruce.bio = "Bruce Willis bio";
		bruce.displayInfo();
		
		Actor denzel = new Actor();
		denzel.id = 2;
		denzel.firstName = "Denzel";
		denzel.lastName = "Washington";
		denzel.bio = "Denzel's bio";
			
		denzel.displayInfo();
		
		
		

	}

}
