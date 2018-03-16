import { Component, OnInit, Input } from '@angular/core';
<<<<<<< HEAD
=======
import { UtilityService } from '../../Helper/utility-service';
>>>>>>> ssointegration


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
