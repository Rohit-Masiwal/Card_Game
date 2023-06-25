import org.cardgame.RankAndSuitOfCards;
import org.cardgame.User;
import org.cardgame.RankAndSuitOfCards.Suits;
import org.junit.Assert;
import org.junit.Test;

import org.cardgame.RankAndSuitOfCards.Rank;

public class UserTest {
    // unit test to verify number of cards taken by a user
    @Test
    public void verifyTakenCards() {
        User user = new User(3);
        RankAndSuitOfCards king = new RankAndSuitOfCards(Rank.KING, Suits.CLUBS);
        user.takeCard(king);
        RankAndSuitOfCards ace = new RankAndSuitOfCards(Rank.ACE, Suits.CLUBS);
        user.takeCard(ace);
        RankAndSuitOfCards queen = new RankAndSuitOfCards(Rank.QUEEN, Suits.CLUBS);
        user.takeCard(queen);
        Assert.assertEquals(3,user.getCards().size());
    }
    // unit test to verify number of cards user is holding after drawing and discard
    @Test
    public void verifyDiscardedCards(){
        User user = new User(8);
        RankAndSuitOfCards king = new RankAndSuitOfCards(Rank.KING, Suits.CLUBS);
        user.takeCard(king);
        RankAndSuitOfCards ace = new RankAndSuitOfCards(Rank.ACE, Suits.CLUBS);
        user.takeCard(ace);
        RankAndSuitOfCards queen = new RankAndSuitOfCards(Rank.QUEEN, Suits.CLUBS);
        user.takeCard(queen);
        user.discardCard(ace);
        Assert.assertEquals(2,user.getCards().size());
    }
    // unit test to verify user
    @Test
    public void verifyUser() {
        User user = new User(5);
        Assert.assertEquals(5,user.getUserNumber());
    }

}
