package com.revature.util;

import com.revature.blackjack.gamelogic.BlackJackGame;

public class DealerThread implements Runnable{

	private BlackJackGame bjg;
	
	@Override
	public void run() {
		bjg.playDealerHand();
	}
	
	public DealerThread(BlackJackGame bjg) {
		this.bjg = bjg;
	}

}
