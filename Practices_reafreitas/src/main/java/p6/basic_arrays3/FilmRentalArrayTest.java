package p6.basic_arrays3;

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
	}

}

class FilmsRentalArray {
	
	int[] filmsRentedDiscount;
	int filmsRented;
	
	public void setFilmRentalArray() {
		filmsRentedDiscount = new int[7];
		filmsRentedDiscount[0] = 0;
		filmsRentedDiscount[1] = 15;
		filmsRentedDiscount[2] = 15;
		filmsRentedDiscount[3] = 15;
		filmsRentedDiscount[4] = 20;
		filmsRentedDiscount[5] = 20;
		filmsRentedDiscount[6] = 25;
	}
	
	public void displayFilmsRentedDiscount() {
		if(filmsRented < 0) {
			System.out.println("This is an invalid number of films");
		} else if (filmsRented < 6) {
			System.out.println(filmsRentedDiscount[filmsRented]);
		} else {
			System.out.println(filmsRentedDiscount[6]);
		}
	}
}