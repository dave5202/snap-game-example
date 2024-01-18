import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Snap {
    public static Random random = new Random();
    public static void play() {
        textSeparator();
        System.out.println("Welcome to the Snap Game!");
        sleep(3);

        // Initialize the deck and players
        Deck deck = new Deck();
        Player player1 = new Player(1);
        Player player2 = new Player(2);

        deck.shuffleDeck();

        deck.distributeCards(player1, player2);

        simulateSnapGame(player1, player2);
    }


    /*
    * Method that simulates the snap game
    * Takes two players as parameters who take turns one after the other until a player has no cards to play
    * */
    private static void simulateSnapGame(Player player1, Player player2) {
        int whoPlays = 1;
        System.out.println("Let's begin....");
        sleep(1);
       while (!player1.isPlayingCardsEmpty() && !player2.isPlayingCardsEmpty()) {
           if (whoPlays == 1) {
               simulateTurn(player1);
               whoPlays++;
           } else {
               simulateTurn(player2);
               whoPlays--;
           }

           if (snapOccurred(player1, player2)) {
               // Random time delay in player shouting snap
               System.out.println("...");
               sleep((long) (Math.random() * 7));

               textSeparator();

               // Random selection of which player wins
               if (random.nextInt(2) == 0) {
                   player1.shoutSnap();
                   textSeparator();
                   sleep(2);
                   player1.takePiles(player2);
               } else {
                   player2.shoutSnap();
                   textSeparator();
                   sleep(2);
                   player2.takePiles(player1);
               }

               sleep(2);
               player1.announceScore();
               sleep(2);
               player2.announceScore();
               sleep(2);
               textSeparator();
               System.out.println("...");
           }
       }

        textSeparator();
        System.out.println("Game over!" + " The winner is...");
        sleep(3);
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1 + ", congratulations!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2 + ", congratulations!");
        } else {
            System.out.println("Neither player unfortunately. It is a draw!");
        }
    }

    private static void simulateTurn(Player player) {
        textSeparator();
        System.out.println(player + " plays " +  player.playCard());
        sleep(1);
    }

    // Snap occurs when there are two cards of the same rank visible on each of the players' stacks of played cards
    private static boolean snapOccurred(Player player1, Player player2) {
        if (player1.isVisibleCardsEmpty() || player2.isVisibleCardsEmpty()) {
            return false;
        } else {
            return player1.peekVisibleCards().getRank().equals(player2.peekVisibleCards().getRank());
        }
    }

    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void textSeparator() {
        System.out.println("----------------------------------");
    }


}
