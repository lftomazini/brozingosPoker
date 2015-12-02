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
package csci205finalproject;

/**
 *
 * @author lffct001
 */
public enum Hand {
    HIGH_CARD(1), ONE_PAIR(2), TWO_PAIR(3), THREE_OF_A_KIND(4), STRAIGHT(5), FLUSH(
            6), FULL_HOUSE(7), FOUR_OF_A_KIND(8), STRAIGHT_FLUSH(
                    9), ROYAL_FLUSH(10);
    private int hand;

    private Hand(int hand) {
        this.hand = hand;
    }

    public int getValue() {
        return hand;
    }

    public static boolean equals(Hand hand1, Hand hand2) {
        return hand1.getValue() == hand2.getValue();
    }
}
