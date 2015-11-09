/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public GameClass(ArrayList<Double> playerList) {
        this.playerList = playerList;
    }

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
