import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class PokerPlayWinnerTest {

    private PokerPlayWinner pokerPlayWinner = new PokerPlayWinner();

    private String P1_WINNER = "P1_WINNER";
    private String P2_WINNER = "P2_WINNER";
    private String DRAW = "DRAW";

    @Test
    public void PokerWinner_P1P2RoyalFlush() {
        String[] input = {"10H", "JH", "QH", "KH", "AH", "10D", "JD", "QD", "KD", "AD"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(DRAW);
    }

    @Test
    public void PokerWinner_P1RoyalFlush() {
        String[] input = {"10H", "JH", "QH", "KH", "AH", "10D", "JD", "QD", "KD", "9D"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2StraightFlush_P1Win() {
        String[] input = {"10H", "JH", "QH", "KH", "9H", "10D", "JD", "QD", "8D", "9D"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2FourOfAKind_P1Win() {
        String[] input = {"10H", "10D", "10F", "10S", "8H", "9D", "9S", "9F", "8D", "9H"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2FullHouse_P1Win() {
        String[] input = {"10H", "10D", "10F", "8S", "8H", "9D", "9S", "9F", "8D", "7H"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2Flush_P1Win() {
        String[] input = {"10H", "7H", "5H", "8H", "3H", "9D", "9S", "9F", "8D", "7H"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2Straight_P1Win() {
        String[] input = {"10D", "7H", "9H", "8H", "6H", "9D", "9S", "9F", "8D", "7H"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2ThreeOfAKind_P1Win() {
        String[] input = {"10D", "10H", "10S", "8H", "6H", "AD", "9S", "9F", "8D", "7H"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2TwoPair_P1Win() {
        String[] input = {"10D", "10H", "8S", "8H", "6H", "AD", "9S", "9F", "8D", "7H"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2OnePair_P1Win() {
        String[] input = {"10D", "10H", "8S", "7H", "6H", "AD", "9S", "4F", "8D", "7H"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void PokerWinner_P1P2HighCard_P1Win() {
        String[] input = {"10D", "3H", "8S", "7H", "AH", "KD", "9S", "4F", "8D", "7H"};
        String result = pokerPlayWinner.checkWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

    @Test
    public void DealPokerWinner_P1P2_P1Win() {
        String[] input = {"10D", "KD", "8S", "7H", "AD", "QD", "JD", "4F", "8D"};
        String result = pokerPlayWinner.checkDealWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);

    }

    @Test
    public void DealPokerWinner_P1P2_P2Win() {
        String[] input = {"8S", "7H", "10D", "KD", "AD", "QD", "JD", "4F", "8D"};
        String result = pokerPlayWinner.checkDealWinner(input);
        assertThat(result).isEqualTo(P2_WINNER);
    }

    @Test
    public void DealPokerWinner_P1P2_Draw() {
        String[] input = {"8S", "7H", "10D", "7D", "7S", "7F", "JD", "4H", "2D"};
        String result = pokerPlayWinner.checkDealWinner(input);
        assertThat(result).isEqualTo(DRAW);
    }

    @Test
    public void DealPokerWinner_P1P2_ALow_P2Win() {
        String[] input = {"AS", "7H", "6D", "7D", "3S", "5F", "JD", "4H", "2D"};
        String result = pokerPlayWinner.checkDealWinner(input);
        assertThat(result).isEqualTo(P2_WINNER);
    }

    @Test
    public void DealPokerWinner_P1P2_High_P1Win() {
        String[] input = {"AS", "7H", "6H", "KD", "3S", "3F", "QD", "4H", "2D"};
        String result = pokerPlayWinner.checkDealWinner(input);
        assertThat(result).isEqualTo(P1_WINNER);
    }

}
