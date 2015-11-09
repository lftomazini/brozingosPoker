/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205finalproject.Cards;

import java.util.ArrayList;

/**
 *
 * @author lbv001
 */
public class Deck {
    private ArrayList<Card> deck;
    private Rank[] ranks;
    private Suits[] suits;

    public Deck() {
        deck = new ArrayList<Card>();

    }

    public void createDeck() {

    }

    public Card[] generateAces() {
        Card[] aces = new Card[4];
        for (int i = 0; i < 4; i++) {
            aces[i].setRank(Rank.ACE);
            aces[i].setSuit(Suits.values()[i]);
        }
        return aces;
    }

    public Card[] generateTwos() {
        Card[] twos = new Card[4];
        for (int i = 0; i < 4; i++) {
            twos[i].setRank(Rank.TWO);
            twos[i].setSuit(Suits.values()[i]);
        }
        return twos;
    }

    public Card[] generateThrees() {
        Card[] threes = new Card[4];
        for (int i = 0; i < 4; i++) {
            threes[i].setRank(Rank.THREE);
            threes[i].setSuit(Suits.values()[i]);
        }
        return threes;
    }

    public Card[] generateFours() {
        Card[] fours = new Card[4];
        for (int i = 0; i < 4; i++) {
            fours[i].setRank(Rank.FOUR);
            fours[i].setSuit(Suits.values()[i]);
        }
        return fours;
    }

    public Card[] generateFIVES() {
        Card[] fives = new Card[4];
        for (int i = 0; i < 4; i++) {
            fives[i].setRank(Rank.FIVE);
            fives[i].setSuit(Suits.values()[i]);
        }
        return fives;
    }

    public Card[] generateSIXES() {
        Card[] sixes = new Card[4];
        for (int i = 0; i < 4; i++) {
            sixes[i].setRank(Rank.SIX);
            sixes[i].setSuit(Suits.values()[i]);
        }
        return sixes;
    }

    public Card[] generateSevens() {
        Card[] sevens = new Card[4];
        for (int i = 0; i < 4; i++) {
            sevens[i].setRank(Rank.SEVEN);
            sevens[i].setSuit(Suits.values()[i]);
        }
        return sevens;
    }

    public Card[] generateEights() {
        Card[] eights = new Card[4];
        for (int i = 0; i < 4; i++) {
            eights[i].setRank(Rank.EIGHT);
            eights[i].setSuit(Suits.values()[i]);
        }
        return eights;
    }

    public Card[] generateNines() {
        Card[] nines = new Card[4];
        for (int i = 0; i < 4; i++) {
            nines[i].setRank(Rank.NINE);
            nines[i].setSuit(Suits.values()[i]);
        }
        return nines;
    }

    public Card[] generateTens() {
        Card[] tens = new Card[4];
        for (int i = 0; i < 4; i++) {
            tens[i].setRank(Rank.TEN);
            tens[i].setSuit(Suits.values()[i]);
        }
        return tens;
    }

    public Card[] generateJs() {
        Card[] js = new Card[4];
        for (int i = 0; i < 4; i++) {
            js[i].setRank(Rank.J);
            js[i].setSuit(Suits.values()[i]);
        }
        return js;

    }

    public Card[] generateQs() {
        Card[] qs = new Card[4];
        for (int i = 0; i < 4; i++) {
            qs[i].setRank(Rank.Q);
            qs[i].setSuit(Suits.values()[i]);
        }
        return qs;
    }

    public Card[] generateKs() {
        Card[] ks = new Card[4];
        for (int i = 0; i < 4; i++) {
            ks[i].setRank(Rank.K);
            ks[i].setSuit(Suits.values()[i]);
        }
        return ks;
    }
}
