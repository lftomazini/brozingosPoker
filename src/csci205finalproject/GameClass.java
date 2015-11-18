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
 * File: GameClass
 * Description:
 *
 * ****************************************
 */
package csci205finalproject;

import java.util.ArrayList;

/**
 *
 * @author lbv001
 */
public class GameClass {
    private ArrayList<Player> playerList;
    private int numOfRounds;
    private double bet;
    private double smallBlind;
    private double bigBlind;

    public GameClass(ArrayList<Player> playerList, double smallBlind,
                     double bigBlind) {
        this.playerList = playerList;
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        this.bet = bigBlind;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void setSmallBlind(double smallBlind) {
        this.smallBlind = smallBlind;
    }

    public void setBigBlind(double bigBlind) {
        this.bigBlind = bigBlind;
    }

    public double getBet() {
        return bet;
    }

    public double getSmallBlind() {
        return smallBlind;
    }

    public double getBigBlind() {
        return bigBlind;
    }

    public void nextRound() {
        numOfRounds++;
    }

    public int getNumOfRounds() {
        return numOfRounds;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
}
