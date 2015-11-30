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
package Controller;

import Cards.Deck;
import csci205finalproject.CardDealer;
import csci205finalproject.Player;
import java.util.ArrayList;

/**
 *
 * @author lbv001
 */
public class test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.createDeck();
        int[] chips1 = {10, 6, 3, 4, 4};
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < 4; i++) {
            players.add(new Player(chips1));
        }
        CardDealer dealer = new CardDealer(deck, players, 0);
        dealer.giveCardstoPlayers();
        for (int i = 0; i < 52; i++) {
            System.out.println(dealer.placeCardsOnTable().getName());
        }
    }

}
