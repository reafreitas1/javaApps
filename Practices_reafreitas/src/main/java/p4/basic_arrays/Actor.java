package p4.basic_arrays;

public class Actor {

	public int id;
	public String firstName;
	public String lastName;
	public String bio;

	public void displayInfo() {
		System.out.println("Actor information:"
				+ "\nId: " + id
				+ "\nFirstName: " + firstName
				+ "\nLastName: " + lastName
				+ "\nBiograph: " + bio);
	}

	public String fullName() {
		return firstName + " " + lastName;
	}
	
}
