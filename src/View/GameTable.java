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
package View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author sag033
 */
public class GameTable extends javax.swing.JFrame {

    /**
     * Creates new form GameTable
     */
    public GameTable() throws IOException {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        foldCheckBetGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        winnerPanel = new javax.swing.JPanel();
        stateWinnerL = new javax.swing.JLabel();
        playAgainB = new javax.swing.JButton();
        exitB = new javax.swing.JButton();
        yourMoneyL = new javax.swing.JLabel();
        foldCheckBet = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        doneFCB = new javax.swing.JButton();
        foldRB = new javax.swing.JRadioButton();
        checkRB = new javax.swing.JRadioButton();
        betRB = new javax.swing.JRadioButton();
        betSl = new javax.swing.JSlider();
        betValue = new javax.swing.JLabel();
        setBlindsPan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        doneButton = new javax.swing.JButton();
        dontPay = new javax.swing.JButton();
        flop = new javax.swing.JLabel();
        turn = new javax.swing.JLabel();
        river = new javax.swing.JLabel();
        deck = new javax.swing.JLabel();
        card1b = new javax.swing.JButton();
        card2b = new javax.swing.JButton();
        p2c1 = new javax.swing.JLabel();
        p2c2 = new javax.swing.JLabel();
        p3c1 = new javax.swing.JLabel();
        p3c2 = new javax.swing.JLabel();
        p4c1 = new javax.swing.JLabel();
        p4c2 = new javax.swing.JLabel();
        p5c1 = new javax.swing.JLabel();
        p5c2 = new javax.swing.JLabel();
        p6c1 = new javax.swing.JLabel();
        p6c2 = new javax.swing.JLabel();
        whiteChip1 = new javax.swing.JLabel();
        blackChip1 = new javax.swing.JLabel();
        redChip1 = new javax.swing.JLabel();
        greenChip1 = new javax.swing.JLabel();
        blueChip1 = new javax.swing.JLabel();
        flip = new javax.swing.JButton();
        smallBlind = new javax.swing.JButton();
        Buttons = new javax.swing.JButton();
        player1 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        player3 = new javax.swing.JLabel();
        player4 = new javax.swing.JLabel();
        player5 = new javax.swing.JLabel();
        player6 = new javax.swing.JLabel();
        flop2 = new javax.swing.JLabel();
        flop1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameInfoTA = new javax.swing.JTextArea();
        givecards = new javax.swing.JButton();
        card1label = new javax.swing.JLabel();
        card2label = new javax.swing.JLabel();
        bigBlind = new javax.swing.JButton();
        blackChipImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(1300, 818));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        winnerPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        winnerPanel.setLayout(null);

        stateWinnerL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stateWinnerL.setText("State Winner");
        winnerPanel.add(stateWinnerL);
        stateWinnerL.setBounds(10, 20, 230, 30);

        playAgainB.setText("Play Again?");
        winnerPanel.add(playAgainB);
        playAgainB.setBounds(60, 80, 130, 50);

        exitB.setText("Exit");
        winnerPanel.add(exitB);
        exitB.setBounds(60, 140, 130, 50);

        yourMoneyL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yourMoneyL.setText("Your Money");
        winnerPanel.add(yourMoneyL);
        yourMoneyL.setBounds(0, 40, 250, 50);

        jPanel1.add(winnerPanel);
        winnerPanel.setBounds(20, 510, 250, 210);

        foldCheckBet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        foldCheckBet.setLayout(null);

        jLabel3.setText("Would you like to:");
        foldCheckBet.add(jLabel3);
        jLabel3.setBounds(20, 10, 130, 20);

        doneFCB.setText("Done");
        doneFCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneFCBActionPerformed(evt);
            }
        });
        foldCheckBet.add(doneFCB);
        doneFCB.setBounds(20, 140, 170, 40);

        foldCheckBetGroup.add(foldRB);
        foldRB.setText("Fold?");
        foldRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foldRBActionPerformed(evt);
            }
        });
        foldCheckBet.add(foldRB);
        foldRB.setBounds(20, 40, 57, 22);

        foldCheckBetGroup.add(checkRB);
        checkRB.setText("Check?");
        foldCheckBet.add(checkRB);
        checkRB.setBounds(20, 70, 70, 22);

        foldCheckBetGroup.add(betRB);
        betRB.setSelected(true);
        betRB.setText("Bet?");
        foldCheckBet.add(betRB);
        betRB.setBounds(20, 100, 53, 22);

        betSl.setMajorTickSpacing(10);
        betSl.setMinorTickSpacing(5);
        betSl.setSnapToTicks(true);
        betSl.setToolTipText("");
        foldCheckBet.add(betSl);
        betSl.setBounds(100, 80, 110, 70);

        betValue.setText("Bet Value");
        foldCheckBet.add(betValue);
        betValue.setBounds(130, 70, 80, 20);

        jPanel1.add(foldCheckBet);
        foldCheckBet.setBounds(360, 580, 220, 200);

        setBlindsPan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setBlindsPan.setLayout(null);

        jLabel2.setText("Pay Big Blind ($20)?:");
        setBlindsPan.add(jLabel2);
        jLabel2.setBounds(40, 30, 170, 15);

        doneButton.setText("Yes!");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });
        setBlindsPan.add(doneButton);
        doneButton.setBounds(60, 60, 80, 40);

        dontPay.setText("Fold");
        dontPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dontPayActionPerformed(evt);
            }
        });
        setBlindsPan.add(dontPay);
        dontPay.setBounds(60, 110, 80, 40);

        jPanel1.add(setBlindsPan);
        setBlindsPan.setBounds(300, 250, 210, 200);

        flop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(flop);
        flop.setBounds(910, 290, 70, 100);

        turn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(turn);
        turn.setBounds(910, 290, 70, 100);

        river.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(river);
        river.setBounds(910, 290, 70, 100);

        deck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(deck);
        deck.setBounds(1000, 290, 70, 100);

        card1b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        card1b.setBorderPainted(false);
        card1b.setContentAreaFilled(false);
        jPanel1.add(card1b);
        card1b.setBounds(570, 460, 83, 112);

        card2b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        card2b.setBorderPainted(false);
        card2b.setContentAreaFilled(false);
        jPanel1.add(card2b);
        card2b.setBounds(650, 460, 83, 112);

        p2c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back-2.jpg"))); // NOI18N
        jPanel1.add(p2c1);
        p2c1.setBounds(130, 180, 120, 110);

        p2c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back-2.jpg"))); // NOI18N
        jPanel1.add(p2c2);
        p2c2.setBounds(130, 270, 130, 110);

        p3c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(p3c1);
        p3c1.setBounds(280, 470, 71, 100);

        p3c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(p3c2);
        p3c2.setBounds(360, 470, 71, 100);

        p4c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(p4c1);
        p4c1.setBounds(280, 140, 71, 100);

        p4c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(p4c2);
        p4c2.setBounds(370, 140, 71, 100);

        p5c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(p5c1);
        p5c1.setBounds(580, 130, 71, 100);

        p5c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(p5c2);
        p5c2.setBounds(660, 130, 71, 100);

        p6c1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(p6c1);
        p6c1.setBounds(870, 130, 71, 100);

        p6c2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(p6c2);
        p6c2.setBounds(950, 130, 70, 100);

        whiteChip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        whiteChip1.setText("10");
        whiteChip1.setOpaque(true);
        jPanel1.add(whiteChip1);
        whiteChip1.setBounds(1120, 760, 80, 30);

        blackChip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blackChip1.setText("6 ");
        blackChip1.setOpaque(true);
        jPanel1.add(blackChip1);
        blackChip1.setBounds(1120, 550, 80, 30);

        redChip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        redChip1.setText("4");
        redChip1.setOpaque(true);
        jPanel1.add(redChip1);
        redChip1.setBounds(1120, 710, 80, 30);

        greenChip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        greenChip1.setText("2");
        greenChip1.setOpaque(true);
        jPanel1.add(greenChip1);
        greenChip1.setBounds(1120, 610, 80, 30);

        blueChip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blueChip1.setText("2");
        blueChip1.setOpaque(true);
        jPanel1.add(blueChip1);
        blueChip1.setBounds(1120, 660, 80, 30);

        flip.setText("Flip Card");
        jPanel1.add(flip);
        flip.setBounds(780, 550, 100, 30);

        smallBlind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Small-Blind-Button-SY-Q58DONE-.png"))); // NOI18N
        smallBlind.setContentAreaFilled(false);
        jPanel1.add(smallBlind);
        smallBlind.setBounds(810, 230, 70, 60);

        Buttons.setText("buttons?");
        jPanel1.add(Buttons);
        Buttons.setBounds(780, 700, 110, 50);

        player1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1.setText("Player 1");
        player1.setOpaque(true);
        jPanel1.add(player1);
        player1.setBounds(620, 700, 90, 30);

        player2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2.setText("Player 2");
        player2.setOpaque(true);
        jPanel1.add(player2);
        player2.setBounds(280, 660, 90, 30);

        player3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player3.setText("Player 3");
        player3.setOpaque(true);
        jPanel1.add(player3);
        player3.setBounds(20, 230, 90, 30);

        player4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player4.setText("Player 4");
        player4.setOpaque(true);
        jPanel1.add(player4);
        player4.setBounds(310, 80, 90, 30);

        player5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player5.setText("Player 5");
        player5.setOpaque(true);
        jPanel1.add(player5);
        player5.setBounds(600, 80, 90, 30);

        player6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player6.setText("Player 6");
        player6.setOpaque(true);
        jPanel1.add(player6);
        player6.setBounds(900, 80, 90, 30);

        flop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(flop2);
        flop2.setBounds(910, 290, 70, 100);

        flop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(flop1);
        flop1.setBounds(910, 290, 70, 100);

        gameInfoTA.setEditable(false);
        gameInfoTA.setColumns(20);
        gameInfoTA.setRows(5);
        gameInfoTA.setText("Welcome to Brozingo's Texas Hold Em!");
        jScrollPane1.setViewportView(gameInfoTA);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(920, 390, 310, 140);

        givecards.setText("jButton1");
        jPanel1.add(givecards);
        givecards.setBounds(790, 440, 66, 27);

        card1label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(card1label);
        card1label.setBounds(570, 460, 71, 100);

        card2label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing-card-back.jpg"))); // NOI18N
        jPanel1.add(card2label);
        card2label.setBounds(660, 470, 70, 100);

        bigBlind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bigblinddone.png"))); // NOI18N
        bigBlind.setContentAreaFilled(false);
        jPanel1.add(bigBlind);
        bigBlind.setBounds(680, 400, 70, 70);

        blackChipImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blackChip.png"))); // NOI18N
        jPanel1.add(blackChipImage);
        blackChipImage.setBounds(1060, 540, 50, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/greenChip.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1060, 590, 50, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blueChip.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1060, 640, 50, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/redChip.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(1060, 690, 50, 50);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/whiteChip.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(1060, 740, 50, 50);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pokertableNew.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jLabel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void flipActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doneButtonActionPerformed

    private void doneFCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneFCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doneFCBActionPerformed

    private void foldRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foldRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foldRBActionPerformed

    private void dontPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dontPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dontPayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameTable.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameTable.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameTable.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameTable.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GameTable().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GameTable.class.getName()).log(Level.SEVERE,
                                                                    null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buttons;
    private javax.swing.JRadioButton betRB;
    private javax.swing.JSlider betSl;
    private javax.swing.JLabel betValue;
    private javax.swing.JButton bigBlind;
    private javax.swing.JLabel blackChip1;
    private javax.swing.JLabel blackChipImage;
    private javax.swing.JLabel blueChip1;
    private javax.swing.JButton card1b;
    private javax.swing.JLabel card1label;
    private javax.swing.JButton card2b;
    private javax.swing.JLabel card2label;
    private javax.swing.JRadioButton checkRB;
    private javax.swing.JLabel deck;
    private javax.swing.JButton doneButton;
    private javax.swing.JButton doneFCB;
    private javax.swing.JButton dontPay;
    private javax.swing.JButton exitB;
    private javax.swing.JButton flip;
    private javax.swing.JLabel flop;
    private javax.swing.JLabel flop1;
    private javax.swing.JLabel flop2;
    private javax.swing.JPanel foldCheckBet;
    private javax.swing.ButtonGroup foldCheckBetGroup;
    private javax.swing.JRadioButton foldRB;
    private javax.swing.JTextArea gameInfoTA;
    private javax.swing.JButton givecards;
    private javax.swing.JLabel greenChip1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel p2c1;
    private javax.swing.JLabel p2c2;
    private javax.swing.JLabel p3c1;
    private javax.swing.JLabel p3c2;
    private javax.swing.JLabel p4c1;
    private javax.swing.JLabel p4c2;
    private javax.swing.JLabel p5c1;
    private javax.swing.JLabel p5c2;
    private javax.swing.JLabel p6c1;
    private javax.swing.JLabel p6c2;
    private javax.swing.JButton playAgainB;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JLabel player3;
    private javax.swing.JLabel player4;
    private javax.swing.JLabel player5;
    private javax.swing.JLabel player6;
    private javax.swing.JLabel redChip1;
    private javax.swing.JLabel river;
    private javax.swing.JPanel setBlindsPan;
    private javax.swing.JButton smallBlind;
    private javax.swing.JLabel stateWinnerL;
    private javax.swing.JLabel turn;
    private javax.swing.JLabel whiteChip1;
    private javax.swing.JPanel winnerPanel;
    private javax.swing.JLabel yourMoneyL;
    // End of variables declaration//GEN-END:variables

    public JButton getFlip() {
        return flip;
    }

    public JLabel getFlop() {
        return flop;
    }

    public JLabel getFlop1() {
        return flop1;
    }

    public JLabel getFlop2() {
        return flop2;
    }

    public JLabel getRiver() {
        return river;
    }

    public JLabel getTurn() {
        return turn;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JButton getCard1b() {
        return card1b;
    }

    public JButton getCard2b() {
        return card2b;
    }

    public JLabel getDeck() {
        return deck;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getP2c1() {
        return p2c1;
    }

    public JLabel getP2c2() {
        return p2c2;
    }

    public JLabel getP3c1() {
        return p3c1;
    }

    public JLabel getP3c2() {
        return p3c2;
    }

    public JLabel getP4c1() {
        return p4c1;
    }

    public JLabel getP4c2() {
        return p4c2;
    }

    public JLabel getP5c1() {
        return p5c1;
    }

    public JLabel getP5c2() {
        return p5c2;
    }

    public JLabel getP6c1() {
        return p6c1;
    }

    public JLabel getP6c2() {
        return p6c2;
    }

    public JPanel getSetBlindsPan() {
        return setBlindsPan;
    }

    public JLabel getBlackChip1() {
        return blackChip1;
    }

    public JLabel getBlueChip1() {
        return blueChip1;
    }

    public JButton getDoneButton() {
        return doneButton;
    }

    public JLabel getGreenChip1() {
        return greenChip1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getRedChip1() {
        return redChip1;
    }

    public JLabel getWhiteChip1() {
        return whiteChip1;
    }

    public JButton getDontPay() {
        return dontPay;
    }

    public JRadioButton getBetRB() {
        return betRB;
    }

    public JRadioButton getCheckRB() {
        return checkRB;
    }

    public JButton getDoneButton1() {
        return doneFCB;
    }

    public JPanel getFoldCheckBet() {
        return foldCheckBet;
    }

    public ButtonGroup getFoldCheckBetGroup() {
        return foldCheckBetGroup;
    }

    public JRadioButton getFoldRB() {
        return foldRB;
    }

    public JButton getBigBlind() {
        return bigBlind;
    }

    public JButton getButtons() {
        return Buttons;
    }

    public JButton getSmallBlind() {
        return smallBlind;
    }

    public JButton getDoneFCB() {
        return doneFCB;
    }

    public JButton getExitB() {
        return exitB;
    }

    public JButton getPlayAgainB() {
        return playAgainB;
    }

    public JPanel getWinnerPanel() {
        return winnerPanel;
    }

    public JLabel getStateWinnerL() {
        return stateWinnerL;
    }

    public JLabel getYourMoneyL() {
        return yourMoneyL;
    }

    public JLabel getPlayer1() {
        return player1;
    }

    public JLabel getPlayer2() {
        return player2;
    }

    public JLabel getPlayer3() {
        return player3;
    }

    public JLabel getPlayer4() {
        return player4;
    }

    public JLabel getPlayer5() {
        return player5;
    }

    public JLabel getPlayer6() {
        return player6;
    }

    public JSlider getBetSl() {
        return betSl;
    }

    public JLabel getBetValue() {
        return betValue;
    }

    public JTextArea getGameInfoTA() {
        return gameInfoTA;
    }

    public JButton getGivecards() {
        return givecards;
    }

    public JLabel getCard1label() {
        return card1label;
    }

    public JLabel getCard2label() {
        return card2label;
    }

}
