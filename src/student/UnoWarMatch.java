package student;

public class UnoWarMatch {
  /** represents the first player */
  private AI ai1;

  /** represents second player */
  private AI ai2;

  /**
   * Constructor for UnoWarMatch creates two instances of an AI to represent the players.
   *
   * @param ai1
   * @param ai2
   */
  public UnoWarMatch(AI ai1, AI ai2) {
    this.ai1 = ai1;
    this.ai2 = ai2;
  }

  /**
   * represents one round of the game.
   *
   * @param deck created in game
   * @param hand1 created in game, ai1's hand
   * @param hand2 created in game, second player hand
   * @param starting determines who plays first in each round
   * @return boolean who won the round. "true" ai1 wins this round "false" means ai2 wins this round
   */
  public boolean playRound(Deck deck, Hand hand1, Hand hand2, boolean starting) {
    CardPile pile = new CardPile(deck.draw());
    Card player1;
    Card player2;
    while (true) {
      if (starting) {
        // player 1 starts
        player1 = ai1.getPlay(hand1, pile);
        if (player1 == null) {
          // player 2 gets point
          return false;
        }
        pile.play(player1);
        hand1.remove(player1);
        starting = false;
      } else {
        player2 = ai2.getPlay(hand2, pile);
        if (player2 == null) {
          // player 2 loses, player 1 wins
          return true;
        }
        // play the card onto the pile
        pile.play(player2);
        // remove the card from hand and replace from deck
        hand2.remove(player2);
        starting = true;
      }
    }
  }

  /**
   * One game is 10 rounds. The winner of each round gets 1 point, there is a new deck created each
   * game. Game over when a player gets 10 points.
   *
   * @return boolean true for ai1 winning the game, false if ai2 wins.
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
      // player 1 wins, player 1 starts next round
      if (winner) {
        player1Points++;
        starting = true;
      } else {
        // player 2 wins, player 2 starts next round
        player2Points++;
        starting = false;
      }
    }
    return (player1Points == 10);
  }

  /**
   * winRate calculates the total winRate of player 1 (ai1) in each match up over nTrials.
   *
   * @param nTrials to play
   * @return ai1 win rate.
   */
  public double winRate(int nTrials) {
    int winsP1 = 0;

    for (int i = 0; i < nTrials; i++) {
      if (playGame()) {
        winsP1++;
      }
    }

    return ((double) winsP1) / nTrials;
  }
}
