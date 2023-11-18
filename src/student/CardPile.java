
package student;

/**
 * The type Card pile.
 */
public class CardPile {
    /** topCard will hold the current topCard for this cardPile.*/
    private Card topCard;
/** size will track the number of cards in the pile.*/
    private int size;

    /**
     * Instantiates a new Card pile.
     * @param topCard the top card of the current cardPile
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.size = 1;
    }

    /**
     * canPlay checks that the card is legal - it adheres
     * to the rules for laying down a card on the cardpile.
     *
     * @param card to check
     * @return the boolean
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        }
        boolean isValid = (card.getSuitName().equals(this.topCard.getSuitName()) ? true
                : (card.getRankNum() >= this.topCard.getRankNum() ? true : false));

        return isValid;
    }

    /**
     * Checks card is legal to play, then makes it the new topCard, and
     * increases the number of cards in the pile.
     *
     * @param card the card
     */
    public void play(Card card) {
        if (canPlay(card)) {
            this.topCard = card;
            this.size++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     * Gets size of card pile.
     *
     * @return the size of the cardpile.
     */
    public int getNumCards() {
        return this.size;
    }

    /**
     * Gets top card.
     * @return the current top card
     */
    public Card getTopCard() {
        return this.topCard;
    }
}
