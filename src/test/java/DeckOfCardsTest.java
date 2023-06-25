import org.cardgame.RankAndSuitOfCards;
import org.cardgame.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DeckOfCardsTest {
    // unit test to ensure that cards get shuffled
    @Test
    public void verifyShuffled(){
        List<RankAndSuitOfCards> cards = new DeckOfCards().createDeckOfCards();
        List<RankAndSuitOfCards> shuffledCards = new DeckOfCards().getDeckOfCards();
        Assert.assertNotSame(cards, shuffledCards);
    }
    // unit test to verify deck of cards
    @Test
    public void verifyDeckOfCards() {
        List<RankAndSuitOfCards> cards = new DeckOfCards().createDeckOfCards();
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.setDeckOfCards(cards);
        Assert.assertEquals(cards, deckOfCards.getDeckOfCards());
    }
}
