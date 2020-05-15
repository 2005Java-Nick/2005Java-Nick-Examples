package com.revature.blackjack.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.revature.util.Card;

@RunWith(MockitoJUnitRunner.class)
public class BlackJackGameTest {
	
	private BlackJackGameImpl blackJackGame;
	
	private Dealer dealer;
	
	List<Card> deck;
	
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
		
		blackJackGame = (BlackJackGameImpl) BlackJackGameImpl.getBlackJackGame();
		
		deck = new ArrayList<Card>();
		deck.add(new Card(3));
		deck.add(new Card(8));
		deck.add(new Card(10));
		deck.add(new Card(5));
		blackJackGame.setDeck(deck);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void playDealerHandTest() {
		List<Integer> hand = new ArrayList<Integer>();
		hand.add(10);
		hand.add(10);
		dealer = new Dealer("Bill", 20, hand);
		blackJackGame.setDealer(dealer);
		when(dealerLogic.stand(dealer)).thenReturn(true);
		blackJackGame.setDealerLogic(dealerLogic);
		blackJackGame.playDealerHand();
		verify(dealerLogic).stand(dealer);
		verifyNoMoreInteractions(dealerLogic);
		
	}
	
	@Test
	public void playDealerHandHitTest() {
		List<Integer> hand = new ArrayList<Integer>();
		hand.add(10);
		hand.add(5);
		dealer = new Dealer("Bill", 20, hand);
		blackJackGame.setDealer(dealer);
		when(dealerLogic.stand(dealer)).thenReturn(false);
		blackJackGame.setDealerLogic(dealerLogic);
		blackJackGame.playDealerHand();
		verify(dealerLogic).stand(dealer);
		verify(dealerLogic).hit(dealer, deck);
	}

}
