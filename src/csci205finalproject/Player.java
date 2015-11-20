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
 * File: Player
 * Description:
 *
 * ****************************************
 */
package csci205finalproject;

import Cards.Card;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author lffct001
 */
public class Player {
    private boolean bigBlind;
    private boolean smallBlind;
    private boolean hasFolded;
    private int money;
    private Hand hand;
    Card card1;
    Card card2;
    private int[] chips = new int[Chips.values().length];
    ArrayList<Card> finalHand = new ArrayList<>();

    public Player() {
        this.bigBlind = false;
        this.smallBlind = false;
        this.card1 = null;
        this.card2 = null;
        this.hasFolded = false;
    }

    public Player(int[] chips1) {
        this.bigBlind = false;
        this.smallBlind = false;
        this.card1 = null;
        this.card2 = null;
        this.chips = chips;
        this.hasFolded = false;
        this.hand = null;
        this.money = this.getTotalChipsValue();
    }

//    public void removeBlackChip(int numHundred) {
//        if (this.chips[4] >= numHundred) {
//            this.chips[4] -= numHundred;
//        } else {
//            if (this.chips[3] > numHundred*(int)(Chips.BLACK.getValue()/Chips.GREEN.getValue())) {
//                this.chips[3] -= numHundred*(int)(Chips.BLACK.getValue()/Chips.GREEN.getValue());
//            } else {
//                if (this.chips[2] > numHundred*(int)(Chips.BLACK.getValue()/Chips.BLUE.getValue())) {
//                    this.chips[2] -= numHundred*(int)(Chips.BLACK.getValue()/Chips.BLUE.getValue());
//                } else {
//                    if (this.chips[1] > numHundred*(int)(Chips.BLACK.getValue()/Chips.RED.getValue())) {
//                        this.chips[1] -= numHundred*(int)(Chips.BLACK.getValue()/Chips.RED.getValue());
//                    } else {
//                        this.chips[0] -= numHundred*(int)(Chips.BLACK.getValue()/Chips.WHITE.getValue());
//                    }
//                }
//
//            }
//        }
//    }
//
//    public void removeGreenChip(int TwentyFive) {
//        if (this.chips[3] >= TwentyFive) {
//            this.chips[3] -= TwentyFive;
//        } else {
//            if (this.chips[2] > TwentyFive*(int)(Chips.GREEN.getValue()/Chips.BLUE.getValue())) {
//                this.chips[2] -= TwentyFive*(int)(Chips.GREEN.getValue()/Chips.BLUE.getValue());
//            } else {
//                if (this.chips[1] > TwentyFive*(int)(Chips.GREEN.getValue()/Chips.RED.getValue())) {
//                    this.chips[1] -= TwentyFive*(int)(Chips.GREEN.getValue()/Chips.RED.getValue());
//                } else {
//                        this.chips[0] -= TwentyFive*(int)(Chips.GREEN.getValue()/Chips.WHITE.getValue());
//                    }
//                }
//
//        }
//    }
//
//    public void removeBlueChip(int Ten) {
//        if (this.chips[2] >= Ten) {
//            this.chips[2] -= Ten;
//        } else {
//            if (this.chips[1] > Ten*(int)(Chips.BLUE.getValue()/Chips.RED.getValue())) {
//                this.chips[1] -= Ten*(int)(Chips.BLUE.getValue()/Chips.RED.getValue());
//            } else {
//                    this.chips[0] -= Ten*(int)(Chips.BLUE.getValue()/Chips.WHITE.getValue());
//                }
//            }
//    }
//
//    public void removeRedChip(int Five) {
//        if (this.chips[1] >= Five) {
//            this.chips[1] -= Five;
//        } else {
//            this.chips[0] -= Five*(int)(Chips.RED.getValue()/Chips.WHITE.getValue());
//        }
//    }
//
//    public void removeWhiteChip(int One) {
//        this.chips[0] -= One;
//    }
    public int getTotalChipsValue() {
        int value = 0;
        value += this.chips[0] * Chips.WHITE.getValue();
        value += this.chips[1] * Chips.RED.getValue();
        value += this.chips[2] * Chips.BLUE.getValue();
        value += this.chips[3] * Chips.GREEN.getValue();
        value += this.chips[4] * Chips.BLACK.getValue();
        return value;
    }

    public void getChipsFromMoney() {
        int value = this.money;

        int numHundred = value % (int) (Chips.BLACK.getValue());
        value = value - (int) (Chips.BLACK.getValue() * numHundred);
        this.chips[4] = numHundred;

        int numTwentyFive = value % (int) (Chips.GREEN.getValue());
        value = value - (int) (Chips.GREEN.getValue() * numTwentyFive);
        this.chips[3] = numTwentyFive;

        int numTen = value % (int) (Chips.BLUE.getValue());
        value = value - (int) (Chips.BLUE.getValue() * numTen);
        this.chips[2] = numTen;

        int numFive = value % (int) (Chips.RED.getValue());
        value = value - (int) (Chips.RED.getValue() * numFive);
        this.chips[1] = numFive;

        int numOne = value % (int) (Chips.WHITE.getValue());
        value = value - (int) (Chips.WHITE.getValue() * numOne);
        this.chips[0] = numOne;
    }

    public int makeBet(int bet) {
        if (bet > this.money) {
            return -1;
        } else {
            this.money -= bet;
            this.getChipsFromMoney();
        }
        return bet;
    }

    public void check() {
    }

    public void call(int bet) {
        int money = this.makeBet(bet);
    }

    public void fold() {
        this.setCard1(null);
        this.setCard2(null);
    }

    public void setBigBlind(boolean bigBlind) {
        this.bigBlind = bigBlind;
    }

    public void setSmallBlind(boolean smallBlind) {
        this.smallBlind = smallBlind;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public void setChips(int[] chips) {
        this.chips = chips;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isBigBlind() {
        return bigBlind;
    }

    public boolean isSmallBlind() {
        return smallBlind;
    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public int[] getChips() {
        return this.chips;
    }

    public int getMoney() {
        return this.money;
    }

    public Hand getHand() {
        return this.hand;
    }

    public static Comparator<Player> byHand = (Player p1, Player p2) -> {
        Card highest_p1 = (p1.getCard1().getRank().getValue() > p1.getCard2().getRank().getValue()) ? p1.getCard1() : p1.getCard2();
        Card highest_p2 = (p2.getCard1().getRank().getValue() > p2.getCard2().getRank().getValue()) ? p2.getCard1() : p2.getCard2();

        if (highest_p1.getRank().getValue() < highest_p2.getRank().getValue()) {
            return -1;
        } else {
            if (highest_p1.getRank().getValue() == highest_p2.getRank().getValue()) {
                return 0;
            } else {
                return 1;
            }
        }
    };
}
