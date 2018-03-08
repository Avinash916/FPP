import { Injectable } from '@angular/core';
import { CustomerPriceDetails } from './Models/customer-price-details';
import { AppConfig } from './app-config';

@Injectable()
export class RepositoryService {
  customerPricingDetails:CustomerPriceDetails[] = [];
  selctedCustomerPricingDetails:CustomerPriceDetails = new CustomerPriceDetails();
  selectedDataPeriod:string;
  //selectedViewTableau:string;
  selectedTableauFilter:string;
  selectedTableauView:string;
  constructor() { }

}
