import java.util.*;

enum PokerRank {
    ROYAL_FLUSH(1),
    STRAIGHT_FLUSH(2),
    FOUR_OF_KIND(3),
    FULL_HOUSE(4),
    FLUSH(5),
    STRAIGHT(6),
    THREE_OF_A_KIND(7),
    TWO_PAIR(8),
    ONE_PAIR(9),
    HIGH_CARD(10);

    private int rank;

    public int getRank() {
        return this.rank;
    }

    PokerRank(int rank) {
        this.rank = rank;
    }
}

public class PokerCompare {

    public boolean checkRoyalFlush(HashMap<String, ArrayList> cardsAndTypes) {
        HashSet type = new HashSet(cardsAndTypes.get("Type"));
        ArrayList<Integer> numCards = cardsAndTypes.get("Cards");

        if (type.size() == 1) {
            int sum = numCards.stream().mapToInt(a -> a).sum();
            return sum == 60 ? true : false;
        }
        return false;
    }

    public boolean checkFlush(HashMap<String, ArrayList> cardsAndTypes) {

        HashSet type = new HashSet(cardsAndTypes.get("Type"));
        if (type.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean checkStraightFlush(HashMap<String, ArrayList> cardsAndTypes) {

        HashSet type = new HashSet(cardsAndTypes.get("Type"));
        if (type.size() == 1) {
            return checkStraight(cardsAndTypes);
        }
        return false;
    }

    private ArrayList convertCardToNumber(ArrayList<String> cards) {
        ArrayList numCards = new ArrayList();

        for (String card : cards
                ) {
            switch (card) {
                case "J":
                    numCards.add(11);
                    break;
                case "Q":
                    numCards.add(12);
                    break;
                case "K":
                    numCards.add(13);
                    break;
                case "A":
                    numCards.add(14);
                    break;
                default:
                    numCards.add(Integer.valueOf(card));
                    break;
            }
        }
        Collections.sort(numCards);
        return numCards;
    }

    private HashMap<String, ArrayList> getCardNumberAndType(String[] inputCards) {
        HashMap<String, ArrayList> output = new HashMap<>();
        ArrayList type = new ArrayList();
        ArrayList cards = new ArrayList();
        for (String el : Arrays.asList(inputCards)
                ) {
            type.add(el.substring(el.length() - 1, el.length()));
            cards.add(el.substring(0, el.length() - 1));
        }
        output.put("Type", type);
        output.put("Cards", convertCardToNumber(cards));
        return output;
    }

    public boolean checkFourOfAKind(HashMap<String, ArrayList> cardsAndTypes) {
        HashMap<Integer, Integer> numCardsCount = getNumCardCount(cardsAndTypes.get("Cards"));
        if (numCardsCount.size() > 2) {
            return false;
        } else {
            for (int key : numCardsCount.keySet()) {
                if (numCardsCount.get(key) == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    private HashMap<Integer, Integer> getNumCardCount(ArrayList<Integer> numCards) {
        HashMap<Integer, Integer> numCardsCount = new HashMap<>();
        for (Integer card : numCards) {
            if (numCardsCount.get(card) == null) {
                numCardsCount.put(card, 1);
            } else {
                int count = numCardsCount.get(card);
                numCardsCount.remove(card);
                numCardsCount.put(card, count + 1);
            }
        }
        return numCardsCount;
    }

    public boolean checkFullHouse(HashMap<String, ArrayList> cardsAndTypes) {
        HashMap<Integer, Integer> numCardsCount = getNumCardCount(cardsAndTypes.get("Cards"));
        if (numCardsCount.size() > 2) {
            return false;
        } else {
            for (int key : numCardsCount.keySet()) {
                if ((numCardsCount.get(key) > 3) || (numCardsCount.get(key) < 2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean checkStraight(HashMap<String, ArrayList> cardsAndTypes) {
        ArrayList<Integer> numCards = cardsAndTypes.get("Cards");
        for (int i = 1; i < numCards.size(); i++) {
            int cardDiff = numCards.get(i) - numCards.get(i - 1);
            if ((cardDiff > 1) || (cardDiff == 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkThreeOfAKind(HashMap<String, ArrayList> cardsAndTypes) {
        HashMap<Integer, Integer> numCardsCount = getNumCardCount(cardsAndTypes.get("Cards"));
        if (numCardsCount.size() == 3) {
            for (Integer key : numCardsCount.keySet()) {
                if (numCardsCount.get(key) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkTwoPair(HashMap<String, ArrayList> cardsAndTypes) {
        HashMap<Integer, Integer> numCardsCount = getNumCardCount(cardsAndTypes.get("Cards"));
        int pairCount = 0;
        if (numCardsCount.size() == 3) {
            for (Integer key : numCardsCount.keySet()) {
                if (numCardsCount.get(key) == 2) {
                    pairCount++;
                }
            }
        }
        if (pairCount == 2) {
            return true;
        }
        return false;
    }

    public boolean checkPair(HashMap<String, ArrayList> cardsAndTypes) {
        HashMap<Integer, Integer> numCardsCount = getNumCardCount(cardsAndTypes.get("Cards"));
        if (numCardsCount.size() == 4) {
            for (Integer key : numCardsCount.keySet()) {
                if (numCardsCount.get(key) == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer getCardRank(String[] input) {
        HashMap<String, ArrayList> cardsAndTypes = getCardNumberAndType(input);
        if(checkRoyalFlush(cardsAndTypes)) {
            return PokerRank.ROYAL_FLUSH.getRank();
        }
        else if(checkStraightFlush(cardsAndTypes)) {
            return PokerRank.STRAIGHT_FLUSH.getRank();
        }
        else if(checkFourOfAKind(cardsAndTypes)) {
            return PokerRank.FOUR_OF_KIND.getRank();
        }
        else if(checkFullHouse(cardsAndTypes)) {
            return PokerRank.FULL_HOUSE.getRank();
        }
        else if(checkFlush(cardsAndTypes)) {
            return PokerRank.FLUSH.getRank();
        }
        else if(checkStraight(cardsAndTypes)) {
            return PokerRank.STRAIGHT.getRank();
        }
        else if(checkThreeOfAKind(cardsAndTypes)) {
            return PokerRank.THREE_OF_A_KIND.getRank();
        }
        else if(checkTwoPair(cardsAndTypes)) {
            return PokerRank.TWO_PAIR.getRank();
        }
        else if(checkPair(cardsAndTypes)) {
            return PokerRank.ONE_PAIR.getRank();
        }
        else {
            return PokerRank.HIGH_CARD.getRank();
        }
    }
}
