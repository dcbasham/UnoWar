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
     * @param deck a deck object
     * @param size the size
     * @Constructor Instantiates a new Hand.
     */
    public Hand(Deck deck, int size) {

        hand = new Card[size];
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
     * Gets size of the hand.
     *
     * @return an integer representing the hand's size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * the deck object stored in private field.
     *
     * @return deck object
     */
    public Deck getDeck() {
        return this.deck;
    }

    /**
     * A getter method to get the hand.
     *
     * @return the hand- an array of Cards.
     */
    public Card[] getHand() {
        return hand;
    }

    /**
     * Get card at index i.
     *
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
     *
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

