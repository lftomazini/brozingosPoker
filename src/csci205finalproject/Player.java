/* *****************************************
 * CSCI205 - Software Engineering and Design
 *
 * Fall 2015
 *
 * Name: Anmol Singh, Leonardo Viglino Luis Felipe Tomazini,
 Stephanie Garboski
 * Date: Nov 9, 2015
 * Time: 10:05:49 AM
 *
 * Project: csci205FinalProject
 * Package: csci205finalproject
 * File: Player
 * Description:
 *
 * ****************************************
 */
package csci205finalproject;

import Cards.Card;

/**
 *
 * @author lffct001
 */
public class Player {
    private boolean bigBlind;
    private boolean smallBlind;
    private Card card1;
    private Card card2;
    private Chips[] chips = new Chips[5];

    public Player() {
        this.bigBlind = false;
        this.smallBlind = false;
        this.card1 = null;
        this.card2 = null;
    }

    public Player(int chips1, int chips2, int chips3, int chips4, int chips5) {
        this.bigBlind = false;
        this.smallBlind = false;
        this.card1 = null;
        this.card2 = null;
    }

    public void setBigBlind(boolean bigBlind) {
        this.bigBlind = bigBlind;
    }

    public void setSmallBlind(boolean smallBlind) {
        this.smallBlind = smallBlind;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public void setChips(Chips[] chips) {
        this.chips = chips;
    }

    public boolean isBigBlind() {
        return bigBlind;
    }

    public boolean isSmallBlind() {
        return smallBlind;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public Chips[] getChips() {
        return chips;
    }
}
