import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        // Generate a standard deck of playing cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        cards = new ArrayList<>();
        for (String suit : suits) {
            for (String rank: ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    void shuffleDeck() {
        Collections.shuffle(cards);
    }

    // Half of the cards are given to each player
    void distributeCards(Player player1, Player player2) {
        int who = 1;
        for(Card card : cards) {
            if (who == 1) {
                player1.takeCard(card);
                who++;
            } else {
                player2.takeCard(card);
                who--;
            }
        }
    }

    List<Card> getCards() {
        return cards;
    }
}
