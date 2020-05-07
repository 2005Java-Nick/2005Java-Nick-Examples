package com.revature.blackjack.gamelogic;

import com.revature.blackjack.player.Dealer;

public interface DealerLogic {
	
	public boolean stand(Dealer dealer);
	
	public boolean hit(Dealer dealer, int[] deck);

}
