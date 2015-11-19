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
package Model;

import Cards.Deck;
import csci205finalproject.Chips;
import csci205finalproject.Player;
import java.util.ArrayList;

/**
 *
 * @author sag033
 */
public class Model {
    Deck deck = new Deck();
    int numPlayers;
    Chips[] chips1;
    ArrayList<Player> players;

    public Model() {
        this.deck.createDeck();

    }

    public Deck getDeck() {
        return deck;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public Chips[] getChips1() {
        return chips1;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setChips1(Chips[] chips1) {
        this.chips1 = chips1;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

}
