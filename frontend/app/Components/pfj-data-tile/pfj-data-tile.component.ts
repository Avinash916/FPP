import { Component, OnInit, Input } from '@angular/core';
<<<<<<< HEAD
<<<<<<< HEAD
=======
import { UtilityService } from '../../Helper/utility-service';
>>>>>>> ssointegration
=======
import { UtilityService } from '../../utility-service';
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1


@Component({
  selector: 'app-pfj-data-tile',
  templateUrl: './pfj-data-tile.component.html',
  styleUrls: ['./pfj-data-tile.component.css']
})
export class PfjDataTileComponent implements OnInit {
  @Input() dataTileName : string;
  @Input() dataTile : any;
  @Input() isRequiredSubTile:boolean;
  @Input() arrItemsSubTile
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
=======
  constructor(public utility:UtilityService) { }

  ngOnInit() {
  } 
>>>>>>> ssointegration
=======
  constructor(public utility:UtilityService) { }

  ngOnInit() {
  } 
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
}
