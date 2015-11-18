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
    private ArrayList<Player> players;
    private int rounds;
    private ArrayList<Card> cardsChosen = new ArrayList<>();
    private ArrayList<Card> cardsOnTable = new ArrayList<>();

    public CardDealer(Card[] deck, ArrayList<Player> players, int round) {
        this.players = players;
        this.rounds = round;
        this.deck = deck;
    }

    public void setCardsOnTable(ArrayList<Card> cardsOnTable) {
        this.cardsOnTable = cardsOnTable;
    }

    public ArrayList<Player> getPlayers() {
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
        boolean isRandom = false;
        int rand = 0;
        while (isRandom == false) {
            rand = rand_int.nextInt(52);
            if (cardsChosen.contains(rand)) {
                isRandom = false;
            } else {
                isRandom = true;
            }
        }
        return rand;
    }

    public void giveCardstoPlayers() {
        int rand_1;
        int rand_2;
        for (int i = 0; i < this.players.size(); i++) {
            rand_1 = this.getRandom();
            cardsChosen.add(deck[rand_1]);
            rand_2 = this.getRandom();
            cardsChosen.add(deck[rand_2]);
            this.players.get(i).setCard1(this.deck[rand_1]);
            this.players.get(i).setCard2(this.deck[rand_2]);
        }
    }

    public Card placeCardsOnTable() {
        int rand = this.getRandom();
        cardsOnTable.add(deck[rand]);
        cardsChosen.add(deck[rand]);
        return this.deck[rand];
    }

}
