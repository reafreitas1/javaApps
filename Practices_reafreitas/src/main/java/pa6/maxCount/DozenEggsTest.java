package pa6.maxCount;

public class DozenEggsTest {

	public static void main(String[] args) {
		
		DozenEggs eggs = new DozenEggs();
		
		eggs.displayCount();

	}

}

class DozenEggs {
	
	final int MAX_COUNT = 100;
	
	public void displayCount() {
		
		for(int i = 1; i < MAX_COUNT; i++) {
			if(i % 12 == 0) {
				System.out.print(i + " ");
			}
		}
	}
	
}