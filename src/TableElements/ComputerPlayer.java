/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 * Instructor: Prof Peck
 * Section: 8am
 *
 * Name: Stephanie Garboski, Leonardo Viglino, Anmol Singh,
 Luis Felipe Tomazini
 * Date:
 *
 * Brozingos Poker:
 *
 * Description:
 *
 * *****************************************/
package TableElements;

import Cards.Rank;

/**
 *
 * @author as062
 */
public class ComputerPlayer extends Player {

    /**
     * Constructor for ComputerPlayer Class (inherits from Player class)
     *
     * @param chips1: array of chips
     * @param name: name of the player
     */
    public ComputerPlayer(int[] chips1, String name) {
        super(chips1, name);
        this.setIsPlayer(false);
    }

//    /**
//     * When a bet is made on the table, it tells what the player to do,
//     * depending on different situations
//     *
//     * @param betAmount: bet made on the table
//     */
//    @Override
//    public void playBet(int betAmount) {
//        if (betAmount > 200 && this.getMoney() < 300) {
//            this.fold();
//        } else {
//            if (this.enoughMoney()) {
//                if (this.hasPair() || this.sameSuit() || this.highCardK()) {
//                    this.call(betAmount + (int) this.getMoney() / 5);
//                } else if (this.highCardIsNotJ()) {
//                    this.fold();
//                } else {
//                    this.call(betAmount);
//                }
//            } else if (this.littleMoney()) {
//                if (this.hasPair() || !this.lowCardJ()) {
//                    this.call(betAmount);
//                } else {
//                    this.fold();
//                }
//            } else {
//                if (this.hasPair() || this.highCardK() || this.sameSuit()) {
//                    this.call(betAmount);
//                } else {
//                    this.fold();
//                }
//            }
//        }
//    }
//
//    /**
//     * When no bet is made on the table, it tells what the player to do,
//     * depending on different situations
//     */
//    @Override
//    public void playNoBet() {
//        if (this.enoughMoney()) {
//            if (this.hasPair() || this.sameSuit() || this.highCardK()) {
//                this.makeBet((int) this.getMoney() / 4);
//            } else if (this.highCardIsNotJ()) {
//                this.fold();
//            }
//        } else if (this.littleMoney()) {
//            if (!this.hasPair() && !this.lowCardJ()) {
//                this.fold();
//            }
//        } else {
//            if (!this.hasPair() && !this.sameSuit() && this.highCardIsNotJ()) {
//                this.fold();
//            }
//        }
//    }
    /**
     * Tells if the player has more than $200
     *
     * @return: boolean (true or false)
     */
    public boolean enoughMoney() {
        return this.getMoney() > 200;
    }

    /**
     * Tells if player has less than $50
     *
     * @return boolean (true or false)
     */
    public boolean littleMoney() {
        return this.getMoney() < 50;
    }

    /**
     * Tells if the player has a pair or not
     *
     * @return: boolean (true or false)
     */
    public boolean hasPair() {
        return this.getCard1().getRank() == this.getCard2().getRank();
    }

    /**
     * Tells if the player has same suit of cards or not
     *
     * @return: boolean (true or false)
     */
    public boolean sameSuit() {
        return this.getCard1().getSuit() == this.getCard2().getSuit();
    }

    /**
     * Tells if the high card of the player is King or Ace
     *
     * @return: boolean (true or false)
     */
    public boolean highCardK() {
        if (this.getCard1().getRank() != Rank.K && this.getCard1().getRank() != Rank.ACE) {
            if (this.getCard2().getRank() != Rank.K && this.getCard2().getRank() != Rank.ACE) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tells if high card of the player is not higher than 10
     *
     * @return: boolean (true or false)
     */
    public boolean highCardIsNotJ() {
        if (this.getCard1().getRank() != Rank.ACE) {
            if (this.getCard1().getRank() != Rank.K) {
                if (this.getCard1().getRank() != Rank.Q) {
                    if (this.getCard1().getRank() != Rank.J) {
                        if (this.getCard2().getRank() != Rank.ACE) {
                            if (this.getCard2().getRank() != Rank.K) {
                                if (this.getCard2().getRank() != Rank.Q) {
                                    if (this.getCard2().getRank() != Rank.J) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Tells if the low card is lower than J
     *
     * @return: boolean (true or false)
     */
    public boolean lowCardJ() {
        Rank[] low = {Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN};
        for (int i = 0; i < low.length; i++) {
            if (this.getCard1().getRank() == low[i] || this.getCard2().getRank() == low[i]) {
                return true;
            }
        }
        return false;
    }
}
