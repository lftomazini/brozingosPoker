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
import TableElements.CardDealer;
import TableElements.GameClass;
import TableElements.Player;
import java.util.ArrayList;

/**
 *
 * @author sag033
 */
public class Model {
    Deck deck = new Deck();
    int numPlayers;
    ArrayList<Player> players;
    int[] chips1;
    GameClass theGameClass;
    CardDealer theCardDealer;
    int round = 0;

    public Model() {
        this.deck.createDeck();

    }

    public Deck getDeck() {
        return deck;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public int[] getChips1() {
        return chips1;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setChips1(int[] chips1) {
        this.chips1 = chips1;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setTheGameClass(GameClass theGameClass) {
        this.theGameClass = theGameClass;
    }

    public void setTheCardDealer(CardDealer theCardDealer) {
        this.theCardDealer = theCardDealer;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public GameClass getTheGameClass() {
        return theGameClass;
    }

    public CardDealer getTheCardDealer() {
        return theCardDealer;
    }

    public int getRound() {
        return round;
    }

}
