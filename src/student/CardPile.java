package student;

// Daurie Basham

/** The type Card pile. */
public class CardPile {
    /**
     * current topCard for this cardPile used to determine which cards are valid to play (match suit
     * or beat rank).
     */
    private Card topCard;

    /** track the number of cards in the pile. */
    private int numCardsInPile;

    /**
     * Constructor for cardPile.
     * @param topCard the top card of the current cardPile
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.numCardsInPile = 1;
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
        return this.numCardsInPile;
    }

    /**
     * canPlay checks that the card the player has chosen is valid to play.
     * @param card to evaluate.
     * @return boolean
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            // player loses, other player wins the round.
            return false;
        }
        return (card.getSuitName().equals(this.topCard.getSuitName())
                || card.getRankNum() >= topCard.getRankNum());
    }

    /**
     * If legal, assigns card as new topCard, and increases the number of cards in the pile.
     * @param card the card played, which was valid, to set as top card
     */
    public void play(Card card) {
        if (canPlay(card)) {
            this.topCard = card;
            this.numCardsInPile++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }
}
