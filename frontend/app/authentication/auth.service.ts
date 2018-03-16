import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { tokenNotExpired } from 'angular2-jwt';

@Injectable()
export class AuthService {

  constructor(private http: Http) {}

  login(authToken:any) {
    localStorage.setItem('auth_token', authToken);
  }

  logout()
  {
    localStorage.removeItem('auth_token'); 
  }

  isLoggedIn()
  {
    //return tokenNotExpired();
    return localStorage.getItem("auth_token") == 'true'
  }

}