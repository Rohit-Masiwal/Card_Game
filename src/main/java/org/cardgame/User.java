package org.cardgame;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userNumber;
    private List<RankAndSuitOfCards> cards = new ArrayList<>();

    public User(int userNumber) {
        this.userNumber = userNumber;
    }

    public void takeCard(RankAndSuitOfCards card) {
        this.cards.add(card);
    }

    public void discardCard(RankAndSuitOfCards card) {
        this.cards.remove(card);
    }

    // getter methods for instance variables userNumber, cards
    public int getUserNumber() {
        return this.userNumber;
    }

    public List<RankAndSuitOfCards> getCards() {
        return cards;
    }

}
