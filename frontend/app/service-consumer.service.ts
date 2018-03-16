import { Injectable } from '@angular/core';
<<<<<<< HEAD
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { AppConfig } from './app-config';
=======
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { AppConfig } from './app-config';
import { HttpHeaders } from '@angular/common/http';
>>>>>>> ssointegration

@Injectable()
export class ServiceConsumer {

  constructor(private http:Http) { }

<<<<<<< HEAD
  GetCustomerPricingDetails():Observable<any>
  {
    console.log(AppConfig.PFJApiUrl+"/customerpricing/getprices");
    return this.http.get(AppConfig.PFJApiUrl+"/customerpricing/getprices")
=======
  GetHerokuEnvVariables(appName:string)
  {
    let headersHeroku = new Headers({ 'Accept': 'application/vnd.heroku+json; version=3','Authorization': "Bearer "+'102f78a7-fadd-435a-9127-ec7a94e3ef5f' });
    let options = new RequestOptions({ headers: headersHeroku });
    return this.http.get("https://api.heroku.com/apps/"+appName+"/config-vars",options)
    .map(res => res.json())
    .catch((error:any)=>Observable.throw(error.json().error || 'Server Error'));
  }

  GetCustomerPricingDetails():Observable<any>
  {
    //console.log(AppConfig.PFJApiUrl);
    return this.http.get(AppConfig.PFJApiUrl+"pfjoverview/getdashboard")
>>>>>>> ssointegration
    .map((res:Response)=>res.json())
    .catch((error:any)=>Observable.throw(error.json().error || 'Server Error'));
  }
}
