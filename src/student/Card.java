
package student;

/**
 * Class Card represents one card.
 * The card object is immutable, once constructed it cannot be changed.
 */
public class Card {

    /**
     * rank: to hold the rank number 1-13.
     */
    private int rank;

    /**
     * suit: to hold the suit number 1-4.
     */
    private int suit;

    /**
     * RANKS to store the 13 rank names.
     */
    public static final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Jack",
            "Queen", "King"};
    /**
     * SUITS to store the four suit names.
     */
    public static final String[] SUITS = {"Spades", "Hearts", "Clubs", "Diamonds"};


    /**
     * Instantiates a new Card.
     *
     * @param rank a number from 1-13 representing all the values of cards in a deck
     * @param suit a number from 1-4 representing the suits of a card
     */
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            this.rank = 1;
            this.suit = 1;
            System.out.println("Invalid Card");
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    /**
     * Gets rank number.
     *
     * @return the card's rank (number value).
     */
    public int getRankNum() {
        return this.rank;

    }

    /**
     * Gets rank name.
     *
     * @return the card's rank name
     */
    public String getRankName() {
        return RANKS[getRankNum() - 1];
    }

    /**
     * Gets suit name.
     *
     * @return suit name
     */
    public String getSuitName() {
        return SUITS[this.suit - 1];
    }

    /**
     * @param obj instance Object we check to see if its parent class is
     * @return boolean
     * @Override method equals().
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;
        return rank == otherCard.rank && suit == otherCard.suit;
    }
    // @javadoc
    //  Assuming the obj is a Card instance,
    //   type cast the generic Object class to be a Card
    //  in order to use its fields and methods, and set the rank and suit values.

    /**
     * @return "{rankName} of {suitName}"
     * @Override String.toString().
     * @default "Ace of Spades"
     * @see public Card();
     */
    @Override
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }
}


