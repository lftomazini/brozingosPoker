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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
    Timer timer;
    boolean onCard1 = false;
    boolean onCard2 = false;

    public Controller(StartScreen startScreen, Model theModel) throws IOException {
        this.startScreen = startScreen;
        this.theModel = theModel;
        this.theGameTable = new GameTable();
        this.startScreen.getStart().addActionListener(this);
        this.theGameTable.getjButton1().addActionListener(this);
        this.theGameTable.getjButton2().addActionListener(this);
        this.theGameTable.getCard1b().addActionListener(this);
        this.theGameTable.getCard2b().addActionListener(this);
    }
    int n = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startScreen.getStart()) {
            startScreen.setVisible(false);
            theGameTable.setLocationRelativeTo(null);
            theGameTable.setVisible(true);

        }
        if (e.getSource() == theGameTable.getjButton1()) {

            Icon icon = new ImageIcon(
                    "/home/accounts/student/s/sag033/csci205FinalProject/src/cardsimage/3SPADES.jpg");
            theGameTable.getFlop().setIcon(icon);

        }
        if (e.getSource() == theGameTable.getjButton2()) {

            timer = new Timer(1, new Flop());
            timer.setInitialDelay(0);
            timer.setRepeats(true);
            timer.start();

        }

        //flip card 1 over
        if (e.getSource() == theGameTable.getCard1b()) {
            if (onCard1 == false) {
                Icon icon = new ImageIcon(
                        "/home/accounts/student/s/sag033/csci205FinalProject/src/cardsimage/3SPADES.jpg");
                theGameTable.getCard1b().setIcon(icon);
                onCard1 = true;
            } else {
                Icon icon = new ImageIcon(
                        "/home/accounts/student/s/sag033/csci205FinalProject/src/View/playing-card-back.jpg");
                theGameTable.getCard1b().setIcon(icon);
                onCard1 = false;
            }
        }

        //flip card 2 over
        if (e.getSource() == theGameTable.getCard2b()) {
            if (onCard2 == false) {
                Icon icon = new ImageIcon(
                        "/home/accounts/student/s/sag033/csci205FinalProject/src/cardsimage/3SPADES.jpg");
                theGameTable.getCard2b().setIcon(icon);
                onCard2 = true;
            } else {
                Icon icon = new ImageIcon(
                        "/home/accounts/student/s/sag033/csci205FinalProject/src/View/playing-card-back.jpg");
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
            if (theGameTable.getFlop().getX() < 200) {
                timer.stop();
            }

        }
    }

}
