import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


public class GenCards {

	public static void main(String[] args) {
		//Variables 
		final int NUMCARDS = 10000;
		Random rd = new Random();
		int index;
		String[] Suits = {"C", "D", "H", "S"};
		String[] Faces = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		HashSet<String> cards = new HashSet<String>();
		
		//Create Cards
		for (String suit : Suits) {
			for (String face : Faces) {
				cards.add(suit+face);
			}
		} // End of Creating Cards
		
		//Deck Size - In case deck wants to be changed, no hard coded numbers
		int size = cards.size();
		
		//Prints NUMCARDS cards to Console 
		for(int i = 0; i < NUMCARDS; i++) {
			index = rd.nextInt(size);
			Iterator<String> iter = cards.iterator();
			for (int j = 0; j < index; j++) {
				iter.next();
			}
			System.out.println(iter.next());
		} //End of Printing Random Cards
	} // End of Main
} // End of GenCards Class
