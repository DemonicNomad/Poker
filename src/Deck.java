import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    final int DECK_SIZE = 52;
    static final int HAND_SIZE = 5;

    Card[] deck = new Card[DECK_SIZE];

    public void fill(){
        int counter = 0;
        for(int suit = 0; suit < 4; suit++){
            for(int rank = 2; rank < 15; rank++){
                deck[counter] = new Card(rank, suit);
                counter++;
            }
        }
    }

    public void shuffle(){
        List<Card> tempList = Arrays.asList(deck);
        Collections.shuffle(tempList);
        tempList.toArray(deck);

    }

    public Card giveCard(){
        Card card;

        int r;
        Random rand = new SecureRandom();
        r = rand.nextInt(DECK_SIZE);

        while(deck[r] == null){
            r = rand.nextInt(DECK_SIZE);
        }
        card = deck[r];
        deck[r] = null;
        return card;
    }

    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        for (Card card:deck) {
            temp.append(card.toString()).append("\n");
        }
        return temp+ "\n" + deck.length;
    }



}
