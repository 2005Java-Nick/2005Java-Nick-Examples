import { Injectable } from '@angular/core';
import { Player } from '../types/Player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  currentPlayer: Player;

  setCurrentPlayer(player: Player): void {
    this.currentPlayer = player;
  }

  getCurrentPlayer(): Player {
    return this.currentPlayer;
  }

  constructor() { }
}
