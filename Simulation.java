
public class Simulation {

    // class to simulate the games with given number of games.
    // Calculates the win percentage over simulations.
    public static void main(String[] args){
        // Creates blackjack object
        Blackjack jack = new Blackjack(50);
        
        int points = jack.game(false); 

        // counts wins
        float playerWinCounts = 0;
        float dealerWinCounts = 0;
        float totalPushCounts = 0;
        
        // stores percentage
        float playerWinPercent;
        float dealerWinPercent;
        float totalPushPercent;


        // loops for 1000 times. Can be changed
        for (int i = 0; i < 1000; i++){
            
            points = jack.game(false);

            if (points == 1){
                playerWinCounts += 1;

            } else if (points == 0){
                totalPushCounts += 1;

            } else if (points == -1){
                dealerWinCounts += 1;
            }
        }
        // calculates percentage
        playerWinPercent = (playerWinCounts / 1000) * 100;
        dealerWinPercent = (dealerWinCounts / 1000) * 100;
        totalPushPercent = (totalPushCounts / 1000) * 100;
    
        // prints out percentage to terminal
        System.out.println("Over a simulation of 1000 games, Player wins " + playerWinPercent + "% of the games. A total of " + playerWinCounts + " wins!");
        System.out.println("Over a simulation of 1000 games, Dealer wins " + dealerWinPercent + "% of the games. A total of " + dealerWinCounts + " wins!");
        System.out.println("Over a simulation of 1000 games, there was a push " + totalPushPercent + "% of the games. A total of " + totalPushCounts + " pushes!");
    }
}   
