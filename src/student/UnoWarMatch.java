package student;

/**
 * UnoWarMatch is a game structured into 10 rounds, each round
 * two players take turns until one of them loses by playing
 * an invalid card.
 */
class UnoWarMatch {
    /** player 1 */
    private AI ai1;
    /** player 2 */
    private AI ai2;

    /**
     * Constructor where 2 AI players are created.
     * @param ai1 is player 1
     * @param ai2 is player 2
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * ROUND:
     *  * cardPile is created new each round (dealt card from deck)
     *  * @param hand1
     *  * player plays card onto pile
     *  * ...continue and take turns until someone loses.
     *
     *  * player1 starts round1 (or winner prev round)
     *  *  check card is valid
     *  * play card
     *   * remove() from hand && draw replacementfrom deck.
     *  */

    /**
     * @param deck     the deck created at beginning of the game.
     * @param starting boolean that tells us which hand will start- representing the players.
     * @param hand1
     * @param hand2
     * @return boolean return true if ai1 wins, otherwise false means ai2 wins.
     */

    public boolean playRound(Deck deck, Hand hand1, Hand hand2, boolean starting) {
        //p1 is previous winner or in round 1 ai1.
        Card topCard = deck.draw();
        //create new cardpile from deck
        CardPile pile = new CardPile(topCard);
        Card choice;
        while (true) {
            if (starting){
//                System.out.println("player1 starting");
                //player 1 starts
                choice = ai1.getPlay(hand1,pile);
                if (choice == null){
                    //player 2 gets point
                    return false;
                }
//                System.out.println("choice : topCard" + choice + topCard);
                pile.play(choice);
                hand1.remove(choice);
                starting = false;
            } else {
                choice = ai2.getPlay(hand2,pile);
                if (choice == null){
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
     * The game of UnoWar is played with a deck of 52 cards,
     * GAME = 10 rounds
     * when game is first called // rounds = 0;
     * new Deck()
     * new Hand -> 5 cards always.
     * ((only called once))
     * hands persist through 10 rounds.
     * Deck is shuffled when empty.
     */
    public boolean playGame() {
        /** deck created each game*/
        Deck deck = new Deck();
        /** hands subsist through each round, only created new once*/
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

/**
 * Play n trials of the game and find win rate of player 1 (ai1).
 * @param nTrials number of games to play (each 10 rounds).
 * @return double for win rate of ai1
 */
public double winRate(int nTrials) {
    int winsP1 = 0;

    for (int i = 0; i < nTrials; i++) {
        if (playGame()) {
            winsP1++;
        }
    }

    return ((double)(winsP1)) / ((double)(nTrials));
}


}
/* may be logic error, player 1 and 'starting' boolean or the double casting on bottom.
// win rates all 0.0 0r 1.0
*/



/*
 *
 * VALID CARD:
 * 1. equal suit
 * playerCard.suit == topCard.suit
 * AND/OR
 * 2. greater than or equal to rank number. (1 - 13)
 * playerCard.rankNum >= topCard.rankNum
 *
 * no valid card? current = loser;
 * otherPlayer = WINNER
 * otherPlayer +1 pt.
 * otherPlayer designated to start next round
 *
 *
 *
 * Keep going until current player can't play any card and they lose.
 *
 *
 *
 *
 * Strategy:
 * Save good cards (high rank) for later
 * - to stay in the game
 * - winner is only assigned because other player loses
 * - based on how long you are able to keep playing valid cards=
 * higher rank cards are better and can be played in more scenarios where
 * you may not have the same suit.
 *
 * GAME OVER:
 * When one player has 10 points (10 total rounds)
 *
*/

