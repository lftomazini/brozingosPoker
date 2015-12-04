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

import Animations.ButtonsMovement;
import Animations.RoundEnd;
import Cards.Card;
import Cards.Deck;
import Model.Model;
import View.GameTable;
import View.StartScreen;
import csci205finalproject.CardDealer;
import csci205finalproject.CheckHands;
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
    int numPlayers;
    int[] chips1 = {10, 6, 4, 2, 2};
    int tableRound = 0;
    int playerBigBlind = 1;
    int playerSmallBlind = 0;
    int bigBlind = 20;
    int smallBlind = 10;
    ButtonsMovement Move;
    RoundEnd MoveEnd;
    int betValue = 0; //holds value of what the bet is up to
    String[] flipNames = {"The Flop", "The Turn", "The River", "The Showdown"};
    String[] computerNames = {"Stephanie", "Luis", "Leo", "Anmol", "Professor Peck", "Professor King"};
    ArrayList<Card> cardsOnTable = new ArrayList<>();

    public Controller() {
    }

    public Controller(StartScreen startScreen, Model theModel) throws IOException {
        this.startScreen = startScreen;
        this.theModel = theModel;
        this.theGameTable = new GameTable();
        this.startScreen.getStart().addActionListener(this);
        this.theGameTable.getFlip().addActionListener(this);
        this.theGameTable.getCard1b().addActionListener(this);
        this.theGameTable.getCard2b().addActionListener(this);
        this.theGameTable.getFlop().setVisible(false);
        this.theGameTable.getFlop1().setVisible(false);
        this.theGameTable.getFlop2().setVisible(false);
        this.theGameTable.getTurn().setVisible(false);
        this.theGameTable.getRiver().setVisible(false);
        this.theGameTable.getFlip().setVisible(false);
        this.theGameTable.getWinnerPanel().setVisible(false);
        this.theGameTable.getFoldCheckBet().setVisible(false);
        this.theGameTable.getButtons().addActionListener(this);
        this.theGameTable.getBetRB().addActionListener(this);
        this.theGameTable.getFoldRB().addActionListener(this);
        this.theGameTable.getCheckRB().addActionListener(this);
        this.theGameTable.getDoneButton().addActionListener(this);
        this.theGameTable.getDoneFCB().addActionListener(this);
        this.theGameTable.getDontPay().addActionListener(this);
        this.theGameTable.getPlayAgainB().addActionListener(this);
        this.theGameTable.getExitB().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == theGameTable.getButtons()) {
            MoveEnd = new RoundEnd(theGameTable, theModel
            );
            MoveEnd.endRound();
        }

        if (e.getSource() == startScreen.getStart()) {
            startScreen.setVisible(false);
            numPlayers = startScreen.getNumPlayers().getSelectedIndex();
            checkNumPlayers();

            theGameTable.setLocationRelativeTo(null);
            theGameTable.setVisible(true);
            numPlayers = startScreen.getNumPlayers().getSelectedIndex();
            checkNumPlayers();
            theModel.setNumPlayers(numPlayers);
            Move = new ButtonsMovement(theGameTable, theModel);
            ArrayList<Player> players = new ArrayList<Player>();
            players.add(new Player(chips1, startScreen.getNameField().getText()));
            for (int i = 0; i < numPlayers; i++) {
                players.add(new Player(chips1, computerNames[i]));
            }

            theModel.setPlayers(players);

            theModel.setTheCardDealer(new CardDealer(theModel.getDeck(),
                                                     theModel.getPlayers()));
            theModel.setTheGameClass(new GameClass(theModel.getPlayers(), 10,
                                                   20));
            theModel.getTheCardDealer().giveCardstoPlayers();
            if (numPlayers == 3) {
                theGameTable.getP2c1().setVisible(false);
                theGameTable.getP2c2().setVisible(false);
                theGameTable.getP3c1().setVisible(false);
                theGameTable.getP3c2().setVisible(false);
                theGameTable.getP4c1().setVisible(false);
                theGameTable.getP4c2().setVisible(false);
                theGameTable.getPlayer2().setVisible(false);
                theGameTable.getPlayer3().setVisible(false);
                theGameTable.getPlayer4().setVisible(false);
                theGameTable.getPlayer1().setText(theModel.getPlayers().get(
                        0).getName());
                theGameTable.getPlayer5().setText(theModel.getPlayers().get(
                        1).getName());
                theGameTable.getPlayer6().setText(theModel.getPlayers().get(
                        2).getName());
            }
            if (numPlayers == 4) {
                theGameTable.getP2c1().setVisible(false);
                theGameTable.getP2c2().setVisible(false);
                theGameTable.getP3c1().setVisible(false);
                theGameTable.getP3c2().setVisible(false);
                theGameTable.getPlayer2().setVisible(false);
                theGameTable.getPlayer3().setVisible(false);
                theGameTable.getPlayer1().setText(theModel.getPlayers().get(
                        0).getName());
                theGameTable.getPlayer4().setText(theModel.getPlayers().get(
                        1).getName());
                theGameTable.getPlayer5().setText(theModel.getPlayers().get(
                        2).getName());
                theGameTable.getPlayer6().setText(theModel.getPlayers().get(
                        3).getName());

            } else if (numPlayers == 5) {
                theGameTable.getP2c1().setVisible(false);
                theGameTable.getP2c2().setVisible(false);
                theGameTable.getPlayer2().setVisible(false);
                theGameTable.getPlayer1().setText(theModel.getPlayers().get(
                        0).getName());
                theGameTable.getPlayer3().setText(theModel.getPlayers().get(
                        1).getName());
                theGameTable.getPlayer4().setText(theModel.getPlayers().get(
                        2).getName());
                theGameTable.getPlayer5().setText(theModel.getPlayers().get(
                        3).getName());
                theGameTable.getPlayer6().setText(theModel.getPlayers().get(
                        4).getName());

            } else if (numPlayers == 6) {
                theGameTable.getPlayer1().setText(theModel.getPlayers().get(
                        0).getName());
                theGameTable.getPlayer2().setText(theModel.getPlayers().get(
                        2).getName());
                theGameTable.getPlayer3().setText(theModel.getPlayers().get(
                        1).getName());
                theGameTable.getPlayer4().setText(theModel.getPlayers().get(
                        2).getName());
                theGameTable.getPlayer5().setText(theModel.getPlayers().get(
                        3).getName());
                theGameTable.getPlayer6().setText(theModel.getPlayers().get(
                        4).getName());

            }
            theModel.getPlayers().get(0).setSmallBlind(true);
            theModel.getPlayers().get(0).setBigBlind(true);

        }

        if (e.getSource()
            == theGameTable.getDoneButton()) {
            theGameTable.getSetBlindsPan().setVisible(false);
            for (int i = 1; i < theModel.getNumPlayers(); i++) {
                theModel.getPlayers().get(i).call(bigBlind);
                theModel.getPlayers().get(i).getChipsFromMoney();
            }

            //ASK USER IF THEY WANT TO FOLD OR PAY
            theModel.getPlayers().get(0).call(smallBlind);
            theModel.getPlayers().get(0).getChipsFromMoney();
            updateCoins();
            this.theGameTable.getFlip().setText(flipNames[tableRound]);
            this.theGameTable.getFlip().setVisible(true);

        }

        if (e.getSource()
            == theGameTable.getDontPay()) {
            theGameTable.getSetBlindsPan().setVisible(false);
            for (int i = 1; i < theModel.getNumPlayers(); i++) {
                theModel.getPlayers().get(i).call(bigBlind);
                theModel.getPlayers().get(i).getChipsFromMoney();
            }
            theModel.getPlayers().get(0).fold();
            this.theGameTable.getFlip().setText(flipNames[tableRound]);
            this.theGameTable.getFlip().setVisible(true);
        }

        /**
         * Flips cards over
         */
        if (e.getSource()
            == theGameTable.getFlip()) {

            flip();
            theGameTable.getFlip().setVisible(false);
            this.theGameTable.getFlip().setText(flipNames[tableRound]);

            //don't let them flip again yet!!! Go through round first
            if ((theModel.getPlayers().get(0).isHasFolded() == false) & (tableRound < 3)) {
                theGameTable.getFoldCheckBet().setVisible(true);
            } else if (tableRound < 3) {
                //A function that moves through computer players
                runPlayers();
                theGameTable.getFlip().setVisible(true);
            } else if (tableRound == 3) {
                showdown();
            }
        }

        /**
         * Finishes each round based on choices!
         */
        if (e.getSource()
            == theGameTable.getDoneFCB()) {

            //Player folds
            if (theGameTable.getFoldRB().isSelected() == true) {
                int i = 0;
                fold(i);
                finishRound();
            } //Player checks
            else if (theGameTable.getCheckRB().isSelected() == true) {
                finishRound();
            } //Player bets!
            else if (theGameTable.getBetRB().isSelected() == true) {
                theModel.getPlayers().get(0).call(betValue);
                theModel.getPlayers().get(0).getChipsFromMoney();
                updateCoins();
                finishRound();
            }
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

        //Reset everything on the game table!
        if (e.getSource()
            == theGameTable.getPlayAgainB()) {
            theModel.getPlayers().get(playerSmallBlind).setSmallBlind(false);
            theModel.getPlayers().get(playerBigBlind).setBigBlind(false);
            tableRound = 0;
            cardsOnTable.clear();
            changeBlinds(playerBigBlind);
            changeBlinds(playerSmallBlind);
            theModel.setDeck(new Deck());
            for (int i = 0; i < theModel.getPlayers().size(); i++) {
                theModel.getPlayers().get(i).setCard1(null);
                theModel.getPlayers().get(i).setCard2(null);
            }
            theModel.getPlayers().get(playerSmallBlind).setSmallBlind(true);
            theModel.getPlayers().get(playerBigBlind).setBigBlind(true);

            theGameTable.getWinnerPanel().setVisible(false);
            theGameTable.getSetBlindsPan().setVisible(true);

        }

        if (e.getSource()
            == theGameTable.getExitB()) {
            System.exit(0);

        }

    }

    /**
     * circulates who in the player array pays which blind
     *
     * @param blind - big or small
     */
    private void changeBlinds(int blind) {
        if (blind == (numPlayers)) {
            blind = 0;
        } else {
            blind += 1;
        }
    }

    /**
     * finishes up the card round of betting, checking, or folding
     */
    private void finishRound() {
        runPlayers();
        theGameTable.getFoldCheckBet().setVisible(false);
        theGameTable.getFlip().setVisible(true);
    }

    /**
     * completes the functionality of the showdown
     */
    private void showdown() {
        CheckHands showdown = new CheckHands();
        showdown.checkHands(theModel.getPlayers(), cardsOnTable);
        ArrayList<Player> winner = new ArrayList();
        winner = showdown.checkWinner(theModel.getPlayers(),
                                      cardsOnTable);
        theGameTable.getStateWinnerL().setText(
                "The Winner is " + winner.get(0).getName());
        theGameTable.getYourMoneyL().setText("Your Money: " + Integer.toString(
                theModel.getPlayers().get(0).getMoney()));
        theGameTable.getWinnerPanel().setVisible(true);
    }

    /**
     * Updates the coin values based on what the player now has
     */
    private void updateCoins() {
        theGameTable.getWhiteChip1().setText(String.valueOf(
                theModel.getPlayers().get(
                        0).getChips()[0]));
        theGameTable.getRedChip1().setText(String.valueOf(
                theModel.getPlayers().get(
                        0).getChips()[1]));
        theGameTable.getBlueChip1().setText(String.valueOf(
                theModel.getPlayers().get(
                        0).getChips()[2]));
        theGameTable.getGreenChip1().setText(String.valueOf(
                theModel.getPlayers().get(
                        0).getChips()[3]));
        theGameTable.getBlackChip1().setText(String.valueOf(
                theModel.getPlayers().get(
                        0).getChips()[4]));
    }

    /**
     * Finishes the round, moving through each computer player
     */
    private void runPlayers() {
        for (int i = 1; i < theModel.getNumPlayers(); i++) {
            if (theModel.getPlayers().get(0).isHasFolded() == true) {
                //TO DO: randomize: check, bet, fold
            }
        }
    }

    /**
     * used to fold for player
     *
     * @param i - which player in array
     */
    private void fold(int i) {
        theModel.getPlayers().get(i).fold();
    }

    /**
     * adjusts the number of players
     */
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

    /**
     * Controls the flip, whenever the dealer flips cards over on the table
     */
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

            cardsOnTable.add(card1);
            cardsOnTable.add(card2);
            cardsOnTable.add(card3);
            tableRound++;
        } //the turn
        else if (tableRound == 1) {
            Card card4 = this.theModel.getTheCardDealer().placeCardsOnTable();
            theGameTable.getTurn().setVisible(true);
            String cardName4 = card4.getName();
            Icon icon4 = new ImageIcon(
                    "src/cardsimage/" + cardName4 + ".png");
            theGameTable.getTurn().setIcon(icon4);
            timer4 = new Timer(1, new Turn());
            timer4.setInitialDelay(0);
            timer4.setRepeats(true);
            timer4.start();

            cardsOnTable.add(card4);
            tableRound++;
        } //the river
        else if (tableRound == 2) {
            Card card5 = this.theModel.getTheCardDealer().placeCardsOnTable();
            theGameTable.getRiver().setVisible(true);
            String cardName5 = card5.getName();
            Icon icon5 = new ImageIcon(
                    "src/cardsimage/" + cardName5 + ".png");
            theGameTable.getRiver().setIcon(icon5);
            timer5 = new Timer(1, new River());
            timer5.setInitialDelay(0);
            timer5.setRepeats(true);
            timer5.start();

            cardsOnTable.add(card5);
            tableRound++;
        }

    }

    /**
     * flips over card 1 for the player
     */
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

    /**
     * flips over card 2 for the player
     */
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

    /**
     * performs movement action for cards
     */
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

    /**
     * performs movement action for cards
     */
    class Turn implements ActionListener {
        public void actionPerformed(ActionEvent e) {
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
            theGameTable.getRiver().setLocation(
                    theGameTable.getRiver().getX() - 1,
                    theGameTable.getRiver().getY());
            if (theGameTable.getRiver().getX() < 700) {
                timer5.stop();
            }
        }
    }

    public GameTable getTheGameTable() {
        return theGameTable;
    }

}
