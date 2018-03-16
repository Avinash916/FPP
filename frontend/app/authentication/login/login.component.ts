import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import {Router, ActivatedRoute, Params} from '@angular/router';
import { AppConfig } from '../../app-config';

@Component({
  selector: 'app-login',
  template: `
    <p style="font-weight:bold;color:#FFF;font-size:30px;">
      Unauthorized !
    </p>
  `,
  styles: []
})
export class LoginComponent implements OnInit {

  constructor(public authService: AuthService,private activatedRoute: ActivatedRoute,private router:Router) { }

  ngOnInit() {
   /* if (!this.authService.isLoggedIn()) {
      this.activatedRoute.queryParams.subscribe((params: Params) => {
        let authToken:string = params['auth_token'];
        this.authService.login(authToken);
      });
    }
    this.router.navigate(['/pfj-overview']);*/
    //location.href = "http://www.google.com";
    this.router.navigate(['/pfj-overview']);

    this.activatedRoute.queryParams.subscribe((params: Params) => {
      let isAuthenticated = params['isAuthenticated'];
      this.authService.login(isAuthenticated);
      if(this.authService.isLoggedIn())
      {
        
      }
      else
      {
       // location.href = "http://www.google.com";
        console.log("unauthorized");
      }
    });
  }
}
