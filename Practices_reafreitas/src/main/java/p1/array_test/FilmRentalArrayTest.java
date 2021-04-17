package p1.array_test;

import java.util.ArrayList;

public class FilmRentalArrayTest {

	
	public static void main(String[] args) {
		
		FilmsRentalArray films = new FilmsRentalArray();
		
		films.setFilmRentalArray();
		films.filmsRented = 1;
		films.displayFilmsRentedDiscount();
		
		films.filmsRented = -1;
		films.displayFilmsRentedDiscount();
		
		films.filmsRented = 6;
		films.displayFilmsRentedDiscount();
		
		films.filmsRented = 7;
		films.displayFilmsRentedDiscount();
		
		films.displayPossibleDiscounts();
	}

}

class FilmsRentalArray {
	
	ArrayList<Integer> filmsRentedDiscount;
	int filmsRented;
	
	public void setFilmRentalArray() {
		filmsRentedDiscount = new ArrayList<Integer>();
		filmsRentedDiscount.add(0);
		filmsRentedDiscount.add(15);
		filmsRentedDiscount.add(15);
		filmsRentedDiscount.add(15);
		filmsRentedDiscount.add(20);
		filmsRentedDiscount.add(20);
		filmsRentedDiscount.add(25);
	}
	
	public void displayFilmsRentedDiscount() {
		if(filmsRented < 0) {
			System.out.println("This is an invalid number of films");
		} else if (filmsRented < 6) {
			System.out.println(filmsRentedDiscount.get(filmsRented));
		} else {
			System.out.println(filmsRentedDiscount.get(6));
		}
	}
	
	public void displayPossibleDiscounts() {
		for(int i = 0; i < filmsRentedDiscount.size(); i++) {
			System.out.println(filmsRentedDiscount.get(i));
		}
	}
}