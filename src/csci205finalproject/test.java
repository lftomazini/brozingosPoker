/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205finalproject;

import Cards.Card;
import Cards.Deck;
import Cards.Rank;
import Cards.Suits;
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
        Card card1 = new Card(Rank.ACE, Suits.HEARTS);
        Card card2 = new Card(Rank.ACE, Suits.HEARTS);
        Card card3 = new Card(Rank.K, Suits.HEARTS);
        Card card4 = new Card(Rank.K, Suits.HEARTS);
        Card card5 = new Card(Rank.K, Suits.HEARTS);
        Card card6 = new Card(Rank.K, Suits.DIAMONDS);
        Card card7 = new Card(Rank.K, Suits.CLUBS);
        Player player = new Player();
        player.setCard1(card1);
        Player[] playerArray = new Player[1];
        player.setCard1(card1);
        player.setCard2(card2);
        playerArray[0] = player;
        CardDealer cardDealer = new CardDealer(cards, playerArray, 0);
        ArrayList<Card> table = new ArrayList<>();
        table.add(card3);
        table.add(card4);
        table.add(card5);
        table.add(card6);
        table.add(card7);

        for (int i = 0; i < table.size(); i++) {
            System.out.println(
                    table.get(i).getRank() + "  " + table.get(
                            i).getSuit());
        }
        System.out.println(
                cardDealer.getPlayers()[0].card1.getRank() + "  " + cardDealer.getPlayers()[0].card1.getSuit());
        System.out.println(
                cardDealer.getPlayers()[0].card2.getRank() + "  " + cardDealer.getPlayers()[0].card2.getSuit());

        ArrayList<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.add(player);
        GameClass game = new GameClass(listOfPlayers);
        System.out.println(game.isFlush(player, table));
    }
}