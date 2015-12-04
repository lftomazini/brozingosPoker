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
import javax.swing.Timer;

/**
 *
 * @author lbv001
 */
public class ButtonsMovement {
    Timer timerXBig;
    Timer timerYBig;
    Timer timerXSmall;
    Timer timerYSmall;
    static int qXBig = 0;
    static int qYBig = 0;
    static int qXSmall = 0;
    static int qYSmall = 0;
    GameTable theGameTable;
    Model c;
    int numPlayers;

    public ButtonsMovement(GameTable theGameTable, Model c) {
        this.theGameTable = theGameTable;
        this.c = c;
        this.numPlayers = c.getNumPlayers();
    }

    public void buttonsNextPosition() {
        timerXBig = new Timer(1, new MoveBigButtonX());
        timerXBig.start();

        timerYBig = new Timer(1, new MoveBigButtonY());
        timerYBig.start();
        timerXSmall = new Timer(1, new MoveSmallButtonX());
        timerXSmall.start();
        timerYSmall = new Timer(1, new MoveSmallButtonY());
        timerYSmall.start();

    }

    class MoveBigButtonX implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (numPlayers == 3) {
                if (qXBig == 0) {

                    qXBig++;
                    timerXBig.stop();

                } else if (qXBig == 1) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());
                    if (theGameTable.getBigBlind().getX() > 830) {
                        qXBig++;
                        timerXBig.stop();

                    }
                } else if (qXBig == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());
                    ;
                    if (theGameTable.getBigBlind().getX() < 640) {
                        qXBig = 0;
                        timerXBig.stop();

                    }
                }

            } else if (numPlayers == 4) {
                if (qXBig == 0) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() < 340) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 1) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() > 580) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());
                    ;
                    if (theGameTable.getBigBlind().getX() > 830) {
                        qXBig++;
                        timerXBig.stop();
                    }

                } else if (qXBig == 3) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() < 640) {
                        qXBig = 0;
                        timerXBig.stop();
                    }

                }
            } else if (numPlayers == 5) {
                if (qXBig == 0) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() < 360) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 1) {

                    qXBig++;
                    timerXBig.stop();

                } else if (qXBig == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() > 640) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 3) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() > 830) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 4) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() < 640) {
                        qXBig = 0;
                        timerXBig.stop();
                    }
                }
            }
            if (numPlayers == 6) {
                if (qXBig == 0) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() < 360) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 1) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());
                    ;
                    if (theGameTable.getBigBlind().getX() < 250) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() > 360) {
                        qXBig++;
                        timerXBig.stop();
                    }

                } else if (qXBig == 3) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() > 580) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 4) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() + 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() > 830) {
                        qXBig++;
                        timerXBig.stop();
                    }
                } else if (qXBig == 5) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX() - 1,
                            theGameTable.getBigBlind().getY());

                    if (theGameTable.getBigBlind().getX() < 640) {
                        qXBig = 0;
                        timerXBig.stop();
                    }

                }
            }
        }

    }

    class MoveBigButtonY implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (numPlayers == 3) {
                if (qYBig == 0) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() - 1);

                    if (theGameTable.getBigBlind().getY() < 230) {
                        qYBig++;
                        timerYBig.stop();

                    }
                } else if (qYBig == 1) {

                    qYBig++;
                    timerYBig.stop();

                } else if (qYBig == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() + 1);
                    if (theGameTable.getBigBlind().getY() > 400) {
                        qYBig = 0;
                        timerYBig.stop();
                    }

                }
            } else if (numPlayers == 4) {
                if (qYBig == 0) {

                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() - 1);

                    if (theGameTable.getBigBlind().getY() < 230) {
                        qYBig++;
                        timerYBig.stop();
                    }
                } else if (qYBig == 1) {
                    qYBig++;
                    timerYBig.stop();

                } else if (qYBig == 2) {
                    qYBig++;
                    timerYBig.stop();
                } else if (qYBig == 3) {

                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() + 1);
                    if (theGameTable.getBigBlind().getY() > 400) {
                        qYBig = 0;
                        timerYBig.stop();

                    }
                }
            } else if (numPlayers == 5) {
                if (qYBig == 0) {

                    qYBig++;
                    timerYBig.stop();

                } else if (qYBig == 1) {

                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() - 1);
                    if (theGameTable.getBigBlind().getY() < 230) {
                        qYBig++;

                        timerYBig.stop();
                    }
                } else if (qYBig == 2) {

                    qYBig++;
                    timerYBig.stop();

                } else if (qYBig == 3) {
                    qYBig++;
                    timerYBig.stop();
                } else if (qYBig == 4) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() + 1);
                    if (theGameTable.getBigBlind().getY() > 400) {
                        qYBig = 0;
                        timerYBig.stop();

                    }
                }
            } else if (numPlayers == 6) {
                if (qYBig == 0) {

                    qYBig++;
                    timerYBig.stop();

                } else if (qYBig == 1) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() - 1);
                    if (theGameTable.getBigBlind().getY() < 320) {
                        qYBig++;
                        timerYBig.stop();

                    }
                } else if (qYBig == 2) {
                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() - 1);

                    if (theGameTable.getBigBlind().getY() < 230) {
                        qYBig++;
                        timerYBig.stop();

                    }
                } else if (qYBig == 3) {

                    qYBig++;
                    timerYBig.stop();

                } else if (qYBig == 4) {

                    qYBig++;
                    timerYBig.stop();;

                } else if (qYBig == 5) {

                    theGameTable.getBigBlind().setLocation(
                            theGameTable.getBigBlind().getX(),
                            theGameTable.getBigBlind().getY() + 1);
                    if (theGameTable.getBigBlind().getY() > 400) {
                        qYBig = 0;
                        timerYBig.stop();

                    }
                }
            }

        }

    }

    class MoveSmallButtonX implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (numPlayers == 3) {
                if (qXSmall == 0) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 640) {
                        qXSmall++;
                        timerXSmall.stop();
                    }

                } else if (qXSmall == 1) {

                    qXSmall++;
                    timerXSmall.stop();

                } else if (qXSmall == 2) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 830) {
                        qXSmall = 0;
                        timerXSmall.stop();

                    }
                }

            } else if (numPlayers == 4) {
                if (qXSmall == 0) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 640) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 1) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 370) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 2) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 530) {
                        qXSmall++;
                        timerXSmall.stop();
                    }

                } else if (qXSmall == 3) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 830) {
                        qXSmall = 0;
                        timerXSmall.stop();
                    }

                }
            } else if (numPlayers == 5) {
                if (qXSmall == 0) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 640) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 1) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 360) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 2) {

                    qXSmall++;
                    timerXSmall.stop();

                } else if (qXSmall == 3) {
                    ;
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 640) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 4) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 830) {
                        qXSmall = 0;
                        timerXSmall.stop();
                    }
                }
            }
            if (numPlayers == 6) {
                if (qXSmall == 0) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 640) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 1) {
                    ;
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 360) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 2) {
                    ;
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() - 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() < 250) {
                        qXSmall++;
                        timerXSmall.stop();
                    }

                } else if (qXSmall == 3) {
                    ;
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 360) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 4) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 580) {
                        qXSmall++;
                        timerXSmall.stop();
                    }
                } else if (qXSmall == 5) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX() + 1,
                            theGameTable.getSmallBlind().getY());
                    if (theGameTable.getSmallBlind().getX() > 830) {
                        qXSmall = 0;
                        timerXSmall.stop();
                    }

                }
            }
        }

    }

    class MoveSmallButtonY implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (numPlayers == 3) {
                if (qYSmall == 0) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() + 1);

                    if (theGameTable.getSmallBlind().getY() > 400) {
                        qYSmall++;
                        timerYSmall.stop();

                    }
                } else if (qYSmall == 1) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() - 1);
                    if (theGameTable.getSmallBlind().getY() < 230) {
                        qYSmall++;
                        timerYSmall.stop();
                    }

                } else if (qYSmall == 2) {

                    qYSmall = 0;
                    timerYSmall.stop();

                }
            } else if (numPlayers == 4) {
                if (qYSmall == 0) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() + 1);

                    if (theGameTable.getSmallBlind().getY() > 400) {
                        qYSmall++;
                        timerYSmall.stop();
                    }
                } else if (qYSmall == 1) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() - 1);
                    if (theGameTable.getSmallBlind().getY() < 230) {
                        qYSmall++;
                        timerYSmall.stop();
                    }
                } else if (qYSmall == 2) {
                    qYSmall++;
                    timerYSmall.stop();
                } else if (qYSmall == 3) {

                    qYSmall = 0;
                    timerYSmall.stop();

                }
            } else if (numPlayers == 5) {
                if (qYSmall == 0) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() + 1);
                    if (theGameTable.getSmallBlind().getY() > 400) {

                        qYSmall++;
                        timerYSmall.stop();
                    }
                } else if (qYSmall == 1) {

                    qYSmall++;

                    timerYSmall.stop();

                } else if (qYSmall == 2) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() - 1);
                    if (theGameTable.getSmallBlind().getY() < 230) {
                        qYSmall++;
                        timerYSmall.stop();;
                    }

                } else if (qYSmall == 3) {
                    qYSmall++;
                    timerYSmall.stop();
                } else if (qYSmall == 4) {
                    {
                        qYSmall = 0;
                        timerYSmall.stop();

                    }
                }
            } else if (numPlayers == 6) {
                if (qYSmall == 0) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() + 1);
                    if (theGameTable.getSmallBlind().getY() > 400) {

                        qYSmall++;
                        timerYSmall.stop();
                    }

                } else if (qYSmall == 1) {

                    qYSmall++;
                    timerYSmall.stop();

                } else if (qYSmall == 2) {

                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() - 1);
                    if (theGameTable.getSmallBlind().getY() < 310) {
                        qYSmall++;
                        timerYSmall.stop();

                    }
                } else if (qYSmall == 3) {
                    theGameTable.getSmallBlind().setLocation(
                            theGameTable.getSmallBlind().getX(),
                            theGameTable.getSmallBlind().getY() - 1);

                    if (theGameTable.getSmallBlind().getY() < 230) {
                        qYSmall++;
                        timerYSmall.stop();
                    }
                } else if (qYSmall == 4) {

                    qYSmall++;
                    timerYSmall.stop();

                } else if (qYSmall == 5) {

                    {
                        qYSmall = 0;
                        timerYSmall.stop();

                    }
                }

            }

        }

    }
}
