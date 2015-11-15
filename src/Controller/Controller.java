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

/**
 *
 * @author sag033
 */
public class Controller implements ActionListener {

    StartScreen startScreen;
    Model theModel;
    GameTable theGameTable;

    public Controller(StartScreen startScreen, Model theModel) throws IOException {
        this.startScreen = startScreen;
        this.theModel = theModel;
        this.theGameTable = new GameTable();
        this.startScreen.getStart().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startScreen.getStart()) {
            theGameTable.setVisible(true);

        }
    }

}
