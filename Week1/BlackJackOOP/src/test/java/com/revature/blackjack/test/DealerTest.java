package com.revature.blackjack.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.blackjack.exception.ScoreLessThanZeroException;
import com.revature.blackjack.player.Dealer;

public class DealerTest {
	
	private Dealer dealer;
	private static final int FIRST_CARD = 3;
	private static final int SECOND_CARD = 7;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dealer = new Dealer();
		dealer.setName("Bill");
		dealer.drawCard(0, FIRST_CARD);
		dealer.drawCard(1, SECOND_CARD);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetScore() {
		assertEquals("Dealer with cards 3 and 7 should have a score of 10", 10, dealer.getScore());
	}
	
	@Test(expected = ScoreLessThanZeroException.class)
	public void testDrawNegativeValueCard() throws ScoreLessThanZeroException {
		dealer.drawCard(2, -20);
	}

}
