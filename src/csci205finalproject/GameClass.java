/* *****************************************
 * CSCI205 - Software Engineering and Design
 *
 * Fall 2015
 *
 * Name: Anmol Singh, Leonardo Viglino Luis Felipe Tomazini,
 Stephanie Garboski
 * Date: Nov 9, 2015
 * Time: 10:05:49 AM
 *
 * Project: csci205FinalProject
 * Package: csci205finalproject
 * File: GameClass
 * Description:
 *
 * ****************************************
 */
package csci205finalproject;

import Cards.Card;
import Cards.Suits;
import java.util.ArrayList;

/**
 *
 * @author lbv001
 */
public class GameClass {
    private ArrayList<Player> playerList;
    private int numOfRounds;

    public GameClass(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void nextRound() {
        numOfRounds++;
    }

    public int getNumOfRounds() {
        return numOfRounds;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    /**
     * @see
     * http://codereview.stackexchange.com/questions/91086/texas-hold-em-poker-hand-recognition-algorithm-and-implementation
     * @param player
     * @param cards
     * @return
     */
    public boolean checkHands(Player player, CardDealer cards) {
        //Royal flush
        return (isFlush(player, cards) && isStraight(player, cards));
        //TODO check if higher is ACE
    }

    boolean isFlush(Player player, CardDealer cards) {
        int nOfClubs = 0;
        int nOfSpades = 0;
        int nOfHearts = 0;
        int nOfDiamonds = 0;
        ArrayList<Card> cardsPossible = new ArrayList<>();
        cardsPossible.add(player.getCard1());
        cardsPossible.add(player.getCard2());
        for (int i = 0; i < cards.getCardsOnTable().size(); i++) {
            cardsPossible.add(cards.getCardsOnTable().get(i));
        }
        Suits suit;
        System.out.println(cardsPossible.size());
        for (int i = 0; i < cardsPossible.size(); i++) {
            suit = cardsPossible.get(i).getSuit();
            switch (suit) {
                case DIAMONDS:
                    nOfDiamonds++;
                    break;
                case SPADES:
                    nOfSpades++;
                    break;
                case HEARTS:
                    nOfHearts++;
                    break;
                case CLUBS:
                    nOfClubs++;
                    break;
            }
        }
        return (nOfClubs >= 5 || nOfSpades >= 5 || nOfHearts >= 5 || nOfDiamonds >= 5);
    }

    private boolean isStraight(Player player, CardDealer cards) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean isOfAKind(Player player, CardDealer cards, int quantity) {
        int repeated = 1;
        ArrayList<Card> cardsPossible = new ArrayList<>();
        cardsPossible.add(player.getCard1());
        cardsPossible.add(player.getCard2());
        for (int i = 0; i < cards.getCardsOnTable().size(); i++) {
            cardsPossible.add(cards.getCardsOnTable().get(i));
        }

        for (int i = 0; i < cardsPossible.size(); i++) {
            repeated = 1;
            for (int j = 1; j < cardsPossible.size(); j++) {
                if (cardsPossible.get(i).getRank() == cardsPossible.get(j).getRank() && cardsPossible.get(
                        i).getSuit() != cardsPossible.get(j).getSuit()) {
                    repeated++;
                    if (repeated == quantity) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean is3OfAKind(Player player, CardDealer cards) {
        return isOfAKind(player, cards, 3);
    }

    boolean is2OfAKind(Player player, CardDealer cards) {
        return isOfAKind(player, cards, 2);
    }
}
