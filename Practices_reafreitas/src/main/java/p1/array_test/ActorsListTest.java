package p1.array_test;

import java.util.ArrayList;

public class ActorsListTest {

	public static void main(String[] args) {
		ActorsList list = new ActorsList();
		list.setList();
		list.manipulateList();
		list.displayNames();
	}

}

class ActorsList {
	
	public ArrayList<String> listOfActors;
	
	public void setList() {
		listOfActors = new ArrayList<>();
		listOfActors.add("Joe Smith");
		listOfActors.add("Jane Smith");
		listOfActors.add("John Smith");
		listOfActors.add("Mr. Smith");
//		listOfActors.add(1);
//		listOfActors.add(1.2);
//		listOfActors.add(true);
		System.out.println("List of actors (setList): " + listOfActors);
	}
	
	public void manipulateList() {
		listOfActors.remove("Joe Smith");
		System.out.println("List of actors (manipulateList): " + listOfActors);
		System.out.println("Size of actors: " + listOfActors.size());
		listOfActors.add(1, "Joe Smith");
		System.out.println("List of actors (manipulateList): " + listOfActors);
		System.out.println("Size of actors: " + listOfActors.size());
		
		for(var item : listOfActors) {
//			((String)item).strip();
			item.strip();
		}
	}
	
	public void displayNames() {
		System.out.println("Printing the actor list");
		for(var actor : listOfActors) {
			System.out.println(actor);
		}
	}
	
}