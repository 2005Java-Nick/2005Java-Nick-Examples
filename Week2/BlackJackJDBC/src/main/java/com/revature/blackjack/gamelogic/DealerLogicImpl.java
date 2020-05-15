package com.revature.blackjack.gamelogic;

import java.util.List;
import java.util.function.Predicate;

import com.revature.blackjack.player.Dealer;
import com.revature.util.Card;

public class DealerLogicImpl /* <T extends Player> */ implements DealerLogic {

	/*
	 * @Override public boolean stand(Dealer dealer) { return checkScore((arg) -> {
	 * return arg.getScore() > 17 ? true : false; }, dealer); }
	 */

	@Override
	public boolean stand(Dealer dealer) {
		return checkScore((arg) -> {
			return arg.getScore() > 17 ? true : false;
		}, dealer);
	}

	@Override
	public boolean hit(Dealer dealer, List<Card> deck) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * private boolean checkScore(Predicate<T> p, Dealer d) { return p.test((T) d);
	 * }
	 */

	private boolean checkScore(Predicate<Dealer> p, Dealer d) {
		return p.test(d);
	}
}
