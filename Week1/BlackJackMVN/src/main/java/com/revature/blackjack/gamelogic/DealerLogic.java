package com.revature.blackjack.gamelogic;

import java.util.List;

import com.revature.blackjack.player.Dealer;

public interface DealerLogic {
	
	public boolean stand(Dealer dealer);
	
	public boolean hit(Dealer dealer, List<Integer> deck);

}
