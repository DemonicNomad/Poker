import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Deck deck = new Deck();
            deck.fill();
            deck.shuffle();

            Scanner scan = new Scanner(System.in);
            int players;

            System.out.println("Wie viele Spieler?");
            players = scan.nextInt();

            Player[] player = new Player[players];
            for(int i = 0; i < players; i++){
                System.out.println("Spieler 1 Name: ");
                String playerName = scan.next();
                player[i] = new Player(deck, playerName);
            }
            for(Player play: player){
                System.out.println(play.toString());
            }
    }
}