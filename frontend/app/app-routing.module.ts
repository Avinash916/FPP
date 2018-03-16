import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PfjoverViewComponent } from './Components/pfj-overview/pfj-overview.component';
import { RetailPricingComponent } from './Components/retail-pricing/retail-pricing.component';
import { ExecutiveReportingComponent } from './Components/executive-reporting/executive-reporting.component';
import { CustomerPricingComponent } from './Components/customer-pricing/customer-pricing.component';
import { AuthGuard } from './authentication/auth-guard.service';
import { LoginComponent } from './authentication/login/login.component';
import { SSOLoginComponent } from './authentication/ssologin/ssologin.component';

const appRoutes: Routes = [
    { path: '', redirectTo: '/pfj-overview', pathMatch: 'full'},
    { path: '', component: PfjoverViewComponent},
    { path: 'ssologin', component: SSOLoginComponent},
    { path: 'login', component: LoginComponent},
    { path: 'pfj-overview', component: PfjoverViewComponent},
    { path: 'retail-pricing', component: RetailPricingComponent, canActivate:[AuthGuard] },
    { path: 'executive-reporting', component: ExecutiveReportingComponent, canActivate:[AuthGuard] },
    { path: 'customer-pricing', component: CustomerPricingComponent, canActivate:[AuthGuard] },
];

@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule { }
