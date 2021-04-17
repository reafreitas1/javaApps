package pa9.category;

public class CategoryTest {

	public static void main(String[] args) {
		
		Category cat = new Category();
		cat.display();

		Category cat1 = new Category();
		cat1.setCategoryInfo(1, "Cat1");
		cat1.display();
		
		Category cat2 = new Category();
		cat2.setCategoryInfo(2, "Cat1", 1);
		cat2.display();
	}

}

class Category {
	
	int categoryId = 0;
	String name = "-name required-";
	int categoryGroup = 0;
	
	public void setCategoryInfo(int id, String name) {
		this.categoryId = id;
		this.name = name;
	}
	
	public void setCategoryInfo(int id, String name, int categoryGroup) {
		setCategoryInfo(id, name);
		this.categoryGroup = categoryGroup;
	}
	
	public void display() {
		System.out.printf("Id: %d%nName: %s; Group: %d%n", categoryId, name, categoryGroup);
	}
	
}