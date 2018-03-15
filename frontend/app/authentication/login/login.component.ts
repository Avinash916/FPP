import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import {Router, ActivatedRoute, Params} from '@angular/router';
import { AppConfig } from '../../app-config';

@Component({
  selector: 'app-login',
  template: `
    <p>
      login Works!
    </p>
  `,
  styles: []
})
export class LoginComponent implements OnInit {

  constructor(public authService: AuthService,private activatedRoute: ActivatedRoute,private router:Router) { }

  ngOnInit() {
    if (!this.authService.isLoggedIn()) {
      this.activatedRoute.queryParams.subscribe((params: Params) => {
        let authToken:string = params['auth_token'];
        this.authService.login(authToken);
      });
    }
    this.router.navigate(['/pfj-overview']);
  }
}
