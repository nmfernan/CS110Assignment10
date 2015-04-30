/**
@author Nicholas Fernandes
@version 1.0
@since 2015-04-24
*/
public class Card{
   /**
   suit of Card object
   */
	private int suit;
   /**
   rank of Card object
   */
   private int rank;
	
   /**
   Constructor for Card object
   @param s describes the suit of the Card object.
   1 represents hearts,
   2 represents diamonds,
   3 represents clubs,
   4 represents spades
   @param r describes the rank of the Card object.
   2 through 10 represent their respective value,
   11 is jack,
   12 is queen,
   13 is king,
   14 is ace.
   */
	public Card(int s, int r){
		setSuit(s);
		setRank(r);
	}
   
	/**
   Gets the suit of the Card object.
   @return returns the suit of the Card object
   */
	public int getSuit(){
      return suit;
	}
   
   /**
   Sets suit the suit of the Card object
	@param s is an integer passed describing the suit of the Card object.
   If the value is 1, the suit is hearts.
   If the value is 2, the suit is diamonds.
   If the value is 3, the suit is clubs.
   If the value is 4 the suit is spades.
   */ 
   public void setSuit(int s){
		suit = s;
	}	

   /**
   Gets the rank of the Card object.
   @return returns the rank of the Card object
   */
   public int getRank(){
		return rank;
	}
   	   
   /**
   Sets the rank of the Card object
   @param r is an integer passed describing the rank of the Card object.
   standard numerical cards, 2 through 10, are kept as the same.
   If the card is a jack, its rank is 11.
   If the card is a queen, its rank is 12.
   If the card is a king, its rank is 13.
   If the card is an ace, its rank is 14.
   */
	public void setRank(int r){//irrelavant for this implementation
		rank = r;
	}
   	
   /**
   compareTo method compares the rank of the calling Card object
   to the rank of the passed Card object  
   @param c is the Card object passed for comparison to the calling object
   @return check is the integer returned to describe the comparison.
   If the rank of the cards are equal, a 0 is returned.
   If the rank of the calling object is greater than the arguement, a 1 is returned.
   If the rank of the calling object is less than the arguement, a -1 is returned.
   */
	public int compareTo(Card c){
	   int check = -2;
      if(getRank() == c.getRank())
         check = 0;
      else if(getRank() > c.getRank())
         check = 1;
      else if(getRank() < c.getRank())
         check = -1;   
      return check;//return value
   }

   
   /**
   toString method combines the suit and rank of the Card object for concatenation with ".jpg"
   so images can be retrieved. The concatenation of the rank and suit is as follows: str = strRank + strSuit;
   @return is equal to the concatenation of the rank and suit of the card.
   The method toString converts the suit and rank to a individual strings, concatenates them,
   and then returns the value
   */
   public String toString(){
      String strSuit = "";
      String strRank = "";
      String str = "";
      
      if(getSuit() == 1)//if suit == 1, make the suit hearts
         strSuit = "h";
      else if(getSuit() == 2)//if suit == 2, make the suit diamonds
         strSuit = "d";
      else if(getSuit() == 3)//if suit == 3, make the suit clubs
         strSuit = "c";
      else if(getSuit() == 4)//if suit == 4, make the suit spades
         strSuit = "s";
                   
      if(getRank() == 11)//if rank == 11, make the rank jack
         strRank = "jack";
      else if(getRank() == 12)//if rank == 12, make the rank queen
         strRank = "queen";
      else if(getRank() == 13)//if rank == 13, make the rank king
         strRank = "king";
      else if(getRank() == 14)//if rank == 14, make the rank ace
         strRank = "ace";
      else//if the rank is a number that can appear on a playing card, turn it into a str
         strRank = str + rank;
         
      str = strRank + strSuit;//combine the string so it can be used to call on images with ".jpg" concatenation
      return str;//return final result               
   }

}