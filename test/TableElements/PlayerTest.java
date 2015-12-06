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

import TableElements.Player;
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
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    private Player player;
    
    @Before
    public void setUp() {
        int[] chips = {5, 2, 1, 3 ,1};
        player = new Player(chips,"player");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalChipsValue method, of class Player.
     */
    @Test
    public void testGetTotalChipsValue() {
        System.out.println("getTotalChipsValue");
        int expResult = 200;
        int result = player.getTotalChipsValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChipsFromMoney method, of class Player.
     */
    @Test
    public void testGetChipsFromMoney() {
        System.out.println("getChipsFromMoney");
        player.setMoney(192);
        player.getChipsFromMoney();
        int[] res = player.getChips();
        assertEquals(1, res[4], 1E-10);
        assertEquals(3, res[3], 1E-10);
        assertEquals(1, res[2], 1E-10);
        assertEquals(1, res[1], 1E-10);
        assertEquals(2, res[0], 1E-10);
    }

    /**
     * Test of makeBet method, of class Player.
     */
    @Test
    public void testMakeBet() {
        System.out.println("makeBet");
        int bet = 250;
        int expResult = -1;
        int result = player.makeBet(bet);
        assertEquals(expResult, result, 1E-10);
        
        bet = 75;
        expResult = 75;
        result = player.makeBet(bet);
        assertEquals(expResult, result, 1E-10);
        int money = 125;
        assertEquals(player.getMoney(),money, 1E-10);
    }

    /**
     * Test of call method, of class Player.
     */
    @Test
    public void testCall() {
        System.out.println("Call");
        int bet = 250;
        int expResult = 0;
        player.call(bet);
        assertEquals(player.getMoney(), expResult, 1E-10);
    }

    /**
     * Test of fold method, of class Player.
     */
    @Test
    public void testFold() {
        System.out.println("fold");
        Card card1 = new Card(Rank.ACE, Suits.CLUBS);
        Card card2 = new Card(Rank.EIGHT, Suits.CLUBS);
        player.setCard1(card1);
        player.setCard2(card2);
        assertEquals(player.getCard1(), card1);
        assertEquals(player.getCard2(), card2);
        
        
        player.fold();
        assertEquals(player.isHasFolded(), true);
    }
}
