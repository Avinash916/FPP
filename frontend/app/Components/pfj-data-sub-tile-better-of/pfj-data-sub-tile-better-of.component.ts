import { Component, OnInit, Input } from '@angular/core';
import { BetterOf } from '../../Models/pfj-tiles';
<<<<<<< HEAD
=======
import { UtilityService } from '../../Helper/utility-service';
>>>>>>> ssointegration
@Component({
  selector: 'app-pfj-data-sub-tile-better-of',
  templateUrl: './pfj-data-sub-tile-better-of.component.html',
  styleUrls: ['./pfj-data-sub-tile-better-of.component.css']
})
export class PfjDataSubTileBetterOfComponent implements OnInit {
  @Input() betterOf : BetterOf;
<<<<<<< HEAD
  constructor() { }

  ngOnInit() {
  }
  roundOffData(data:string)
  {
    data = data.toString().trim().replace("-","");
    return parseFloat(data).toFixed(2);
  }

}
=======
  constructor(public utility:UtilityService) { }

  ngOnInit() {
  }
 }
>>>>>>> ssointegration
