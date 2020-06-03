import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../environments/environment';
import { BlackJackGame } from '../types/BlackJackGame';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private readonly createGameUrl = environment.serviceUrl + environment.createGameEndpoint;

  private readonly username = 'DoomSlayer';

  public createNewGame(): Observable<BlackJackGame> {
    return this.http.post<BlackJackGame>(this.createGameUrl,
      '',
      {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }
      });
  }

  constructor(private http: HttpClient) { }
}
