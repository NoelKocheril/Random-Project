import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CheckDeck {
	public static void main(String args[]) throws Exception {
		String input;
		Scanner in = new Scanner(System.in);
		int min = Integer.MAX_VALUE;
		String[] Suits = {"C", "D", "H", "S"};
		String[] Faces = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		Set<String> cards;
		HashMap<String, Integer> deck = new HashMap<String, Integer>();
		
		// Set up Deck
		for (String suit : Suits) {
			for (String face : Faces) {
				deck.put(suit+face, 0);
			}
		} // End of Creating Deck and Start Value
	
		cards = deck.keySet();
//		System.out.println(deck);
		
		// Add Cards to Deck
		while (true) {
			System.out.print("Enter Card: ");

			// Allow for Upper and Lower Case Entry
			input = in.nextLine().toUpperCase();
			
			//If User Enters Quit Exit and Do Value Checks
			if(input.compareToIgnoreCase("quit") == 0) break;
			
			//If User enters a card that is not part of deck, do not add to hashmap
			if(!cards.contains(input)) {
				System.out.println(input + " is not a valid card");
				System.out.println("Valid Cards are: " + cards);
				continue;
			}
			
			//Increment Value of Card
			deck.put(input, deck.get(input)+1);
		} //End of Getting Cards from User
		
		in.close(); // No Memory Leak

		// Find Lowest Card Count
		for (String card : cards) {
			if (min > deck.get(card)) min = deck.get(card);
		} // End of Finding Lowest Card
		
		System.out.printf("\nThe Max number of Cards that are Possible is: %d\n", min);
		System.out.println(deck);
		
		//Calculates and Prints how many Extra Cards
		int extra = 0;
		int e;
		for (String card : cards) {
			e = deck.get(card)-min;
			if(e < 0)
				System.out.println(e);
			extra += e;
		} // End of Extra Cards Check
		System.out.println("You have " + Integer.toString(extra) + " Extra Cards.");
	} // End of Main
} // End of Check Deck Class
