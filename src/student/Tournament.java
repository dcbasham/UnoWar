package student;
// Daurie Basham

/**
 * reports winRates for games between AIs.
 */
public class Tournament {

    /**
     * match up different combinations of AIs.
     * @param args
     */
    public static void main(String[] args) {
        AI rand = new AI();
        AI rand2 = new AI();
        AI sm = new SmallestCardAI();
        AI sm2 = new SmallestCardAI();
        AI b = new BiggestCardAI();
        AI b2 = new BiggestCardAI();


        UnoWarMatch r1r2 = new UnoWarMatch(rand, rand2);
        System.out.println(rand.toString() + " vs. " + rand2.toString() + " winrate " + r1r2.winRate(1000));

        UnoWarMatch rr = new UnoWarMatch(rand, rand);
        System.out.println(rand.toString() + " r1 vs. " + rand.toString() + " r1 "
                + "winrate " + rr.winRate(1000));


        UnoWarMatch r1sm1 = new UnoWarMatch(rand, sm);
        System.out.println(rand.toString() + " r1 vs. " + sm.toString() + " sm1 winrate " + r1sm1.winRate(1000));

        UnoWarMatch r1sm2 = new UnoWarMatch(rand, sm2);
        System.out.println(rand.toString() + " r1 vs. " + sm2.toString() + " sm2 winrate " + r1sm2.winRate(1000));

        UnoWarMatch r2sm2 = new UnoWarMatch(rand2, sm2);
        System.out.println(rand2.toString() + "r2 vs. " + sm2.toString() + " sm2 winrate " + r1sm2.winRate(1000));

        UnoWarMatch r1b1 = new UnoWarMatch(rand, b);
        System.out.println(rand.toString() + " r1 vs. " + b.toString() + " b1 winrate " + r1b1.winRate(1000));

        UnoWarMatch b1r1 = new UnoWarMatch(b, rand);
        System.out.println(b.toString() + " b1 vs. " + rand.toString() + " r1 winrate " + b1r1.winRate(1000));

        UnoWarMatch sm1r1 = new UnoWarMatch(sm, rand);
        System.out.println(sm.toString() + " sm1 vs. " + rand.toString() + " r1 winrate " + sm1r1.winRate(1000));

        UnoWarMatch sm1sm2 = new UnoWarMatch(sm, sm2);
        System.out.println(sm.toString() + " sm1 vs. " + sm2.toString() + " sm2 winrate " + sm1sm2.winRate(1000));

        UnoWarMatch sm1b1 = new UnoWarMatch(sm, b);
        System.out.println(sm.toString() + " sm1 vs. " + b.toString() + " b1 winrate " + sm1b1.winRate(1000));

        UnoWarMatch b1sm1 = new UnoWarMatch(b, sm);
        System.out.println(b.toString() + " b1 vs. " + sm.toString() + " sm1 winrate " + b1sm1.winRate(1000));

        UnoWarMatch b2sm = new UnoWarMatch(b2, sm);
        System.out.println(b2.toString() + " b2 vs. " + sm.toString() + " sm1 winrate " + b2sm.winRate(1000));

        UnoWarMatch b1b2 = new UnoWarMatch(b, b2);
        System.out.println(b.toString() + " b1 vs. " + b2.toString() + " b2 winrate " + b1b2.winRate(1000));
    }
}




