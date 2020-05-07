package com.revature.blackjack.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.revature.blackjack.gamelogic.BlackJackGameImpl;
import com.revature.blackjack.player.Dealer;

@RunWith(MockitoJUnitRunner.class)
public class BlackJackGameTest {
	
	private BlackJackGameImpl blackJackGame;
	
	private Dealer dealer;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		blackJackGame = new BlackJackGameImpl();
		
		int[] deck = {3, 8, 10, 5};
		blackJackGame.setDeck(deck);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void playDealerHandTest() {
		dealer = new Dealer("Bill", 20, new int[] {10,10});
		blackJackGame.setDealer(dealer);
		blackJackGame.playDealerHand();
		
	}

}
