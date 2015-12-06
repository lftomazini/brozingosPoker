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
public class RoundStart {
    GameTable theGameTable;
    Timer card1bX;
    Timer card1bY;
    Timer card2bX;
    Timer card2bY;
    Timer p2c1X;
    Timer p2c1Y;
    Timer p2c2X;
    Timer p2c2Y;
    Timer p3c1X;
    Timer p3c1Y;
    Timer p3c2X;
    Timer p3c2Y;
    Timer p4c1X;
    Timer p4c1Y;
    Timer p4c2X;
    Timer p4c2Y;
    Timer p5c1X;
    Timer p5c1Y;
    Timer p5c2X;
    Timer p5c2Y;
    Timer p6c1X;
    Timer p6c1Y;
    Timer p6c2X;
    Timer p6c2Y;
    int numPlayers;
    int initialDelay = 4500;
    Model c;
    Icon icon1 = new ImageIcon("src/images/playing-card-back.jpg");

    public RoundStart(GameTable theGameTable, Model c) {
        this.theGameTable = theGameTable;
        this.numPlayers = c.getNumPlayers();
        this.c = c;

    }

    public void StartRound() {
        card1bX = new Timer(1, new Card1bX());
        card1bX.setInitialDelay(initialDelay);
        card1bY = new Timer(1, new Card1bY());
        card1bY.setInitialDelay(initialDelay);
        card2bX = new Timer(1, new Card2bX());
        card2bX.setInitialDelay(initialDelay);
        card2bY = new Timer(1, new Card2bY());
        card2bY.setInitialDelay(initialDelay);
        p6c1X = new Timer(1, new P6c1X());
        p6c1X.setInitialDelay(initialDelay);
        p6c1Y = new Timer(1, new P6c1Y());
        p6c1Y.setInitialDelay(initialDelay);
        p6c2X = new Timer(1, new P6c2X());
        p6c2X.setInitialDelay(initialDelay);

        p6c2Y = new Timer(1, new P6c2Y());
        p6c2Y.setInitialDelay(initialDelay);
        p5c1X = new Timer(1, new P5c1X());
        p5c1X.setInitialDelay(initialDelay);
        p5c1Y = new Timer(1, new P5c1Y());
        p5c1Y.setInitialDelay(initialDelay);
        p5c2X = new Timer(1, new P5c2X());
        p5c2X.setInitialDelay(initialDelay);
        p5c2Y = new Timer(1, new P5c2Y());
        p5c2Y.setInitialDelay(initialDelay);
        p4c1X = new Timer(1, new P4c1X());
        p4c1X.setInitialDelay(initialDelay);
        p4c1Y = new Timer(1, new P4c1Y());
        p4c2X = new Timer(1, new P4c2X());
        p4c2X.setInitialDelay(initialDelay);
        p4c2Y = new Timer(1, new P4c2Y());
        p4c2Y.setInitialDelay(initialDelay);
        p3c1X = new Timer(1, new P3c1X());
        p3c1X.setInitialDelay(initialDelay);
        p3c1Y = new Timer(1, new P3c1Y());
        p3c1Y.setInitialDelay(initialDelay);
        p3c2X = new Timer(1, new P3c2X());
        p3c2X.setInitialDelay(initialDelay);
        p3c2Y = new Timer(1, new P3c2Y());
        p3c2Y.setInitialDelay(initialDelay);
        p2c1X = new Timer(1, new P2c1X());
        p2c1X.setInitialDelay(initialDelay);
        p2c1Y = new Timer(1, new P2c1Y());
        p2c1Y.setInitialDelay(initialDelay);
        p2c2X = new Timer(1, new P2c2X());
        p2c2X.setInitialDelay(initialDelay);
        p2c2Y = new Timer(1, new P2c2Y());
        p2c2Y.setInitialDelay(initialDelay);
        if (numPlayers == 3) {
            card1bX.start();
            card1bY.start();
            card2bX.start();
            card2bY.start();
            p5c1X.start();
            p5c1Y.start();
            p5c2X.start();
            p5c2Y.start();
            p6c1X.start();
            p6c1Y.start();
            p6c2X.start();
            p6c2Y.start();

        } else if (numPlayers == 4) {
            p4c1X.start();
            p4c1Y.start();
            p4c2X.start();
            p4c2Y.start();
            card1bX.start();
            card1bY.start();
            card2bX.start();
            card2bY.start();
            p5c1X.start();
            p5c1Y.start();
            p5c2X.start();
            p5c2Y.start();
            p6c1X.start();
            p6c1Y.start();
            p6c2X.start();
            p6c2Y.start();

        } else if (numPlayers == 5) {
            p4c1X.start();
            p4c1Y.start();
            p4c2X.start();
            p4c2Y.start();
            card1bX.start();
            card1bY.start();
            card2bX.start();
            card2bY.start();
            p5c1X.start();
            p5c1Y.start();
            p5c2X.start();
            p5c2Y.start();
            p6c1X.start();
            p6c1Y.start();
            p6c2X.start();
            p6c2Y.start();
            p3c1X.start();
            p3c1Y.start();
            p3c2X.start();
            p3c2Y.start();

        } else if (numPlayers == 6) {
            p4c1X.start();
            p4c1Y.start();
            p4c2X.start();
            p4c2Y.start();
            card1bX.start();
            card1bY.start();
            card2bX.start();
            card2bY.start();
            p5c1X.start();
            p5c1Y.start();
            p5c2X.start();
            p5c2Y.start();
            p6c1X.start();
            p6c1Y.start();
            p6c2X.start();
            p6c2Y.start();
            p3c1X.start();
            p3c1Y.start();
            p3c2X.start();
            p3c2Y.start();
            p2c1X.start();
            p2c1Y.start();
            p2c2X.start();
            p2c2Y.start();

        }

    }

    class Card1bX implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getCard1label().setVisible(true);
            theGameTable.getCard1label().setLocation(
                    theGameTable.getCard1label().getX() - 1,
                    theGameTable.getCard1label().getY());
            if (theGameTable.getCard1label().getX() < 560) {
                theGameTable.getCard1b().setVisible(true);
                theGameTable.getCard1label().setVisible(false);

                card1bX.stop();
            }

        }

    }

    class Card1bY implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getCard1label().setVisible(true);
            theGameTable.getCard1label().setLocation(
                    theGameTable.getCard1label().getX(),
                    theGameTable.getCard1label().getY() + 1);
            if (theGameTable.getCard1label().getY() > 460) {
                card1bY.stop();
            }

        }

    }

    class Card2bX implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getCard2label().setVisible(true);
            theGameTable.getCard2label().setLocation(
                    theGameTable.getCard2label().getX() - 1,
                    theGameTable.getCard2label().getY());
            if (theGameTable.getCard2label().getX() < 650) {
                theGameTable.getCard2b().setVisible(true);
                theGameTable.getCard2label().setVisible(false);

                card2bX.stop();
            }

        }

    }

    class Card2bY implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            theGameTable.getCard2label().setVisible(true);
            theGameTable.getCard2label().setLocation(
                    theGameTable.getCard2label().getX(),
                    theGameTable.getCard2label().getY() + 1);
            if (theGameTable.getCard2label().getY() > 460) {
                card2bY.stop();
            }

        }

    }

    class P2c1X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP2c1().setVisible(true);
            theGameTable.getP2c1().setLocation(theGameTable.getP2c1().getX() - 1,
                                               theGameTable.getP2c1().getY());
            if (theGameTable.getP2c1().getX() < 130) {
                p2c1X.stop();
            }

        }

    }

    class P2c1Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP2c1().setLocation(theGameTable.getP2c1().getX(),
                                               theGameTable.getP2c1().getY() - 1);
            if (theGameTable.getP2c1().getY() < 240) {
                p2c1Y.stop();
            }

        }

    }

    class P2c2X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP2c2().setVisible(true);
            theGameTable.getP2c2().setLocation(theGameTable.getP2c2().getX() - 1,
                                               theGameTable.getP2c2().getY());
            if (theGameTable.getP2c2().getX() < 130) {
                p2c2X.stop();
            }

        }

    }

    class P2c2Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    class P3c1X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP3c1().setVisible(true);
            theGameTable.getP3c1().setLocation(theGameTable.getP3c1().getX() - 1,
                                               theGameTable.getP3c1().getY());
            if (theGameTable.getP3c1().getX() < 280) {
                p3c1X.stop();
            }

        }

    }

    class P3c1Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP3c1().setLocation(theGameTable.getP3c1().getX(),
                                               theGameTable.getP3c1().getY() + 1);
            if (theGameTable.getP3c1().getY() > 470) {
                p3c1Y.stop();
            }

        }

    }

    class P3c2X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP3c2().setVisible(true);
            theGameTable.getP3c2().setLocation(theGameTable.getP3c2().getX() - 1,
                                               theGameTable.getP3c2().getY());
            if (theGameTable.getP3c2().getX() < 360) {
                p3c2X.stop();
            }

        }

    }

    class P3c2Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP3c2().setLocation(theGameTable.getP3c2().getX(),
                                               theGameTable.getP3c2().getY() + 1);
            if (theGameTable.getP3c2().getY() > 470) {
                p3c2Y.stop();
            }

        }

    }

    class P4c1X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP4c1().setVisible(true);
            theGameTable.getP4c1().setLocation(theGameTable.getP4c1().getX() - 1,
                                               theGameTable.getP4c1().getY());
            if (theGameTable.getP4c1().getX() < 280) {
                p4c1X.stop();
            }

        }

    }

    class P4c1Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP4c1().setLocation(theGameTable.getP4c1().getX(),
                                               theGameTable.getP4c1().getY() - 1);
            if (theGameTable.getP4c1().getY() < 130) {
                p4c1Y.stop();
            }

        }

    }

    class P4c2X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP4c2().setVisible(true);
            theGameTable.getP4c2().setLocation(theGameTable.getP4c2().getX() - 1,
                                               theGameTable.getP4c2().getY());
            if (theGameTable.getP4c2().getX() < 370) {
                p4c2X.stop();
            }

        }

    }

    class P4c2Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP4c2().setLocation(theGameTable.getP4c2().getX(),
                                               theGameTable.getP4c2().getY() - 1);
            if (theGameTable.getP4c2().getY() < 130) {
                p4c2Y.stop();
            }

        }

    }

    class P5c1X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP5c1().setVisible(true);

            theGameTable.getP5c1().setLocation(theGameTable.getP5c1().getX() - 1,
                                               theGameTable.getP5c1().getY());
            if (theGameTable.getP5c1().getX() < 580) {
                p5c1X.stop();
            }

        }

    }

    class P5c1Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP5c1().setLocation(theGameTable.getP5c1().getX(),
                                               theGameTable.getP5c1().getY() - 1);
            if (theGameTable.getP5c1().getY() < 130) {
                p5c1Y.stop();
            }

        }

    }

    class P5c2X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP5c2().setVisible(true);
            theGameTable.getP5c2().setLocation(theGameTable.getP5c2().getX() - 1,
                                               theGameTable.getP5c2().getY());
            if (theGameTable.getP5c2().getX() < 660) {
                p5c2X.stop();
            }

        }

    }

    class P5c2Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            theGameTable.getP5c2().setLocation(theGameTable.getP5c2().getX(),
                                               theGameTable.getP5c2().getY() - 1);
            if (theGameTable.getP5c2().getY() < 130) {
                p5c2Y.stop();
            }

        }

    }

    class P6c1X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP6c1().setVisible(true);
            theGameTable.getP6c1().setLocation(theGameTable.getP6c1().getX() - 1,
                                               theGameTable.getP6c1().getY());
            if (theGameTable.getP6c1().getX() < 870) {
                p6c1X.stop();
            }

        }

    }

    class P6c1Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP6c1().setLocation(theGameTable.getP6c1().getX(),
                                               theGameTable.getP6c1().getY() - 1);
            if (theGameTable.getP6c1().getY() < 130) {
                p6c1Y.stop();
            }

        }

    }

    class P6c2X implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP6c2().setVisible(true);

            theGameTable.getP6c2().setLocation(theGameTable.getP6c2().getX() + 1,
                                               theGameTable.getP6c2().getY());
            if (theGameTable.getP6c2().getX() > 950) {
                p6c2X.stop();
            }

        }

    }

    class P6c2Y implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            theGameTable.getP6c2().setLocation(theGameTable.getP6c2().getX(),
                                               theGameTable.getP6c2().getY() - 1);
            if (theGameTable.getP6c2().getY() < 130) {
                p6c2Y.stop();
            }

        }

    }
}
