package student;

import java.util.Random;

/**
 * The type Deck is stores 52 different card objects.
 */
public class Deck {
    /**
     * an array of type Card to hold the deck object.
     */
    private Card[] deck;

    /**
     * a private variable to track the cards remaining.
     */
    private int cardsRemaining;

    /**
     * @Constructor Instantiates a new Deck with 52 card objects.
     */
    public Deck() {
        deck = new Card[52];
        int i = 0;

        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 1; suit <= 4; suit++) {
                deck[i] = new Card(rank, suit);
                i++;
            }
        }

        cardsRemaining = 52;
        shuffle();
    }

    /**
     * Shuffle the deck created in constructor.
     * Uses Fisher-Yates algorithm to shuffle by swapping random pairs of cards.
     */
    public void shuffle() {
        Random ran = new Random(1000);
// exchanges randomly chosen pairs of array elements
        for (int i = deck.length - 1; i > 0; i--) {
            // let j be a random integer between 0 and i inclusive
            int j = ran.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    /**
     * Draws the next card from the deck.
     *
     * @return the drawn card
     */
    public Card draw() {
        if (cardsRemaining <= 0) {
            shuffle();
            cardsRemaining = 52;
        }

        Card nextCard = deck[cardsRemaining - 1];
        cardsRemaining--;
        return nextCard;
    }

    /**
     * Cards remaining in the deck.
     *
     * @return the int
     */
    public int cardsRemaining() {
        return cardsRemaining;
    }

    /**
     * Checks if the deck has no more cards left.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return cardsRemaining == 0;
    }
}
