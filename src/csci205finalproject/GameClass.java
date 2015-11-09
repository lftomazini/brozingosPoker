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
    private ArrayList<Double> playerList;
    private int numOfRounds;

    public void nextRound() {
        numOfRounds++;
    }

    public int getNumOfRounds() {
        return numOfRounds;
    }

    public ArrayList<Double> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Double> playerList) {
        this.playerList = playerList;
    }

}
