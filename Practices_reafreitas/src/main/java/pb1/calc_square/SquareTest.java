package pb1.calc_square;

public class SquareTest {

	public static void main(String[] args) {

		Square r1 = new Square();
		r1.draw();
		
//		
//		Rectangle rectangle = new Rectangle(5, 5);
//		System.out.println(rectangle.getArea());
//		rectangle.draw();
	}
}

class Square {
	private int width;
	private int height;

	public Square() {
		width = 25;
		height = 10;
	}

	public Square(int width, int height) {
		if((width > 0 && width < 30) && width == height) {
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
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}