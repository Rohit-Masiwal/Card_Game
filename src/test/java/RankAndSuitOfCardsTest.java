import org.cardgame.RankAndSuitOfCards;
import org.cardgame.RankAndSuitOfCards.Rank;
import org.cardgame.RankAndSuitOfCards.Suits;
import org.junit.Assert;
import org.junit.Test;

public class RankAndSuitOfCardsTest {
    // unit test to verify cards
    @Test
    public void verifyCards() {
        RankAndSuitOfCards cards = new RankAndSuitOfCards(Rank.ACE,Suits.HEARTS);
        Assert.assertEquals(Rank.ACE,cards.getRank());
        Assert.assertEquals(Suits.HEARTS,cards.getSuit());
    }

}
