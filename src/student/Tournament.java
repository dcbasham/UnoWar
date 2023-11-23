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

        UnoWarMatch rr = new UnoWarMatch(rand, rand);
        System.out.println(
                rand.toString() + " vs. " + rand.toString() + " winRate  " + rr.winRate(1000));

        UnoWarMatch rsm = new UnoWarMatch(rand, sm);
        System.out.println(rand.toString() + " vs. " + sm.toString() + " winRate " + rsm.winRate(1000));

        UnoWarMatch rbig = new UnoWarMatch(rand, big);
        System.out.println(
                rand.toString() + " vs. " + big.toString() + " winRate" + rbig.winRate(1000));

        UnoWarMatch smr = new UnoWarMatch(sm, rand);
        System.out.println(sm.toString() + " vs. " + rand.toString() + " winRate " + smr.winRate(1000));

        UnoWarMatch ss = new UnoWarMatch(sm, sm);
        System.out.println(sm.toString() + " vs. " + sm.toString() + " winRate " + ss.winRate(1000));

        UnoWarMatch sbig = new UnoWarMatch(sm, big);
        System.out.println(sm.toString() + " vs. " + big.toString() + " winrate " + sbig.winRate(1000));

        UnoWarMatch bigr = new UnoWarMatch(big, rand);
        System.out.println(
                big.toString() + " vs. " + rand.toString() + " winRate " + bigr.winRate(1000));

        UnoWarMatch bigs = new UnoWarMatch(big, sm);
        System.out.println(big.toString() + " vs. " + sm.toString() + " winRate " + bigs.winRate(1000));

        UnoWarMatch bb = new UnoWarMatch(big, big);
        System.out.println(big.toString() + " vs. " + big.toString() + " winRate " + bb.winRate(1000));
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
