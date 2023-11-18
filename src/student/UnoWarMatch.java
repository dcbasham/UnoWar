package student;

public class UnoWarMatch {
    private AI ai1;
    private AI ai2;
    /**
     * keep track of points over rounds
     */
    private int pointsAI1;

    private int getPointsAI1() {
        return pointsAI1;
    }

    /**
     * keep track of points over rounds
     */
    private int pointsAI2;

    private int getPointsAI2() {
        return pointsAI2;
    }

    private int round = 0;
    private AI currentPlayer;
    private void setCurrentPlayer(AI player){
        currentPlayer = player;
    }
    private void setDeck(Deck deck) {
      deck  = new Deck();
    }

    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
        this.pointsAI1 = 0;
        this.pointsAI2 = 0;
    }


    /**
     * Create a new deck and deal the first card to the cardPile.
     */
    public boolean playGame() {
        Deck deck;
        Hand hand1;
        Hand hand2;
        CardPile cardPile;
        Card topCard;
        AI otherPlayer;
        if (round == 0){
           deck = new Deck();
            hand1 = new Hand(deck, 5);
            hand2 = new Hand(deck, 5);
            ((AI) ai1).setHand(hand1);
            ((AI) ai2).setHand(hand2);
            currentPlayer = ai1;
            otherPlayer = ai2;
        }
            if (deck.isEmpty() || round == 0) {
                deck = new Deck();
                topCard = deck.draw();
                cardPile = new CardPile(topCard);
            }
            Card markedCard = currentPlayer.getPlay(currentPlayer.equals(ai1) ? hand1 : hand2, cardPile);
            if (markedCard == null) {
                if (!currentPlayer.equals(ai1)) {
                    // The other player wins the round
                    pointsAI2++;
                    otherPlayer = currentPlayer;
                    currentPlayer = switchPlayer(currentPlayer);
                }
            } else if (cardPile.canPlay(markedCard)) {
                cardPile.play(markedCard);
                currentPlayer.getHand()
                        .remove(markedCard);
                otherPlayer = currentPlayer;
                currentPlayer = switchPlayer(currentPlayer);
            }
        }

        return (round == 10) && (pointsAI1 > pointsAI2) ? true : false;

    }
    private AI switchPlayer(AI currentPlayer) {
        System.out.println("In switchPlayer Function .....");
        round++;
        System.out.println("Switching Players, round = " + round);
        // Method to switch players after each turn
        System.out.println("currentPlayer " + currentPlayer);
        System.out.println(currentPlayer.equals(ai1) ? ai2 : ai1);
        System.out.println(currentPlayer + "is current player after expression in switchPlater");
        return currentPlayer.equals(ai1) ? ai2 : ai1;
    }


    public double winRate(int nTrials) {
        int ai1Wins = 0;

        for (int i = 0; i < nTrials; i++) {
            boolean ai1Won = playGame(); // Play a single game and check if ai1 won

            if (ai1Won) {
                ai1Wins++;
                System.out.println("ai1Wins " + ai1Wins);
            }
        }
        System.out.println("Win Rate: ");

        double wins = (double) ai1Wins / nTrials; // Calculate win rate as a double between 0 and 1
        System.out.println(wins);
        return wins;
    }
}





