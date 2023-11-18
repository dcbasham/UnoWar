package student;


/**
 * The type Smallest card ai.
 */
public class SmallestCardAI extends AI {
    /**
     * The Deck.
     */
    private Deck deck;
    /**
     * The Valid cards.
     */
    private Card[] validCards = new Card[5];

    /**
     * AI play round
     *
     * @param hand     the hand
     * @param cardPile the card pile
     * @return the play
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        this.deck = hand.getDeck();
        Card nullCard = null;
        //integer for valid count
        int validCount = 0;
        for (int i = 0; i < hand.getSize(); i++) {
            Card card = hand.get(i);
            if (cardPile.canPlay(card)) {
                validCards[validCount] = card;
                validCount++;
            }
        }
        if (validCount > 0) {
            Card smallest = validCards[0];
            for (int i = 1; i < validCount; i++) {
                if (validCards[i].getRankNum() < smallest.getRankNum()) {
                    smallest = validCards[i];
                }
            }
            hand.remove(smallest);
            return smallest;
        }
        return nullCard;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
