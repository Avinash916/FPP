import { Component,OnInit } from '@angular/core';
import { ServiceConsumer } from './service-consumer.service';
import { AppConfig } from './app-config';
import { environment } from '../environments/environment';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
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
}
