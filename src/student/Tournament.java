package student;

// Daurie Basham

/** reports winRates for games between AIs. */
public class Tournament {

  /**
   * * Start with Random AI vs. random, small, big AIs, repeat the pattern for each AI. (small vs.
   * random, small, big etc.
   */
  public static void main(String[] args) {
    AI rand = new AI();
    AI sm = new SmallestCardAI();
    AI big = new BiggestCardAI();

    UnoWarMatch RR = new UnoWarMatch(rand, rand);
    System.out.println(
        rand.toString() + " vs. " + rand.toString() + " winRate  " + RR.winRate(1000));

    UnoWarMatch Rsm = new UnoWarMatch(rand, sm);
    System.out.println(rand.toString() + " vs. " + sm.toString() + " winRate " + Rsm.winRate(1000));

    UnoWarMatch Rbig = new UnoWarMatch(rand, big);
    System.out.println(
        rand.toString() + " vs. " + big.toString() + " winRate" + Rbig.winRate(1000));

    /** smallest AI vs. random, small, big */
    UnoWarMatch smR = new UnoWarMatch(sm, rand);
    System.out.println(sm.toString() + " vs. " + rand.toString() + " winRate " + smR.winRate(1000));

    UnoWarMatch SS = new UnoWarMatch(sm, sm);
    System.out.println(sm.toString() + " vs. " + sm.toString() + " winRate " + SS.winRate(1000));

    UnoWarMatch Sbig = new UnoWarMatch(sm, big);
    System.out.println(sm.toString() + " vs. " + big.toString() + " winrate " + Sbig.winRate(1000));

    /** big vs. other AIs */
    UnoWarMatch BigR = new UnoWarMatch(big, rand);
    System.out.println(
        big.toString() + " vs. " + rand.toString() + " winRate " + BigR.winRate(1000));

    UnoWarMatch BigS = new UnoWarMatch(big, sm);
    System.out.println(big.toString() + " vs. " + sm.toString() + " winRate " + BigS.winRate(1000));

    UnoWarMatch BB = new UnoWarMatch(big, big);
    System.out.println(big.toString() + " vs. " + big.toString() + " winRate " + BB.winRate(1000));
  }
}
/*
Expected Output:
Random Card AI vs. Random Card AI winRate: 0.499
Random Card AI vs. Smallest Card AI winRate: 0.002
Random Card AI vs. Biggest Card AI winRate: 0.842

Smallest Card AI vs. Random Card AI winRate: 0.998
Smallest Card AI vs. Smallest Card AI winRate: 0.499
Smallest Card AI vs. Biggest Card AI winRate: 0.999

Biggest Card AI vs. Random Card AI winRate: 0.156
Biggest Card AI vs. Smallest Card AI winRate: 0.0
Biggest Card AI vs. Biggest Card AI winRate: 0.491
 */
