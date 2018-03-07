import { Component, OnInit,Version } from '@angular/core';
import { ServiceConsumer } from '../../service-consumer.service';
import { RepositoryService } from '../../repository.service';
import { PfjOverviewOperations } from '../../Models/pfjoverview-operations';
import { CustomerPriceDetails } from '../../Models/customer-price-details';
import { VERSION } from '@angular/platform-browser-dynamic';
import { AppConfig } from '../../app-config';
import { UtilityService } from '../../utility-service';
import { Observable } from 'rxjs/Rx';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
@Component({
  selector: 'app-pfj-overview',
  templateUrl: './pfj-overview.component.html',
  styleUrls: ['./pfj-overview.component.css']
})
export class PfjoverViewComponent implements OnInit {
  apiToken:Observable<any> = null;
  

  selectedCustPricingDetails : CustomerPriceDetails;
  constructor(public serviceConsumer: ServiceConsumer ,public repository : RepositoryService,
              public utility:UtilityService,private http:Http) {
   }

  ngOnInit() {
   if(this.repository.customerPricingDetails.length<=0)
    {
     // let appName = this.utility.GetPrimaryDomainName(location.hostname);
    
     var arr = window.location.href.split('/');
     var result = arr[0] + "//" + arr[2];
      AppConfig.PFJApiUrl = result+'/';

     
     this.http.get('/heroku-token').map(response => response)
      .subscribe(data=>console.log("heroku api token "+JSON.stringify(data)));
     // console.log("this.apiToken "+this.apiToken);

      //Get customer pricing details from service.
      //this.serviceConsumer.GetHerokuEnvVariables(result)
      //.subscribe(data=>this.GetHerokuConfigVars(data),error=>console.log(error));

      this.serviceConsumer.GetCustomerPricingDetails()
      .subscribe(data=>this.PopulateCustomerPricingDetails(data),error=>console.log(error));
    }
    else
    {
      //console.log("this.repository.selectedDataPeriod "+this.repository.selectedDataPeriod);
      this.ProcessSelectedCustomerPricingDetails(this.repository.selectedDataPeriod);
      this.ToggleTableauHeaderTxt(this.repository.selectedTableauFilter);
    }
    /*let s = '[{"temporalPeriod":"MTD","dimPlPeriodDateId":20180101,"pFJTotal":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":105.23,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":518.71},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"totalGAL":549.68,"totalTarget":554.04},"betterOf":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":53.67,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":25.81},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false},"buyingPerfActual":0.00,"buyingPerfTarget":0.00,"effPumpFeeActual":0.00,"effPumpFeeTarget":0.00},"totalRetail":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":51.56,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":492.90},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}},"retailMinus":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":30.52,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":39.32},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false},"rmDiscountActual":0.00,"rmDiscountTarget":0.00},"funded":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":11.58,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":234.84},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}},"ccc":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":9.47,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":218.74},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}}},{"temporalPeriod":"LCM","dimPlPeriodDateId":20180101,"pFJTotal":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":113.11,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":570.74},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"totalGAL":593.50,"totalTarget":603.34},"betterOf":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":57.69,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":26.54},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false},"buyingPerfActual":0.00,"buyingPerfTarget":0.00,"effPumpFeeActual":0.00,"effPumpFeeTarget":0.00},"totalRetail":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":55.43,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":544.20},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}},"retailMinus":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":32.80,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":42.95},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false},"rmDiscountActual":0.00,"rmDiscountTarget":0.00},"funded":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":12.44,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":259.82},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}},"ccc":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":10.18,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":241.44},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}}},{"temporalPeriod":"LCYTD","dimPlPeriodDateId":20180101,"pFJTotal":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":113.11,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":570.74},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"totalGAL":593.50,"totalTarget":603.34},"betterOf":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":57.69,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":26.54},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false},"buyingPerfActual":0.00,"buyingPerfTarget":0.00,"effPumpFeeActual":0.00,"effPumpFeeTarget":0.00},"totalRetail":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":55.43,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":544.20},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}},"retailMinus":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":32.80,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":42.95},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false},"rmDiscountActual":0.00,"rmDiscountTarget":0.00},"funded":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":12.44,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":259.82},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}},"ccc":{"grossProfitDollars":{"vsTgLeft":0.00,"vsTgLeftPositive":true,"vsTgRight":10.18,"vsLyLeft":0.00,"vsLyLeftPositive":true,"vsLyRight":241.44},"volume":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"margin":{"vsTgLeft":0.00,"vsTgLeftPositive":false,"vsTgRight":0.00,"vsLyLeft":0.00,"vsLyLeftPositive":false,"vsLyRight":0.00},"mixPercentage":{"mixActual":0.00,"mixTarget":0.00,"mixVsLy":0.00,"mixVsLyPositive":false}}}]';
      s = s.replace(/\\n/g, "\\n")  
               .replace(/\\'/g, "\\'")
               .replace(/\\"/g, '\\"')
               .replace(/\\&/g, "\\&")
               .replace(/\\r/g, "\\r")
               .replace(/\\t/g, "\\t")
               .replace(/\\b/g, "\\b")
               .replace(/\\f/g, "\\f");
      var o = JSON.parse(s);
      console.log(o);
      this.PopulateCustomerPricingDetails(o);*/
  }

  GetHerokuConfigVars(data)
  {
    AppConfig.PFJApiUrl = data.FPP_API_URL;
    console.log("AppConfig.PFJApiUrl "+AppConfig.PFJApiUrl);
    this.serviceConsumer.GetCustomerPricingDetails()
    .subscribe(data=>this.PopulateCustomerPricingDetails(data),error=>console.log(error));
  }

  PopulateCustomerPricingDetails(data)
  {
    this.repository.customerPricingDetails = new PfjOverviewOperations().PopulateCustomerPricingDetails(data);
    this.ProcessSelectedCustomerPricingDetails("LCYTD");
    this.repository.selectedDataPeriod = "LCYTD";
    this.repository.selectedTableauFilter = "GROSS PROFIT $";
    this.ToggleTableauHeaderTxt("GROSS PROFIT $");
  }

  ProcessSelectedCustomerPricingDetails(dataPeriod)
  {
    this.repository.selctedCustomerPricingDetails = this.repository.customerPricingDetails.find(c=>c.temporalPeriod.toUpperCase() == dataPeriod.toUpperCase());
    this.selectedCustPricingDetails = this.repository.selctedCustomerPricingDetails;
    //console.log(JSON.stringify(this.selectedCustPricingDetails));
    this.repository.selectedDataPeriod = dataPeriod;
  }

  ToggleTableauHeaderTxt(data)
  {
    //console.log(data);
    this.repository.selectedTableauFilter = data;
    this.repository.selectedViewTableau = data;
  }
}
