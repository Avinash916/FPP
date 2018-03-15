import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CanActivate,ActivatedRoute,Params } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private auth: AuthService, private router: Router,private activatedRoute: ActivatedRoute) { }

    canActivate() {
        this.activatedRoute.queryParams.subscribe((params: Params) => {
            let authToken:string = params['auth_token'];
            console.log(authToken);
          });
        return true;
        /*if (this.auth.isLoggedIn()) {
            return true;
        } else {
            //this.router.navigateByUrl('/unauthorized');
           // location.href = "http://www.google.com";
            return true;
        }*/
    }
}