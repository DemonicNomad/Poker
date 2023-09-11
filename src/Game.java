import java.util.Arrays;
import java.util.Scanner;

public class Game {
  public static void start() {
    Deck deck = new Deck();

    deck.fill();
    deck.shuffle();

    Dealer dealer = new Dealer(deck);

    Scanner scan = new Scanner(System.in);
    int players = 0;
    int chips = 0;


    while (chips <= 0) {
      System.out.println("Wie viele Chips?");
      chips = scan.nextInt();
    }
    while (players <= 0 || players > 5) {
      System.out.println("Wie viele Spieler?");
      players = scan.nextInt();
    }


    Player[] player = new Player[players];
    for (int i = 0; i < players; i++) {
      System.out.println("Spieler " + (i + 1) + " Name: ");
      String playerName = scan.next();
      player[i] = new Player(deck, playerName, chips);
    }

    for (Player play : player) {
      System.out.println(play.toString() + "\n");
    }

    for(int i = 0; i < 3; i++){
      for (Player play : player) {
        round(play, dealer);
        dealer.table[i + 2] = deck.giveCard();
        
        System.out.println(play.getChips());
        System.out.println(dealer.getCurrentBet());
      }
    }
  }

  public static void round(Player player, Dealer dealer) {
    //payBlinds();
    if(player.getChips() <= 0){
      return;
    }

    Scanner scan = new Scanner(System.in);
    int answer = 4;

    System.out.println("Die Karten des Dealers sind:\n" + Arrays.toString(dealer.table) + "\n");

    while(answer == 4){
      System.out.println("""
            Was willst du tun?
            1)Schieben/Mitgehen
            2)Einsatz erhöhen
            3)Ausscheiden\s
            4)Karten anzeigen
            """);

      answer = scan.nextInt();

      switch (answer) {
        case 1 -> {
          int potDiff = dealer.getCurrentBet() - player.getCurrentBet();
          player.setChips(player.getChips() - potDiff);
          player.setCurrentBet(player.getCurrentBet() + potDiff);
        }
        case 2 -> {
          raise(dealer, player, scan);
        }
        case 3 -> player.setChips(-1);
        case 4 -> System.out.println(player);
      }
    }

  }

  private static void raise(Dealer dealer, Player player, Scanner scan) {

    System.out.println("Um wieviel willst du erhöhen?");
    int bet = scan.nextInt();

    dealer.setCurrentBet(dealer.getCurrentBet() + bet);
    player.setChips(player.getChips() - (dealer.getCurrentBet() - player.getCurrentBet()));
    player.setCurrentBet(player.getCurrentBet() + (dealer.getCurrentBet() - player.getCurrentBet()));
  }
}
