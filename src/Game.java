import java.util.Scanner;

public class Game {
  public static void start() {
    Deck deck = new Deck();
    deck.fill();
    deck.shuffle();

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
      System.out.println(play.toString());
    }

    int currentPot = 0;

    for(int i = 0; i < 3; i++){
      for (Player play : player) {
        currentPot += round(play, currentPot);
        System.out.println(play.getChips());
      }
    }


  }

  public static int round(Player player, int currentPot) {
    //payBlinds();
    if(player.getChips() <= 0){
      return 0;
    }
    Scanner scan = new Scanner(System.in);
    int answer;

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
        int potDiff = currentPot - player.getCurrentBet();
        player.setChips(player.getChips() - potDiff);
        player.setCurrentBet(player.getCurrentBet() + potDiff);
      }
      case 2 -> {
        return raise(currentPot, player, scan);
      }
      case 3 -> player.setChips(-1);
      case 4 -> System.out.println(player.toString());
    }
    return 0;
  }

  private static int raise(int currentPot, Player player, Scanner scan) {

    System.out.println("Um wieviel willst du erhöhen?");
    int bet = scan.nextInt();

    currentPot += bet;
    player.setChips(player.getChips() - (currentPot - player.getCurrentBet()));
    player.setCurrentBet(player.getCurrentBet() + (currentPot - player.getCurrentBet()));
    return currentPot;
  }

  public static void payBlinds() {

  }


}
