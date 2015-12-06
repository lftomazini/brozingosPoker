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
package Animations;

import Cards.Card;
import View.GameTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author lbv001
 */
public class FlipCards {
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    Timer timer5;
    GameTable theGameTable;
    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;

    public FlipCards(GameTable theGameTable, Card card1, Card card2, Card card3,
                     Card card4, Card card5) {
        this.timer1 = new Timer(1, new Flop());
        this.timer2 = new Timer(1, new Flop1());
        this.timer3 = new Timer(1, new Flop2());
        this.timer4 = new Timer(1, new Turn());
        this.timer5 = new Timer(1, new River());

        this.theGameTable = theGameTable;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.card4 = card4;
        this.card5 = card5;
    }

    public void flop() {
        changeIcon(card1, theGameTable.getFlop());

        timer1.start();
        changeIcon(card2, theGameTable.getFlop1());
        timer2.setInitialDelay(1000);
        timer2.start();
        timer3.setInitialDelay(2000);
        changeIcon(card3, theGameTable.getFlop2());
        timer3.start();
    }

    public void turn() {
        changeIcon(card4, theGameTable.getTurn());
        timer4.start();
    }

    public void river() {
        changeIcon(card5, theGameTable.getRiver());
        timer5.start();
    }

    private void changeIcon(Card card, JLabel label) {
        Icon icon = new ImageIcon("src/cardsimage/" + card.getName() + ".png");
        label.setIcon(icon);
    }

    class Flop implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            theGameTable.getFlop().setVisible(true);

            theGameTable.getFlop().setLocation(
                    theGameTable.getFlop().getX() - 1,
                    theGameTable.getFlop().getY());
            if (theGameTable.getFlop().getX() < 300) {
                timer1.stop();
            }

        }
    }

    /**
     * performs movement action for cards
     */
    class Flop1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            theGameTable.getFlop1().setVisible(true);
            theGameTable.getFlop1().setLocation(
                    theGameTable.getFlop1().getX() - 1,
                    theGameTable.getFlop1().getY());
            if (theGameTable.getFlop1().getX() < 400) {
                timer2.stop();
            }

        }
    }

    /**
     * performs movement action for cards
     */
    class Flop2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            theGameTable.getFlop2().setVisible(true);
            theGameTable.getFlop2().setLocation(
                    theGameTable.getFlop2().getX() - 1,
                    theGameTable.getFlop2().getY());
            if (theGameTable.getFlop2().getX() < 500) {
                timer3.stop();
            }
        }
    }

    class Turn implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            theGameTable.getTurn().setVisible(true);
            theGameTable.getTurn().setLocation(
                    theGameTable.getTurn().getX() - 1,
                    theGameTable.getTurn().getY());
            if (theGameTable.getTurn().getX() < 600) {
                timer4.stop();
            }
        }
    }

    /**
     * performs movement action for cards
     */
    class River implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            theGameTable.getRiver().setVisible(true);
            theGameTable.getRiver().setLocation(
                    theGameTable.getRiver().getX() - 1,
                    theGameTable.getRiver().getY());
            if (theGameTable.getRiver().getX() < 700) {
                timer5.stop();
            }
        }
    }

}
