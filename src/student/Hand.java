package student;

/** The type Hand, usually size of 5 cards */
public class Hand {
  /** The Deck object passed to constructor is saved here. */
  private Deck deck;

  /** a hand is an array of Cards. */
  private Card[] handCards;

  /** Store the size passed to the constructor. */
  private int size;

  /**
   * Constructor for Hand class. Creates a hand object of Cards with size and deck fields.
   *
   * @param deck a deck object
   * @param size the size to initialize hand object to
   */
  public Hand(Deck deck, int size) {

    handCards = new Card[size];
    this.size = size;
    this.deck = deck;
    // shuffle the deck to ensure it's randomized.
    this.deck.shuffle();
    // Fill the hand with cards from the deck
    for (int i = 0; i < size; i++) {
      handCards[i] = deck.draw();
    }
  }

  /**
   * get the deck being played.
   *
   * @return deck object
   */
  public Deck getDeck() {
    return this.deck;
  }

  /**
   * get cards in the hand.
   *
   * @return hand object
   */
  public Card[] getHand() {
    return this.handCards;
  }

  /**
   * Get size of the hand.
   *
   * @return an integer representing the hand's size
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Get card at index i of hand.
   *
   * @param i the index nummber to get hand card
   * @return the card or default (0,0)
   */
  public Card get(int i) {
    if (i < 0 || i > this.size - 1 || handCards[i].equals(null)) {
      System.out.println("Invalid hand index!");
      return handCards[0];
    }
    return handCards[i];
  }

  /**
   * remove the card after playing it by replacing at index i with a new card from the deck.
   *
   * @param card card to find in your hand
   * @return boolean true if found, false if not found/ not replaced
   */
  public boolean remove(Card card) {
    for (int i = 0; i < size; i++) {
      if (handCards[i].equals(card)) {
        Card newCard = deck.draw();
        handCards[i] = newCard;
        return true;
      }
    }
    return false;
  }
}
