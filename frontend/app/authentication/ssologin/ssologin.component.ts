import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ssologin',
  templateUrl: './ssologin.component.html',
  styleUrls: ['./ssologin.component.css']
})
export class SSOLoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    location.href = 'https://spring-saml-sample.herokuapp.com/saml/discovery?entityID=https%3A%2F%2Fspring-saml-sample.herokuapp.com&returnIDParam=idp';
  }

}
