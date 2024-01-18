import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Snap {
    public static Random random = new Random();
    public String snapType;
    public void play(int rounds, String snapType) {
        textSeparator();
        System.out.println("Welcome to the Snap Game!");
        sleep(3);

        // Initialize players
        Player player1 = new Player(1);
        Player player2 = new Player(2);

        // We ensure that this is either 'rank' or 'suit' in the Main class
        this.snapType = snapType;

        simulateSnapGame(player1, player2, rounds);
    }


    private void simulateSnapGame(Player player1, Player player2, int rounds) {
        int currentRound = 1;
        Deck deck = new Deck();

        while (currentRound <= rounds) {
            textSeparator();
            player1.announceRoundsWon();
            player2.announceRoundsWon();
            sleep(1);
            System.out.println("Let us begin Round " + currentRound);
            sleep(2);
            System.out.println("Resetting for the round...");
            sleep(1);
            player1.resetScore(); player1.discardPlayingCards(); player1.discardVisibleCards();
            player2.resetScore(); player2.discardPlayingCards(); player2.discardVisibleCards();

            // Shuffle deck and distribute cards at start of round
            deck.shuffleDeck();
            deck.distributeCards(player1, player2);
            simulateSnapRound(player1, player2, currentRound);
            currentRound++;
        }

        textSeparator();
        System.out.println("Game over! The winner is...");
        sleep(1);
        if (player1.getRoundsWon() > player2.getRoundsWon()) {
            textSeparator();
            System.out.println(player1 + " CONGRATULATIONS!!!");
            textSeparator();
        } else if (player2.getRoundsWon() > player1.getRoundsWon()) {
            textSeparator();
            System.out.println(player2 + " CONGRATULATIONS!!");
            textSeparator();
        } else {
            System.out.println("Neither player unfortunately. The game is a draw!");
        }
    }

    /*
    * Method that simulates the snap game
    * Takes two players as parameters who take turns one after the other until a player has no cards to play
    * */
    private void simulateSnapRound(Player player1, Player player2, int round) {
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

           if (snapOccurred(player1, player2, snapType)) {
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
        System.out.println("The round is over!" + " The winner of round " + round + " is...");
        sleep(3);
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1 + ", congratulations!");
            player1.incrementRoundsWon();
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2 + ", congratulations!");
            player2.incrementRoundsWon();
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
    private static boolean snapOccurred(Player player1, Player player2, String snapType) {
        if (player1.isVisibleCardsEmpty() || player2.isVisibleCardsEmpty()) {
            return false;
        } else {
            if (snapType.equals("rank")) {
                return player1.peekVisibleCards().getRank().equals(player2.peekVisibleCards().getRank());
            } else {
                return player1.peekVisibleCards().getSuit().equals(player2.peekVisibleCards().getSuit());
            }
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
