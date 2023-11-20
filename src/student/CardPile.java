
package student;

/**
 * The type Card pile.
 */
public class CardPile {
    /** topCard will hold the current topCard for this cardPile. */
    private Card topCard;

    /** size will track the number of cards in the pile. */
    private int size;

    /**
     * Constructor for cardPile.
     * @param topCard the top card of the current cardPile
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.size = 1;
    }


    /**
     * Get top card.
     * @return the current top card
     */
    public Card getTopCard() {
        return this.topCard;
    }


    /**
     * Get size of card pile.
     * @return the size of the cardpile.
     */
    public int getNumCards() {
        return this.size;
    }

    /**
     * canPlay checks that the card is legal to play on the current stack,
     * specifically the topCard.
     * implements a boolean compareTo method to evaluate the card.
     * @param card to evaluate.
     * @return boolean
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false; //player loses, other player wins the round.
        }
        return compareTo(card);
    }

    /**
     * Checks card is legal to play, then makes it the new topCard, and
     * increases the number of cards in the pile.
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
     * Compares the current card passed in to the current topCard,
     * checking its rank and suit for validity against topCard.
     * Helper function for canPlay().
     * @param card must be greater than or equal to the topCard's rank,
     *             *             or equal to the topCard's suit to be legal.
     * @return boolean
     */

    public boolean compareTo(Card card) {
        return (card.getSuitName().equals(this.topCard.getSuitName()) ? true
                : (card.getRankNum() >= this.topCard.getRankNum() ? true : false));
    }
}
