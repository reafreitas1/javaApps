package pa4.film_test;

import java.util.ArrayList;

public class FilmTest {

	public static void main(String[] args) {
		
	
		Actor actor1 = new Actor();
		
		Film film = new Film();
		
		int actorsCount = 0;
		
		actorsCount = film.addActor(actor1);
		System.out.printf("Total number of actors is %s%n", actorsCount);
		
		Actor actor2 = new Actor();
		Actor actor3 = new Actor();
		Actor actor4 = new Actor();
		Actor actor5 = new Actor();
		Actor actor6 = new Actor();
		Actor actor7 = new Actor();
		Actor actor8 = new Actor();
		
		film.addActor(actor2);
		film.addActor(actor3);
		film.addActor(actor4);
		film.addActor(actor5);
		film.addActor(actor6);
		film.addActor(actor7);
		actorsCount = film.addActor(actor8);
		
		System.out.printf("Total number of actors is %s%n", actorsCount);
		
	}

}


class Actor {
	
}

class Film {

	ArrayList<Actor> actors = new ArrayList<>();
	
	public int addActor(Actor actor) {
		actors.add(actor);
		return actors.size();
	}

	
	
}