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
package Controller;

import Cards.Card;
import Model.Model;
import View.GameTable;
import View.StartScreen;
import csci205finalproject.CardDealer;
import csci205finalproject.GameClass;
import csci205finalproject.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author sag033
 */
public class Controller implements ActionListener {
    static int qX = 0;
    static int qY = 0;
    StartScreen startScreen;
    Model theModel;
    GameTable theGameTable;
    JLabel flop;
    JLabel flop1;
    JLabel flop2;
    Timer timer3;
    Timer timer2;
    Timer timer1;
    Timer timer4;
    Timer timer5;
    Timer timerX;
    Timer timerY;
    boolean onCard1 = false;
    boolean onCard2 = false;
    int numPlayers;
    int[] chips1 = {10, 6, 4, 2, 2};
    int tableRound = 0;

    public Controller(StartScreen startScreen, Model theModel) throws IOException {
        this.startScreen = startScreen;
        this.theModel = theModel;
        this.theGameTable = new GameTable();
        this.startScreen.getStart().addActionListener(this);
        this.theGameTable.getFlip().addActionListener(this);
        this.theGameTable.getCard1b().addActionListener(this);
        this.theGameTable.getCard2b().addActionListener(this);
        theGameTable.getFlop().setVisible(false);
        theGameTable.getFlop1().setVisible(false);
        theGameTable.getFlop2().setVisible(false);
        theGameTable.getTURN().setVisible(false);
        theGameTable.getRIVER().setVisible(false);
        theGameTable.getButtons().addActionListener(this);

    }

    void buttonsNextPosition() {
        int position = 0;
        timerX = new Timer(1, new MoveButtonX());
        timerX.setInitialDelay(0);
        timerX.start();
        timerY = new Timer(1, new MoveButtonY());
        timerY.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == theGameTable.getButtons()) {
            buttonsNextPosition();
        }

        if (e.getSource() == startScreen.getStart()) {
            startScreen.setVisible(false);
            numPlayers = startScreen.getNumPlayers().getSelectedIndex();
            checkNumPlayers();

            theGameTable.setLocationRelativeTo(null);
            theGameTable.setVisible(true);
            theModel.setNumPlayers(numPlayers);
            ArrayList<Player> players = new ArrayList<Player>();
            for (int i = 0; i < numPlayers; i++) {
                players.add(new Player(chips1));
            }
            theModel.setPlayers(players);
            theModel.setTheCardDealer(new CardDealer(theModel.getDeck(),
                                                     theModel.getPlayers()));
            theModel.setTheGameClass(new GameClass(theModel.getPlayers(), 10.00,
                                                   20.00));
            theModel.getTheCardDealer().giveCardstoPlayers();
            if (numPlayers == 3) {
                theGameTable.getP2c1().setVisible(false);
                theGameTable.getP2c2().setVisible(false);
                theGameTable.getP3c1().setVisible(false);
                theGameTable.getP3c2().setVisible(false);
                theGameTable.getP4c1().setVisible(false);
                theGameTable.getP4c2().setVisible(false);
            }
            if (numPlayers == 4) {
                theGameTable.getP2c1().setVisible(false);
                theGameTable.getP2c2().setVisible(false);
                theGameTable.getP3c1().setVisible(false);
                theGameTable.getP3c2().setVisible(false);

            } else if (numPlayers == 5) {
                theGameTable.getP2c1().setVisible(false);
                theGameTable.getP2c2().setVisible(false);

            }
        }

        if (e.getSource() == theGameTable.getFlip()) {

            flip();

        }

        //flip card 1 over
        if (e.getSource()
            == theGameTable.getCard1b()) {
            showCard1();
        }

        //flip card 2 over
        if (e.getSource()
            == theGameTable.getCard2b()) {
            showCard2();
        }

    }

    private void checkNumPlayers() {
        if (numPlayers == 0) {
            numPlayers = 3;
        } else if (numPlayers == 1) {
            numPlayers = 4;
        } else if (numPlayers == 2) {
            numPlayers = 5;
        } else {
            numPlayers = 6;
        }
    }

    void flip() {
        //the flop
        if (tableRound == 0) {
            theGameTable.getFlop().setVisible(true);
            Card card1 = this.theModel.getTheCardDealer().placeCardsOnTable();
            String cardName = card1.getName();
            Icon icon = new ImageIcon(
                    "src/cardsimage/" + cardName + ".png");
            System.out.println(cardName);
            theGameTable.getFlop().setIcon(icon);
            timer1 = new Timer(1, new Flop());
            timer1.setInitialDelay(0);
            timer1.setRepeats(true);
            timer1.start();

            Card card2 = this.theModel.getTheCardDealer().placeCardsOnTable();

            String cardName2 = card2.getName();
            Icon icon2 = new ImageIcon(
                    "src/cardsimage/" + cardName2 + ".png");
            System.out.println(cardName2);
            theGameTable.getFlop1().setIcon(icon2);
            timer2 = new Timer(1, new Flop1());
            timer2.setInitialDelay(1000);
            timer2.setRepeats(true);
            timer2.start();

            Card card3 = this.theModel.getTheCardDealer().placeCardsOnTable();

            String cardName3 = card3.getName();
            Icon icon3 = new ImageIcon(
                    "src/cardsimage/" + cardName3 + ".png");
            theGameTable.getFlop2().setIcon(icon3);
            System.out.println(cardName3);
            timer3 = new Timer(1, new Flop2());
            timer3.setInitialDelay(2000);
            timer3.setRepeats(true);
            timer3.start();

            tableRound++;
        } //the turn
        else if (tableRound == 1) {
            Card card4 = this.theModel.getTheCardDealer().placeCardsOnTable();
            theGameTable.getTURN().setVisible(true);
            String cardName4 = card4.getName();
            Icon icon4 = new ImageIcon(
                    "src/cardsimage/" + cardName4 + ".png");
            theGameTable.getTURN().setIcon(icon4);
            timer4 = new Timer(1, new Turn());
            timer4.setInitialDelay(0);
            timer4.setRepeats(true);
            timer4.start();
            tableRound++;
        } //the river
        else if (tableRound == 2) {
            Card card5 = this.theModel.getTheCardDealer().placeCardsOnTable();
            theGameTable.getRIVER().setVisible(true);
            String cardName5 = card5.getName();
            Icon icon5 = new ImageIcon(
                    "src/cardsimage/" + cardName5 + ".png");
            theGameTable.getRIVER().setIcon(icon5);
            timer5 = new Timer(1, new River());
            timer5.setInitialDelay(0);
            timer5.setRepeats(true);
            timer5.start();
            tableRound++;
        }

    }

    void showCard1() {
        if (onCard1 == false) {
            String cardName = this.theModel.getPlayers().get(0).getCard1().getName();
            Icon icon = new ImageIcon(
                    "src/cardsimage/" + cardName + ".png");
            System.out.println(cardName);
            theGameTable.getCard1b().setIcon(icon);
            onCard1 = true;
        } else {
            Icon icon = new ImageIcon(
                    "src/images/playing-card-back.jpg");
            theGameTable.getCard1b().setIcon(icon);
            onCard1 = false;
        }
    }

    void showCard2() {
        if (onCard2 == false) {
            String cardName = this.theModel.getPlayers().get(0).getCard2().getName();
            Icon icon = new ImageIcon(
                    "src/cardsimage/" + cardName + ".png");
            System.out.println(cardName);
            theGameTable.getCard2b().setIcon(icon);
            onCard2 = true;
        } else {
            Icon icon = new ImageIcon(
                    "src/images/playing-card-back.jpg");
            theGameTable.getCard2b().setIcon(icon);
            onCard2 = false;
        }
    }

    class Flop implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            theGameTable.getFlop().setLocation(
                    theGameTable.getFlop().getX() - 1,
                    theGameTable.getFlop().getY());
            if (theGameTable.getFlop().getX() < 300) {
                timer1.stop();
            }

        }
    }

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
            theGameTable.getTURN().setLocation(
                    theGameTable.getTURN().getX() - 1,
                    theGameTable.getTURN().getY());
            if (theGameTable.getTURN().getX() < 600) {
                timer4.stop();
            }
        }
    }

    class River implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            theGameTable.getRIVER().setLocation(
                    theGameTable.getRIVER().getX() - 1,
                    theGameTable.getRIVER().getY());
            if (theGameTable.getRIVER().getX() < 700) {
                timer5.stop();
            }
        }
    }

    class MoveButtonX implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (numPlayers == 3) {
                if (qX == 0) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 640) {
                        qX++;
                        timerX.stop();
                    }

                } else if (qX == 1) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());
                    if (theGameTable.getBigBlind().getX() > 830) {
                        qX++;
                        timerX.stop();

                    }
                } else if (qX == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getBigBlind().getX() < 640 && theGameTable.getSmallBlind().getX() > 830) {
                        qX = 0;
                        timerX.stop();

                    }
                }

            } else if (numPlayers == 4) {
                if (qX == 0) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getBigBlind().getX() < 340 && theGameTable.getSmallBlind().getX() < 640) {
                        qX++;
                        timerX.stop();
                    }
                } else if (qX == 1) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getBigBlind().getX() > 580 && theGameTable.getSmallBlind().getX() < 370) {
                        qX++;
                        timerX.stop();
                    }
                } else if (qX == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getBigBlind().getX() > 830 && theGameTable.getSmallBlind().getX() > 530) {
                        qX++;
                        timerX.stop();
                    }

                } else if (qX == 3) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getBigBlind().getX() < 640 && theGameTable.getSmallBlind().getX() > 830) {
                        qX = 0;
                        timerX.stop();
                    }

                }
            } else if (numPlayers == 5) {
                if (qX == 0) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 640 && theGameTable.getBigBlind().getX() < 360) {
                        qX++;
                        timerX.stop();
                    }
                } else if (qX == 1) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 360) {
                        qX++;
                        timerX.stop();
                    }
                } else if (qX == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() > 640) {
                        qX++;
                        timerX.stop();
                    }
                } else if (qX == 3) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 640 && theGameTable.getBigBlind().getX() > 830) {
                        qX++;
                        timerX.stop();
                    }
                } else if (qX == 4) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 830 && theGameTable.getBigBlind().getX() < 640) {
                        qX = 0;
                        timerX.stop();
                    }
                }
            }
        }

    }

    class MoveButtonY implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (numPlayers == 3) {
                if (qY == 0) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() - 1);
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() + 1);

                    if (theGameTable.getBigBlind().getY() < 230 && theGameTable.getSmallBlind().getY() > 400) {
                        qY++;
                        timerY.stop();

                    }
                } else if (qY == 1) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() - 1);
                    if (theGameTable.getSmallBlind().getY() < 230) {
                        qY++;
                        timerY.stop();
                    }

                } else if (qY == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() + 1);
                    if (theGameTable.getBigBlind().getY() > 400) {
                        qY = 0;
                        timerY.stop();
                    }

                }
            } else if (numPlayers
                       == 4) {
                if (qY == 0) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() + 1);
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() - 1);

                    if (theGameTable.getSmallBlind().getY() > 400 && theGameTable.getBigBlind().getY() < 230) {
                        qY++;
                        timerY.stop();
                    }
                } else if (qY == 1) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() - 1);
                    if (theGameTable.getSmallBlind().getY() < 230) {
                        qY++;
                        timerY.stop();
                    }
                } else if (qY == 2) {
                    qY++;
                    timerY.stop();
                } else if (qY == 3) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() + 1);
                    if (theGameTable.getBigBlind().getY() > 400) {
                        qY = 0;
                        timerY.stop();

                    }
                }
            } else if (numPlayers == 5) {
                if (qY == 0) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() + 1);
                    if (theGameTable.getSmallBlind().getY() > 400) {

                        qY++;
                        timerY.stop();
                    }
                } else if (qY == 1) {

                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() - 1);
                    if (theGameTable.getBigBlind().getY() < 230) {
                        qY++;

                        timerY.stop();
                    }
                } else if (qY == 2) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() - 1);
                    if (theGameTable.getSmallBlind().getY() < 230) {
                        qY++;
                        timerY.stop();
                    }

                } else if (qY == 3) {
                    qY++;
                    timerY.stop();
                } else if (qY == 4) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() + 1);
                    if (theGameTable.getBigBlind().getY() > 400) {
                        qY = 0;
                        timerY.stop();

                    }
                }
            }

        }

    }
}
