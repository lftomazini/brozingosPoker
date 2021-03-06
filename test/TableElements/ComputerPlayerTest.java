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
package TableElements;

import Cards.Card;
import Cards.Rank;
import Cards.Suits;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author as062
 */
public class ComputerPlayerTest {

    public ComputerPlayerTest() {
    }

    private ComputerPlayer instance;

    @Before
    public void setUp() {
        int[] chips = {5, 2, 1, 3, 2};
        instance = new ComputerPlayer(chips, "player");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of playBet method, of class ComputerPlayer.
     */
    @Test
    public void testPlayBet() {
        System.out.println("playBet");
        int betAmount = 220;
        instance.setMoney(280);
        Card cd1 = new Card(Rank.FIVE, Suits.CLUBS);
        Card cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(true, instance.isHasFolded());
        
        instance.setMoney(300);
        cd1 = new Card(Rank.FIVE, Suits.CLUBS);
        cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(20, instance.getMoney());
        
        instance.setMoney(300);
        cd1 = new Card(Rank.NINE, Suits.HEARTS);
        cd2 = new Card(Rank.NINE, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(20, instance.getMoney());
        
        instance.setMoney(300);
        cd1 = new Card(Rank.THREE, Suits.HEARTS);
        cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(20, instance.getMoney());
        
        instance.setMoney(300);
        cd1 = new Card(Rank.THREE, Suits.HEARTS);
        cd2 = new Card(Rank.FIVE, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(300, instance.getMoney());
        
        instance.setMoney(300);
        cd1 = new Card(Rank.J, Suits.HEARTS);
        cd2 = new Card(Rank.SEVEN, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(80, instance.getMoney());
        
        instance.setMoney(150);
        betAmount = 100;
        cd1 = new Card(Rank.FIVE, Suits.CLUBS);
        cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(50, instance.getMoney());
        
        instance.setMoney(150);
        cd1 = new Card(Rank.NINE, Suits.HEARTS);
        cd2 = new Card(Rank.NINE, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(50, instance.getMoney());
        
        instance.setMoney(150);
        cd1 = new Card(Rank.THREE, Suits.HEARTS);
        cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(50, instance.getMoney());
        
        instance.setMoney(150);
        cd1 = new Card(Rank.J, Suits.HEARTS);
        cd2 = new Card(Rank.SEVEN, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(150, instance.getMoney());
        
        instance.setMoney(40);
        betAmount = 20;
        cd1 = new Card(Rank.NINE, Suits.HEARTS);
        cd2 = new Card(Rank.NINE, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(20, instance.getMoney());
        
        instance.setMoney(40);
        cd1 = new Card(Rank.J, Suits.HEARTS);
        cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(20, instance.getMoney());
        
        instance.setMoney(40);
        cd1 = new Card(Rank.NINE, Suits.HEARTS);
        cd2 = new Card(Rank.J, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playBet(betAmount);
        assertEquals(40, instance.getMoney());
    }

    /**
     * Test of playNoBet method, of class ComputerPlayer.
     */
    @Test
    public void testPlayNoBet() {
        System.out.println("playNoBet");
        
        instance.setMoney(320);
        Card cd1 = new Card(Rank.FIVE, Suits.CLUBS);
        Card cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playNoBet();
        assertEquals(240, instance.getMoney());
        
        instance.setMoney(320);
        cd1 = new Card(Rank.NINE, Suits.HEARTS);
        cd2 = new Card(Rank.NINE, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playNoBet();
        assertEquals(240, instance.getMoney());
        
        instance.setMoney(320);
        cd1 = new Card(Rank.THREE, Suits.HEARTS);
        cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playNoBet();
        assertEquals(240, instance.getMoney());
        
        instance.setMoney(320);
        cd1 = new Card(Rank.THREE, Suits.HEARTS);
        cd2 = new Card(Rank.FIVE, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playNoBet();
        assertEquals(320, instance.getMoney());
        
        instance.setMoney(150);
        cd1 = new Card(Rank.J, Suits.HEARTS);
        cd2 = new Card(Rank.SEVEN, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playNoBet();
        assertEquals(150, instance.getMoney());
        
        instance.setMoney(40);
        cd1 = new Card(Rank.NINE, Suits.HEARTS);
        cd2 = new Card(Rank.J, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        instance.playNoBet();
        assertEquals(40, instance.getMoney());
        instance.playNoBet();
    }

    /**
     * Test of enoughMoney method, of class ComputerPlayer.
     */
    @Test
    public void testEnoughMoney() {
        System.out.println("enoughMoney");
        boolean expResult = true;
        boolean result = instance.enoughMoney();
        assertEquals(expResult, result);

        instance.setMoney(100);
        result = instance.enoughMoney();
        assertEquals(false, result);
    }

    /**
     * Test of littleMoney method, of class ComputerPlayer.
     */
    @Test
    public void testLittleMoney() {
        System.out.println("littleMoney");
        instance.setMoney(40);
        boolean expResult = true;
        boolean result = instance.littleMoney();
        assertEquals(expResult, result);

        instance.setMoney(200);
        assertEquals(false, instance.littleMoney());
    }

    /**
     * Test of hasPair method, of class ComputerPlayer.
     */
    @Test
    public void testHasPair() {
        System.out.println("hasPair");
        Card cd1 = new Card(Rank.ACE, Suits.CLUBS);
        Card cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        boolean expResult = false;
        boolean result = instance.hasPair();
        assertEquals(expResult, result);

        cd1 = new Card(Rank.K, Suits.HEARTS);
        cd2 = new Card(Rank.K, Suits.DIAMONDS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        assertEquals(true, instance.hasPair());
    }

    /**
     * Test of sameSuit method, of class ComputerPlayer.
     */
    @Test
    public void testSameSuit() {
        System.out.println("sameSuit");

        Card cd1 = new Card(Rank.ACE, Suits.CLUBS);
        Card cd2 = new Card(Rank.K, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        boolean expResult = true;
        boolean result = instance.sameSuit();
        assertEquals(expResult, result);

        cd1 = new Card(Rank.K, Suits.HEARTS);
        cd2 = new Card(Rank.K, Suits.DIAMONDS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        assertEquals(false, instance.sameSuit());
    }

    /**
     * Test of highCardK method, of class ComputerPlayer.
     */
    @Test
    public void testHighCardK() {
        System.out.println("highCardK");

        Card cd1 = new Card(Rank.Q, Suits.CLUBS);
        Card cd2 = new Card(Rank.TWO, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        boolean expResult = false;
        boolean result = instance.highCardK();
        assertEquals(expResult, result);

        cd1 = new Card(Rank.K, Suits.HEARTS);
        cd2 = new Card(Rank.Q, Suits.DIAMONDS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        assertEquals(true, instance.highCardK());
    }

    /**
     * Test of highCardIsNotJ method, of class ComputerPlayer.
     */
    @Test
    public void testHighCardNotJ() {
        System.out.println("highCardNotJ");

        Card cd1 = new Card(Rank.Q, Suits.CLUBS);
        Card cd2 = new Card(Rank.TWO, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);

        boolean expResult = false;
        boolean result = instance.highCardIsNotJ();
        assertEquals(expResult, result);

        cd1 = new Card(Rank.TWO, Suits.HEARTS);
        cd2 = new Card(Rank.NINE, Suits.DIAMONDS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        assertEquals(true, instance.highCardIsNotJ());
    }

    /**
     * Test of lowCardJ method, of class ComputerPlayer.
     */
    @Test
    public void testLowCardJ() {
        System.out.println("lowCardJ");

        Card cd1 = new Card(Rank.Q, Suits.CLUBS);
        Card cd2 = new Card(Rank.J, Suits.CLUBS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        boolean expResult = false;
        boolean result = instance.lowCardJ();
        assertEquals(expResult, result);

        cd1 = new Card(Rank.TWO, Suits.HEARTS);
        cd2 = new Card(Rank.NINE, Suits.DIAMONDS);
        instance.setCard1(cd1);
        instance.setCard2(cd2);
        assertEquals(true, instance.lowCardJ());
    }

}
