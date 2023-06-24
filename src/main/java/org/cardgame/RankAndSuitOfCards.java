package org.cardgame;

public class RankAndSuitOfCards {
    public enum Rank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        KING,
        QUEEN,
        JACK
    }
    public enum Suits {
        SPADES,
        DIAMONDS,
        HEARTS,
        CLUBS
    }

    private Rank rank;
    private Suits suit;

    public RankAndSuitOfCards(Rank rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // getter methods for instance variables rank, suit
    public RankAndSuitOfCards.Rank getRank() {
        return this.rank;
    }

    public Suits getSuit() {
        return this.suit;
    }

}
