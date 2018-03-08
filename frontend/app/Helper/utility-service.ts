import { Injectable } from '@angular/core';
@Injectable()
export class UtilityService {
    FormatContextualData(data)
    {
        return data = data.toString().trim().replace("-","");
    }

    GetPrimaryDomainName(domain:string):string
    {
        return domain.split('.')[0];
    }
}
