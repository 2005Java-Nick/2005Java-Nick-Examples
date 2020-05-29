import { Component, OnInit } from '@angular/core';
import { BlackJackGame } from 'src/app/types/BlackJackGame';
import { GameService } from 'src/app/service/game.service';
import { PlayerService } from 'src/app/service/player.service';

@Component({
  selector: 'app-black-jack-game',
  templateUrl: './black-jack-game.component.html',
  styleUrls: ['./black-jack-game.component.css']
})
export class BlackJackGameComponent implements OnInit {

  game: BlackJackGame;

  gameReady = false;

  constructor(private gameService: GameService, private playerService: PlayerService) { }

  setNewGame() {
    this.gameService.createNewGame().subscribe(
      (game) => {
        this.game = game;
        this.gameReady = true;
        this.playerService.setCurrentPlayer(game.player);
      }
    );
  }

  ngOnInit(): void {
    this.setNewGame();
  }

}
