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

import TableElements.CheckHands;
import TableElements.Player;
import Cards.Card;
import Cards.Deck;
import Cards.Rank;
import Cards.Suits;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lftomazini
 */
public class CheckHandsTest {

    public CheckHandsTest() {
    }

    private int[] chips;
    private ArrayList<Player> playerArray;
    private ArrayList<Card> table;
    private CheckHands check;
    
    @Before
    public void setUp() {
        Deck deck = new Deck();
        deck.createDeck();
        chips = new int[5];
        playerArray = new ArrayList<>();
        table = new ArrayList<>();
        check = new CheckHands();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of checkWinner method, of class CheckHands.
     */
    @Test
    public void testCheckWinner() {
        System.out.println("checkWinner");

        Card card1 = new Card(Rank.EIGHT, Suits.SPADES);
        Card card2 = new Card(Rank.ACE, Suits.DIAMONDS);
        Card card3 = new Card(Rank.TEN, Suits.HEARTS);
        Card card4 = new Card(Rank.NINE, Suits.SPADES);
        Card card5 = new Card(Rank.FOUR, Suits.HEARTS);
        Card card6 = new Card(Rank.FIVE, Suits.HEARTS);
        Card card7 = new Card(Rank.J, Suits.SPADES);
        Card card8 = new Card(Rank.SEVEN, Suits.HEARTS);
        Card card9 = new Card(Rank.Q, Suits.HEARTS);
        Card card10 = new Card(Rank.J, Suits.CLUBS);
        Card card11 = new Card(Rank.FOUR, Suits.SPADES);
        Card card12 = new Card(Rank.EIGHT, Suits.CLUBS);
        Card card13 = new Card(Rank.THREE, Suits.CLUBS);
        Card card14 = new Card(Rank.THREE, Suits.HEARTS);
        Card card15 = new Card(Rank.THREE, Suits.SPADES);

        Player player_1 = new Player(chips, "Todd");
        Player player_2 = new Player(chips, "Jeff");
        Player player_3 = new Player(chips, "Sasha");
        Player player_4 = new Player(chips, "Alisha");
        Player player_5 = new Player(chips, "Raymond");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        player_2.setCard1(card3);
        player_2.setCard2(card4);
        player_3.setCard1(card5);
        player_3.setCard2(card6);
        player_4.setCard1(card7);
        player_4.setCard2(card8);
        player_5.setCard1(card9);
        player_5.setCard2(card10);

        playerArray.add(player_1);
        playerArray.add(player_2);
        playerArray.add(player_3);
        playerArray.add(player_4);
        playerArray.add(player_5);

        addTable(card11,card12, card13, card14, card15);
        
        ArrayList<Player> winner = new ArrayList<>();
        winner.add(player_1);

        check.checkHands(playerArray, table);
        assertEquals(winner, check.checkWinner(playerArray, table));
    }

    /**
     * Test of isFlush method, of class CheckHands.
     */
    @Test
    public void testIsFlush() {
        System.out.println("isFlush");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.THREE, Suits.HEARTS);
        Card card3 = new Card(Rank.J, Suits.HEARTS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.ACE, Suits.HEARTS);
        Card card6 = new Card(Rank.TWO, Suits.DIAMONDS);
        Card card7 = new Card(Rank.J, Suits.CLUBS);

        Player player_1 = new Player(chips, "Raquel");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.isFlush(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of isFlush method, of class CheckHands is false.
     */
    @Test
    public void testIsNotFlush() {
        System.out.println("isNotFlush");


        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.THREE, Suits.HEARTS);
        Card card3 = new Card(Rank.J, Suits.HEARTS);
        Card card4 = new Card(Rank.ACE, Suits.CLUBS);
        Card card5 = new Card(Rank.ACE, Suits.HEARTS);
        Card card6 = new Card(Rank.TWO, Suits.DIAMONDS);
        Card card7 = new Card(Rank.J, Suits.CLUBS);

        Player player_1 = new Player(chips, "Tanya");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.isFlush(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of isStraight method, of class CheckHands.
     */
    @Test
    public void testIsStraight() {
        System.out.println("isStraight");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.Q, Suits.HEARTS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.TEN, Suits.HEARTS);
        Card card6 = new Card(Rank.TWO, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Alexander");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        boolean result = check.isStraight(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of isStraight method, of class CheckHands.
     */
    @Test
    public void testIsNotStraight() {
        System.out.println("isStraight");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.J, Suits.HEARTS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.TEN, Suits.HEARTS);
        Card card6 = new Card(Rank.TWO, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Aram");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.isStraight(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of isFullHouse method, of class CheckHands.
     */
    @Test
    public void testIsFullHouse() {
        System.out.println("isFullHouse");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.K, Suits.CLUBS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.TWO, Suits.HEARTS);
        Card card6 = new Card(Rank.TWO, Suits.DIAMONDS);
        Card card7 = new Card(Rank.TWO, Suits.CLUBS);

        Player player_1 = new Player(chips, "Greg");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.isFullHouse(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of isFullHouse method, of class CheckHands.
     */
    @Test
    public void testIsNotFullHouse() {
        System.out.println("isNotFullHouse");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.Q, Suits.CLUBS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.TWO, Suits.HEARTS);
        Card card6 = new Card(Rank.TWO, Suits.DIAMONDS);
        Card card7 = new Card(Rank.TWO, Suits.CLUBS);

        Player player_1 = new Player(chips, "Frances");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.isFullHouse(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of is2Pairs method, of class CheckHands.
     */
    @Test
    public void testIs2Pairs() {
        System.out.println("is2Pairs");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.K, Suits.CLUBS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.TWO, Suits.HEARTS);
        Card card6 = new Card(Rank.TWO, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Layla");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.is2Pairs(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of is2Pairs method, of class CheckHands.
     */
    @Test
    public void testIsNot2Pairs() {
        System.out.println("isNot2Pairs");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.K, Suits.CLUBS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.TWO, Suits.HEARTS);
        Card card6 = new Card(Rank.FOUR, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Kayla");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.is2Pairs(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of is4OfAKind method, of class CheckHands.
     */
    @Test
    public void testIs4OfAKind() {
        System.out.println("is4OfAKind");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.K, Suits.CLUBS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.K, Suits.SPADES);
        Card card6 = new Card(Rank.K, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Archibald");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.is4OfAKind(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of is4OfAKind method, of class CheckHands.
     */
    @Test
    public void testIsNot4OfAKind() {
        System.out.println("isNot4OfAKind");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.K, Suits.CLUBS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.Q, Suits.SPADES);
        Card card6 = new Card(Rank.K, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Arshjit");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.is4OfAKind(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of is3OfAKind method, of class CheckHands.
     */
    @Test
    public void testIs3OfAKind() {
        System.out.println("is3OfAKind");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.K, Suits.CLUBS);
        Card card3 = new Card(Rank.J, Suits.CLUBS);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.Q, Suits.SPADES);
        Card card6 = new Card(Rank.K, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Manuel");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.is3OfAKind(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of is3OfAKind method, of class CheckHands.
     */
    @Test
    public void testIsNot3OfAKind() {
        System.out.println("isNot3OfAKind");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.J, Suits.CLUBS);
        Card card3 = new Card(Rank.K, Suits.SPADES);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.Q, Suits.SPADES);
        Card card6 = new Card(Rank.J, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Amanda");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.is3OfAKind(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of is2OfAKind method, of class CheckHands.
     */
    @Test
    public void testIs2OfAKind() {
        System.out.println("is2OfAKind");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.J, Suits.CLUBS);
        Card card3 = new Card(Rank.ACE, Suits.SPADES);
        Card card4 = new Card(Rank.ACE, Suits.HEARTS);
        Card card5 = new Card(Rank.Q, Suits.SPADES);
        Card card6 = new Card(Rank.J, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Courtney");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.is2OfAKind(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of is2OfAKind method, of class CheckHands.
     */
    @Test
    public void testIsNot2OfAKind() {
        System.out.println("is2OfAKind");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.J, Suits.CLUBS);
        Card card3 = new Card(Rank.FOUR, Suits.SPADES);
        Card card4 = new Card(Rank.TWO, Suits.HEARTS);
        Card card5 = new Card(Rank.Q, Suits.SPADES);
        Card card6 = new Card(Rank.ACE, Suits.DIAMONDS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "John");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.is2OfAKind(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of isStraightFlush method, of class CheckHands.
     */
    @Test
    public void testIsStraightFlush() {
        System.out.println("isStraightFlush");

        Card card1 = new Card(Rank.FOUR, Suits.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suits.HEARTS);
        Card card3 = new Card(Rank.SIX, Suits.HEARTS);
        Card card4 = new Card(Rank.SEVEN, Suits.HEARTS);
        Card card5 = new Card(Rank.EIGHT, Suits.HEARTS);
        Card card6 = new Card(Rank.K, Suits.CLUBS);
        Card card7 = new Card(Rank.Q, Suits.CLUBS);

        Player player_1 = new Player(chips, "Karl");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        boolean result = check.isStraightFlush(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of isStraightFlush method, of class CheckHands.
     */
    @Test
    public void testIsNotStraightFlush() {
        System.out.println("isNotStraightFlush");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.J, Suits.HEARTS);
        Card card3 = new Card(Rank.Q, Suits.CLUBS);
        Card card4 = new Card(Rank.TEN, Suits.HEARTS);
        Card card5 = new Card(Rank.Q, Suits.SPADES);
        Card card6 = new Card(Rank.ACE, Suits.HEARTS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Nigel");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        check.checkHands(playerArray, table);
        boolean result = check.isStraightFlush(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of isRoyalFlush method, of class CheckHands.
     */
    @Test
    public void testIsRoyalFlush() {
        System.out.println("isRoyalFlush");

        Card card1 = new Card(Rank.K, Suits.HEARTS);
        Card card2 = new Card(Rank.J, Suits.HEARTS);
        Card card3 = new Card(Rank.Q, Suits.HEARTS);
        Card card4 = new Card(Rank.TEN, Suits.HEARTS);
        Card card5 = new Card(Rank.TWO, Suits.SPADES);
        Card card6 = new Card(Rank.ACE, Suits.HEARTS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Thomas");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        boolean result = check.isStraightFlush(player_1, table);
        assertEquals(true, result);
    }

    /**
     * Test of isRoyalFlush method, of class CheckHands.
     */
    @Test
    public void testIsNotRoyalFlush() {
        System.out.println("isNotRoyalFlush");

        Card card1 = new Card(Rank.K, Suits.CLUBS);
        Card card2 = new Card(Rank.J, Suits.HEARTS);
        Card card3 = new Card(Rank.Q, Suits.HEARTS);
        Card card4 = new Card(Rank.TEN, Suits.HEARTS);
        Card card5 = new Card(Rank.TWO, Suits.SPADES);
        Card card6 = new Card(Rank.ACE, Suits.HEARTS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Greg");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);
        
        boolean result = check.isStraightFlush(player_1, table);
        assertEquals(false, result);
    }

    /**
     * Test of getHighCard method, of class CheckHands.
     */
    @Test
    public void testGetHighCard() {
        System.out.println("getHighCard");

        Card card1 = new Card(Rank.K, Suits.CLUBS);
        Card card2 = new Card(Rank.J, Suits.HEARTS);
        Card card3 = new Card(Rank.Q, Suits.HEARTS);
        Card card4 = new Card(Rank.TEN, Suits.HEARTS);
        Card card5 = new Card(Rank.TWO, Suits.SPADES);
        Card card6 = new Card(Rank.ACE, Suits.HEARTS);
        Card card7 = new Card(Rank.THREE, Suits.CLUBS);

        Player player_1 = new Player(chips, "Harry Potter");
        player_1.setCard1(card1);
        player_1.setCard2(card2);
        playerArray.add(player_1);

        addTable(card3,card4, card5, card6, card7);

        Card result = check.getHighCard(player_1, table);
        assertEquals(Rank.ACE, result.getRank());
    }
    
    public void addTable(Card card1, Card card2, Card card3, Card card4, Card card5){
        table.add(card4);
        table.add(card3);
        table.add(card2);
        table.add(card1);
        table.add(card5);
    }
}
