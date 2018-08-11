import java.util.Arrays;

public class PokerPlayWinner {

    private String P1_WINNER = "P1_WINNER";
    private String P2_WINNER = "P2_WINNER";
    private String DRAW = "DRAW";

    private PokerCheck pokerCheck = new PokerCheck();

    public String checkWinner(String[] input) {

        String[] p1Input = Arrays.copyOfRange(input, 0, 5);
        String[] p2Input = Arrays.copyOfRange(input, 5, 10);

        int P1Rank = pokerCheck.getCardRank(p1Input);
        int P2Rank = pokerCheck.getCardRank(p2Input);

        if (P1Rank == P2Rank) {
            Integer p1HighCard = pokerCheck.getHighCard(p1Input);
            Integer p2HighCard = pokerCheck.getHighCard(p2Input);
            if (p1HighCard > p2HighCard) {
                return P1_WINNER;
            } else if (p1HighCard < p2HighCard) {
                return P2_WINNER;
            }
            return DRAW;
        } else if (P1Rank < P2Rank) {
            return P1_WINNER;
        } else if (P2Rank < P1Rank) {
            return P2_WINNER;
        }
        return null;
    }
}
