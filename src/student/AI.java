package student;

/**
 * AI "Random Card AI" is the parent class to all other AIs.
 */
public class AI {
    /**
     * The hand reference.
     */
    private Hand hand;
    /**
     * cardPile reference.
     */
    private CardPile cardPile;
    /**
     * the card to refer to when finding a valid card from hand.
     */

    private Card card;

    /**
     * picks first valid card found in hand (left to right), if no valid card to play on cardPile return null.
     *
     * @param hand
     * @param cardPile
     * @return card to play or null if invalid
     */

    public Card getPlay(Hand hand, CardPile cardPile) {
        this.hand = hand;
        this.cardPile = cardPile;

        Card nullCard = null;
        for (int i = 0; i < hand.getSize(); i++) {
            this.card = hand.get(i);
            if (cardPile.canPlay(this.card)) {
                return this.card;
            }
        }
        return nullCard;
    }


    public Hand getHand() {
        return this.hand;
    }

    /**set player hand */
    public void setHand(Hand hand){
        this.hand = hand;
    }

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
