import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ssologin',
  templateUrl: './ssologin.component.html',
  styleUrls: ['./ssologin.component.css']
})
export class SSOLoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    location.href = 'http://spring-saml-sample.herokuapp.com';
  }

}
