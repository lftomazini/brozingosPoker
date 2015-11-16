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
import Cards.Rank;
import Cards.Suits;
import java.util.ArrayList;
import java.util.Comparator;

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
    public boolean checkHands(Player player, ArrayList<Card> cards) {
        //Royal flush

        //TODO check if higher is ACE
        return false;
    }

    public boolean isFlush(Player player, ArrayList<Card> cards) {
        int nOfClubs = 0;
        int nOfSpades = 0;
        int nOfHearts = 0;
        int nOfDiamonds = 0;
        ArrayList<Card> cardsPossible = new ArrayList<>();
        cardsPossible.add(player.getCard1());
        cardsPossible.add(player.getCard2());
        for (int i = 0; i < cards.size(); i++) {
            cardsPossible.add(cards.get(i));
        }
        Suits suit;
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

    public boolean isOfAKind(Player player, ArrayList<Card> cards, int quantity) {
        int repeated = 1;
        ArrayList<Card> cardsPossible = new ArrayList<>();
        cardsPossible.add(player.getCard1());
        cardsPossible.add(player.getCard2());
        for (int i = 0; i < cards.size(); i++) {
            cardsPossible.add(cards.get(i));
        }

        for (int i = 0; i < cardsPossible.size(); i++) {
            repeated = 1;
            for (int j = i + 1; j < cardsPossible.size(); j++) {
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

    public boolean isStraight(Player player, ArrayList<Card> cards) {
        int cardsInARow = 0;
        int position = 0;
        ArrayList<Card> hand = new ArrayList<>();
        ArrayList<Card> cardsPossible = new ArrayList<>();
        cardsPossible.add(player.getCard1());
        cardsPossible.add(player.getCard2());
        for (int i = 0; i < cards.size(); i++) {
            cardsPossible.add(cards.get(i));
        }
//        Arrays.sort(cardsPossible, byRank);
        for (int i = 0; i < cardsPossible.size() - 1; i++) {
            if (cardsPossible.get(position + 1).getRank().getValue() - cardsPossible.get(
                    position).getRank().getValue() == 1) {
                cardsInARow++;
                hand.add(cardsPossible.get(position));
                hand.add(cardsPossible.get(position + 1));
                if (cardsInARow >= 4) {
                    player.finalHand = hand;
                    return true;
                } else {
                    position++;
                }
            } else {
                cardsInARow = 0;
                position++;
            }
        }
        return false;
    }

    public boolean isFullHouse(Player player, ArrayList<Card> cards) {
        int repeated = 1;
        boolean is3OfAKind = false;
        boolean is2OfAKind = false;
        ArrayList<Card> cardsPossible = new ArrayList<>();
        cardsPossible.add(player.getCard1());
        cardsPossible.add(player.getCard2());
        //        Arrays.sort(cardsPossible, byRank);

        for (int i = 0; i < cardsPossible.size() - 1; i++) {
            if (cardsPossible.get(i).getRank().getValue() == cardsPossible.get(
                    i + 1).getRank().getValue()) {
                repeated++;
                if (repeated == 3) {
                    is3OfAKind = true;
                    repeated = 1;
                } else if (repeated == 2) {
                    is2OfAKind = true;
                    repeated = 1;
                }
            } else {
                repeated = 1;
            }
        }
        return (is2OfAKind && is3OfAKind);
    }

    public boolean is2Pairs(Player player, ArrayList<Card> cards) {
        int repeated = 1;
        int noOfPairs = 0;
        ArrayList<Card> cardsPossible = new ArrayList<>();
        cardsPossible.add(player.getCard1());
        cardsPossible.add(player.getCard2());
        for (int i = 0; i < cards.size(); i++) {
            cardsPossible.add(cards.get(i));
        }

        for (int i = 0; i < cardsPossible.size(); i++) {
            repeated = 1;
            for (int j = i + 1; j < cardsPossible.size(); j++) {
                if (cardsPossible.get(i).getRank() == cardsPossible.get(j).getRank() && cardsPossible.get(
                        i).getSuit() != cardsPossible.get(j).getSuit()) {
                    repeated++;
                    if (repeated == 2) {
                        noOfPairs++;
                        if (noOfPairs >= 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean is4OfAKind(Player player, ArrayList<Card> cards) {
        return isOfAKind(player, cards, 4);
    }

    public boolean is3OfAKind(Player player, ArrayList<Card> cards) {
        return isOfAKind(player, cards, 3);
    }

    public boolean is2OfAKind(Player player, ArrayList<Card> cards) {
        return isOfAKind(player, cards, 2);
    }

    public boolean isStraightFlush(Player player, ArrayList<Card> cards) {
        return (isFlush(player, cards) && isStraight(player, cards));
    }

    public boolean isRoyalFlush(Player player, ArrayList<Card> cards) {
        return (isStraightFlush(player, cards) && getHighCard(player).getRank() == Rank.ACE);
    }

    public Card getHighCard(Player player) {
        ArrayList<Card> cardsPossible = new ArrayList<>();
        cardsPossible = player.finalHand;
//        Arrays.sort(cardsPossible, byRank);
        return cardsPossible.get(0);
    }
    public Comparator<Card> byRank = (Card left, Card right) -> {
        if (left.getRank().getValue() < right.getRank().getValue()) {
            return -1;
        } else {
            if (left.getRank().getValue() == right.getRank().getValue()) {
                return 0;
            } else {
                return 1;
            }
        }
    };
}
