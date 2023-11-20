package student;

/**
 * The type Hand.
 */
public class Hand {
    /**
     * The Deck object passed to constructor is saved here.
     */
    private Deck deck;
    /**
     * a hand is an array of Cards.
     */
    private Card[] hand;
    /**
     * Store the size passed to the constructor.
     */
    private int size;

    /**
     * get deck object.
     * @return deck object
     */
    public Deck getDeck() {
        return this.deck;
    }



    /**
     * get hand object.
     *
     * @return hand object
     */
    public Card[] getHand() {
        return this.hand;
    }


    /**
     * Get size of the hand.
     * @return an integer representing the hand's size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Conastructor for Hand object.
     * @param deck a deck object
     * @param size the size to initialize hand object to
     */
    public Hand(Deck deck, int size) {

        this.hand = new Card[size];
        this.size = size;
        this.deck = deck;
        // shuffle the deck to ensure it's randomized.
        this.deck.shuffle();
        // Fill the hand with cards from the deck
        for (int i = 0; i < size; i++) {
            hand[i] = deck.draw();
        }
    }

    /**
     * Get card at index i of hand.
     * @param i the
     * @return the card
     */
    public Card get(int i) {
        if (i < 0 || i > this.size - 1 || hand[i].equals(null)) {
            System.out.println("Invalid hand index!");
            return hand[0];
        }
        return hand[i];
    }

    /**
     * Checks if the given card is in the hand- if it is: remove it (replace it) with a drawn card from the deck.
     * @param card card to find in your hand
     * @return boolean
     */
    public boolean remove(Card card) {
        for (int i = 0; i < size; i++) {
            if (hand[i].equals(card)) {
                Card newCard = deck.draw();
                hand[i] = newCard;
                return true;
            }
        }
        return false;
    }
}

