package com.revature.blackjack.test;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.revature.blackjack.player.Dealer;


public class DealerTest {
	
	private Dealer dealer;
	private static final int[] FIRST_CARD = {1,2,3,4,5,6,7,8,9,10};
	private static final int[] SECOND_CARD = {4,2,3,4,7,6,7,8,9,5};
	private static final int[] EXPECTED_SUM = {7,4,6,8,12,13,14,16,18,15};
    private static int testIndex;

    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testIndex=0;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dealer = new Dealer();
		dealer.setName("Bill");
		dealer.drawCard(0, FIRST_CARD[testIndex]);
		dealer.drawCard(1, SECOND_CARD[testIndex]);
	}

	@After
	public void tearDown() throws Exception {
		testIndex++;
	}
	
	@Test
	public void testGetScore1() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	
	@Test
	public void testGetScore2() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	@Test
	public void testGetScore3() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	@Test
	public void testGetScore4() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	@Test
	public void testGetScore5() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	@Test
	public void testGetScore6() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	@Test
	public void testGetScore7() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	@Test
	public void testGetScore8() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	@Test
	public void testGetScore9() {
		assertEquals("Dealer with cards "+FIRST_CARD[testIndex]+" and "+SECOND_CARD[testIndex]+" should have a score of "+EXPECTED_SUM[testIndex], EXPECTED_SUM[testIndex], dealer.getScore());
	}
	
}
