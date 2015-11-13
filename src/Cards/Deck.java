/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import java.util.ArrayList;

/**
 *
 * @author lbv001
 */
public class Deck {
    private ArrayList<Card> deck;
    private Rank[] ranks;
    private Suits[] suits;
    private final int DECKSIZE = 52;

    public Deck() {
        deck = new ArrayList<Card>();

    }

    public void createDeck() {
        generateAces();
        generateTwos();
        generateThrees();
        generateFours();
        generateFives();
        generateSixes();
        generateSevens();
        generateEights();
        generateNines();
        generateTens();
        generateJs();
        generateQs();
        generateKs();

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void printDeck() {

        for (int i = 0; i < DECKSIZE; i++) {
            System.out.println(
                    deck.get(i).getRank().name() + "   " + deck.get(i).getSuit().name());
        }
    }

    public void generateAces() {
        Card[] aces = new Card[4];
        for (int i = 0; i < 4; i++) {
            aces[i] = new Card(Rank.ACE, Suits.values()[i]);
            deck.add(aces[i]);
        }

    }

    public void generateTwos() {
        Card[] twos = new Card[4];
        for (int i = 0; i < 4; i++) {
            twos[i] = new Card(Rank.TWO, Suits.values()[i]);
            deck.add(twos[i]);
        }
    }

    public void generateThrees() {
        Card[] threes = new Card[4];
        for (int i = 0; i < 4; i++) {
            threes[i] = new Card(Rank.THREE, Suits.values()[i]);
            deck.add(threes[i]);
        }

    }

    public void generateFours() {
        Card[] fours = new Card[4];
        for (int i = 0; i < 4; i++) {
            fours[i] = new Card(Rank.FOUR, Suits.values()[i]);
            deck.add(fours[i]);
        }

    }

    public void generateFives() {
        Card[] fives = new Card[4];
        for (int i = 0; i < 4; i++) {
            fives[i] = new Card(Rank.FIVE, Suits.values()[i]);
            deck.add(fives[i]);
        }

    }

    public void generateSixes() {
        Card[] sixes = new Card[4];
        for (int i = 0; i < 4; i++) {
            sixes[i] = new Card(Rank.SIX, Suits.values()[i]);
            deck.add(sixes[i]);
        }
    }

    public void generateSevens() {
        Card[] sevens = new Card[4];
        for (int i = 0; i < 4; i++) {
            sevens[i] = new Card(Rank.SEVEN, Suits.values()[i]);
            deck.add(sevens[i]);
        }
    }

    public void generateEights() {
        Card[] eights = new Card[4];
        for (int i = 0; i < 4; i++) {
            eights[i] = new Card(Rank.EIGHT, Suits.values()[i]);
            deck.add(eights[i]);
        }

    }

    public void generateNines() {
        Card[] nines = new Card[4];
        for (int i = 0; i < 4; i++) {
            nines[i] = new Card(Rank.NINE, Suits.values()[i]);
            deck.add(nines[i]);
        }

    }

    public void generateTens() {
        Card[] tens = new Card[4];
        for (int i = 0; i < 4; i++) {
            tens[i] = new Card(Rank.TEN, Suits.values()[i]);
            deck.add(tens[i]);
        }

    }

    public void generateJs() {
        Card[] js = new Card[4];
        for (int i = 0; i < 4; i++) {
            js[i] = new Card(Rank.J, Suits.values()[i]);
            deck.add(js[i]);
        }

    }

    public void generateQs() {
        Card[] qs = new Card[4];
        for (int i = 0; i < 4; i++) {
            qs[i] = new Card(Rank.Q, Suits.values()[i]);
            deck.add(qs[i]);
        }

    }

    public void generateKs() {
        Card[] ks = new Card[4];
        for (int i = 0; i < 4; i++) {
            ks[i] = new Card(Rank.K, Suits.values()[i]);
            deck.add(ks[i]);
        }

    }
}
