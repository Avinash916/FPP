import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
<<<<<<< HEAD
import { PfjoverViewComponent } from './Components/pfjover-view/pfjover-view.component';
=======
import { PfjoverViewComponent } from './Components/pfj-overview/pfjover-view.component';
>>>>>>> ssointegration
=======
import { PfjoverViewComponent } from './Components/pfj-overview/pfj-overview.component';
>>>>>>> Development
import { RetailPricingComponent } from './Components/retail-pricing/retail-pricing.component';
import { ExecutiveReportingComponent } from './Components/executive-reporting/executive-reporting.component';
import { CustomerPricingComponent } from './Components/customer-pricing/customer-pricing.component';
import { AuthGuard } from './authentication/auth-guard.service';
import { LoginComponent } from './authentication/login/login.component';
import { SSOLoginComponent } from './authentication/ssologin/ssologin.component';

const appRoutes: Routes = [
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    {path: '', redirectTo: '/pfjover-view',pathMatch: 'full'},
=======
    { path: '', redirectTo: '/pfjover-view',pathMatch: 'full'},
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
    { path: '', component: PfjoverViewComponent},
    { path: 'pfjover-view', component: PfjoverViewComponent },
=======
    { path: '', redirectTo: '/pfj-overview',pathMatch: 'full'},
    { path: '', component: PfjoverViewComponent},
    { path: 'pfj-overview', component: PfjoverViewComponent },
>>>>>>> ssointegration
    { path: 'retail-pricing', component: RetailPricingComponent },
    { path: 'executive-reporting', component: ExecutiveReportingComponent },
    { path: 'customer-pricing', component: CustomerPricingComponent },
=======
    { path: '', redirectTo: '/pfj-overview', pathMatch: 'full'},
    { path: '', component: PfjoverViewComponent},
    { path: 'ssologin', component: SSOLoginComponent},
    { path: 'login', component: LoginComponent},
    { path: 'pfj-overview', component: PfjoverViewComponent},
    { path: 'retail-pricing', component: RetailPricingComponent, canActivate:[AuthGuard] },
    { path: 'executive-reporting', component: ExecutiveReportingComponent, canActivate:[AuthGuard] },
    { path: 'customer-pricing', component: CustomerPricingComponent, canActivate:[AuthGuard] },
>>>>>>> Development
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
