import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { AppConfig } from './app-config';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class ServiceConsumer {

  constructor(private http:Http) { }

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
    console.log(AppConfig.PFJApiUrl+"pfjoverview/getdashboard");
    return this.http.get("http://fuel-pricing-platform-dev.herokuapp.com/pfjoverview/getdashboard")
    .map((res:Response)=>res.json())
    .catch((error:any)=>Observable.throw(error.json().error || 'Server Error'));
  }
}
