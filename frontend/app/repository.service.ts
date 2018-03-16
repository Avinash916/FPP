import { Injectable } from '@angular/core';
import { CustomerPriceDetails } from './Models/customer-price-details';
<<<<<<< HEAD
//import { PFJTotal,BetterOf,RetailMinus,TotalRetail,Funded,CCC } from './Models/pfj-tiles';

=======
import { AppConfig } from './app-config';
>>>>>>> ssointegration

@Injectable()
export class RepositoryService {
  customerPricingDetails:CustomerPriceDetails[] = [];
  selctedCustomerPricingDetails:CustomerPriceDetails = new CustomerPriceDetails();
  selectedDataPeriod:string;
<<<<<<< HEAD
  selectedViewTableau:string;
  selectedTableauFilter:string;
=======
  selectedTableauFilter:string;
  selectedTableauView:string;
  selectedTableauViewType:string;
  selectedTableauFullMapViewType:string;
  arrTableauViewByDataPeriod:string[] = [];
>>>>>>> ssointegration
  constructor() { }

}
