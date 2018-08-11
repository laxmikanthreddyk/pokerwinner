import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerCompareTest {

    PokerCompare pokerCompare = new PokerCompare();
    HashMap<String, ArrayList> cardsAndTypes;

    @Test
    public void checkRoyalFlush_true() {
        cardsAndTypes = getCardInput(10, 11, 12,
                13, 14, "H", "H",
                "H", "H", "H");
        boolean result = pokerCompare.checkRoyalFlush(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void checkRoyalFlush_false() {
        cardsAndTypes = getCardInput(10, 11, 12,
                13, 14, "H", "H",
                "H", "H", "D");
        boolean result = pokerCompare.checkRoyalFlush(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void checkFlush_true() {
        cardsAndTypes = getCardInput(10, 11, 2,
                9, 14, "H", "H",
                "H", "H", "H");
        boolean result = pokerCompare.checkFlush(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void checkFlush_false() {
        cardsAndTypes = getCardInput(10, 11, 2,
                9, 14, "H", "H",
                "D", "H", "H");
        boolean result = pokerCompare.checkFlush(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckStraightFlush_true() {
        cardsAndTypes = getCardInput(10, 11, 12,
                9, 8, "H", "H",
                "H", "H", "H");
        boolean result = pokerCompare.checkStraightFlush(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckStraightFlush_false() {
        cardsAndTypes = getCardInput(10, 11, 13,
                9, 8, "H", "H",
                "H", "H", "H");
        boolean result = pokerCompare.checkStraightFlush(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckFourOfAKind_true() {
        cardsAndTypes = getCardInput(10, 10, 10,
                10, 8, "H", "D",
                "F", "S", "H");
        String[] input = {"10H", "10D", "10F", "10S", "8H"};
        boolean result = pokerCompare.checkFourOfAKind(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckFourOfAKind_false() {
        cardsAndTypes = getCardInput(10, 10, 10,
                9, 8, "H", "D",
                "F", "S", "H");
        boolean result = pokerCompare.checkFourOfAKind(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckFullHouse_true() {
        cardsAndTypes = getCardInput(10, 10, 10,
                9, 9, "H", "D",
                "F", "S", "H");

        boolean result = pokerCompare.checkFullHouse(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckFullHouse_false() {
        cardsAndTypes = getCardInput(10, 10, 10,
                9, 8, "H", "D",
                "F", "S", "H");

        boolean result = pokerCompare.checkFullHouse(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckStraight_true() {
        cardsAndTypes = getCardInput(7, 6, 10,
                9, 8, "H", "D",
                "F", "S", "H");
        boolean result = pokerCompare.checkStraight(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckStraight_false() {
        cardsAndTypes = getCardInput(7, 6, 10,
                9, 10, "H", "D",
                "F", "S", "H");
        boolean result = pokerCompare.checkStraight(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckThreeOfAKind_true() {
        cardsAndTypes = getCardInput(7, 7, 7,
                8, 9, "H", "D",
                "F", "S", "H");

        boolean result = pokerCompare.checkThreeOfAKind(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckThreeOfAKind_false() {
        cardsAndTypes = getCardInput(7, 7, 10,
                8, 10, "H", "D",
                "F", "S", "H");

        boolean result = pokerCompare.checkThreeOfAKind(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckTwoPair_true() {
        cardsAndTypes = getCardInput(7, 7, 8,
                8, 10, "H", "D",
                "F", "S", "H");

        boolean result = pokerCompare.checkTwoPair(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckTWoPair_false() {
        cardsAndTypes = getCardInput(7, 7, 10,
                8, 6, "H", "D",
                "F", "S", "H");

        boolean result = pokerCompare.checkTwoPair(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckPair_true() {
        cardsAndTypes = getCardInput(7, 7, 10,
                8, 6, "H", "D",
                "F", "S", "H");

        boolean result = pokerCompare.checkPair(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckPair_false() {
        cardsAndTypes = getCardInput(7, 5, 10,
                8, 6, "H", "D",
                "F", "S", "H");

        boolean result = pokerCompare.checkPair(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void GetCardRank_RoyalFlush() {
        String[] input = {"10H", "JH", "QH", "KH", "AH"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void GetCardRank_StraightFlush() {
        String[] input = {"10H", "JH", "QH", "KH", "9H"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void GetCardRank_FourOfAKind() {
        String[] input = {"10H", "10D", "10F", "10S", "9H"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void GetCardRank_FullHouse() {
        String[] input = {"10H", "10D", "10F", "9S", "9H"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void GetCardRank_Flush() {
        String[] input = {"7H", "2H", "3H", "AH", "9H"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void GetCardRank_Straight() {
        String[] input = {"7H", "6D", "5S", "4H", "8H"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void GetCardRank_ThreeOfAKind() {
        String[] input = {"7H", "7D", "7S", "4H", "8H"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void GetCardRank_TwoPair() {
        String[] input = {"7H", "7D", "4S", "4H", "8H"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void GetCardRank_OnePair() {
        String[] input = {"7H", "7D", "5S", "4H", "8H"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void GetCardRank_HighCard() {
        String[] input = {"7H", "4D", "2S", "KH", "AH"};
        Integer result = pokerCompare.getCardRank(input);
        assertThat(result).isEqualTo(10);
    }

    private ArrayList addCardType(String c1, String c2, String c3,
                                  String c4, String c5) {
        String[] cardTypes = {c1, c2, c3, c4, c5};
        return new ArrayList(Arrays.asList(cardTypes));
    }

    private ArrayList<Integer> addCards(Integer c1, Integer c2,
                                        Integer c3, Integer c4, Integer c5) {
        Integer[] cards = {c1, c2, c3, c4, c5};
        ArrayList<Integer> numCards = new ArrayList(Arrays.asList(cards));
        Collections.sort(numCards);
        return numCards;
    }

    private HashMap<String, ArrayList> getCardInput(Integer card1, Integer card2,
                                 Integer card3, Integer card4, Integer card5,
                                 String ctype1, String ctype2, String ctype3,
                                 String ctype4, String ctype5) {
        cardsAndTypes = new HashMap<>();
        cardsAndTypes.put("Cards", addCards(card1, card2, card3, card4, card5));
        cardsAndTypes.put("Type", addCardType(ctype1, ctype2, ctype3, ctype4, ctype5));
        return cardsAndTypes;
    }

}
