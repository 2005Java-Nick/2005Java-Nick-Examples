import { Component, ViewChildren, QueryList } from '@angular/core';
import { HandComponent } from './component/hand/hand.component';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'My Awesome BlackJack App!!!!!!!';

  constructor(private http: HttpClient) {

   }

onClick1(){
  this.http.get("url").toPromise().then(data => {
    console.log(data);
  });
}

}
