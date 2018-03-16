import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from './auth.service';
import { AuthGuard } from './auth-guard.service';
import { LoginComponent } from './login/login.component';
import { SSOLoginComponent } from './ssologin/ssologin.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [LoginComponent, SSOLoginComponent],
  providers: [ AuthService, AuthGuard]
})
export class AuthenticationModule { }
