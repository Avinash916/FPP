import { Component, OnInit, Input } from '@angular/core';
import { RetailMinus } from '../../Models/pfj-tiles';
<<<<<<< HEAD
=======
import { UtilityService } from '../../Helper/utility-service';
>>>>>>> ssointegration

@Component({
  selector: 'app-pfj-data-sub-tile-retail-minus',
  templateUrl: './pfj-data-sub-tile-retail-minus.component.html',
  styleUrls: ['./pfj-data-sub-tile-retail-minus.component.css']
})
export class PfjDataSubTileRetailMinusComponent implements OnInit {
  @Input() retailMinus : RetailMinus;
<<<<<<< HEAD
  constructor() { }

  ngOnInit() {
  }

  roundOffData(data:string)
  {
    data = data.toString().trim().replace("-","");
    return parseFloat(data).toFixed(2);
  }

=======
  constructor(public utility:UtilityService) { }

  ngOnInit() {
  }
>>>>>>> ssointegration
}
