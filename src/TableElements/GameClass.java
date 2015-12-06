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
package TableElements;

import java.util.ArrayList;

/**
 *
 * @author lbv001
 */
public class GameClass {
    private ArrayList<Player> playerList;
    private int numOfRounds;
    private int bet;
    private int smallBlind;
    private int bigBlind;

    public GameClass(ArrayList<Player> playerList, int smallBlind,
                     int bigBlind) {
        this.playerList = playerList;
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        this.bet = bigBlind;
        playerList.get(0).setSmallBlind(true);
        playerList.get(1).setBigBlind(true);
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setSmallBlind(int smallBlind) {
        this.smallBlind = smallBlind;
    }

    public void setBigBlind(int bigBlind) {
        this.bigBlind = bigBlind;
    }

    public int getBet() {
        return bet;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public int getBigBlind() {
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
