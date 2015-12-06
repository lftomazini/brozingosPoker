/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 * Instructor: Prof Peck
 * Section: 8am
 *
 * Name: Stephanie Garboski, Leonardo Viglino, Anmol Singh,
 Luis Felipe Tomazini
 * Date:
 *
 * Brozingos Poker:
 *
 * Description:
 *
 * *****************************************/
package csci205finalproject;

import Cards.Card;
import Cards.Deck;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lffct001
 */
public class gameFlow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.createDeck();
        int[] chips = new int[5];

        //creating players
        ArrayList<Player> playerArray = new ArrayList<>();
        Player player_1 = new Player(chips, "Player 1");
        Player player_2 = new Player(chips, "Player 2");
        Player player_3 = new Player(chips, "Player 3");
        Player player_4 = new Player(chips, "Player 4");
        Player player_5 = new Player(chips, "Player 5");

        playerArray.add(player_1);
        playerArray.add(player_2);
        playerArray.add(player_3);
        playerArray.add(player_4);
        playerArray.add(player_5);

        //giving cards
        CardDealer cardDealer = new CardDealer(deck, playerArray);
        cardDealer.giveCardstoPlayers();
        ArrayList<Card> table = new ArrayList<>();

        //cretaes the game
        GameClass game = new GameClass(playerArray, 25, 50);
        //set the minimum bet to the big blind
        game.setBet(game.getBigBlind());

        int ending;
        int j;
        //for flop turn river and final bets
        for (int i = 0; i < 4; i++) {

            // rounds equal number of players
            ending = playerArray.size();
            j = 0;
            //for each player
            while (0 != ending) {
//            for (j = 0; j < playerArray.size(); j++) {
                System.out.println("Player " + (j + 1));
//                System.out.println("Will end in " + ending);

                //let the player to something if still on the game
                if (!playerArray.get(j).isHasFolded()) {

                    //pays big blind if player is big blind
                    if (playerArray.get(j).isBigBlind() && i == 0) {
                        playerArray.get(j).makeBet(game.getBigBlind());
                        System.out.println("Payed big");
                    } else {

                        //pays small blind if player is small blind
                        if (playerArray.get(j).isSmallBlind() && i == 0) {
                            playerArray.get(j).makeBet(game.getSmallBlind());
                            ending++;
                            playerArray.get(j).setSmallBlind(false);
                            System.out.println("Payed small");

                            //let the player choose an action
                        } else {
                            System.out.println("0: Pay minimum");
                            System.out.println("1: Fold");
                            System.out.println("2: Increase");
                            Scanner sc = new Scanner(System.in);
                            int option = sc.nextInt();

                            //do an action depending on what the player chose
                            switch (option) {
                                case 0:
                                    playerArray.get(j).makeBet(
                                            game.getBet());
                                    //TODO remove money from player
                                    break;
                                case 1:
                                    playerArray.get(j).setHasFolded(true);
                                    break;
                                case 2:
                                    System.out.println("Amount to increase: ");
                                    int amount = sc.nextInt();
                                    playerArray.get(j).makeBet(amount);
                                    game.setBet(amount);
                                    //TODO remove money from player

//                                    ending = (ending + playerArray.size() - 3) % playerArray.size();
                                    ending = (ending + playerArray.size() > playerArray.size()) ? playerArray.size() : (ending + playerArray.size());
                                    break;
                            }
                        }
                    }
                }
//                if (!(ending == playerArray.size() && j + 1 == ending)) {
                j = (j == playerArray.size() - 1) ? 0 : j + 1;
                ending--;
//                } else {
//                    j++;
//                }
            }

            //do an action depending if it is flop turn river
            switch (i) {
                case 0:
                    System.out.println("Flop");
                    Card flop_1 = cardDealer.placeCardsOnTable();
                    Card flop_2 = cardDealer.placeCardsOnTable();
                    Card flop_3 = cardDealer.placeCardsOnTable();
                    table.add(flop_1);
                    table.add(flop_2);
                    table.add(flop_3);
                    break;
                case 1:
                    System.out.println("Turn");
                    Card flop_4 = cardDealer.placeCardsOnTable();
                    table.add(flop_4);
                    break;
                case 2:
                    System.out.println("River");
                    Card flop_5 = cardDealer.placeCardsOnTable();

                    table.add(flop_5);
                    break;
                case 3:
                    System.out.println("Final bets");
                    break;
            }

            //prints the players cards after flop turn river
            for (int k = 0; k < playerArray.size(); k++) {
                System.out.println(playerArray.get(k).getName());
                System.out.println(
                        cardDealer.getPlayers().get(k).card1.getRank() + "  " + cardDealer.getPlayers().get(
                                k).card1.getSuit());
                System.out.println(
                        cardDealer.getPlayers().get(k).card2.getRank() + "  " + cardDealer.getPlayers().get(
                                k).card2.getSuit());
                System.out.println("");
            }

            //prints the cards that are on the table
            for (int m = 0; m < cardDealer.getCardsOnTable().size(); m++) {
                System.out.println("\n"
                                   + cardDealer.getCardsOnTable().get(m).getRank() + "  " + cardDealer.getCardsOnTable().get(
                                m).getSuit());
            }

            //sets the minimum bet back to 0 after each river flop turn
            game.setBet(0);
        }

        //tells the winner
        CheckHands check = new CheckHands();

        check.checkHands(playerArray, table);

        System.out.println(
                "-----------");
        ArrayList<Player> toPrint = check.checkWinner(playerArray, table);
        for (int i = 0;
             i < toPrint.size();
             i++) {
            System.out.println(
                    toPrint.get(i).getName());
        }
    }
}
