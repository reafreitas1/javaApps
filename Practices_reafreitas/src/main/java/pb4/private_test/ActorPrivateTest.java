package pb4.private_test;

public class ActorPrivateTest {

	public static void main(String[] args) {
		
		ActorPrivate actor = new ActorPrivate();
		actor.setActorId(1);
		actor.setFirstName("Denzel");
		actor.setLastName("Washington");
		
		System.out.println(actor.getActorId() + " " + actor.getFirstName() + " " + actor.getLastName());
		
		actor = new ActorPrivate();
		actor.setActorId(1);
		actor.setFirstName("Denzel");
		actor.setLastName(null);
		
		System.out.println(actor.getActorId() + " " + actor.getFirstName() + " " + actor.getLastName());
		

	}

}

class ActorPrivate {
	private int actorId;
	private String firstName;
	private String lastName;
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName == null) {
			this.lastName = "no name assigned";
		} else {
			this.lastName = lastName;	
		}
			
		
	}
	
	
}