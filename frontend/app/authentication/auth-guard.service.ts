import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CanActivate,ActivatedRoute,Params,ActivatedRouteSnapshot  } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private auth: AuthService, private router: Router,private activatedRoute: ActivatedRoute) { }

    canActivate(route: ActivatedRouteSnapshot) {
        
       /* if(String(route.queryParams.isAuthenticated).toUpperCase() == 'TRUE')
        {
            //this.router.navigate(['/pfj-overview'], { skipLocationChange: true});
            return true;
        }
        else
        {
            console.log(route.queryParams.isAuthenticated);
            this.router.navigateByUrl('/login');
            return false;
        }*/
        return true;
        
       /* let isValidLogin:boolean = false;
        this.activatedRoute.queryParams.subscribe((params: Params) => {
            let authToken:boolean = params['isAuthenticated'];
            if(authToken)
            {
                isValidLogin = true;
            }
            else
            {
                isValidLogin = false;
            }
          });*/
       
        /*if (this.auth.isLoggedIn()) {
            return true;
        } else {
            //this.router.navigateByUrl('/unauthorized');
           // location.href = "http://www.google.com";
            return true;
        }*/
    }
}