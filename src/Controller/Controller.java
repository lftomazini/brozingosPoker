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

    public Controller(StartScreen startScreen, Model theModel) throws IOException {
        this.startScreen = startScreen;
        this.theModel = theModel;
        this.theGameTable = new GameTable();
        this.startScreen.getStart().addActionListener(this);
        this.theGameTable.getjButton1().addActionListener(this);
        this.theGameTable.getjButton2().addActionListener(this);

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
                    "/home/accounts/student/l/lbv001/csci205FinalProject/src/cardsimage/3SPADES.jpg");
            theGameTable.getFlop().setIcon(icon);

        }
        if (e.getSource() == theGameTable.getjButton2()) {

            timer = new Timer(1, new Flop());
            timer.setInitialDelay(0);
            timer.setRepeats(true);
            timer.start();

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
