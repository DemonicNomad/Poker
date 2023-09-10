import java.util.Arrays;

public class Player {
    private Card[] hand = new Card[Deck.HAND_SIZE];
    private String name;
    private int chips;
    private int currentBet;

    public Player(Deck deck, String name, int chips) {
        for(int i = 0; i < 2; i++){
            hand[i] = deck.giveCard();
        }

        this.name = name;
        this.chips = chips;
    }

    @Override
    public final String toString() {
        return name + "'s" +
                " Hand : " + Arrays.toString(hand) +
                " Geld: " + chips;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

}
