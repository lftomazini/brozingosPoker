/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205finalproject;

import Cards.Card;
import Cards.Deck;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author lbv001
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, LineUnavailableException, IOException {
        Deck deck = new Deck();
        deck.createDeck();
        int[] chips = new int[5];
//        for (int i = 0; i < cards.length; i++) {
//            System.out.println(cards[i]);
//        }
//        Card card1 = new Card(Rank.K, Suits.HEARTS);
//        Card card2 = new Card(Rank.Q, Suits.HEARTS);
//        Card card3 = new Card(Rank.K, Suits.HEARTS);
//        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
//        Card card5 = new Card(Rank.ACE, Suits.HEARTS);
//        Card card6 = new Card(Rank.TWO, Suits.DIAMONDS);
//        Card card7 = new Card(Rank.J, Suits.CLUBS);
        ArrayList<Player> playerArray = new ArrayList<>();
        Player player_1 = new Player(chips);
        Player player_2 = new Player(chips);
        Player player_3 = new Player(chips);
        Player player_4 = new Player(chips);
        Player player_5 = new Player(chips);

        playerArray.add(player_1);
        playerArray.add(player_2);
        playerArray.add(player_3);
        playerArray.add(player_4);
        playerArray.add(player_5);

        CardDealer cardDealer = new CardDealer(deck, playerArray);
        cardDealer.giveCardstoPlayers();
        ArrayList<Card> table = new ArrayList<>();
        Card flop_1 = cardDealer.placeCardsOnTable();
        Card flop_2 = cardDealer.placeCardsOnTable();
        Card flop_3 = cardDealer.placeCardsOnTable();
        Card flop_4 = cardDealer.placeCardsOnTable();
        Card flop_5 = cardDealer.placeCardsOnTable();

        table.add(flop_1);
        table.add(flop_2);
        table.add(flop_3);
        table.add(flop_4);
        table.add(flop_5);

        GameClass game = new GameClass(playerArray, 25, 50);

//        game.getPlayerList().get(0).paySmallBlind();
//        game.getPlayerList().get(1).payBligBlind();
//        game.getPlayerList().get(2).fold();
//        game.getPlayerList().get(3).call();
//        game.getPlayerList().get(4).call();
//        game.getPlayerList().get(0).paySmallBlind();
        for (int i = 0; i < cardDealer.getPlayers().size(); i++) {
            System.out.println("\n\nPlayer " + (1 + i));
            System.out.println(
                    cardDealer.getPlayers().get(i).card1.getRank() + "  " + cardDealer.getPlayers().get(
                            i).card1.getSuit());
            System.out.println(
                    cardDealer.getPlayers().get(i).card2.getRank() + "  " + cardDealer.getPlayers().get(
                            i).card2.getSuit());
        }

        for (int i = 0; i < cardDealer.getCardsOnTable().size(); i++) {
            System.out.println("\n"
                               + cardDealer.getCardsOnTable().get(i).getRank() + "  " + cardDealer.getCardsOnTable().get(
                            i).getSuit());
        }
        CheckHands check = new CheckHands();
        check.checkHands(playerArray, table);
        System.out.println("\n");
        for (int i = 0; i < playerArray.size(); i++) {
            System.out.println(playerArray.get(i).getHand());
        }

        System.out.println("-----------");
        ArrayList<Player> toPrint = check.checkWinner(playerArray, table);
        for (int i = 0; i < toPrint.size(); i++) {
            System.out.println(
                    toPrint.get(i).card1.getName());
        }
    }
}
