import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

authenticate(username, password)
{
  console.log('Username : ', username);
  console.log('Password : ', password);
}


  constructor() { }
}
