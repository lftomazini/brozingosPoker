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

import TableElements.CardDealer;
import TableElements.Player;
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
    
    private ArrayList<Player> players = new ArrayList<>();
    private CardDealer instance;
    
    @Before
    public void setUp() {
        int[] chips = {1,2,3,4,5};
        Player player1 = new Player(chips, "p1");
        Player player2 = new Player(chips, "p2");
        Player player3 = new Player(chips, "p3");
        Player player4 = new Player(chips, "p4");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        Deck deck = new Deck();
        deck.createDeck();
        instance = new CardDealer(deck, players);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRandom method, of class CardDealer.
     */
    @Test
    public void testGetRandom() {
        System.out.println("getRandom");
        int[] arr = new int[52];
        for (int i = 0; i < 52; i++) {
            arr[i] = instance.getRandom();
        }
        int result = 1;
        for (int j = 0; j < 52; j++) {
            for (int k = 0; k < 52; k++) {
                if (arr[j] == arr[k] && j!=k) {
                    result = 0;
                }
            }
        }
        int expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of giveCardstoPlayers method, of class CardDealer.
     */
    @Test
    public void testGiveCardstoPlayers() {
        System.out.println("giveCardstoPlayers");
        instance.giveCardstoPlayers();
        assertFalse(instance.getPlayers().get(0).getCard1() == null);
        assertFalse(instance.getPlayers().get(0).getCard2() == null);
        assertFalse(instance.getPlayers().get(1).getCard1() == null);
        assertFalse(instance.getPlayers().get(1).getCard2() == null);
        assertFalse(instance.getPlayers().get(2).getCard1() == null);
        assertFalse(instance.getPlayers().get(2).getCard2() == null);
        assertFalse(instance.getPlayers().get(3).getCard1() == null);
        assertFalse(instance.getPlayers().get(3).getCard2() == null);
    }

    /**
     * Test of placeCardsOnTable method, of class CardDealer.
     */
    @Test
    public void testPlaceCardsOnTable() {
        System.out.println("placeCardsOnTable");
        Card cd1 = instance.placeCardsOnTable();
        Card cd2 = instance.placeCardsOnTable();
        
        
        assertEquals(instance.getCardsChosen().size(), 2);
        assertFalse(cd1 == null);
        assertFalse(cd2 == null);
    }

    /**
     * Test of newRound method, of class CardDealer.
     */
    @Test
    public void testNewRound() {
        System.out.println("newRound");
        instance.placeCardsOnTable();
        instance.giveCardstoPlayers();
        assertFalse(instance.getCardsOnTable().get(0) == null);
        assertFalse(instance.getCardsChosen().get(0) == null);
        assertEquals(instance.getRounds(), 0);
        
        instance.newRound();
        
        assertEquals(instance.getCardsChosen().size(), 0);
        assertEquals(instance.getCardsOnTable().size(), 0);
        assertEquals(instance.getRounds(), 1);
        
    }
    
}
