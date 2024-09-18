/*
* file name: Blackjack.java
* Authors:        Ming Zhang
* last modified:  9/17/2022
*/

// Main class that creates the game and runs it
public class Blackjack {
    
    // Creates an arrayList playerHand and dealerHand for each side to hold cards
    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();

    // Creates a new Deck object to hold the deck.
    Deck deck = new Deck();

    // Sets the reshuffleCutoff variable.
    public int reshuffleCutoff;

    // Creates a integer variable to store the player's points and sets it to 0.
    public int playerPoints = 0;


    /*
    The Constructor that stores the reshuffleCutoff value and the basic methods of the game.
     */
    public Blackjack(int reshuffleCutoff){

        this.reshuffleCutoff = reshuffleCutoff;     
                
        reset();

    }

    /*
    This constructor sets the reshuffleCutoff value.
     */

    public Blackjack(){
        // Calls the other constructor
        this(40);
            
    }

    /*
    This will reset 
    @playerHand and @dealerHand
    */
    public void reset(){
        // Resets playerHand using reset method from the Hand class
        playerHand.reset();

        // Resets dealerHand using reset method from the Hand class
        dealerHand.reset();


        if (deck.size() < reshuffleCutoff){
        // Overwrites the old deck and replaces it with a new deck.
            deck = new Deck();

            // Shuffles the deck.
            deck.shuffle();
        }
    }

    /*
    This method will deal cards to player's hand and dealer's hand.
    */
    public void deal(){
        
        // Deals two cards to the player.
        for (int i = 0; i < 2; i++){
            playerHand.add(deck.deal());
        }

        // Deals two cards to the dealer.
        for (int j = 0; j < 2; j++){
            dealerHand.add(deck.deal());
        }
        

    }

    /*
    This method will draw cards from the deck and give to the player's hand. 
    It then will calculate the values of the hands to check if it's in range.
    */
    public boolean playerTurn(){
        // Will calculate playerHand value to determine whether they continues to draw cards
    
        while (playerHand.getTotalValue() < 16){
            // Adds a card from the deck to the player's hand if value still below 16.
            playerHand.add(deck.deal());
        }
        if (playerHand.getTotalValue() > 21){
            // sets the playerBust boolean to be true and the player has busted over 21.
            return false;
        }
    
        // return the playerTurn boolean to be false. The player's turn has ended.
        return true;
        
    }
    /*
    This method will draw cards from the deck and give to the dealer's hand. 
    It then will calculate the values of the hands to check if it's in range
    */
    public boolean dealerTurn(){
        // Will calculate dealerHand value to determine whether he continues to draw cards.
        while (dealerHand.getTotalValue() < 17){
            // Adds a card from the deck to the dealer's hand if value still below 17.
                dealerHand.add(deck.deal());        

        } 
        if(dealerHand.getTotalValue() > 21){
            // sets the dealerBust boolean to be true and the dealer has busted over 21.
            return false;
            
        }
    
        // return the dealerTurn boolean to be false. The dealer's turn has ended.
        return true;

    }

    /*
    This method assigns a new cutoff value to the internal reshuffle cutoff field.
    */
    public void setReshuffleCutoff(int cutoff){
        reshuffleCutoff = cutoff;
        
    }


    /*
    This method returns the current reshuffleCutoff value.
    */
    public int getReshuffleCutoff(){
        return reshuffleCutoff;
    }


    /*
    This method returns a string that represents the state of the game. 
    */
    public String toString(){
        // Returns a string of the values of the playerHand and the dealerHand.
        return "Player: " + playerHand + " " + "Dealer: " + dealerHand + "\n" + "Player's value: " + playerHand.getTotalValue() + "\n" + "Dealer's value: " + dealerHand.getTotalValue(); 

    }

    /*
    This method does comparisons of the player hand and dealer hand values.
    Also checks for whether the player or dealer's busts determine which side wins. 
    */

    public int game(boolean verbose){    
        // Resets the game
        reset();

        // Deals 2 cards to both sides
        deal();

        // Draws cards for player's hand until within range from 16-21 or over 21
        boolean playerResult = playerTurn();

        // Draws cards for dealer's hand until within range from 17-21 or over 21.
        boolean dealerResult = dealerTurn();

        // This if-else statement will return a point value based on win-lose status of the player.
        if (playerResult == false){
            return -1;

        } else if (dealerResult == false){
            return 1;

        } else {
            if (playerHand.getTotalValue() > dealerHand.getTotalValue()){
                return 1;
            } else if (playerHand.getTotalValue() < dealerHand.getTotalValue()){
                
                return -1;
            } else {
                return 0;
            }
        }
    }    

    // runs and simulates the game
    public static void main(String[] args){
        Blackjack bj1 = new Blackjack();

        int points = bj1.game(true);

        System.out.println(bj1.toString());

        if (points == -1){
            System.out.println("Dealer Wins!");

        } else if (points == 0){
            System.out.println("Push!");

        } else if (points == 1){
            System.out.println("Player Wins!");
        }
        System.out.println("Player Points: " + points);
    }
}
