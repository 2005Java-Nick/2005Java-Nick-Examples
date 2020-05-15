package com.revature.blackjack.gamelogic;

import java.util.List;
import java.util.function.Predicate;

import com.revature.blackjack.exception.ScoreLessThanZeroException;
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
			if(arg.getScore() > 17) {
				if(arg.getScore() > 21) {
					if(arg.reduceAce()) {
						arg.setScore(arg.getScore()-10);
						return false;
					} else {
						return true;
					}
				} else {
					return true;
				}
			} else {
				return false;
			}
		}, dealer);
	}

	@Override
	public boolean hit(Dealer dealer, List<Card> deck) {
		try {
			dealer.drawCard(deck.get(0));
			deck.remove(0);
			System.out.println("The dealer chooses to hit.");
			return true;
		} catch (ScoreLessThanZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
