public enum PokerRank {
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
