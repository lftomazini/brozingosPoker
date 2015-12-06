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

import Animations.FlipCards;
import Animations.RoundEnd;
import Animations.RoundStart;
import Cards.Card;
import Cards.Deck;
import Model.Model;
import TableElements.CardDealer;
import TableElements.CheckHands;
import TableElements.GameClass;
import TableElements.Player;
import View.GameTable;
import View.PokerHands;
import View.StartScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author sag033
 */
public class Controller implements ActionListener, ChangeListener {

    StartScreen startScreen;
    Model theModel;
    GameTable theGameTable;

    PokerHands thePokerHands;
    JLabel flop;
    JLabel flop1;
    JLabel flop2;
    Timer timer3;
    Timer timer2;
    Timer timer1;
    Timer timer4;
    Timer timer5;

    RoundEnd MoveEnd;
    FlipCards FlipCards;
    RoundStart RoundStart;

    boolean onCard1 = false;
    boolean onCard2 = false;
    int numPlayers;
    int[] chips1 = {10, 6, 4, 2, 2};
    int tableRound = 0;
    int playerBigBlind = 0;
    int playerSmallBlind = 2;
    int bigBlind = 20;
    int smallBlind = 10;
    int paidSmallBlind = 0;

    int betValue = 0; //holds value of what the bet is up to
    String[] flipNames = {"The Flop", "The Turn", "The River", "The Showdown"};
    String[] computerNames = {"Ethan Deck", "Ryan Bling", "Phil Ivey", "Patrik Antonius", "jungleman12"};
    ArrayList<Card> cardsOnTable = new ArrayList<>();
    int moneyPool = 0;

    public Controller() {
    }

    public Controller(StartScreen startScreen, Model theModel) throws IOException {
        this.startScreen = startScreen;
        this.theModel = theModel;
        this.theGameTable = new GameTable();
        this.thePokerHands = new PokerHands();
        this.startScreen.getStart().addActionListener(this);
        this.theGameTable.getFlip().addActionListener(this);
        this.theGameTable.getCard1b().addActionListener(this);
        this.theGameTable.getCard2b().addActionListener(this);
        this.theGameTable.getGivecards().addActionListener(this);
        this.theGameTable.getFlop().setVisible(false);
        this.theGameTable.getFlop1().setVisible(false);
        this.theGameTable.getFlop2().setVisible(false);
        this.theGameTable.getTurn().setVisible(false);
        this.theGameTable.getRiver().setVisible(false);
        this.theGameTable.getFlip().setVisible(false);
        this.theGameTable.getCard1label().setVisible(false);
        this.theGameTable.getCard2label().setVisible(false);
        this.theGameTable.getWinnerPanel().setVisible(false);
        this.theGameTable.getFoldCheckBet().setVisible(false);
        this.theGameTable.getDontPay().setVisible(false);
        this.theGameTable.getButtons().addActionListener(this);
        this.theGameTable.getBetRB().addActionListener(this);
        this.theGameTable.getFoldRB().addActionListener(this);
        this.theGameTable.getCheckRB().addActionListener(this);
        this.theGameTable.getDoneButton().addActionListener(this);
        this.theGameTable.getDoneFCB().addActionListener(this);
        this.theGameTable.getDontPay().addActionListener(this);
        this.theGameTable.getPlayAgainB().addActionListener(this);
        this.theGameTable.getExitB().addActionListener(this);
        this.theGameTable.getBetSl().addChangeListener((ChangeListener) this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == theGameTable.getButtons()) {
            MoveEnd = new RoundEnd(theGameTable, theModel
            );

            MoveEnd.endRound();
        }
        if (e.getSource() == theGameTable.getGivecards()) {
            RoundStart = new RoundStart(theGameTable, theModel);
            RoundStart.StartRound();
        }

        if (e.getSource() == startScreen.getStart()) {
            startScreen.setVisible(false);
            numPlayers = startScreen.getNumPlayers().getSelectedIndex();
            checkNumPlayers();

            theGameTable.setLocationRelativeTo(null);
            theGameTable.setVisible(true);
            thePokerHands.setLocationRelativeTo(null);
            thePokerHands.setVisible(true);

            numPlayers = startScreen.getNumPlayers().getSelectedIndex();
            checkNumPlayers();
            theModel.setNumPlayers(numPlayers);
            ArrayList<Player> players = new ArrayList<Player>();
            players.add(new Player(chips1, startScreen.getNameField().getText()));
            for (int i = 0; i < numPlayers - 1; i++) {
                players.add(new Player(chips1, computerNames[i]));
            }

            theModel.setPlayers(players);

            theModel.setTheCardDealer(new CardDealer(theModel.getDeck(),
                                                     theModel.getPlayers()));
            theModel.setTheGameClass(new GameClass(theModel.getPlayers(), 10,
                                                   20));
            theModel.getTheCardDealer().giveCardstoPlayers();

            adjustPlayerVisibility();

            theModel.getPlayers().get(0).setBigBlind(true);
            theModel.getPlayers().get(2).setSmallBlind(true);

            MoveEnd = new RoundEnd(theGameTable, theModel
            );
            RoundStart = new RoundStart(theGameTable, theModel);
        }

        //If they pay the big blind
        if (e.getSource()
            == theGameTable.getDoneButton()) {
            theGameTable.getSetBlindsPan().setVisible(false);

            payBlinds();
        }

        if (e.getSource()
            == theGameTable.getDontPay()) {
            theGameTable.getSetBlindsPan().setVisible(false);
            theModel.getPlayers().get(0).setHasFolded(true);
            payBlinds();
        }

        /**
         * Flips cards over
         */
        if (e.getSource()
            == theGameTable.getFlip()) {

            flip();
            theGameTable.getFlip().setVisible(false);
            this.theGameTable.getFlip().setText(flipNames[tableRound]);
            if (tableRound < 3) {
                for (int i = 0; i < theModel.getPlayers().size(); i++) {
                    int playerTurn = (bigBlind + i) % theModel.getPlayers().size();
                    if (playerTurn == 0) {
                        if ((theModel.getPlayers().get(0).isHasFolded() == false) & (tableRound < 3)) {
                            adjustBetSlider(0);
                            theGameTable.getFoldCheckBet().setVisible(true);
                        }

                    } else {
                        //TO DO
//                        theGameTable.getGameInfoTA().append("\n"
//                                                            + theModel.getPlayers().get(
//                                        i).getName() + " has folded/checked/bet.");

                    }
                }
                theGameTable.getFlip().setVisible(true);

            } else if (tableRound == 3) {
                try {
                    showdown();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controller.class.getName()).log(
                            Level.SEVERE,
                            null, ex);
                }
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

                theGameTable.getGameInfoTA().append("\nYou have folded");

            } //Player checks
            else if (theGameTable.getCheckRB().isSelected() == true) {
                theGameTable.getGameInfoTA().append("\nYou have checked");
            } //Player bets!
            else if (theGameTable.getBetRB().isSelected() == true) {
                betValue = theGameTable.getBetSl().getValue();
                theModel.getPlayers().get(0).call(
                        betValue);
                theModel.getPlayers().get(0).getChipsFromMoney();
                moneyPool += betValue;
                updateCoins();
                theGameTable.getGameInfoTA().append(
                        "\nyou have bet $" + Integer.toString(betValue));
            }
            theGameTable.getFoldCheckBet().setVisible(false);
            theGameTable.getFlip().setVisible(true);
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

            MoveEnd.endRound();
            RoundStart.StartRound();
            theModel.getPlayers().get(playerSmallBlind).setSmallBlind(false);
            theModel.getPlayers().get(playerBigBlind).setBigBlind(false);
            tableRound = 0;
            moneyPool = 0;
            paidSmallBlind = 0;
            betValue = 0;
            cardsOnTable.clear();
            playerBigBlind = changeBlinds(playerBigBlind);
            playerSmallBlind = changeBlinds(playerSmallBlind);
            System.out.println("small blind " + playerSmallBlind);
            System.out.println("big blind " + playerBigBlind);
            theModel.setDeck(new Deck());
            for (int i = 0; i < theModel.getPlayers().size(); i++) {
                theModel.getPlayers().get(i).setCard1(null);
                theModel.getPlayers().get(i).setCard2(null);
                theModel.getPlayers().get(i).setHasFolded(false);
            }
            theModel.getTheCardDealer().giveCardstoPlayers();
            theModel.getPlayers().get(playerSmallBlind).setSmallBlind(true);
            theModel.getPlayers().get(playerBigBlind).setBigBlind(true);
            if (playerSmallBlind == 0) {
                theGameTable.getjLabel2().setText("Pay Small Blind ($10)?");
            } else {
                theGameTable.getjLabel2().setText("Pay Big Blind ($20)?");
            }

            theGameTable.getWinnerPanel().setVisible(false);
            theGameTable.getSetBlindsPan().setVisible(true);

        }

        if (e.getSource()
            == theGameTable.getExitB()) {
            System.exit(0);

        }

    }

    /**
     * Goes through all players and determines whether or not they pay, or do
     * not pay the blinds
     */
    private void payBlinds() {
        if (paidSmallBlind == 1) {
            if (theModel.getPlayers().get(playerSmallBlind).isHasFolded() == false) {
                theModel.getPlayers().get(playerSmallBlind).call(smallBlind);
                theModel.getPlayers().get(playerSmallBlind).getChipsFromMoney();
                moneyPool += smallBlind;
                theGameTable.getGameInfoTA().append(
                        "\n " + theModel.getPlayers().get(playerSmallBlind).getName() + " has paid the small blind.");
            }
            updateCoins();
            this.theGameTable.getFlip().setText(flipNames[tableRound]);
            this.theGameTable.getFlip().setVisible(true);
        } else {
            for (int i = 0; i < theModel.getPlayers().size(); i++) {
                int playerTurn = (smallBlind + i) % theModel.getPlayers().size();
                //We will pay small blind, don't fold
                if ((theModel.getPlayers().get(playerTurn).isSmallBlind() == true) & (theModel.getPlayers().get(
                                                                                      playerTurn).isHasFolded() == false)) {
                    theModel.getPlayers().get(playerTurn).call(smallBlind);
                    theModel.getPlayers().get(playerTurn).getChipsFromMoney();
                    moneyPool += smallBlind;
                    theGameTable.getGameInfoTA().append(
                            "\n " + theModel.getPlayers().get(playerTurn).getName() + " has paid the small blind.");

                } else if (theModel.getPlayers().get(playerTurn).isHasFolded() == true) {

                    theGameTable.getGameInfoTA().append(
                            "\n " + theModel.getPlayers().get(playerTurn).getName() + " has folded.");
                } else {
                    theModel.getPlayers().get(playerTurn).call(bigBlind);
                    theModel.getPlayers().get(playerTurn).getChipsFromMoney();
                    moneyPool += bigBlind;
                    theGameTable.getGameInfoTA().append(
                            "\n " + theModel.getPlayers().get(playerTurn).getName() + " has paid the big blind.");
                }

            }

            if ((theModel.getPlayers().get(0).isSmallBlind() == true) & (paidSmallBlind == 0)) {
                paidSmallBlind += 1;
                theGameTable.getDontPay().setVisible(true);
                theGameTable.getSetBlindsPan().setVisible(true);
            } else if ((playerSmallBlind != 0) & (theModel.getPlayers().get(
                                                  playerSmallBlind).isHasFolded() == false)) {
                theModel.getPlayers().get(playerSmallBlind).call(smallBlind);
                theModel.getPlayers().get(playerSmallBlind).getChipsFromMoney();
                moneyPool += smallBlind;
                theGameTable.getGameInfoTA().append(
                        "\n " + theModel.getPlayers().get(playerSmallBlind).getName() + " has paid the small blind.");
                this.theGameTable.getFlip().setText(flipNames[tableRound]);
                this.theGameTable.getFlip().setVisible(true);
            } else {
                this.theGameTable.getFlip().setText(flipNames[tableRound]);
                this.theGameTable.getFlip().setVisible(true);
            }
        }
    }

    /**
     * Adjusts what players are visible based on numPlayers
     */
    private void adjustPlayerVisibility() {
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
    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == theGameTable.getBetSl()) {
            theGameTable.getBetValue().setText(Integer.toString(
                    theGameTable.getBetSl().getValue()));
        }
    }

    private void adjustBetSlider(int index) {
        theGameTable.getBetSl().setMaximum(theModel.getPlayers().get(
                index).getMoney());
        theGameTable.getBetSl().setMinimum(betValue);
    }

    /**
     * circulates who in the player array pays which blind
     *
     * @param blind - big or small
     */
    private int changeBlinds(int blind) {
        if (blind == (theModel.getPlayers().size() - 1)) {
            blind = 0;
        } else {
            blind += 1;
        }
        return blind;
    }

    /**
     * completes the functionality of the showdown
     */
    private void showdown() throws InterruptedException {
        CheckHands showdown = new CheckHands();
        showdown.checkHands(theModel.getPlayers(), cardsOnTable);
        ArrayList<Player> winner = new ArrayList();
        winner = showdown.checkWinner(theModel.getPlayers(),
                                      cardsOnTable);
        int winnerIndex = 0;
        for (int i = 1; i < theModel.getNumPlayers(); i++) {
            if (winner.get(0).getName() == theModel.getPlayers().get(i).getName()) {
                winnerIndex = i;
            }
        }

        theModel.getPlayers().get(winnerIndex).call(moneyPool);
        theModel.getPlayers().get(winnerIndex).getChipsFromMoney();
        updateCoins();

        if (theModel.getPlayers().get(0).getMoney() == 0) {
            theGameTable.getStateWinnerL().setText(
                    "The Winner is " + winner.get(0).getName());
            theGameTable.getYourMoneyL().setText(
                    "You ran out of money! You lose!");
            theGameTable.getPlayAgainB().setVisible(false);
            theGameTable.getWinnerPanel().setVisible(true);
            //Thread.sleep(4000);
            //exit(0);
        } else {
            theGameTable.getStateWinnerL().setText(
                    "The Winner is " + winner.get(0).getName());
            theGameTable.getYourMoneyL().setText(
                    "Your Money: $" + Integer.toString(
                            theModel.getPlayers().get(0).getMoney()));

            theGameTable.getWinnerPanel().setVisible(true);
        }

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
     * used to fold for player
     *
     * @param i - which player in array
     */
    private void fold(int i) {
        theModel.getPlayers().get(i).fold();
        MoveEnd.playerFold(theModel.getPlayers(), i);
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
    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;

    /**
     * Controls the flip, whenever the dealer flips cards over on the table
     */
    void flip() {
        //the flop
        if (tableRound == 0) {
            card1 = this.theModel.getTheCardDealer().placeCardsOnTable();
            card2 = this.theModel.getTheCardDealer().placeCardsOnTable();
            card3 = this.theModel.getTheCardDealer().placeCardsOnTable();
            card4 = this.theModel.getTheCardDealer().placeCardsOnTable();
            card5 = this.theModel.getTheCardDealer().placeCardsOnTable();
            cardsOnTable.add(card1);
            cardsOnTable.add(card2);
            cardsOnTable.add(card3);
            FlipCards = new FlipCards(theGameTable, card1, card2, card3, card4,
                                      card5);
            FlipCards.flop();
            tableRound++;

        } //the turn
        else if (tableRound == 1) {
            FlipCards.turn();
            cardsOnTable.add(card4);
            tableRound++;
        } //the river
        else if (tableRound == 2) {
            FlipCards.river();
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
