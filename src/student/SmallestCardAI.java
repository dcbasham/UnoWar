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
     * Play one round.
     * @param hand     hand for AI.
     * @param cardPile card pile to play card on.
     * @return card if valid card, null if not valid.
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
     * override default toString method to return className.
     * @return the string
     */
    @Override
    public String toString() {
        return "Smallest Card AI";

    }
}
