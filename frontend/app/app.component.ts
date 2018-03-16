<<<<<<< HEAD
import { Component } from '@angular/core';
=======
import { Component,OnInit } from '@angular/core';
import { ServiceConsumer } from './service-consumer.service';
import { AppConfig } from './app-config';
import { environment } from '../environments/environment';
import { AuthService } from './authentication/auth.service';

>>>>>>> ssointegration

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
<<<<<<< HEAD
export class AppComponent {
  title = 'app';
=======
export class AppComponent implements OnInit {
  title = 'app';
  constructor(public serviceConsumer:ServiceConsumer)
  {
  }
  ngOnInit()
  {
    AppConfig.PFJApiUrl = environment.apiurl;
    console.log("received from environment "+AppConfig.PFJApiUrl);
  }
>>>>>>> ssointegration
}
