import { Component, OnInit } from '@angular/core';
import { BlackJackGame } from 'src/app/types/BlackJackGame';
import { GameService } from 'src/app/service/game.service';

@Component({
  selector: 'app-black-jack-game',
  templateUrl: './black-jack-game.component.html',
  styleUrls: ['./black-jack-game.component.css']
})
export class BlackJackGameComponent implements OnInit {

  game: BlackJackGame;

  constructor(private gameService: GameService) { }

  setNewGame() {
    this.gameService.createNewGame().subscribe(
      (game) => { console.log(game); }
    );
  }

  ngOnInit(): void {
  }

}
