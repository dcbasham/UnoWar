package student;

/** AI "Random Card AI" is the parent class to all other AIs. */
public class AI {
  /** hand instance. */
  //  private Hand hand;

  /**
   * Get hand of AI. picks first valid card found in hand (left to right), if no valid card to play
   * on cardPile return null.
   *
   * @param hand
   * @param cardPile
   * @return card to play or null if invalid
   */
  public Card getPlay(Hand hand, CardPile cardPile) {

    for (int i = 0; i < hand.getSize(); i++) {
      Card card = hand.get(i);
      if (cardPile.canPlay(card)) {
        return card;
      }
    }
    return null;
  }
  ;

  /**
   * the name of the AI.
   *
   * @return "Random Card AI"
   */
  @Override
  public String toString() {
    return "Random Card AI";
  }
}
