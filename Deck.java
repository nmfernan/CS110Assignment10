/**
@author Nicholas Fernandes
@version 1.0
@since 2015-04-24
*/

import java.util.ArrayList;//used to create arraylist of cards (the deck)
import java.util.Collections;//used for shuffle deck command

public class Deck{
   /**
   newCard is an object that is recreated in the Deck constructor 52 times.
   Each time it is created, the new Card object is added to the Deck ArrayList.
   */
   Card newCard;
   
   /**
   i is used as a count value for passing suit to the Card constructor
   */
   int i = 0;
   
   /**
   j is used as a count value for passing rank to the Card constructor
   */
   int j = 0;
   
   /**
   Deck is the ArrayList of Card objects that comprise a deck.
   An ArrayList is used because it is simple to add, remove, and get items
   */
   static ArrayList<Card> Deck = new ArrayList<Card>();
   
   /**
   Creates the deck using nested for loops
   */
	public Deck(){
		for(i = 1; i < 5; i++){//i starts at 1 for the first suit, and goes up till 4 then quits
			for(j = 2; j < 15; j++){//j starts at 2 for the lowest rank, and goes up till 14 for the highest rank (ace)
				newCard = new Card(i,j);//creates a new Card object
				Deck.add(newCard);//adds the new card to the ArrayList
			}
		}
	}
   
   /**
   Shuffles the deck using the Collections method .shuffle() on the ArrayList Deck created in the Deck constructor.
   @return returns the shuffled deck
   */
   public ArrayList<Card> shuffleDeck(){//simple function using Collections to shuffle the values in the ArrayList
      Collections.shuffle(Deck);//shuffles the deck
      return Deck;//returns the shuffled deck
   }
}