package com.revature.blackjack.gamelogic;

import java.util.List;

import com.revature.blackjack.player.Dealer;
import com.revature.util.Card;

public interface DealerLogic {
	
	public boolean stand(Dealer dealer);
	
	public boolean hit(Dealer dealer, List<Card> deck);

}
