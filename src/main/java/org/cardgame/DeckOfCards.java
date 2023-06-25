package org.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<RankAndSuitOfCards> deckOfCards;
    public DeckOfCards() {
        this.deckOfCards = createDeckOfCards();
        Collections.shuffle(deckOfCards);
    }

    public List<RankAndSuitOfCards> createDeckOfCards() {
        List<RankAndSuitOfCards> deckOfCards = new ArrayList<>();
        for(RankAndSuitOfCards.Rank rank: RankAndSuitOfCards.Rank.values()) {
            for(RankAndSuitOfCards.Suits suits : RankAndSuitOfCards.Suits.values()) {
                deckOfCards.add(new RankAndSuitOfCards(rank, suits));
            }
        }

        return deckOfCards;
    }

    // getter methods for instance variable deckOfCards
    public List<RankAndSuitOfCards> getDeckOfCards() {
        return this.deckOfCards;
    }

    public void setDeckOfCards(List<RankAndSuitOfCards> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

}
