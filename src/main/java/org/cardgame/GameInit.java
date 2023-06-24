package org.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.cardgame.RankAndSuitOfCards.Rank.*;

public class GameInit {

    public static void main(String[] args) {
        // execution of game.
        System.out.println("************************GAME BEGINS************************");

        int players;
        while(true) {
            System.out.println("Enter the number of players(2, 3 or 4 players): ");
            players = new Scanner(System.in).nextInt();
            if(players == 2 || players == 3 || players == 4) {
                break;
            }
            System.out.println("Invalid entry. Please try again!");
        }
        gameInit(players);

        System.out.println("************************GAME OVER************************");

    }

    public static void gameInit(int players) {
        List<RankAndSuitOfCards> deckOfCards = new DeckOfCards().getDeckOfCards();

        List<User> users = getUsers(players, deckOfCards);

        List<RankAndSuitOfCards> discardPileOfCards = new ArrayList<>();
        discardPileOfCards.add(deckOfCards.get(0)); // adding first card to discard pile and remaining to draw pile
        deckOfCards.remove(0);
        List<RankAndSuitOfCards> drawPileOfCards = new ArrayList<>(deckOfCards);

        int playerNumber = 0;
        boolean clockwiseDirection = true; // tells the direction in which the players will be discarding/drawing cards

        int numberOfCardsToDraw = 1;

        while (true) {
            // when number of cards to draw are less, game will draw
            if (drawPileOfCards.size() < numberOfCardsToDraw) {
                System.out.println("Game Draw");
                break;
            }

            // playerNumber can be from 0 to players-1
            playerNumber = (playerNumber + players)%players;

            boolean isMatched = false; // to check if card matches with either suit or rank of the top card on discard pile
            RankAndSuitOfCards.Rank matchedRank = null;
            RankAndSuitOfCards topDiscardRankAndSuitOfCards = discardPileOfCards.get(discardPileOfCards.size() - 1);
            System.out.println("Card at top of discard pile is " + topDiscardRankAndSuitOfCards.getRank()
                    + " of " + topDiscardRankAndSuitOfCards.getSuit());

            // iterating through all cards of current player to find a matching card
            for (RankAndSuitOfCards currentPlayerRankAndSuitOfCards : users.get(playerNumber).getCards()) {
                if (currentPlayerRankAndSuitOfCards.getRank() == topDiscardRankAndSuitOfCards.getRank()
                        || currentPlayerRankAndSuitOfCards.getSuit() == topDiscardRankAndSuitOfCards.getSuit()) {

                    // condition for action cards to be not stackable i.e, can't be placed one over another
                    if ((topDiscardRankAndSuitOfCards.getRank() == ACE)
                            || (topDiscardRankAndSuitOfCards.getRank() == KING)
                            || (topDiscardRankAndSuitOfCards.getRank() == QUEEN)
                            || (topDiscardRankAndSuitOfCards.getRank() == JACK)) {
                        // not playing action card
                        if (currentPlayerRankAndSuitOfCards.getRank() == topDiscardRankAndSuitOfCards.getRank()) {
                            continue;
                        }
                    }

                    System.out.println("Player " + users.get(playerNumber).getUserNumber() + " has a matching card");
                    System.out.println("New card at top of discard pile is " + currentPlayerRankAndSuitOfCards.getRank()
                            + " of " + currentPlayerRankAndSuitOfCards.getSuit());

                    // in cards matching case, current player may have to draw cards based on previous player's action card
                    if(numberOfCardsToDraw > 1){
                        while (numberOfCardsToDraw-- > 0) {
                            RankAndSuitOfCards drawCard = drawPileOfCards.get(drawPileOfCards.size() - 1);
                            System.out.println("Player " + users.get(playerNumber).getUserNumber() + " draws "
                                    + drawCard.getRank() + " of " + drawCard.getSuit());

                            users.get(playerNumber).takeCard(drawCard);
                            drawPileOfCards.remove(drawPileOfCards.size() - 1);
                        }
                        numberOfCardsToDraw = 1;
                    }

                    // removing the matched card to discard pile
                    users.get(playerNumber).discardCard(currentPlayerRankAndSuitOfCards);
                    discardPileOfCards.add(currentPlayerRankAndSuitOfCards);
                    isMatched = true;
                    matchedRank = currentPlayerRankAndSuitOfCards.getRank();
                    break;
                }
            }

            if (!isMatched) {
                System.out.println("None of the cards matched for player " + users.get(playerNumber).getUserNumber()
                        + ", hence drawing " + numberOfCardsToDraw + " card/s from draw pile");

                while (numberOfCardsToDraw-- > 0) {
                    System.out.println("Player " + users.get(playerNumber).getUserNumber() + " draws "
                            + drawPileOfCards.get(drawPileOfCards.size() - 1).getRank()
                        + " of " + drawPileOfCards.get(drawPileOfCards.size() - 1).getSuit());
                    users.get(playerNumber).takeCard(drawPileOfCards.get(drawPileOfCards.size() - 1));
                    drawPileOfCards.remove(drawPileOfCards.size() - 1);
                }
                numberOfCardsToDraw = 1;
            }
            else {
                // if current player has a match and is left with no cards then he's the winner
                if (users.get(playerNumber).getCards().size() == 0) {
                    System.out.println("Player " + users.get(playerNumber).getUserNumber() + " wins the game :)");
                    break;
                }

                // if the current player plays ACE then next player's chance will be skipped
                if (matchedRank == ACE) {
                    playerNumber += clockwiseDirection ? 1 : -1;
                }

                // if the current player plays KING then reverse the sequence of players
                if (matchedRank == KING) {
                    clockwiseDirection = !clockwiseDirection;
                }

                // if the current player plays JACK then next player will draw 4 cards
                if (matchedRank == JACK) {
                    numberOfCardsToDraw = 4;
                }

                // if the current player plays QUEEN then next player will draw 2 cards
                if (matchedRank == QUEEN) {
                    numberOfCardsToDraw = 2;
                }
            }

            playerNumber += clockwiseDirection ? 1 : -1;

            System.out.println('\n');
        }

    }

    public static List<User> getUsers(int players, List<RankAndSuitOfCards> deckOfCards) {
        List<User> users = new ArrayList<>();
        for (int player = 1; player <= players; player++) {
            User user = new User(player);
            int cards = 5;
            while(cards-- > 0) {
                user.takeCard(deckOfCards.get(deckOfCards.size() - 1));
                deckOfCards.remove(deckOfCards.size() - 1);
            }
            users.add(user);
        }
        return users;
    }
}