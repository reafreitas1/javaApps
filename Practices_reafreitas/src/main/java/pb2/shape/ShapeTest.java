package pb2.shape;

public class ShapeTest {

	public static void main(String[] args) {
		
		Square square = new Square(5, 5);
		
		square.draw();
		
		System.out.println();
		Rectangle rectangle = new Rectangle(10, 5);
		
		rectangle.draw();

	}

}

class Rectangle {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public double getArea() {
		return width * height;
	}

	public void draw() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}

class Square {
	private int width;
	private int height;

	public Square(int width, int height) {
		if ((width > 0 && width < 30) && width == height) {
			this.width = width;
			this.height = height;
		} else {
			System.out.println("Width must be between 0 and 30 and width must equal height");
		}
	}

	public double getArea() {
		return width * height;
	}

	public void draw() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
