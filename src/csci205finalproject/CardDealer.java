/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205finalproject;

import java.util.ArrayList;
import java.util.Random;
import package Cards;
/**
 *
 * @author as062
 */
public class CardDealer {
    
    private Cards[] deck;
    private Player[] players;
    private int rounds;
    private ArrayList<Integer> cards_chosen = new ArrayList<>(); 
    private ArrayList<Cards> cardsOnTable = new ArrayList<>();
    
    public CardDealer(Cards[] deck, Player[] players, int round) {
            this.players = players;
            this.rounds = round;
    }
    
    public Cards[] getDeckofCards(){
        Cards[] deck = new Cards[52];
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 12; i++) {
                if (j == 0) {
                    deck += Cards(i, Suits.SPADE);
                } else if (j == 1) {
                    deck += Cards(i, Suits.DIAMOND);
                } else if (j == 2) {
                    deck += Cards(i, Suits.HEART);
                } else {
                    deck += Cards(i, Suits.CLUB);
                }
            }
        }
        return deck;
    }
    
    public Player[] getPlayers(){
        return this.players;
    }
    
    public int getRounds(){
        return this.rounds;
    }
    
    public void completeRound() {
        this.rounds += 1;
    }
    
    public int getRandom(){
        Random rand_int = new Random();
        int rand;
        do{
            rand = rand_int.nextInt(52);
        } while (cards_chosen.contains(rand));
        cards_chosen.add(rand); 
        return rand;
    }
    
    public void giveCardstoPlayers() {
        Random rand_int = new Random();
        int rand_1;
        int rand_2;
        for (int i =0; i < this.players.length; i++) {
            rand_1 = rand_int.nextInt(52);
            rand_2 = rand_int.nextInt(52);
            this.players[i].setCard1(this.deck[this.getRandom()]);
            this.players[i].setCard2(this.deck[this.getRandom()]);
        }
    }
    
    public Cards placeCardsOnTable() {
        int rand  = this.getRandom();
        cardsOnTable.add(rand);
        return this.deck[rand];
    }
    
    
}
    
