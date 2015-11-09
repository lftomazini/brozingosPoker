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
public enum Suits {
    DIAMONDS(1), SPADES(2), HEARTS(3), CLUBS(4);
    private int suit;

    private Suits(int suit) {
        this.suit = suit;
    }

}
