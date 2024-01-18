import java.util.Stack;

public class Player {
    private Stack<Card> playingCards;
    private Stack<Card> visibleCards;
    private int score;

    private int roundsWon;

    public int playerNumber;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        visibleCards = new Stack<>();
        playingCards = new Stack<>();
    }

    public void takeCard(Card card) {
        playingCards.push(card);
    }

    public Card playCard() {
        Card playedCard = playingCards.pop();
        visibleCards.push(playedCard);
        return playedCard;
    }

    public boolean isPlayingCardsEmpty() {
        return playingCards.isEmpty();
    }

    public void discardPlayingCards() {playingCards.clear();}

    public Card peekVisibleCards() {
        return visibleCards.peek();
    }

    public boolean isVisibleCardsEmpty() {
        return visibleCards.isEmpty();
    }

    public int numberOfVisibleCards() {
        return visibleCards.size();
    }

    public void discardVisibleCards() {
        visibleCards.clear();
    }

    public void shoutSnap() {
        System.out.println(this + " shouts SNAP!");
    }

    public void takePiles(Player other) {
        System.out.println(this + " takes the piles!");
        score = score + other.numberOfVisibleCards() + this.numberOfVisibleCards();
        other.discardVisibleCards();
        this.discardVisibleCards();
    }

    public void announceScore() {
        System.out.println(this + " now has a score of " + score);
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void announceRoundsWon() {
        System.out.println(this + " has won " + roundsWon + " rounds");
    }

    public void incrementRoundsWon() {
        roundsWon++;
    }

    @Override
    public String toString() {
        return "Player " + playerNumber;
    }
}
