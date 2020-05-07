package com.revature.blackjack.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.blackjack.gamelogic.BlackJackGameImpl;
import com.revature.blackjack.gamelogic.DealerLogic;
import com.revature.blackjack.player.Dealer;

@RunWith(MockitoJUnitRunner.class)
public class BlackJackGameTest {
	
	private BlackJackGameImpl blackJackGame;
	
	private Dealer dealer;
	
	int[] deck;
	
	@Mock
	DealerLogic dealerLogic;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		blackJackGame = new BlackJackGameImpl();
		
		deck = new int[]{3, 8, 10, 5};
		blackJackGame.setDeck(deck);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void playDealerHandTest() {
		dealer = new Dealer("Bill", 20, new int[] {10,10});
		blackJackGame.setDealer(dealer);
		when(dealerLogic.stand(dealer)).thenReturn(true);
		blackJackGame.setDealerLogic(dealerLogic);
		blackJackGame.playDealerHand();
		verify(dealerLogic).stand(dealer);
		verifyNoMoreInteractions(dealerLogic);
		
	}
	
	@Test
	public void playDealerHandHitTest() {
		dealer = new Dealer("Bill", 15, new int[] {10,5});
		blackJackGame.setDealer(dealer);
		when(dealerLogic.stand(dealer)).thenReturn(false);
		blackJackGame.setDealerLogic(dealerLogic);
		blackJackGame.playDealerHand();
		verify(dealerLogic).stand(dealer);
		verify(dealerLogic).hit(dealer, deck);
	}

}
