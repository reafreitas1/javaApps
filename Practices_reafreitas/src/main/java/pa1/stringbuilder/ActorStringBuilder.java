package pa1.stringbuilder;

public class ActorStringBuilder {

	StringBuilder name = new StringBuilder(8);
	StringBuilder phoneNumber = new StringBuilder();
	
	public void displayActorInfo() {
		name.append("Denzel");
		name.append(" ");
		name.append("Washington");
		System.out.println(name.toString()); // it's really not necessary, because sysout calls the toString implicitly 
		System.out.println(name.capacity());
		
		phoneNumber.append("998887766");
		phoneNumber.insert(2, " ");
		phoneNumber.insert(6, " ");
		phoneNumber.insert(9, " ");
		System.out.println(phoneNumber);
		
		System.out.println(name.substring(0, name.indexOf(" ")));
	}
	
}
