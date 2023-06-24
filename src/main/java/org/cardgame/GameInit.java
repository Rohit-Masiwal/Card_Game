package org.cardgame;

import java.util.Scanner;

public class GameInit {

    public static void main(String[] args) {
        // execution of game.
        System.out.println("************GAME BEGINS************");

        int numOfPlayers;
        while(true) {
            System.out.println("Enter the number of players(2, 3 or 4 players): ");
            numOfPlayers = new Scanner(System.in).nextInt();
            if(numOfPlayers == 2 || numOfPlayers == 3 || numOfPlayers == 4) {
                break;
            }
            System.out.println("Invalid entry. Please try again!");
        }

        System.out.println("************GAME OVER************");

    }

}