/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205finalproject.Cards;

/**
 *
 * @author lbv001
 */
public class Card {
    private Rank rank;
    private Suits suit;

    public Rank getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

}
