class Card {
    private int suit, rank;
    public Card () {
        this.suit = 0;
        this.rank = 0;
    }

    public Card (int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public void printCard () {
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] ranks = { "narf", "Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King" }; //zeorth element is narf and not normally used
        System.out.println (ranks[rank] + " of " + suits[suit]);
    } //end printCard
} //end class
