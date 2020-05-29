import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  authenticate()
  {
    this.authenticationService.authenticate(this.username, this.password);
  }

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
  }

}
