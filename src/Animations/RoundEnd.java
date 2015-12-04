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

import Model.Model;
import View.GameTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author lbv001
 */
public class RoundEnd {
    GameTable theGameTable;
    ButtonsMovement Move;
    Timer flop;
    Timer flop1;
    Timer flop2;
    Timer turn;
    Timer river;
    int spin = 0;
    int count;
    Model c;
    Icon icon1 = new ImageIcon("src/images/playing-card-back.jpg");

    public RoundEnd(GameTable theGameTable, Model c) {
        this.theGameTable = theGameTable;
        Move = new ButtonsMovement(theGameTable, c);
    }

    public void endRound() {

        theGameTable.getFlop().setIcon(icon1);
        theGameTable.getFlop1().setIcon(icon1);
        theGameTable.getFlop2().setIcon(icon1);
        theGameTable.getTurn().setIcon(icon1);
        theGameTable.getRiver().setIcon(icon1);
        Move.buttonsNextPosition();
        flop = new Timer(1, new Flop());
        flop1 = new Timer(1, new Flop1());

        flop2 = new Timer(1, new Flop2());

        turn = new Timer(1, new Turn());
        river = new Timer(1, new River());
        flop.start();
        flop1.start();
        flop2.start();
        turn.start();
        river.start();
    }

    class Flop implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getFlop().setLocation(theGameTable.getFlop().getX() + 1,
                                               theGameTable.getFlop().getY());

            if (theGameTable.getFlop().getX() > 910) {
                theGameTable.getFlop().setVisible(false);
                flop.stop();
            }
        }

    }

    class Flop1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getFlop1().setLocation(
                    theGameTable.getFlop1().getX() + 1,
                    theGameTable.getFlop1().getY());

            if (theGameTable.getFlop1().getX() > 910) {
                theGameTable.getFlop1().setVisible(false);

                flop1.stop();
            }
        }

    }

    class Flop2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            theGameTable.getFlop2().setLocation(
                    theGameTable.getFlop2().getX() + 1,
                    theGameTable.getFlop2().getY());

            if (theGameTable.getFlop2().getX() > 910) {
                theGameTable.getFlop2().setVisible(false);

                flop2.stop();
            }
        }

    }

    class Turn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getTurn().setLocation(theGameTable.getTurn().getX() + 1,
                                               theGameTable.getTurn().getY());

            if (theGameTable.getTurn().getX() > 910) {
                theGameTable.getTurn().setVisible(false);
                turn.stop();
            }
        }

    }

    class River implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getRiver().setLocation(
                    theGameTable.getRiver().getX() + 1,
                    theGameTable.getRiver().getY());

            if (theGameTable.getRiver().getX() > 910) {
                theGameTable.getRiver().setVisible(false);
                river.stop();
            }
        }

    }
}
