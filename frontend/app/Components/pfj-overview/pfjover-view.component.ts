import { Component, OnInit,Version } from '@angular/core';
import { ServiceConsumer } from '../../service-consumer.service';
import { RepositoryService } from '../../repository.service';
import { PfjOverviewOperations } from '../../Models/pfjoverview-operations';
import { CustomerPriceDetails } from '../../Models/customer-price-details';
import { VERSION } from '@angular/platform-browser-dynamic';
import { AppConfig } from '../../app-config';
import { UtilityService } from '../../Helper/utility-service';
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

    // this.http.get('/heroku-token').map(response => response)
    //  .subscribe(data=>console.log("heroku api token "+JSON.stringify(data)));
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
      this.ToggleTableau(this.repository.selectedTableauFilter,this.repository.selectedTableauView,this.repository.selectedTableauFullMapViewType);
    }
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
    this.repository.selectedTableauViewType = "GrossProfitMap";
    this.repository.selectedTableauFullMapViewType = "GrossProfitDashboard";
    this.ToggleTableau(this.repository.selectedTableauFilter,this.repository.selectedTableauViewType,this.repository.selectedTableauFullMapViewType);
  }

  ProcessSelectedCustomerPricingDetails(dataPeriod)
  {
    /*let arrTableauView:string[] = [dataPeriod+"~"+"GrossProfitDashboard"+"~"+this.IsShowGrossProfitDashboard,
                                  dataPeriod+"~"+"GallonsDashboard"+"~"+this.IsShowGallonsDashboard,
                                  dataPeriod+"~"+"MarginDashboard"+"~"+this.IsShowMarginDashboard];
    
    arrTableauView.forEach(c=>{
      let tableauView = c.split('~');

      this.repository.arrTableauViewByDataPeriod.push(
        AppConfig.TableauBaseMapUrl.replace('viewtype',tableauView[1])
                                            .replace('dataperiod',tableauView[0])+"~"+tableauView[2]
      )

    });*/                                  


    this.repository.selctedCustomerPricingDetails = this.repository.customerPricingDetails.find(c=>c.temporalPeriod.toUpperCase() == dataPeriod.toUpperCase());
    this.selectedCustPricingDetails = this.repository.selctedCustomerPricingDetails;
    this.repository.selectedDataPeriod = dataPeriod;
    this.ToggleTableau(this.repository.selectedTableauFilter,this.repository.selectedTableauViewType,this.repository.selectedTableauFullMapViewType);

    /*switch(this.repository.selectedTableauViewType){
      case  "GrossProfitDashboard":{
        this.IsShowGrossProfitDashboard=true;
        this.IsShowGallonsDashboard = false;
        this.IsShowMarginDashboard = false;
        break;
      }
      case  "GallonsDashboard":{
        this.IsShowGrossProfitDashboard=false;
        this.IsShowGallonsDashboard = true;
        this.IsShowMarginDashboard = false;
        break;
      }
      case  "MarginDashboard":{
        this.IsShowGrossProfitDashboard=false;
        this.IsShowGallonsDashboard = false;
        this.IsShowMarginDashboard = true;
        break;
      }
      
    }*/
   
  }

  ToggleTableau(data,viewType,fullMapViewType)
  {
    //console.log("viewType "+viewType);
    this.repository.selectedTableauFilter = data;
    this.repository.selectedTableauViewType = viewType;
    this.repository.selectedTableauFullMapViewType = fullMapViewType;
    this.repository.selectedTableauView = AppConfig.TableauBaseMapUrl
                                            .replace('viewtype',this.repository.selectedTableauViewType)
                                            .replace('dataperiod',this.repository.selectedDataPeriod);
    
  }

  OpenFullMap()
  {
    let fullMapUrl = AppConfig.TableauBaseMapUrl
                    .replace('viewtype',this.repository.selectedTableauFullMapViewType)
                    .replace('dataperiod',this.repository.selectedDataPeriod);  
   // window.location.href = fullMapUrl;
   window.open(
    fullMapUrl,
    '_blank' // <- This is what makes it open in a new window.
  );
  }
}
