public class Dealer {

  private int currentBet = 0;
  Card[] table = new Card[5];

  public Dealer(Deck deck){
      for (int i = 0; i < 2; i++){
        this.table[i] = deck.giveCard();
      }
  }

  public int getCurrentBet() {
    return currentBet;
  }

  public void setCurrentBet(int currentBet) {
    this.currentBet = currentBet;
  }
}
