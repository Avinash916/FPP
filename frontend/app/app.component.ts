import { Component } from '@angular/core';
import { ServiceConsumer } from './service-consumer.service';
import { AppConfig } from './app-config';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  constructor(public serviceConsumer:ServiceConsumer)
  {
  }
}
