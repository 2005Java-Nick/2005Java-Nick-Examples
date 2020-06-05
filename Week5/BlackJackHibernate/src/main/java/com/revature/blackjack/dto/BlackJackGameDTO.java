package com.revature.blackjack.dto;

import com.revature.blackjack.domain.BlackJackGame;
import com.revature.blackjack.domain.Dealer;
import com.revature.blackjack.domain.Player;

public class BlackJackGameDTO {
	
	private Player player;
	
	private DealerDTO dealer;
	
	public BlackJackGameDTO(BlackJackGame blackJackGame) {
		this.player = blackJackGame.getPlayer();
		this.dealer = new DealerDTO(blackJackGame.getDealer());
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public DealerDTO getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = new DealerDTO(dealer);
	}
	
	public void setDealer(DealerDTO dealer) {
		this.dealer = dealer;
	}
	
	

}
