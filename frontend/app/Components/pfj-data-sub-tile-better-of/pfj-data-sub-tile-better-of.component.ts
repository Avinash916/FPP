import { Component, OnInit, Input } from '@angular/core';
import { BetterOf } from '../../Models/pfj-tiles';
<<<<<<< HEAD
<<<<<<< HEAD
=======
import { UtilityService } from '../../Helper/utility-service';
>>>>>>> ssointegration
=======
import { UtilityService } from '../../utility-service';
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
@Component({
  selector: 'app-pfj-data-sub-tile-better-of',
  templateUrl: './pfj-data-sub-tile-better-of.component.html',
  styleUrls: ['./pfj-data-sub-tile-better-of.component.css']
})
export class PfjDataSubTileBetterOfComponent implements OnInit {
  @Input() betterOf : BetterOf;
<<<<<<< HEAD
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
=======
  constructor(public utility:UtilityService) { }

  ngOnInit() {
  }
 }
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
