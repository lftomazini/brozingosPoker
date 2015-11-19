/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import java.util.Comparator;

/**
 *
 * @author lbv001
 */
public class Card {
    private Rank rank;
    private Suits suit;

    public Card(Rank rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }

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

    public String getName() {
        return Integer.toString(this.rank.getValue()) + this.suit.toString();
    }

    public static Comparator<Card> byRank = (Card o1, Card o2) -> {
        if (o1.getRank().getValue() < o2.getRank().getValue()) {
            return -1;
        } else {
            if (o1.getRank().getValue() == o2.getRank().getValue()) {
                return 0;
            } else {
                return 1;
            }
        }
    };
}
