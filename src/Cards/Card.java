/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

/**
 *
 * @author lbv001
 */
public class Card implements Comparable<Card> {
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

    @Override
    public int compareTo(Card other) {
        if (this.getRank().getValue() < other.getRank().getValue()) {
            return -1;
        } else {
            if (this.getRank().getValue() == other.getRank().getValue()) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
