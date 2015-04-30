//Nick Fernandes
//WarGame
//4.25.2015

import java.util.ArrayList;//Used to allow for array lists
import java.util.Collections;//Used to shuffle array lists
import javax.swing.*;//used for panels
import java.awt.event.*;//used for listener interface
import java.awt.*;//used for events

public class WarGame extends JFrame{
	
   //GUI setup
   //Window settings
   int width = 1600;
   int length = 800;
   
   //Panels to populate sectors of border layout
   JPanel leftPanel = new JPanel();//for first players cards
   JPanel rightPanel = new JPanel();//for second players cards
   JPanel topPanel = new JPanel();//for play button and hand sizes
   JPanel bottomPanel = new JPanel();//for win statement in between players
   
   //Images
   ImageIcon left = new ImageIcon();//image of player1s first card per turn
   ImageIcon leftDown = new ImageIcon();//image of player1s first war card
   ImageIcon leftUp = new ImageIcon();//image of player1s second war card
   ImageIcon right = new ImageIcon();//image of player2s first card per turn
   ImageIcon rightDown = new ImageIcon();//image of player2s first war card
   ImageIcon rightUp = new ImageIcon();//image of player2s second war card
   ImageIcon back = new ImageIcon("back.jpg");//deck backing
   
   //Labels
   //These Labels are what the ImageIcons above are actually put onto
   JLabel player1Card = new JLabel();
   JLabel player1CardDown = new JLabel();
   JLabel player1CardUp = new JLabel();
   JLabel player2Card = new JLabel();
   JLabel player2CardDown = new JLabel();   
   JLabel player2CardUp = new JLabel();
	JLabel player1Default = new JLabel(back);
   JLabel player2Default = new JLabel(back);
   //These labels are for the players hand size
   JLabel player1Size;
   JLabel player2Size;
   //These labels are for win conditions
   JLabel win = new JLabel();//regular win condition
   JLabel winWar = new JLabel();//if player wins on a war, explains so
   
   //Button
   JButton play = new JButton();//Creates the button to play the game and assocaite with an actionListener
   
   //Create deck object and hands for players
	int i = 0;//count variable
   Deck deck = new Deck();//create 52 card deck
	ArrayList<Card> hand1 = new ArrayList<Card>();//player1 hand
	ArrayList<Card> hand2 = new ArrayList<Card>();//player2 hand
	      
   //Setup GUI and hands for game
   public WarGame(){ 
   
      //Prep deck for dealing, then deal
      deck.shuffleDeck();//shuffle the deck
      //Deal player one
      for(i = 0; i < 26; i++)
      	hand1.add(deck.Deck.get(i));
      //Deal player two
      for(i = 26; i < 52; i++)
         hand2.add(deck.Deck.get(i));
      
      //Create labels from current size of decks for players, and add play button
      //labels are added in handsize1, then play button, then handsize2, because java adds labels from left to right
      //Player1 Label
      player1Size = new JLabel("Player 1 Cards: " + hand1.size());//make label of player 1 deck size
      topPanel.add(player1Size);//put label onto leftPanel
      player1Size.setForeground(Color.white);//set color of text
      player1Size.setFont(new Font("COURIER",Font.BOLD,24));//makes font nice and big
      
      //Add a button to play on topPanel
      play = new JButton("Play");//make a new button with the word play in it
      topPanel.add(play);
      play.setFont(new Font("COURIER",Font.BOLD,24));
      play.addActionListener(new PlayListener());
      
      //Player2 Label
      player2Size = new JLabel("Player 2 Cards: " + hand2.size());//make label of player 2 deck size
      topPanel.add(player2Size);//put label onto rightPanel
      player2Size.setForeground(Color.white);//set color of text
      player2Size.setFont(new Font("COURIER",Font.BOLD,24));
      
      //Add Cards images to proper panels
      leftPanel.add(player1Default);//panels must be added in this order, because java adds to panels from left to right
      leftPanel.add(player1Card);
      leftPanel.add(player1CardDown);
      leftPanel.add(player1CardUp);
      rightPanel.add(player2CardUp);
      rightPanel.add(player2CardDown);
      rightPanel.add(player2Card);
      rightPanel.add(player2Default);
      
      //Add win to bottom panel
      bottomPanel.add(win);
      win.setForeground(Color.white);
      win.setFont(new Font("COURIER",Font.BOLD,20));
      bottomPanel.add(winWar);
      winWar.setForeground(Color.white);
      winWar.setFont(new Font("COURIER",Font.BOLD,20));
      
      //Create GUI window
      setLayout(new BorderLayout());//create border layout for the GUI
      add(leftPanel,BorderLayout.WEST);//set leftpanel at west border
      add(rightPanel,BorderLayout.EAST);//set rightpanel at east border
      add(topPanel,BorderLayout.NORTH);//set toppanel at north border
      add(bottomPanel,BorderLayout.CENTER);//set bottompanel at center border
      setVisible(true);//makes game visible
      
      //Set window size
      setSize(width, length);
      
      //Set GUI colors to dark red, because it's metal
      leftPanel.setBackground(new Color(122,0,0));
      rightPanel.setBackground(new Color(122,0,0));
      topPanel.setBackground(new Color(122,0,0));
      bottomPanel.setBackground(new Color(122,0,0)); 
   }//end WarGame
   
   public class PlayListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         String command = e.getActionCommand();//gets the action actually sent by the JButton. This is equal to the string "Play"
         if(command.equals("Play")){
            int check;//check variable to get a return value from compare in the Card class
            
            //Remove war cards from previous war, if one happened
            win.setText(null);
            player1CardUp.setIcon(null);
            player1CardDown.setIcon(null);
            player2CardUp.setIcon(null);
            player2CardDown.setIcon(null);
            
            //Update players hand size
            player1Size.setText("Player 1 Cards: " + hand1.size());
            player2Size.setText("Player 2 Cards: " + hand2.size());
            
            //Check if a player has won
            if(hand1.size() == 0){//if player1 has no cards, player2 wins
               win.setText("Player2 wins");//display win message
               topPanel.remove(play);//remove play button
               player1Card.setIcon(null);//remove all player1 cards
               player1CardUp.setIcon(null);
               player1CardDown.setIcon(null);
            }
            
            else if(hand2.size() == 0){//if player2 has no cards, player1 wins
               win.setText("Player1 wins");//display win message
               topPanel.remove(play);//remove play button
               player2Card.setIcon(null);//remove all player2 cards
               player2CardUp.setIcon(null);
               player2CardDown.setIcon(null);
            }
            
            //display cards
            left = new ImageIcon(hand1.get(hand1.size()-1) + ".jpg");//get hand1 card image 
            right = new ImageIcon(hand2.get(hand2.size()-1) + ".jpg");//get hand2 card image
            player1Card.setIcon(left);//set left card image
            player2Card.setIcon(right);//set right card image
            
            //compare cards
            check = hand1.get(hand1.size()-1).compareTo(hand2.get(hand2.size()-1));//compare the value of the cards displayed
            
            if(check == 1){//if check returns 1, hand1 has a higher card
               hand1.add(hand2.remove(hand2.size()-1));
               Collections.shuffle(hand1);
            }
            else if(check == -1){//if check returns -1, hand2 has a higher card
               hand2.add(hand1.remove(hand1.size()-1));
               Collections.shuffle(hand2);
            }
            while(check == 0){//if check = 0 there is a war
            //Try statement prevents issues with a war causing the end of a game.
            //if a player is put into a war but does not have 3 cards left, that player immediately loses.
            //Due to the way a war is implemented, there will be a NullPointerException thrown if the game
            //does end because of a war. The catch statement below solves this problem
            try{
               player1CardDown.setIcon(back);//sets player1s second card to be facedown
               player2CardDown.setIcon(back);//sets player2s second card to be facedown
               leftUp = new ImageIcon(hand1.get(hand1.size()-3) + ".jpg");//gets player1s 3rd card faceup
               rightUp = new ImageIcon(hand2.get(hand2.size()-3) + ".jpg");//gets player2s 3rd card faceup
               player1CardUp.setIcon(leftUp);//displays player1s 3rd card faceup
               player2CardUp.setIcon(rightUp);//displays player2s 3rd card faceup
               
               check = hand1.get(hand1.size()-3).compareTo(hand2.get(hand2.size()-3));//checks who won the war
               if(check == 1){//player1 wins
                  win.setText("Player 1 wins the war");//displays fact that player1 has won war
                  for(int i = 1; i <= 3; i++)//steals 3 of player2s cards that were used in the war
                     hand1.add(hand2.remove(hand2.size()-1));
                  Collections.shuffle(hand1);//shuffles the deck, otherwise player2s war card would immediately be used
               }
               else if(check == -1){//player2 wins
                  win.setText("Player 2 wins the war");//displays fact that player2 has won war
                  for(int i = 1; i <= 3; i++)//steals 3 of player1s cards that were used in the war
                     hand2.add(hand1.remove(hand1.size()-1));
                  Collections.shuffle(hand2);//shuffles the deck, otherwise player1s war card would immediately be used   
               }
            }//end try
            
            catch(NullPointerException f){//catch for the null pointer exception
               System.out.println(f);
               if(hand1.size() > hand2.size()){//if player1 still has cards after the exception is caught
                  win.setText("Player 1 wins");
                  winWar.setText("Player 2 has no cards!");
                  topPanel.remove(play);//remove play button
                  player2Card.setIcon(null);//remove all player2 cards
                  player2CardUp.setIcon(null);
                  player2CardDown.setIcon(null); 
               }
               else{//if player2 still has cards after the exception is caught
                  win.setText("Player 2 wins");   
                  winWar.setText("Player 1 has no cards!");
                  topPanel.remove(play);//remove play button
                  player1Card.setIcon(null);//remove all player1 cards
                  player1CardUp.setIcon(null);
                  player1CardDown.setIcon(null); 
               }
            }//end catch
            }//end while for war condition
         }//end play if statement
      }//end actionPerformed method
   }//end PlayListener ActionListener
      
   //Driver
   public static void main(String[] args){
		WarGame game = new WarGame();//starts the GUI
      game.setTitle("War Card Game by Nick Fernandes @ UVM, 4.25.2015");//sets title
      game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//causes program to end when window is closed
   }  
}