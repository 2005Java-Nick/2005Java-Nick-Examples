import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { PlayerService } from 'src/app/service/player.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  authenticate()
  {
    this.authenticationService.authenticate(this.username, this.password).subscribe(
      (player) => {this.playerService.setCurrentPlayer(player); }
    );
  }

  constructor(private authenticationService: AuthenticationService, private playerService: PlayerService) { }

  ngOnInit(): void {
  }

}
