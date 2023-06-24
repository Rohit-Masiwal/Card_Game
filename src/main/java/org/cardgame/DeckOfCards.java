package org.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<RankAndSuitOfCards> deckOfCards = new ArrayList<>();
    public DeckOfCards() {
        for(RankAndSuitOfCards.Rank rank: RankAndSuitOfCards.Rank.values()) {
            for(RankAndSuitOfCards.Suits suits : RankAndSuitOfCards.Suits.values()) {
                this.deckOfCards.add(new RankAndSuitOfCards(rank, suits));
            }
        }
        Collections.shuffle(this.deckOfCards);
    }

    // getter methods for instance variable deckOfCards
    public List<RankAndSuitOfCards> getDeckOfCards() {
        return this.deckOfCards;
    }

}
