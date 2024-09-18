import java.util.ArrayList;
import java.util.Random;

public class Deck {
    // Makes a new random object
    private Random ran = new Random();

    // Makes the array
    private ArrayList<Card> deck;

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {
        // Makes the arraylist for deck
        deck = new ArrayList<Card>();

        // builds the deck
        build();
        shuffle();

    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {
        deck = new ArrayList<Card>();
        // This forloop will create the card values from 2 to 9, each with 4 cards
        for (int i = 0; i < 8; i++){
            
            // sets up the for loop for numbers from 2 to 9
            int value = 2 + i;
            
            // Makes 
            for (int j = 0; j < 4; j++){

                // Because value is not a Card object, a new Card object needs to be created 
                // that contains the value.
                deck.add(new Card(value));
            }
           
        }

        // This forloop will create the card value of 11, with 4 cards.
        for (int i = 0; i < 4; i++){
            
            // Because value is not a Card object, a new Card object needs to be created 
            // that contains the value.
            deck.add(new Card(11));
        }


        // This forloop will create the card value of 10, with 16 cards.
        for (int i = 0; i < 16; i++){
            // Because value is not a Card object, a new Card object needs to be created 
            // that contains the value.
            deck.add(new Card(10));
        }

    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        // Returns size of deck
        return deck.size();
    }



    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        // removes the 0th index of the arraylist and returns its value.
        return deck.remove(0);
    }
    

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        // Using the Fisher-Yates Algorithm
        for (int i = deck.size() - 1; i > 0; i--){
            // Special syntax to set indices to each other and swap their values.
            int j = ran.nextInt(i + 1);
            Card temp = deck.get(i); // temp needs to be set to a Card object
            deck.set(i, deck.get(j));
            deck.set(j, temp);


        }
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        // Concatenates the string with the deck
        return "" + deck;
    }
}
