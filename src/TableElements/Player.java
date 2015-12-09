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
package TableElements;

import Cards.Card;
import Cards.Hand;
import Cards.Rank;
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
    private boolean isPlayer;
    private int money;
    private Hand hand;
    private String name;
    Card card1;
    Card card2;
    private int[] chips = new int[Chips.values().length];
    ArrayList<Card> finalHand = new ArrayList<>();

    /**
     * Constructs a player object
     *
     * @param chips1: An array of chips
     */
    public Player(int[] chips1, String name) {
        this.bigBlind = false;
        this.smallBlind = false;
        this.card1 = null;
        this.card2 = null;
        this.chips = chips1;
        this.hasFolded = false;
        this.hand = null;
        this.money = this.getTotalChipsValue();
        this.name = name;
        this.isPlayer = true;
    }

    public boolean isIsPlayer() {
        return isPlayer;
    }

    public void setIsPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Calculates the total value of the chips
     *
     * @return : value of chips
     */
    public int getTotalChipsValue() {
        int value = 0;
        value += this.chips[0] * Chips.WHITE.getValue();
        value += this.chips[1] * Chips.RED.getValue();
        value += this.chips[2] * Chips.BLUE.getValue();
        value += this.chips[3] * Chips.GREEN.getValue();
        value += this.chips[4] * Chips.BLACK.getValue();
        return value;
    }

    /**
     * Distributes the money into chips of different value
     */
    public void getChipsFromMoney() {
        int value = this.getMoney();

        int remainderHundred = value % (int) (Chips.BLACK.getValue());
        int numHundred = (value - remainderHundred) / (int) (Chips.BLACK.getValue());
        value = value - (int) (Chips.BLACK.getValue() * numHundred);
        this.chips[4] = numHundred;

        int remainderTwentyFive = value % (int) (Chips.GREEN.getValue());
        int numTwentyFive = (value - remainderTwentyFive) / (int) (Chips.GREEN.getValue());
        value = value - (int) (Chips.GREEN.getValue() * numTwentyFive);
        this.chips[3] = numTwentyFive;

        int remainderTen = value % (int) (Chips.BLUE.getValue());
        int numTen = (value - remainderTen) / (int) (Chips.BLUE.getValue());
        value = value - (int) (Chips.BLUE.getValue() * numTen);
        this.chips[2] = numTen;

        int remainderFive = value % (int) (Chips.RED.getValue());
        int numFive = (value - remainderFive) / (int) (Chips.RED.getValue());
        value = value - (int) (Chips.RED.getValue() * numFive);
        this.chips[1] = numFive;

        int remainderOne = value % (int) (Chips.WHITE.getValue());
        int numOne = (value - remainderOne) / (int) (Chips.WHITE.getValue());
        value = value - (int) (Chips.WHITE.getValue() * numOne);
        this.chips[0] = numOne;
    }

    /**
     * Returns the amount of bet made and deducts that amount from the money
     * that the player has. Returns -1 if bet is greater than amount of money
     * the player has
     *
     * @param bet: amount betted
     * @return : the amount betted
     */
    public int makeBet(int bet) {
        if (bet > this.money) {
            return -1;
        } else {
            this.money -= bet;
            this.getChipsFromMoney();
        }
        return bet;
    }

    /**
     * Matches the bet made
     *
     * @param bet: amount betted
     */
    public void call(int bet) {
        int money = this.makeBet(bet);
        if (money == -1) {
            money = this.makeBet(this.getMoney());
        }
    }

    public void setHasFolded(boolean hasFolded) {
        this.hasFolded = hasFolded;
    }

    /**
     * Sets both the cards to be null
     */
    public void fold() {
        this.hasFolded = true;
    }

    /**
     * Sets the bigBlind
     *
     * @param bigBlind: true means the player has to play the big blind
     */
    public void setBigBlind(boolean bigBlind) {
        this.bigBlind = bigBlind;
    }

    /**
     * Sets the smallBlind
     *
     * @param smallBlind: true means the player has to play the big blind
     */
    public void setSmallBlind(boolean smallBlind) {
        this.smallBlind = smallBlind;
    }

    /**
     * Sets card1 of the player
     *
     * @param card1
     */
    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    /**
     * Tells what type of hand the player has. E.g. - flush, straight, pair,
     * etc.
     *
     * @param hand
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * Sets card1 of the player
     *
     * @param card2
     */
    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    /**
     * Sets the number of chips of each type that the player will have
     *
     * @param chips
     */
    public void setChips(int[] chips) {
        this.chips = chips;
    }

    /**
     * Sets the amount of money that a Player has
     *
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;
        this.getChipsFromMoney();
    }

    /**
     * Tells whether the player plays the bigBlind or not
     *
     * @return: boolean value - True meaning Yes; False meaning No
     */
    public boolean isBigBlind() {
        return this.bigBlind;
    }

    public boolean isHasFolded() {
        return this.hasFolded;
    }

    /**
     * Tells whether the player plays the smallBlind or not
     *
     * @return: boolean value - True meaning Yes; False meaning No
     */
    public boolean isSmallBlind() {
        return this.smallBlind;
    }

    /**
     * Returns Card1 of the player
     *
     * @return: card1
     */
    public Card getCard1() {
        return this.card1;
    }

    /**
     * Returns Card2 of the player
     *
     * @return: card2
     */
    public Card getCard2() {
        return this.card2;
    }

    /**
     * Returns the array of chips that the player has
     *
     * @return: array of chips
     */
    public int[] getChips() {
        return this.chips;
    }

    /**
     * returns the amount of money the player has
     *
     * @return: money
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Returns the Hand that the player has
     *
     * @return: hand
     */
    public Hand getHand() {
        return this.hand;
    }

    /**
     * Compares the two players on the basis of their respective hands
     */
    public static Comparator<Player> byHand = (Player p1, Player p2) -> {
        if (p1.getHand().getValue() < p2.getHand().getValue()) {
            return 1;
        } else {
            if (p1.getHand().getValue() == p2.getHand().getValue()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    /**
     * Compares the two players on the basis of their respective highcards
     */
    public static Comparator<Player> byHighCard = (Player p1, Player p2) -> {
        if (p1.getCard1().getRank().getValue() < p1.getCard2().getRank().getValue()) {
            Card aux = null;
            aux = p1.getCard1();
            p1.setCard1(p1.getCard2());
            p1.setCard2(aux);
        }
        Card highest_p1 = p1.getCard1();

        if (p2.getCard1().getRank().getValue() < p2.getCard2().getRank().getValue()) {
            Card aux = null;
            aux = p2.getCard1();
            p2.setCard1(p2.getCard2());
            p2.setCard2(aux);
        }
        Card highest_p2 = p2.getCard1();

        if (highest_p1.getRank().getValue() < highest_p2.getRank().getValue()) {
            return 1;
        } else {
            if (highest_p1.getRank().getValue() == highest_p2.getRank().getValue()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    /**
     * When a bet is made on the table, it tells what the player to do,
     * depending on different situations
     *
     * @param betAmount: bet made on the table
     */
    public int playBet(int betAmount) {
        int betValue = 0;
        if (betAmount > 100 && this.getMoney() < 100) {
            this.fold();
        } else {
            if (this.enoughMoney()) {
                if (this.hasPair() || this.sameSuit() || this.highCardK()) {
                    this.call(betAmount + (int) this.getMoney() / 5);
                    betValue = betAmount + (int) this.getMoney() / 5;
                } else if (this.highCardIsNotJ()) {
                    this.fold();
                } else {
                    this.call(betAmount);
                }
            } else if (this.littleMoney()) {
                if (this.hasPair() || !this.lowCardJ()) {
                    this.call(betAmount);
                } else {
                    this.fold();
                }
            } else {
                if (this.hasPair() || this.highCardK() || this.sameSuit()) {
                    this.call(betAmount);
                } else {
                    this.fold();
                }
            }
        }
        return betValue;
    }

    /**
     * When no bet is made on the table, it tells what the player to do,
     * depending on different situations
     */
    public int playNoBet() {
        int betValue = 0;
        if (this.enoughMoney()) {
            if (this.hasPair() || this.sameSuit() || this.highCardK()) {
                this.makeBet((int) this.getMoney() / 4);
                betValue = (int) this.getMoney() / 4;
            } else if (this.highCardIsNotJ()) {
                this.fold();
            }
        } else if (this.littleMoney()) {
            if (!this.hasPair() && !this.lowCardJ()) {
                this.fold();
            }
        } else {
            if (!this.hasPair() && !this.sameSuit() && this.highCardIsNotJ()) {
                this.fold();
            }
        }
        return betValue;
    }

    /**
     * Tells if the player has more than $200
     *
     * @return: boolean (true or false)
     */
    public boolean enoughMoney() {
        return this.getMoney() > 100;
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

    @Override
    public Player clone() {
        Player p = new Player(this.chips, this.name);
        p.bigBlind = this.bigBlind;
        p.smallBlind = this.smallBlind;
        p.card1 = this.card1;
        p.card2 = this.card2;
        p.chips = this.chips;
        p.hasFolded = this.hasFolded;
        p.hand = this.hand;
        p.money = this.money;
        p.name = this.name;
        p.isPlayer = this.isPlayer;
        return p;

    }
}
