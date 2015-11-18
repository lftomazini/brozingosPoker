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

/**
 *
 * @author lffct001
 */
public class Player {
    private boolean bigBlind;
    private boolean smallBlind;
    private boolean hasFolded;
    Card card1;
    Card card2;
    private int[] chips = new int[Chips.values().length];
    ArrayList<Card> finalHand = new ArrayList<>();

//    public Player() {
//        this.bigBlind = false;
//        this.smallBlind = false;
//        this.card1 = null;
//        this.card2 = null;
//        this.hasFolded = false;
//    }

    public Player(int[] chips1, Card card1, Card card2) {
        this.bigBlind = false;
        this.smallBlind = false;
        this.card1 = card1;
        this.card2 = card2;
        this.chips = chips;
        this.hasFolded = false;
    }

    public void removeBlackChip(int numHundred) {
        if (this.chips[4] >= numHundred) {
            this.chips[4] -= numHundred;
        } else {
            if (this.chips[3] > numHundred*(int)(Chips.BLACK.getValue()/Chips.GREEN.getValue())) {
                this.chips[3] -= numHundred*(int)(Chips.BLACK.getValue()/Chips.GREEN.getValue());
            } else {
                if (this.chips[2] > numHundred*(int)(Chips.BLACK.getValue()/Chips.BLUE.getValue())) {
                    this.chips[2] -= numHundred*(int)(Chips.BLACK.getValue()/Chips.BLUE.getValue());
                } else {
                    if (this.chips[1] > numHundred*(int)(Chips.BLACK.getValue()/Chips.RED.getValue())) {
                        this.chips[1] -= numHundred*(int)(Chips.BLACK.getValue()/Chips.RED.getValue());
                    } else {
                        this.chips[0] -= numHundred*(int)(Chips.BLACK.getValue()/Chips.WHITE.getValue());
                    } 
                }

            } 
        }
    }
    
    public void removeGreenChip(int TwentyFive) {
        if (this.chips[3] >= TwentyFive) {
            this.chips[3] -= TwentyFive;
        } else {
            if (this.chips[2] > TwentyFive*(int)(Chips.GREEN.getValue()/Chips.BLUE.getValue())) {
                this.chips[2] -= TwentyFive*(int)(Chips.GREEN.getValue()/Chips.BLUE.getValue());
            } else {
                if (this.chips[1] > TwentyFive*(int)(Chips.GREEN.getValue()/Chips.RED.getValue())) {
                    this.chips[1] -= TwentyFive*(int)(Chips.GREEN.getValue()/Chips.RED.getValue());
                } else {
                        this.chips[0] -= TwentyFive*(int)(Chips.GREEN.getValue()/Chips.WHITE.getValue());
                    } 
                }

        } 
    }
    
    public void removeBlueChip(int Ten) {
        if (this.chips[2] >= Ten) {
            this.chips[2] -= Ten;
        } else {
            if (this.chips[1] > Ten*(int)(Chips.BLUE.getValue()/Chips.RED.getValue())) {
                this.chips[1] -= Ten*(int)(Chips.BLUE.getValue()/Chips.RED.getValue());
            } else {
                    this.chips[0] -= Ten*(int)(Chips.BLUE.getValue()/Chips.WHITE.getValue());
                } 
            }
    }
    
    public void removeRedChip(int Five) {
        if (this.chips[1] >= Five) {
            this.chips[1] -= Five;
        } else {
            this.chips[0] -= Five*(int)(Chips.RED.getValue()/Chips.WHITE.getValue());
        } 
    }
    
    public void removeWhiteChip(int One) {
        this.chips[0] -= One;
    }
    
    public int getTotalChipsValue() {
        int value = 0;
        value += this.chips[0]*Chips.WHITE.getValue();
        value += this.chips[1]*Chips.RED.getValue();
        value += this.chips[2]*Chips.BLUE.getValue();
        value += this.chips[3]*Chips.GREEN.getValue();
        value += this.chips[4]*Chips.BLACK.getValue();
        return value;
    }
    
    public int makeBet(int bet) {
        int betMade = bet;

        if (bet > this.getTotalChipsValue()) {
            return -1;
        } else {
            int numHundred = bet%(int)(Chips.BLACK.getValue());
            bet = bet - (int)(Chips.BLACK.getValue()*numHundred);
            
            int numTwentyFive = bet%(int)(Chips.GREEN.getValue());
            bet = bet - (int)(Chips.GREEN.getValue()*numTwentyFive);

            int numTen = bet%(int)(Chips.BLUE.getValue());
            bet = bet - (int)(Chips.BLUE.getValue()*numTen);

            int numFive = bet%(int)(Chips.RED.getValue());
            bet = bet - (int)(Chips.RED.getValue()*numFive);

            int numOne = bet%(int)(Chips.WHITE.getValue());
            bet = bet - (int)(Chips.WHITE.getValue()*numOne);
            
            if (numHundred != 0) {
                this.removeBlackChip(numHundred);
            } 
            if (numTwentyFive != 0) {
                this.removeGreenChip(numTwentyFive);
            }        
            if (numTen != 0) {
                this.removeBlueChip(numTen);
            }
            if (numFive != 0) {
                this.removeRedChip(numFive);
            }
            if (numOne != 0) {
                this.removeWhiteChip(numOne);
            }       
        }
        return betMade;
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

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public void setChips(int[] chips) {
        this.chips = chips;
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
}
