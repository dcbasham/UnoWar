package student;

/**
 * The type Biggest card ai.
 */

public class BiggestCardAI extends AI {
    /**
     * picks first valid card found in hand (left to right), if no valid card to play on cardPile
     * return null.
     * @param hand
     * @param cardPile
     * @return card to play or null if invalid
     * @see student.AI
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card nullCard = null;
        Card biggest = null;

        for (int i = 0; i < hand.getSize(); i++) {
            Card card = hand.get(i);
            if (cardPile.canPlay(card)) {
                if (biggest == null || card.getRankNum() > biggest.getRankNum()) {
                    biggest = card;
                }
            }
        }

        if (biggest != null) {
            hand.remove(biggest);
            return biggest;
        }

        return nullCard;
    }

    /**
     * Prints the name of the AI.
     * @return the string
     */
    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
