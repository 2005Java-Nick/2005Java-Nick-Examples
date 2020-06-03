import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Player } from '../types/Player';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private readonly LOGIN_URL = environment.serviceUrl + environment.loginEndpoint;

  authenticate(username, password) {
    return this.http.post<Player>(
      this.LOGIN_URL,
      'username=' + username, {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
      }
    });
  }


  constructor(private http: HttpClient) { }
}
