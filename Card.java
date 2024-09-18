import java.util.Random;
// Importing random module


public class Card {
    Random ran = new Random();

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) {
        
        if(2 <= val && val <= 11){
            value = val;
        }
        else{
            // Checks to see if value is within the range between 2 and 11
            System.out.println("This value is not within range");
            value = ran.nextInt(2, 11);
        }

    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return "" + value;
    }
}
