import java.util.Arrays;

public class Player {
    Card[] hand = new Card[Deck.HAND_SIZE];
    String name;

    public Player(Deck deck, String name) {
        for(int i = 0; i < 2; i++){
            hand[i] = deck.giveCard();
        }

        this.name = name;
    }

    @Override
    public final String toString() {
        return name + "'s " +
                "Hand : " + Arrays.toString(hand);
    }
}
