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
package csci205finalproject;

import Cards.Card;
import Cards.Deck;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author as062
 */
public class CardDealerTest {
    
    public CardDealerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCardsOnTable method, of class CardDealer.
     */
    @Test
    public void testSetCardsOnTable() {
        System.out.println("setCardsOnTable");
        ArrayList<Card> cardsOnTable = null;
        CardDealer instance = null;
        instance.setCardsOnTable(cardsOnTable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class CardDealer.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        CardDealer instance = null;
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRounds method, of class CardDealer.
     */
    @Test
    public void testGetRounds() {
        System.out.println("getRounds");
        CardDealer instance = null;
        int expResult = 0;
        int result = instance.getRounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeck method, of class CardDealer.
     */
    @Test
    public void testGetDeck() {
        System.out.println("getDeck");
        CardDealer instance = null;
        Deck expResult = null;
        Deck result = instance.getDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardsChosen method, of class CardDealer.
     */
    @Test
    public void testGetCardsChosen() {
        System.out.println("getCardsChosen");
        CardDealer instance = null;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getCardsChosen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardsOnTable method, of class CardDealer.
     */
    @Test
    public void testGetCardsOnTable() {
        System.out.println("getCardsOnTable");
        CardDealer instance = null;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getCardsOnTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandom method, of class CardDealer.
     */
    @Test
    public void testGetRandom() {
        System.out.println("getRandom");
        CardDealer instance = null;
        int expResult = 0;
        int result = instance.getRandom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of giveCardstoPlayers method, of class CardDealer.
     */
    @Test
    public void testGiveCardstoPlayers() {
        System.out.println("giveCardstoPlayers");
        CardDealer instance = null;
        instance.giveCardstoPlayers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of placeCardsOnTable method, of class CardDealer.
     */
    @Test
    public void testPlaceCardsOnTable() {
        System.out.println("placeCardsOnTable");
        CardDealer instance = null;
        Card expResult = null;
        Card result = instance.placeCardsOnTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newRound method, of class CardDealer.
     */
    @Test
    public void testNewRound() {
        System.out.println("newRound");
        CardDealer instance = null;
        instance.newRound();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
