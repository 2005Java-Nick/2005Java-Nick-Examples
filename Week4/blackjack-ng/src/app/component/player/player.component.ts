import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/types/Player';
import { PlayerService } from 'src/app/service/player.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  player: Player;

  constructor(private playerService: PlayerService) {
    setInterval(() => {this.player = this.playerService.getCurrentPlayer(); }, 500);
  }

  ngOnInit(): void {
  }

}
