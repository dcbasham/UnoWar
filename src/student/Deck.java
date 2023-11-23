package student;

import java.util.Random;

/** The type Deck stores 52 different card objects. */
public class Deck {
    /** an array of cards to hold the deck object. */
    private Card[] deckCards;

    /** a private variable to track the cards remaining. */
    private int cardsAvailable;

    /** Deck constructor, assigns card to deck array. */
    public Deck() {
        deckCards = new Card[52];
        int i = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deckCards[i] = new Card(rank, suit);
                i++;
            }
        }
        cardsAvailable = 52;
        shuffle();
    }

    /**
     * gets the deck object.
     * @return deckCards
     */
    public Card[] getDeck() {
        return deckCards;
    }

    /**
     * Shuffle the deck created in constructor. Uses Fisher-Yates algorithm to shuffle by swapping
     * random pairs of cards, a nested for loop with i = (length -1) -> i>=1 -> i--; j is a random
     * integer between 0 and i+1; swap the cards at i and j.
     */
    public void shuffle() {
        Random ran = new Random();
        for (int i = deckCards.length - 1; i >= 1; i--) {
            int j = ran.nextInt(0, i + 1);
            Card temp = deckCards[i];
            deckCards[i] = deckCards[j];
            deckCards[j] = temp;
        }
    }

    /**
     * Draws the next card from the deck and updates count of available cards in deck.
     * @return the card drawn
     */
    public Card draw() {
        if (cardsAvailable == 0) {
            shuffle();
            cardsAvailable = 52;
        }
        Card nextCard = deckCards[cardsAvailable - 1];
        cardsAvailable--;
        return nextCard;
    }

    /**
     * The number of cards remaining in the deck.
     * @return cardsAvailable
     */
    public int cardsRemaining() {
        return cardsAvailable;
    }

    /**
     * Checks if the deck is empty with the cards remaining method.
     * @return boolean
     */
    public boolean isEmpty() {
        return cardsRemaining() == 0;
    }
}
