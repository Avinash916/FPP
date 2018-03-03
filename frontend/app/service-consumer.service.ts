import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { AppConfig } from './app-config';

@Injectable()
export class ServiceConsumer {

  constructor(private http:Http) { }

  GetCustomerPricingDetails():Observable<any>
  {
    console.log(AppConfig.PFJApiUrl+"pfjoverview/getdashboard");
    return this.http.get("pfjoverview/getdashboard")
    .map((res:Response)=>res.json())
    .catch((error:any)=>Observable.throw(error.json().error || 'Server Error'));
  }
}
