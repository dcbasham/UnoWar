package student;


class UnoWarMatch {
    /** represents the first player and the one we measure for winRate. */
    private AI ai1;
    /** represents "other player". */
    private AI ai2;

    /**
     * Constructor for UnoWarMatch creates two instances of an AI to represent the players.
     * @param ai1
     * @param ai2
     */

    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * represents one round of the game.
     * @param deck     created in game
     * @param hand1    created in game
     * @param hand2    created in game, second player hand
     * @param starting determines who starts the round
     * @return boolean who won the round.
     * "true" ai1 wins this round
     * "false" means ai2 wins this round.
     */

    public boolean playRound(Deck deck, Hand hand1, Hand hand2, boolean starting) {
        //p1 is previous winner or in round 1 ai1.
        Card topCard = deck.draw();
        //create new cardpile from deck
        CardPile pile = new CardPile(topCard);
        Card choice;
        while (true) {
            if (starting) {
//                System.out.println("player1 starting");
                //player 1 starts
                choice = ai1.getPlay(hand1, pile);
                if (choice == null) {
                    //player 2 gets point
                    return false;
                }
//                System.out.println("choice : topCard" + choice + topCard);
                pile.play(choice);
                hand1.remove(choice);
                starting = false;
            } else {
                choice = ai2.getPlay(hand2, pile);
                if (choice == null) {
                    //player 2 loses, player 1 wins
                    return true;
                }
                //play the card onto the pile
                pile.play(choice);
                //remove the card from hand and take replacement
                hand2.remove(choice);
                //player 1 starts next round
                starting = true;
                //starting = !starting
            }
        }
    }

    /**
     * One game is 10 rounds. The winner of each round gets 1 point,
     * there is a new deck created each game.
     * hands subsist through each round, only created new once.
     * @return boolean when a player reaches 10
     * points, return true for ai1 winning the game, false for ai2.
     */
    public boolean playGame() {

        Deck deck = new Deck();

        Hand hand1 = new Hand(deck, 5);
        Hand hand2 = new Hand(deck, 5);

        int player1Points = 0;
        int player2Points = 0;

        boolean starting = true;

        while ((player1Points < 10) && (player2Points < 10)) {
            boolean winner = playRound(deck, hand1, hand2, starting);
            //player 1 wins, player 1 starts next round
            if (winner) {
                player1Points++;
                starting = true;
            } else {
                //player 2 wins, player 2 starts next round
                player2Points++;
                starting = false;
            }
        }
        //return true if player 1 wins false if player 2 wins
        // return (player1Points == 10);
        return player1Points > player2Points ? true : false;
    }

    public double winRate(int nTrials) {
        double thisWinRate;
        double winsP1 = 0;

        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                winsP1++;
            }
        }
        double v = ((double) winsP1) / nTrials;

        return v;
    }
}


