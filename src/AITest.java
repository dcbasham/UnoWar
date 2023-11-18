

import student.*;


public class AITest {
    public static void main(String[] args) {
        AI r = new AI();

        AI s = new SmallestCardAI();
        AI b = new BiggestCardAI();
        System.out.println(r);         // should print "Random Card AI"
        System.out.println(s);         // should print "Smallest Card AI"
        System.out.println(b);         // should print "Biggest Card AI"

        // These tests will require you personally verifying them. I can't see a way to fix that.
        Deck deck = new Deck();
        Hand hand = new Hand(deck, 5);
        student.CardPile pile = new student.CardPile(deck.draw());
        AI testAI = new BiggestCardAI();

        System.out.println("Top card is: " + pile.getTopCard());

        System.out.println("Hand is: ");
        System.out.println(hand.get(0));
        System.out.println(hand.get(1));
        System.out.println(hand.get(2));
        System.out.println(hand.get(3));
        System.out.println(hand.get(4));

        Card choice = r.getPlay(hand, pile);
        System.out.println("AI chose: " + choice);

        Card smallest = s.getPlay(hand, pile);
        System.out.println("Smallest Card AI chose: " + smallest);

        Card biggest = b.getPlay(hand, pile);
        System.out.println("Biggest AI CHOSE: " + biggest);


    }


}


