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
            return checkHighCardWin(p1Input, p2Input);
        } else if (P1Rank < P2Rank) {
            return P1_WINNER;
        } else if (P2Rank < P1Rank) {
            return P2_WINNER;
        }
        return null;
    }

    private String checkHighCardWin(String[] p1Input, String[] p2Input) {
        Integer p1HighCard = pokerCheck.getHighCard(p1Input);
        Integer p2HighCard = pokerCheck.getHighCard(p2Input);
        if (p1HighCard > p2HighCard) {
            return P1_WINNER;
        } else if (p1HighCard < p2HighCard) {
            return P2_WINNER;
        }
        return DRAW;
    }

    public String checkDealWinner(String[] input) {

        String[] p1Input = Arrays.copyOfRange(input, 0, 2);
        String[] p2Input = Arrays.copyOfRange(input, 2, 4);
        String[] dealInput = Arrays.copyOfRange(input, 4, 9);

        PokerWinner p1Win = pokerCheck.getCardRank(p1Input, dealInput);
        PokerWinner p2Win = pokerCheck.getCardRank(p2Input, dealInput);

        if(p1Win.getRank() == p2Win.getRank()) {
            return checkHighCardWin(p1Win.getCards(), p2Win.getCards());
        }
        return p1Win.getRank() < p2Win.getRank() ? P1_WINNER : P2_WINNER;
    }
}
