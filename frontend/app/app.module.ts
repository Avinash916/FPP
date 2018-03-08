import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import { AppComponent } from './app.component';
import { HeaderComponent } from './Components/header/header.component';
import { SectionContainerComponent } from './Components/section-container/section-container.component';
import { FooterComponent } from './Components/footer/footer.component';
import { PfjoverViewComponent } from './Components/pfj-overview/pfjover-view.component';
import { RetailPricingComponent } from './Components/retail-pricing/retail-pricing.component';
import { ExecutiveReportingComponent } from './Components/executive-reporting/executive-reporting.component';
import { CustomerPricingComponent } from './Components/customer-pricing/customer-pricing.component';

import {AppRoutingModule} from './app-routing.module';
import { ServiceConsumer } from './service-consumer.service';
import { RepositoryService } from './repository.service';
import { PfjtotalComponent } from './Components/pfjtotal/pfjtotal.component';
import { PfjDataTileComponent } from './Components/pfj-data-tile/pfj-data-tile.component';
import { PfjDataSubTileBetterOfComponent } from './Components/pfj-data-sub-tile-better-of/pfj-data-sub-tile-better-of.component';
import { PfjDataSubTileRetailMinusComponent } from './Components/pfj-data-sub-tile-retail-minus/pfj-data-sub-tile-retail-minus.component';

import { UtilityService } from './Helper/utility-service';
import { TableauComponent } from './Components/tableau/tableau.component';

import { SafePipe } from './Helper/safe-pipe-url';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SectionContainerComponent,
    FooterComponent,
    PfjoverViewComponent,
    RetailPricingComponent,
    ExecutiveReportingComponent,
    CustomerPricingComponent,
    PfjtotalComponent,
    PfjDataTileComponent,
    PfjDataSubTileBetterOfComponent,
    PfjDataSubTileRetailMinusComponent,
    TableauComponent,
    SafePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule, 
  ],
  providers: [ServiceConsumer,RepositoryService,UtilityService,{provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
