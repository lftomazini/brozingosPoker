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
import java.util.ArrayList;
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
    Timer card1b;
    Timer card2b;
    Timer p2c1;
    Timer p2c2;
    Timer p3c1;
    Timer p3c2;
    Timer p4c1;
    Timer p4c2;
    Timer p5c1;
    Timer p5c2;
    Timer p6c1;
    Timer p6c2;
    int numPlayers;

    Model theModel;
    Icon icon1 = new ImageIcon("src/images/playing-card-back.jpg");

    public RoundEnd(GameTable theGameTable, Model theModel) {
        this.theGameTable = theGameTable;
        Move = new ButtonsMovement(theGameTable, theModel);
        this.numPlayers = theModel.getNumPlayers();
        flop = new Timer(1, new Flop());
        flop1 = new Timer(1, new Flop1());

        flop2 = new Timer(1, new Flop2());

        turn = new Timer(1, new Turn());
        river = new Timer(1, new River());
        card1b = new Timer(1, new Card1b());
        card2b = new Timer(1, new Card2b());
        p6c1 = new Timer(1, new P6c1());
        p6c2 = new Timer(1, new P6c2());
        p5c1 = new Timer(1, new P5c1());
        p5c2 = new Timer(1, new P5c2());
        p4c1 = new Timer(1, new P4c1());
        p4c2 = new Timer(1, new P4c2());
        p3c1 = new Timer(1, new P3c1());
        p3c2 = new Timer(1, new P3c2());
        p2c1 = new Timer(1, new P2c1());
        p2c2 = new Timer(1, new P2c2());

    }

    public void playerFold(ArrayList players, int i) {
        if (players.size() == 3) {
            if (i == 0) {
                card1b.setInitialDelay(0);
                card1b.start();
                card2b.setInitialDelay(0);
                card2b.start();

            } else if (i == 1) {
                p5c1.setInitialDelay(0);
                p5c1.start();
                p5c2.setInitialDelay(0);
                p5c2.start();
            } else if (i == 2) {
                p6c1.setInitialDelay(0);
                p6c1.start();
                p6c2.setInitialDelay(0);
                p6c2.start();
            }
        } else if (players.size() == 4) {
            if (i == 0) {
                card1b.setInitialDelay(0);
                card1b.start();
                card2b.setInitialDelay(0);
                card2b.start();

            } else if (i == 1) {
                p4c1.setInitialDelay(0);
                p4c1.start();
                p4c2.setInitialDelay(0);
                p4c2.start();

            } else if (i == 2) {
                p5c1.setInitialDelay(0);
                p5c1.start();
                p5c2.setInitialDelay(0);
                p5c2.start();

            } else if (i == 3) {
                p6c1.setInitialDelay(0);
                p6c1.start();
                p6c2.setInitialDelay(0);
                p6c2.start();
            }

        } else if (players.size() == 5) {
            if (i == 0) {
                card1b.setInitialDelay(0);
                card1b.start();
                card2b.setInitialDelay(0);
                card2b.start();

            } else if (i == 1) {
                p3c1.setInitialDelay(0);
                p3c1.start();
                p3c2.setInitialDelay(0);
                p3c2.start();

            } else if (i == 2) {
                p4c1.setInitialDelay(0);
                p4c1.start();
                p4c2.setInitialDelay(0);
                p4c2.start();

            } else if (i == 3) {
                p5c1.setInitialDelay(0);
                p5c1.start();
                p5c2.setInitialDelay(0);
                p5c2.start();

            } else if (i == 4) {
                p6c1.setInitialDelay(0);
                p6c1.start();
                p6c2.setInitialDelay(0);
                p6c2.start();

            }

        } else if (players.size() == 6) {
            if (i == 0) {
                card1b.setInitialDelay(0);
                card1b.start();
                card2b.setInitialDelay(0);
                card2b.start();

            } else if (i == 1) {
                p3c1.setInitialDelay(0);
                p3c1.start();
                p3c2.setInitialDelay(0);
                p3c2.start();

            } else if (i == 2) {
                p2c1.setInitialDelay(0);
                p2c1.start();
                p2c2.setInitialDelay(0);
                p2c2.start();

            } else if (i == 3) {
                p4c1.setInitialDelay(0);
                p4c1.start();
                p4c2.setInitialDelay(0);
                p4c2.start();

            } else if (i == 4) {
                p5c1.setInitialDelay(0);
                p5c1.start();
                p5c2.setInitialDelay(0);
                p5c2.start();

            } else if (i == 5) {
                p6c1.setInitialDelay(0);
                p6c1.start();
                p6c2.setInitialDelay(0);
                p6c2.start();

            }

        }

    }

    public void endRound() {

        theGameTable.getFlop().setIcon(icon1);
        theGameTable.getFlop1().setIcon(icon1);
        theGameTable.getFlop2().setIcon(icon1);
        theGameTable.getTurn().setIcon(icon1);
        theGameTable.getRiver().setIcon(icon1);
        Move.buttonsNextPosition();

        flop.start();
        flop1.start();
        flop2.start();
        turn.start();
        river.start();

        card1b.setInitialDelay(500);
        card2b.setInitialDelay(800);
        p6c1.setInitialDelay(1100);
        p6c2.setInitialDelay(1400);
        p5c1.setInitialDelay(1700);
        p5c2.setInitialDelay(2000);
        p4c1.setInitialDelay(2300);
        p4c2.setInitialDelay(2700);

        p3c1.setInitialDelay(3000);
        p3c2.setInitialDelay(3300);

        p2c1.setInitialDelay(3700);
        p2c2.setInitialDelay(4000);
        if (numPlayers == 3) {
            card1b.start();
            card2b.start();
            p5c1.start();
            p5c2.start();
            p6c1.start();
            p6c2.start();

        } else if (numPlayers == 4) {
            p5c1.start();
            card1b.start();
            card2b.start();
            p5c2.start();
            p6c1.start();
            p6c2.start();
            p4c1.start();
            p4c2.start();

        } else if (numPlayers == 5) {
            p5c1.start();
            card1b.start();
            card2b.start();
            p5c2.start();
            p6c1.start();
            p6c2.start();
            p4c1.start();
            p4c2.start();
            p3c1.start();
            p3c2.start();

        } else if (numPlayers == 6) {
            p2c1.start();
            p2c2.start();
            p5c1.start();
            card1b.start();
            card2b.start();
            p5c2.start();
            p6c1.start();
            p6c2.start();
            p4c1.start();
            p4c2.start();
            p3c1.start();
            p3c2.start();

        }

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

    class Card1b implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getCard1b().setVisible(false);
            theGameTable.getCard1label().setVisible(true);
            if (theGameTable.getCard1label().getY() > 290) {
                theGameTable.getCard1label().setLocation(
                        theGameTable.getCard1label().getX(),
                        theGameTable.getCard1label().getY() - 1);
            } else if (theGameTable.getCard1label().getX() < 910) {
                theGameTable.getCard1label().setLocation(
                        theGameTable.getCard1label().getX() + 1,
                        theGameTable.getCard1label().getY());
            } else {
                theGameTable.getCard1label().setVisible(false);
                theGameTable.getCard1b().setIcon(icon1);

                card1b.stop();
            }

        }

    }

    class Card2b implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getCard2b().setVisible(false);
            theGameTable.getCard2label().setVisible(true);
            if (theGameTable.getCard2label().getY() > 290) {
                theGameTable.getCard2label().setLocation(
                        theGameTable.getCard2label().getX(),
                        theGameTable.getCard2label().getY() - 1);
            } else if (theGameTable.getCard2label().getX() < 910) {
                theGameTable.getCard2label().setLocation(
                        theGameTable.getCard2label().getX() + 1,
                        theGameTable.getCard2label().getY());
            } else {
                theGameTable.getCard2label().setVisible(false);
                theGameTable.getCard2b().setIcon(icon1);

                card2b.stop();
            }

        }

    }

    class P2c1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theGameTable.getP2c1().getY() < 320) {
                theGameTable.getP2c1().setLocation(theGameTable.getP2c1().getX(),
                                                   theGameTable.getP2c1().getY() + 1);
            } else if (theGameTable.getP2c1().getX() < 910) {

                theGameTable.getP2c1().setLocation(
                        theGameTable.getP2c1().getX() + 1,
                        theGameTable.getP2c1().getY());
            } else {
                theGameTable.getP2c1().setVisible(false);
                p2c1.stop();

            }

        }

    }

    class P2c2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theGameTable.getP2c2().setLocation(theGameTable.getP2c2().getX() + 1,
                                               theGameTable.getP2c2().getY());
            if (theGameTable.getP2c2().getX() > 910) {
                theGameTable.getP2c2().setVisible(false);
                p2c2.stop();
            }

        }

    }

    class P3c1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theGameTable.getP3c1().getY() > 290) {
                theGameTable.getP3c1().setLocation(theGameTable.getP3c1().getX(),
                                                   theGameTable.getP3c1().getY() - 1);
            } else if (theGameTable.getP3c1().getX() < 910) {
                theGameTable.getP3c1().setLocation(
                        theGameTable.getP3c1().getX() + 1,
                        theGameTable.getP3c1().getY());
            } else {
                theGameTable.getP3c1().setVisible(false);
                p3c1.stop();
            }

        }

    }

    class P3c2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theGameTable.getP3c2().getY() > 290) {
                theGameTable.getP3c2().setLocation(theGameTable.getP3c2().getX(),
                                                   theGameTable.getP3c2().getY() - 1);
            } else if (theGameTable.getP3c2().getX() < 910) {
                theGameTable.getP3c2().setLocation(
                        theGameTable.getP3c2().getX() + 1,
                        theGameTable.getP3c2().getY());
            } else {
                theGameTable.getP3c2().setVisible(false);
                p3c2.stop();
            }

        }

    }

    class P4c1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theGameTable.getP4c1().getY() < 290) {
                theGameTable.getP4c1().setLocation(theGameTable.getP4c1().getX(),
                                                   theGameTable.getP4c1().getY() + 1);
            } else if (theGameTable.getP4c1().getX() < 910) {
                theGameTable.getP4c1().setLocation(
                        theGameTable.getP4c1().getX() + 1,
                        theGameTable.getP4c1().getY());
            } else {
                theGameTable.getP4c1().setVisible(false);
                p4c1.stop();
            }

        }

    }

    class P4c2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theGameTable.getP4c2().getY() < 290) {
                theGameTable.getP4c2().setLocation(theGameTable.getP4c2().getX(),
                                                   theGameTable.getP4c2().getY() + 1);
            } else if (theGameTable.getP4c2().getX() < 910) {
                theGameTable.getP4c2().setLocation(
                        theGameTable.getP4c2().getX() + 1,
                        theGameTable.getP4c2().getY());
            } else {
                theGameTable.getP4c2().setVisible(false);
                p4c2.stop();
            }

        }

    }

    class P5c1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theGameTable.getP5c1().getY() < 290) {
                theGameTable.getP5c1().setLocation(theGameTable.getP5c1().getX(),
                                                   theGameTable.getP5c1().getY() + 1);
            } else if (theGameTable.getP5c1().getX() < 910) {
                theGameTable.getP5c1().setLocation(
                        theGameTable.getP5c1().getX() + 1,
                        theGameTable.getP5c1().getY());
            } else {
                theGameTable.getP5c1().setVisible(false);
                p5c1.stop();
            }

        }

    }

    class P5c2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theGameTable.getP5c2().getY() < 290) {
                theGameTable.getP5c2().setLocation(theGameTable.getP5c2().getX(),
                                                   theGameTable.getP5c2().getY() + 1);
            } else if (theGameTable.getP5c2().getX() < 910) {
                theGameTable.getP5c2().setLocation(
                        theGameTable.getP5c2().getX() + 1,
                        theGameTable.getP5c2().getY());
            } else {
                theGameTable.getP5c2().setVisible(false);
                p5c2.stop();
            }
        }

    }

    class P6c1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theGameTable.getP6c1().getY() < 290) {
                theGameTable.getP6c1().setLocation(theGameTable.getP6c1().getX(),
                                                   theGameTable.getP6c1().getY() + 1);
            } else if (theGameTable.getP6c1().getX() < 910) {
                theGameTable.getP6c1().setLocation(
                        theGameTable.getP6c1().getX() + 1,
                        theGameTable.getP6c1().getY());
            } else {
                theGameTable.getP6c1().setVisible(false);
                p6c1.stop();
            }
        }

    }

    class P6c2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (theGameTable.getP6c2().getX() > 870 && theGameTable.getP6c2().getY() < 290) {
                theGameTable.getP6c2().setLocation(
                        theGameTable.getP6c2().getX() - 1,
                        theGameTable.getP6c2().getY());
            } else if (theGameTable.getP6c2().getY() < 290) {
                theGameTable.getP6c2().setLocation(theGameTable.getP6c2().getX(),
                                                   theGameTable.getP6c2().getY() + 1);
            } else if (theGameTable.getP6c2().getX() < 910) {
                theGameTable.getP6c2().setLocation(
                        theGameTable.getP6c2().getX() + 1,
                        theGameTable.getP6c2().getY());
            } else {
                theGameTable.getP6c2().setVisible(false);
                p6c2.stop();

            }
        }

    }

}
