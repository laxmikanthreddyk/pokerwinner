import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerCheckTest {

    PokerCheck pokerCheck = new PokerCheck();
    HashMap<String, ArrayList> cardsAndTypes;

    @Test
    public void checkRoyalFlush_true() {
        cardsAndTypes = getCardInput(10, 11, 12,
                13, 14, "H", "H",
                "H", "H", "H");
        boolean result = pokerCheck.checkRoyalFlush(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void checkRoyalFlush_false() {
        cardsAndTypes = getCardInput(10, 11, 12,
                13, 14, "H", "H",
                "H", "H", "D");
        boolean result = pokerCheck.checkRoyalFlush(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void checkFlush_true() {
        cardsAndTypes = getCardInput(10, 11, 2,
                9, 14, "H", "H",
                "H", "H", "H");
        boolean result = pokerCheck.checkFlush(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void checkFlush_false() {
        cardsAndTypes = getCardInput(10, 11, 2,
                9, 14, "H", "H",
                "D", "H", "H");
        boolean result = pokerCheck.checkFlush(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckStraightFlush_true() {
        cardsAndTypes = getCardInput(10, 11, 12,
                9, 8, "H", "H",
                "H", "H", "H");
        boolean result = pokerCheck.checkStraightFlush(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckStraightFlush_false() {
        cardsAndTypes = getCardInput(10, 11, 13,
                9, 8, "H", "H",
                "H", "H", "H");
        boolean result = pokerCheck.checkStraightFlush(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckFourOfAKind_true() {
        cardsAndTypes = getCardInput(10, 10, 10,
                10, 8, "H", "D",
                "F", "S", "H");
        String[] input = {"10H", "10D", "10F", "10S", "8H"};
        boolean result = pokerCheck.checkFourOfAKind(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckFourOfAKind_false() {
        cardsAndTypes = getCardInput(10, 10, 10,
                9, 8, "H", "D",
                "F", "S", "H");
        boolean result = pokerCheck.checkFourOfAKind(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckFullHouse_true() {
        cardsAndTypes = getCardInput(10, 10, 10,
                9, 9, "H", "D",
                "F", "S", "H");

        boolean result = pokerCheck.checkFullHouse(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckFullHouse_false() {
        cardsAndTypes = getCardInput(10, 10, 10,
                9, 8, "H", "D",
                "F", "S", "H");

        boolean result = pokerCheck.checkFullHouse(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckStraight_true() {
        cardsAndTypes = getCardInput(7, 6, 10,
                9, 8, "H", "D",
                "F", "S", "H");
        boolean result = pokerCheck.checkStraight(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckStraight_LowCard_A_true() {
        cardsAndTypes = getCardInput(5, 4, 2,
                3, 14, "H", "D",
                "F", "S", "H");
        boolean result = pokerCheck.checkStraight(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckStraight_false() {
        cardsAndTypes = getCardInput(7, 6, 10,
                9, 10, "H", "D",
                "F", "S", "H");
        boolean result = pokerCheck.checkStraight(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckThreeOfAKind_true() {
        cardsAndTypes = getCardInput(7, 7, 7,
                8, 9, "H", "D",
                "F", "S", "H");

        boolean result = pokerCheck.checkThreeOfAKind(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckThreeOfAKind_false() {
        cardsAndTypes = getCardInput(7, 7, 10,
                8, 10, "H", "D",
                "F", "S", "H");

        boolean result = pokerCheck.checkThreeOfAKind(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckTwoPair_true() {
        cardsAndTypes = getCardInput(7, 7, 8,
                8, 10, "H", "D",
                "F", "S", "H");

        boolean result = pokerCheck.checkTwoPair(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckTWoPair_false() {
        cardsAndTypes = getCardInput(7, 7, 10,
                8, 6, "H", "D",
                "F", "S", "H");

        boolean result = pokerCheck.checkTwoPair(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void CheckPair_true() {
        cardsAndTypes = getCardInput(7, 7, 10,
                8, 6, "H", "D",
                "F", "S", "H");

        boolean result = pokerCheck.checkPair(cardsAndTypes);
        assertThat(result).isTrue();
    }

    @Test
    public void CheckPair_false() {
        cardsAndTypes = getCardInput(7, 5, 10,
                8, 6, "H", "D",
                "F", "S", "H");

        boolean result = pokerCheck.checkPair(cardsAndTypes);
        assertThat(result).isFalse();
    }

    @Test
    public void GetCardRank_RoyalFlush() {
        String[] input = {"10H", "JH", "QH", "KH", "AH"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void GetCardRank_StraightFlush() {
        String[] input = {"10H", "JH", "QH", "KH", "9H"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void GetCardRank_FourOfAKind() {
        String[] input = {"10H", "10D", "10F", "10S", "9H"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void GetCardRank_FullHouse() {
        String[] input = {"10H", "10D", "10F", "9S", "9H"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void GetCardRank_Flush() {
        String[] input = {"7H", "2H", "3H", "AH", "9H"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void GetCardRank_Straight() {
        String[] input = {"7H", "6D", "5S", "4H", "8H"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void GetCardRank_Straight_LowCard_A() {
        String[] input = {"3H", "2D", "5S", "4H", "AH"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void GetCardRank_ThreeOfAKind() {
        String[] input = {"7H", "7D", "7S", "4H", "8H"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void GetCardRank_TwoPair() {
        String[] input = {"7H", "7D", "4S", "4H", "8H"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void GetCardRank_OnePair() {
        String[] input = {"7H", "7D", "5S", "4H", "8H"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void GetCardRank_HighCard() {
        String[] input = {"7H", "4D", "2S", "KH", "AH"};
        Integer result = pokerCheck.getCardRank(input);
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void GetHighCard() {
        String[] input = {"7H", "4D", "2S", "KH", "AH"};
        Integer result = pokerCheck.getHighCard(input);
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void GetHighCard_Straight_ACard() {
        String[] input = {"2H", "3D", "4S", "5H", "AH"};
        Integer result = pokerCheck.getHighCard(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_RoyalFlush() {
        String[] input = {"10H", "JH"};
        String[] dealInput = { "7F", "AD", "QH", "KH", "AH"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_RoyalFlush() {
        String[] input = {"3H", "JH"};
        String[] dealInput = { "10H", "AD", "QH", "KH", "AH"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_StraightFlush() {
        String[] input = {"9H", "JH"};
        String[] dealInput = { "7F", "AD", "QH", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_StraightFlush() {
        String[] input = {"3H", "JH"};
        String[] dealInput = { "9H", "AD", "QH", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_FourOfAKind() {
        String[] input = {"9H", "9D"};
        String[] dealInput = { "7F", "9F", "9S", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_FourOfAKind() {
        String[] input = {"3H", "JH"};
        String[] dealInput = { "JF", "JS", "JD", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_FullHouse() {
        String[] input = {"9H", "9D"};
        String[] dealInput = { "7F", "10F", "10S", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_FullHouse() {
        String[] input = {"3H", "KH"};
        String[] dealInput = { "JF", "JS", "JD", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_Flush() {
        String[] input = {"9H", "3H"};
        String[] dealInput = { "4H", "6F", "2S", "KH", "AH"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_Flush() {
        String[] input = {"3H", "AF"};
        String[] dealInput = { "JH", "6H", "2D", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_Straight() {
        String[] input = {"9H", "JH"};
        String[] dealInput = { "4H", "10F", "8S", "KD", "QH"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_Straight() {
        String[] input = {"3H", "JH"};
        String[] dealInput = { "9F", "8S", "QD", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_ThreeOfAKind() {
        String[] input = {"9H", "9D"};
        String[] dealInput = { "4H", "9F", "8S", "KH", "QH"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_ThreeOfAKind() {
        String[] input = {"3H", "JH"};
        String[] dealInput = { "JF", "JS", "9D", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_TwoPair() {
        String[] input = {"9H", "9D"};
        String[] dealInput = { "4H", "8F", "8S", "KH", "QH"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_TwoPair() {
        String[] input = {"3H", "JH"};
        String[] dealInput = { "JF", "10S", "9D", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_OnePair() {
        String[] input = {"9H", "9D"};
        String[] dealInput = { "4H", "8F", "6S", "KH", "QH"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_OnePair() {
        String[] input = {"3H", "JH"};
        String[] dealInput = { "JF", "4S", "9D", "KH", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void GetCardRank_Dealer_TwoCards_HighCard() {
        String[] input = {"9H", "AD"};
        String[] dealInput = { "4H", "8F", "6S", "KH", "QH"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_HighCard() {
        String[] input = {"3H", "KH"};
        String[] dealInput = { "JF", "4S", "9D", "5H", "10H"};
        Integer result = pokerCheck.getCardRank(input, dealInput).getRank();
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void GetCardRank_Dealer_SingleCard_BestCards() {
        String[] input = {"3H", "KH"};
        String[] dealInput = { "JF", "QS", "9D", "5H", "10H"};
        String[] result = pokerCheck.getCardRank(input, dealInput).getCards();
        assertThat(result).contains("KH","JF","QS","9D","10H");
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
