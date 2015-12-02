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
    boolean onCard1 = false;
    boolean onCard2 = false;
    int numPlayers = 5;
    int[] chips1 = {10, 6, 4, 2, 2};
    int tableRound = 0;
    int playerBigBlind = 1;
    int playerSmallBlind = 0;

    public Controller(StartScreen startScreen, Model theModel) throws IOException {
        this.startScreen = startScreen;
        this.theModel = theModel;
        this.theGameTable = new GameTable();
        this.startScreen.getStart().addActionListener(this);
        this.theGameTable.getjButton1().addActionListener(this);
        this.theGameTable.getjButton2().addActionListener(this);
        this.theGameTable.getCard1b().addActionListener(this);
        this.theGameTable.getCard2b().addActionListener(this);
        this.startScreen.getPlayers3().addActionListener(this);
        this.startScreen.getPlayers4().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startScreen.getStart()) {
            startScreen.setVisible(false);

            theGameTable.setLocationRelativeTo(null);
            theGameTable.setVisible(true);
            theModel.setNumPlayers(numPlayers);
            ArrayList<Player> players = new ArrayList<Player>();
            for (int i = 0; i < numPlayers; i++) {
                players.add(new Player(chips1));
            }
            theModel.setPlayers(players);
            theModel.setTheCardDealer(new CardDealer(theModel.getDeck(),
                                                     theModel.getPlayers(),
                                                     theModel.getRound()));
            theModel.setTheGameClass(new GameClass(theModel.getPlayers(), 10.00,
                                                   20.00));
            theModel.getTheCardDealer().giveCardstoPlayers();
            if (numPlayers == 3) {
                theGameTable.getP2c1().setVisible(false);
                theGameTable.getP2c2().setVisible(false);
                theGameTable.getP3c1().setVisible(false);
                theGameTable.getP3c2().setVisible(false);

            } else if (numPlayers == 4) {
                theGameTable.getP2c1().setVisible(false);
                theGameTable.getP2c2().setVisible(false);

            }
            if (playerBigBlind == 0) {
                theGameTable.getSmallBlindSl().setVisible(false);
                theGameTable.getSmallBlindL().setVisible(false);
            } else if (playerSmallBlind == 0) {
                theGameTable.getBigBlindSl().setVisible(false);
                theGameTable.getBigBlindL().setVisible(false);
            }

        }

        if (e.getSource() == startScreen.getPlayers3()) {
            numPlayers = 3;
        }

        if (e.getSource() == startScreen.getPlayers4()) {
            numPlayers = 4;
        }

        if (e.getSource() == theGameTable.getjButton1()) {

            //the flop
            if (tableRound == 0) {
                int card1 = this.theModel.getTheCardDealer().getRandom();
                String cardName = this.theModel.getDeck().getDeck().get(
                        card1).getName();
                Icon icon = new ImageIcon(
                        "src/cardsimage/" + cardName + ".png");
                theGameTable.getFlop().setIcon(icon);
                timer1 = new Timer(1, new Flop());
                timer1.setInitialDelay(0);
                timer1.setRepeats(true);
                timer1.start();

                int card2 = this.theModel.getTheCardDealer().getRandom();
                String cardName2 = this.theModel.getDeck().getDeck().get(
                        card2).getName();
                Icon icon2 = new ImageIcon(
                        "src/cardsimage/" + cardName2 + ".png");
                theGameTable.getFlop1().setIcon(icon2);
                timer2 = new Timer(1, new Flop1());
                timer2.setInitialDelay(1000);
                timer2.setRepeats(true);
                timer2.start();

                int card3 = this.theModel.getTheCardDealer().getRandom();
                String cardName3 = this.theModel.getDeck().getDeck().get(
                        card3).getName();
                Icon icon3 = new ImageIcon(
                        "src/cardsimage/" + cardName3 + ".png");
                theGameTable.getFlop2().setIcon(icon3);
                timer3 = new Timer(1, new Flop2());
                timer3.setInitialDelay(2000);
                timer3.setRepeats(true);
                timer3.start();

                tableRound++;

            } //the turn
            else if (tableRound == 1) {
                int card4 = this.theModel.getTheCardDealer().getRandom();
                String cardName4 = this.theModel.getDeck().getDeck().get(
                        card4).getName();
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
                int card5 = this.theModel.getTheCardDealer().getRandom();
                String cardName5 = this.theModel.getDeck().getDeck().get(
                        card5).getName();
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

        //flip card 1 over
        if (e.getSource()
            == theGameTable.getCard1b()) {
            if (onCard1 == false) {
                String cardName = this.theModel.getPlayers().get(0).getCard1().getName();
                Icon icon = new ImageIcon(
                        "src/cardsimage/" + cardName + ".png");
                theGameTable.getCard1b().setIcon(icon);
                onCard1 = true;
            } else {
                Icon icon = new ImageIcon(
                        "src/View/playing-card-back.jpg");
                theGameTable.getCard1b().setIcon(icon);
                onCard1 = false;
            }
        }

        //flip card 2 over
        if (e.getSource()
            == theGameTable.getCard2b()) {
            if (onCard2 == false) {
                String cardName = this.theModel.getPlayers().get(0).getCard2().getName();
                Icon icon = new ImageIcon(
                        "src/cardsimage/" + cardName + ".png");
                theGameTable.getCard2b().setIcon(icon);
                onCard2 = true;
            } else {
                Icon icon = new ImageIcon(
                        "src/View/playing-card-back.jpg");
                theGameTable.getCard2b().setIcon(icon);
                onCard2 = false;
            }
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

}
