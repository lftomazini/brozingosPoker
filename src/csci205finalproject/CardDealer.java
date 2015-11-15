/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205finalproject;

import Cards.Card;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author as062
 */
public class CardDealer {

    private Card[] deck;
    private Player[] players;
    private int rounds;
    private ArrayList<Card> cardsChosen = new ArrayList<>();
    private ArrayList<Card> cardsOnTable = new ArrayList<>();

    public CardDealer(Card[] deck, Player[] players, int round) {
        this.players = players;
        this.rounds = round;
        this.deck = deck;
    }

    public void setCardsOnTable(ArrayList<Card> cardsOnTable) {
        this.cardsOnTable = cardsOnTable;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public int getRounds() {
        return this.rounds;
    }

    public Card[] getDeck() {
        return deck;
    }

    public ArrayList<Card> getCardsChosen() {
        return cardsChosen;
    }

    public ArrayList<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    public void completeRound() {
        this.rounds += 1;
    }

    public int getRandom() {
        Random rand_int = new Random();
        int rand;
        do {
            rand = rand_int.nextInt(52);
        } while (cardsChosen.contains(rand));
        cardsChosen.add(deck[rand]);
        return rand;
    }

    public void giveCardstoPlayers() {
        Random rand_int = new Random();
        int rand_1;
        int rand_2;
        for (int i = 0; i < this.players.length; i++) {
            rand_1 = rand_int.nextInt(52);
            rand_2 = rand_int.nextInt(52);
            this.players[i].setCard1(this.deck[this.getRandom()]);
            this.players[i].setCard2(this.deck[this.getRandom()]);
        }
    }

    public Card placeCardsOnTable() {
        int rand = this.getRandom();
        cardsOnTable.add(deck[rand]);
        return this.deck[rand];
    }

}