import java.util.*;

public class PokerCheck {

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

        if (!checkCardSequence(numCards)) {
            return true;
        }
        if (numCards.get(4) == 14) {
            ArrayList<Integer> cards = new ArrayList<>();
            cards.add(1);
            cards.addAll(numCards.subList(0, 4));
            if (!checkCardSequence(cards)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCardSequence(ArrayList<Integer> numCards) {
        for (int i = 1; i < numCards.size(); i++) {
            int cardDiff = numCards.get(i) - numCards.get(i - 1);
            if ((cardDiff > 1) || (cardDiff == 0)) {
                return true;
            }
        }
        return false;
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
        if (checkRoyalFlush(cardsAndTypes)) {
            return PokerRank.ROYAL_FLUSH.getRank();
        } else if (checkStraightFlush(cardsAndTypes)) {
            return PokerRank.STRAIGHT_FLUSH.getRank();
        } else if (checkFourOfAKind(cardsAndTypes)) {
            return PokerRank.FOUR_OF_KIND.getRank();
        } else if (checkFullHouse(cardsAndTypes)) {
            return PokerRank.FULL_HOUSE.getRank();
        } else if (checkFlush(cardsAndTypes)) {
            return PokerRank.FLUSH.getRank();
        } else if (checkStraight(cardsAndTypes)) {
            return PokerRank.STRAIGHT.getRank();
        } else if (checkThreeOfAKind(cardsAndTypes)) {
            return PokerRank.THREE_OF_A_KIND.getRank();
        } else if (checkTwoPair(cardsAndTypes)) {
            return PokerRank.TWO_PAIR.getRank();
        } else if (checkPair(cardsAndTypes)) {
            return PokerRank.ONE_PAIR.getRank();
        } else {
            return PokerRank.HIGH_CARD.getRank();
        }
    }

    public Integer getHighCard(String[] input) {
        HashMap<String, ArrayList> cardsAndTypes = getCardNumberAndType(input);
        ArrayList<Integer> numCards = cardsAndTypes.get("Cards");
        if (checkStraight(cardsAndTypes)) {
            if (numCards.get(4) ==14 && numCards.get(3) == 5) {
                return numCards.get(3);
            }
            return numCards.get(4);
        }
        return numCards.get(4);
    }
}
