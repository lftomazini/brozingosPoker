/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableElements;

import Cards.Card;
import Cards.Deck;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author as062
 */
public class CardDealer {

    private Deck deck;
    private ArrayList<Player> players;
    private int rounds;
    private ArrayList<Card> cardsChosen = new ArrayList<>();
    private ArrayList<Card> cardsOnTable = new ArrayList<>();

    /**
     * Constructors a cardDealer object
     *
     * @param deck: Deck of cards
     * @param players: Array of players
     */
    public CardDealer(Deck deck, ArrayList<Player> players) {
        this.players = players;
        this.rounds = 0;
        this.deck = deck;
        this.cardsChosen = new ArrayList<>();
        this.cardsOnTable = new ArrayList<>();
    }

    /**
     * Setter method to set the cards on Table
     *
     * @param cardsOnTable: Array of cards
     */
    public void setCardsOnTable(ArrayList<Card> cardsOnTable) {
        this.cardsOnTable = cardsOnTable;
    }

    /**
     * Returns the array of Players in the game
     *
     * @return: array of players
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * Returns the number of rounds player
     *
     * @return: number of rounds
     */
    public int getRounds() {
        return this.rounds;
    }

    /**
     * Returns the deck of cards
     *
     * @return: Deck
     */
    public Deck getDeck() {
        return this.deck;
    }

    /**
     * Returns the cards already used from the deck
     *
     * @return: Array of Cards
     */
    public ArrayList<Card> getCardsChosen() {
        return this.cardsChosen;
    }

    /**
     * Returns the Cards on the Table
     *
     * @return: Array of cards
     */
    public ArrayList<Card> getCardsOnTable() {
        return this.cardsOnTable;
    }

    /**
     * Returns a random integer that hasn't been used before
     *
     * @return: random integer
     */
    public int getRandom() {
        Random rand_int = new Random();
        boolean isRandom = false;
        int rand = 0;
        while (isRandom == false) {
            rand = rand_int.nextInt(52);
            if (this.cardsChosen.contains(deck.getDeck().get(rand))) {
                isRandom = false;
            } else {
                isRandom = true;
            }
        }
        this.cardsChosen.add(deck.getDeck().get(rand));
        return rand;
    }

    /**
     * Gives two cards 2 each player in the array of players
     */
    public void giveCardstoPlayers() {
        int rand_1;
        int rand_2;
        for (int i = 0; i < this.players.size(); i++) {
            rand_1 = this.getRandom();
//            this.cardsChosen.add(deck.getDeck().get(rand_1));
            rand_2 = this.getRandom();
//            this.cardsChosen.add(deck.getDeck().get(rand_2));
            this.players.get(i).setCard1(deck.getDeck().get(rand_1));
            this.players.get(i).setCard2(deck.getDeck().get(rand_2));
        }
    }

    /**
     * Gives a random card On the table
     *
     * @return: Card from the deck
     */
    public Card placeCardsOnTable() {
        int rand = this.getRandom();
        this.cardsOnTable.add(deck.getDeck().get(rand));
        //      this.cardsChosen.add(deck.getDeck().get(rand));
        return deck.getDeck().get(rand);
    }

    /**
     * Calls for a new round by clearing out the cards and setting all players'
     * cards to null
     */
    public void newRound() {
        this.cardsOnTable.clear();
        this.cardsChosen.clear();
        this.rounds += 1;
        for (int i = 0; i < this.players.size(); i++) {
            this.players.get(i).setCard1(null);
            this.players.get(i).setCard2(null);
        }
    }

}
