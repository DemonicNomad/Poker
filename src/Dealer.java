public class Dealer {

  private int currentBet = 0;
  Card[] table = new Card[5];
  private int playerRotation = 0;
  private final int blinds;

  public Dealer(Deck deck, int blinds){
      for (int i = 0; i < 2; i++){
        this.table[i] = deck.giveCard();
      }
      this.blinds = blinds;
  }

  public int getCurrentBet() {
    return currentBet;
  }

  public void setCurrentBet(int currentBet) {
    this.currentBet = currentBet;
  }

  public int getPlayerRotation() {
    return playerRotation;
  }

  public void setPlayerRotation(int playerRotation) {
    this.playerRotation = playerRotation;
  }

  public int getBlinds() {
    return blinds;
  }
}
