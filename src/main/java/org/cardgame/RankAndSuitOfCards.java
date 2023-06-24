package org.cardgame;

public class RankAndSuitOfCards {
    public enum Rank {
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        King,
        Queen,
        Jack
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
