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

    /**
     * Constructor for the Card class
     *
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the rank of the card
     *
     * @return: rank
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Returns the suit of the card
     *
     * @return: suit
     */
    public Suits getSuit() {
        return this.suit;
    }

    /**
     * Sets the rank for the card
     *
     * @param rank
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * Sets the suit for the card
     *
     * @param suit
     */
    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    /**
     * Returns the string naming the rank and suit of the card
     *
     * @return: String
     */
    public String getName() {
        return Integer.toString(this.rank.getValue()) + " " + this.suit.toString();
    }

    /**
     * Tells if two cards are equal or not
     *
     * @param card1
     * @param card2
     * @return: true or false
     */
    public static boolean equals(Card card1, Card card2) {
        return card1.getName().equals(card2.getName());
    }

    /**
     * Compares two cards on the basis of their ranks
     */
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
