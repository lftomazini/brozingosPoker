/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205finalproject;

import Cards.Card;
import Cards.Deck;
import java.util.ArrayList;

/**
 *
 * @author lbv001
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Deck deck = new Deck();
        deck.createDeck();
//        deck.printDeck();
//        System.out.println(deck.getDeck().size());

        Card[] cards = new Card[52];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(deck.getDeck().get(i).getRank(),
                                deck.getDeck().get(i).getSuit());
        }
//        for (int i = 0; i < cards.length; i++) {
//            System.out.println(cards[i]);
//        }
        Player player = new Player();
        Player[] playerArray = new Player[1];
        playerArray[0] = player;
        CardDealer cardDealer = new CardDealer(cards, playerArray, 0);
        cardDealer.giveCardstoPlayers();
        cardDealer.placeCardsOnTable();
        cardDealer.placeCardsOnTable();
        cardDealer.placeCardsOnTable();
        cardDealer.placeCardsOnTable();
        cardDealer.placeCardsOnTable();
        for (int i = 0; i < cardDealer.getCardsOnTable().size(); i++) {
            System.out.println(
                    cardDealer.getCardsOnTable().get(1).getRank() + "  " + cardDealer.getCardsOnTable().get(
                            i).getSuit());
        }
        System.out.println(
                cardDealer.getPlayers()[0].card1.getRank() + "  " + cardDealer.getPlayers()[0].card1.getSuit());
        System.out.println(
                cardDealer.getPlayers()[0].card1.getRank() + "  " + cardDealer.getPlayers()[0].card2.getSuit());

        ArrayList<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(player);
        GameClass game = new GameClass(listOfPlayers);
        System.out.println(game.isFlush(player, cardDealer));
    }
}
