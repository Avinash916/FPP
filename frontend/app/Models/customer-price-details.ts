import { ICustomerPriceDetails } from '../Interface/pfj-interfaces';
import { PFJTotal,BetterOf,TotalRetail,RetailMinus,Funded,CCC } from '../Models/pfj-tiles';
export class CustomerPriceDetails implements ICustomerPriceDetails {
    temporalPeriod: string;
<<<<<<< HEAD
<<<<<<< HEAD
    lastClosedPeriod:string;
=======
    dimPlPeriodDateId:string;
>>>>>>> ssointegration
=======
    dimPlPeriodDateId:string;
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
    pfjTotal: PFJTotal;
    betterOf: BetterOf;
    totalRetail: TotalRetail;
    retailMinus: RetailMinus;
    funded: Funded;
    ccc: CCC;
}
