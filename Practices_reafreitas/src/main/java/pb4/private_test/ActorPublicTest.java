package pb4.private_test;

public class ActorPublicTest {

	public static void main(String[] args) {
		
		ActorPublic actor = new ActorPublic();
		actor.actorId = 1;
		actor.firstName = "Denzel";
		actor.lastName = "Washington";
		
		System.out.println(actor.actorId + " " + actor.firstName + " " + actor.lastName);
		
		actor = new ActorPublic();
		actor.actorId = 1;
		actor.firstName = "Denzel";
		actor.lastName = null;
		
		System.out.println(actor.actorId + " " + actor.firstName + " " + actor.lastName);
	}

}

class ActorPublic {
	public int actorId;
	public String firstName;
	public String lastName;
	
}